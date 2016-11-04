/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Categoria;
import app.models.Compra;
import app.models.Metodo;
import app.models.Producto;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;
import org.javalite.activeweb.FormItem;
import org.javalite.activeweb.freemarker.SelectOption;

/**
 *
 * @author Matias
 */
public class CompraController extends AppController{

    @GET
    public void index() {
        view("compras", Compra.lista_compras());
    }

    @GET
    public void newForm() {
        //ydeclaro producto
        //Producto producto = Producto.findById(getId());
        //view("producto", producto);
        java.util.List<SelectOption> list = Metodo.selectedMetodos();
        view("metodos", list);
        render().layout("layouts/form_layout");
    }

    @POST
    public void create() {
        Compra compra = new Compra();
        compra.fromMap(params1st());

        if (!Compra.registrar(compra)) {
            flash("message", "No se ha podido guardar el producto, revise los siguientes items");
            flash("errors", compra.errors());
            flash("params", params1st());
            redirect(CompraController.class, "new_form");
        } else {
            flash("message", "Compra de : " + compra.get("id_producto") + "fue realizada correctamente" );
            redirect(CompraController.class);
        }
    }

    @GET
    public void edit() {
       
        Compra c =  (Compra) Compra.findById(getId());
        //java.util.List<SelectOption> list = MetodoPago.selectedMetodos();
        render().layout("layouts/form_layout");
        //view("metodos", list);
        view("producto", c);

    }

    @DELETE
    public void delete() {
        Compra c = (Compra) Compra.findById(getId());
        String producto = c.getString("producto");
        Compra.baja(c);
        flash("message", "La compra de : '" + producto + "'fue dada de baja correctamente");
        redirect(CompraController.class);
    }

    @PUT
    public void update() {
        Compra c = (Compra) Compra.findById(getId());
        c.fromMap(params1st());
        if(!Compra.actualizar(c)){
            flash("message", "No se ha podido actulizar la compra, revise los siguientes items");
            flash("errors", c.errors());
            flash("params", params1st());
            redirect(CompraController.class, "edit");
        }else {
            flash("message", "Los datos de Compra del producto : '" + c.get("producto") + "' fueron modificados");
            redirect(CompraController.class);
        }
    }

    
}
