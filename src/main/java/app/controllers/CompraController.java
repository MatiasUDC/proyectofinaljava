/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.controllers.authorization.Protected;
import app.models.Compra;
import app.models.Metodo;
import app.models.Producto;
import app.models.Token;
import app.models.Usuario;
import java.util.List;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;
import org.javalite.activeweb.freemarker.SelectOption;

/**
 *
 * @author Matias
 */
@Protected
public class CompraController extends AppController {

    @GET
    public void index() {
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            if(Usuario.getRol(usuario).getString("nombre").equals("admin")){
                redirect(app.controllers.admin.HomeController.class);
            } else {
                //view("producto", Compra.TraerProducto()
                view("compras", Compra.lista_compras());
            }
        }

    }

    @GET
    public void newForm() {
        //declaro producto
        Producto producto = Producto.findById(getId());
        view("producto", producto);
        java.util.List<SelectOption> token = Token.token();
        view("token", token);
        java.util.List<SelectOption> list = Metodo.selectedMetodos();
        view("metodos", list);
        render().layout("layouts/form_layout");
    }

    @POST
    public void create() {
        Compra compra = new Compra();
        compra.fromMap(params1st());
        Producto producto = Producto.findById(getId());
        if (producto.getInteger("stock") != 0) {
            if (producto.getInteger("stock") > compra.getInteger("cantidad")) {
                int resta = producto.getInteger("stock") - compra.getInteger("cantidad");
                producto.set("stock", resta);
                if (!Compra.registrar(compra)) {
                    flash("message", "No se ha podido guardar el producto, revise los siguientes items");
                    flash("errors", compra.errors());
                    flash("params", params1st());
                    redirect(CompraController.class, "new_form");
                } else {

                    flash("message", "La Compra fue realizada correctamente");
                    redirect(CompraController.class);
                }
            } else {
                flash("message", "Stock insuficiente disponible para la compra, por favor prueba con otra cantidad");
                flash("errors", compra.errors());
                flash("params", params1st());
                redirect(CompraController.class, "new_form");
            }
        } else {
            flash("message", "Producto no Disponible para compra por falta de Stock");
            flash("errors", compra.errors());
            flash("params", params1st());
            redirect(CompraController.class, "index");
        }

    }

    @GET
    public void edit() {

        Compra c = (Compra) Compra.findById(getId());
        java.util.List<SelectOption> list = Metodo.selectedMetodos();
        view("metodos", list);
        view("compra", c);

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
        if (!Compra.actualizar(c)) {
            flash("message", "No se ha podido actulizar la compra, revise los siguientes items");
            flash("errors", c.errors());
            flash("params", params1st());
            redirect(CompraController.class, "edit");
        } else {
            flash("message", "Los datos de Compra del producto : '" + c.get("producto") + "' fueron modificados");
            redirect(CompraController.class);
        }
    }

}
