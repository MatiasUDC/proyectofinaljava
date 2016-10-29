/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Categoria;
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
 * @author universidad
 */
public class ProductoController extends AppController {

    @GET
    public void index() {
        view("productos", Producto.lista_productos());

    }

    @GET
    public void newForm() {
        java.util.List<SelectOption> list = Categoria.selectedCategoria();
        view("categorias", list);
        render().layout("layouts/form_layout");
    }

    @POST
    public void create() throws IOException  {
        Producto producto = new Producto();
        //producto.fromMap(params1st());
        List<FormItem> items = multipartFormItems();
        producto.set("nombre", param("nombre", items));
        producto.set("descripcion", param("descripcion", items));
        producto.set("precio", param("precio", items));
        producto.set("stock", param("stock", items));

        if (!Producto.crear(producto)) {
            flash("message", "No se ha podido guardar el producto, revise los siguientes items");
            flash("errors", producto.errors());
            flash("params", params1st());
            redirect(ProductoController.class, "new_form");
        } else {
            //FileItem files = getFile("imagen", items);
            //files.saveTo("/home/cesar/Escritorio");
            //producto.set("imagen", files.getFileName());
            flash("message", "Nuevo producto agregado: " + producto.get("nombre"));
            redirect(ProductoController.class);
        }
    }

    @GET
    public void edit() {
       
        Producto p = (Producto) Producto.findById(getId());
        render().layout("layouts/form_layout");
        view("producto", p);

    }

    @DELETE
    public void delete() {
        Producto p = (Producto) Producto.findById(getId());
        String nombre = p.getString("nombre");
        Producto.eliminar(p);
        flash("message", "Producto: '" + nombre + "' eliminado");
        redirect(ProductoController.class);
    }

    @PUT
    public void update() {
        Producto p = (Producto) Producto.findById(getId());
        p.fromMap(params1st());
        Producto.actualizar(p);
        flash("message", "Producto: '" + p.get("nombre") + "' modificado");
        redirect(ProductoController.class);
    }
}
