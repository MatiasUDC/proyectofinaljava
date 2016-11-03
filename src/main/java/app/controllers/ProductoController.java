/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Categoria;
import app.models.Producto;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
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
        view("path_imagen",appContext().get("path_imagen"));
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
        HashMap<String, String> params = new HashMap();
        
        List<FormItem> formItems = multipartFormItems();

        for (FormItem item : formItems) {
            
            if(item.isFile()){

                Date fecha = new Date();
                String nameFile = fecha.getTime()+item.getName();
                item.saveTo(appContext().get("path_imagen_disc") + nameFile);
                producto.set("imagen", nameFile);
                
                
            } else {
               String valor = new String(item.getBytes());
               String name = item.getFieldName();
               producto.set(name, valor);
               params.put(name, valor);
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
       
        Producto p = (Producto) Producto.getProducto(getId());
        java.util.List<SelectOption> list = Categoria.selectedCategoria(p.getInteger("id"));
        render().layout("layouts/form_layout");
        view("path_imagen",appContext().get("path_imagen"));
        view("categorias", list);
        view("producto", p);

    }

    @DELETE
    public void delete() {
        Producto p = (Producto) Producto.getProducto( getId());
        String nombre = p.getString("nombre");
        Producto.eliminar(p);
        flash("message", "Producto: '" + nombre + "' eliminado");
        redirect(ProductoController.class);
    }

    @PUT
    public void update() {
        Producto p = (Producto) Producto.getProducto(getId());
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
    
    public void show(){
         Producto p = Producto.getProducto(getId());
         Categoria c;
         c = Categoria.getCategoria(p.get("categoria_id"));
         view("categoria",c);
         view("producto", p);
    }
}
