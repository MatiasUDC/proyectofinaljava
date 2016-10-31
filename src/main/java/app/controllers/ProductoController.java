/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Categoria;
import app.models.Producto;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
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
    public void create() throws IOException {
        Producto producto = new Producto();
        Map<String, String> params = params1st();//guardo para no perder los datos.
        producto.fromMap(params);

        
        Iterator<FormItem> iterator = uploadedFiles();
        if (iterator.hasNext()){
            FormItem item = iterator.next();

            if(item.isFile()){
                InputStream in = item.getInputStream();
                Date fecha = new Date();
                String nameFile = fecha.toString()+item.getFileName();
                item.saveTo("src/main/webapp/imagenes/producto/"+nameFile);
                producto.set("imagen", nameFile);
                
                ///process data
            }               
        }
        
        if (!Producto.crear(producto)) {
            flash("message", "No se ha podido guardar el producto, revise los siguientes items");
            flash("errors", producto.errors());
            flash("params", params);
            redirect(ProductoController.class, "new_form");
        } else {
            flash("message", "Nuevo producto agregado: " + producto.get("nombre"));
            redirect(ProductoController.class);
        }
    }

    @GET
    public void edit() {
       
        Producto p = (Producto) Producto.findById(getId());
        java.util.List<SelectOption> list = Categoria.selectedCategoria();
        render().layout("layouts/form_layout");
        view("categorias", list);
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
        if(!Producto.actualizar(p)){
            flash("message", "No se ha podido guardar el producto, revise los siguientes items");
            flash("errors", p.errors());
            flash("params", params1st());
            redirect(ProductoController.class, "edit");
        }else {
            flash("message", "Producto: '" + p.get("nombre") + "' modificado");
            redirect(ProductoController.class);
        }
    }
}
