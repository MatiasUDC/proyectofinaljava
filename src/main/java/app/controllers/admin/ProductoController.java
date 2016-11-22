/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.admin;

import app.models.Categoria;
import app.models.Producto;
import java.io.File;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;
import org.javalite.activeweb.FormItem;
import org.javalite.activeweb.freemarker.SelectOption;
import app.controllers.authorization.Protected;
import app.models.Comentario;
import app.models.Usuario;
/**
 *
 * @author universidad
 */
@Protected
public class ProductoController extends AppController {

    @GET
    public void index() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            view("path_imagen",appContext().get("path_imagen"));
            view("productos", Producto.lista_productos());
            view("index_producto", true );
        }
    }

    @GET
    public void newForm() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            java.util.List<SelectOption> list = Categoria.selectedCategoria();
            view("categorias", list);
            render().layout("layouts/form_layout");
        }
    }

    @POST
    public void create() throws IOException {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
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
    }

    @GET
    public void edit() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Producto p = (Producto) Producto.getProducto(getId());
            Categoria c;
            c = p.parent(Categoria.class);
            java.util.List<SelectOption> list = Categoria.selectedCategoria(c.getId());
            render().layout("layouts/form_layout");
            view("path_imagen",appContext().get("path_imagen"));
            view("categorias", list);
            view("producto", p);
        }

    }

    @DELETE
    public void delete() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Producto p = (Producto) Producto.getProducto( getId());
            String nombre = p.getString("nombre");
            Producto.eliminar(p);
            flash("message", "Producto: '" + nombre + "' eliminado");
            redirect(ProductoController.class);
        }
    }

    @POST
    public void update() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
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
    }
    
    public void show(){
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            
            Producto p = Producto.getProducto(getId());
            List comentarios = Comentario.listaCompentariosProducto(p);
            Categoria c;
            c = p.parent(Categoria.class);
            
            view("comentarios", comentarios);
            view("path_imagen",appContext().get("path_imagen"));
            view("categoria",c);
            view("producto", p);
            
            render().layout("layouts/form_layout");
        }
    } 
   @POST
    public void imagen() throws IOException{
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Producto producto = Producto.getProducto(getId()); 
            List<FormItem> formItems = multipartFormItems();
            String lastName = appContext().get("path_imagen_disc")+producto.getString("imagen");
            for (FormItem item : formItems) {

                if(item.isFile() && !item.getName().equals(producto.getString("imagen"))){
                    Date fecha = new Date();
                    String nameFile = fecha.getTime()+item.getName();
                    item.saveTo(appContext().get("path_imagen_disc") + nameFile);
                    producto.set("imagen", nameFile);
                } else {
                   flash("message", "No se han realizado cambios.");

                } 
            }

            if (!Producto.actualizar(producto)) {
                flash("message", "No se ha podido guardar la imegen en el producto, revise los siguientes items.");
            } else {
                File imagen = new File(lastName);
                imagen.deleteOnExit();
                flash("message", "Se ha agregado la imagen en el producto : " + producto.get("nombre") + " correctamente.");
            }
            redirect(ProductoController.class, "show", producto.get("id"));
        }
    }
    public boolean control(){
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            return !Usuario.getRol(usuario).getString("nombre").equals("admin");
        }
        return false;
    }

}
