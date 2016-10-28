/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import app.models.Categoria;
import app.models.Producto;
import java.util.LinkedList;
import java.util.List;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.FormItem;
import org.javalite.activeweb.annotations.*;
import org.javalite.activeweb.freemarker.SelectOption;


/**
 *
 * @author universidad
 */
public class ProductoController extends AppController{
    public void index(){
        view("productos", Producto.lista_productos());
       
    }
    public void newForm(){
        render().layout("layouts/form_layout");
        
    }

    @POST
    public void create(){
        Producto producto = new Producto();
        producto.fromMap(params1st());
        if(!Producto.crear(producto)){
            flash( "message", "No se ha podido guardar el producto, revise los siguientes items" );
            flash( "errors", producto.errors() );
            flash( "params", params1st() );
            redirect( ProductoController.class, "new_form" );
        }else{
            flash( "message", "Nuevo producto agregado: " + producto.get("nombre") );
            redirect( ProductoController.class );
        }
    }
    
    public void show(){}
    
    @DELETE
    public void delete(){
        Producto p = (Producto)Producto.findById(getId());
        String nombre = p.getString("nombre");
        Producto.eliminar(p);
        flash("message", "Producto: '" + nombre + "' eliminado");
        redirect(ProductoController.class);
    }


}
