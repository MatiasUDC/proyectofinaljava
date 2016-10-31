/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import org.javalite.activeweb.AppController;
import app.models.Categoria;

import java.util.List;
import org.javalite.activeweb.annotations.DELETE;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.PUT;



/**
 *
 * @author universidad
 */
public class CategoriaController extends AppController {
    public void index(){
        List categorias = Categoria.lista_categorias();
        view("categorias", categorias);
    }
    
    @GET
    public void newForm() {
        render().layout("layouts/form_layout");
    }
    
    @POST
    public void create() {
        Categoria c = new Categoria();
        c.fromMap(params1st());

        if (!Categoria.crear(c)) {
            flash("message", "No se ha podido guardar la categoria, revise los siguientes items");
            flash("errors", c.errors());
            flash("params", params1st());
            redirect(CategoriaController.class, "new_form");
        } else {
            flash("message", "Nueva categoria agregada: " + c.get("nombre"));
            redirect(CategoriaController.class);
        }
    }
    @GET
    public void edit() {
       
        Categoria c = (Categoria) Categoria.findById(getId());
        render().layout("layouts/form_layout");
        view("categoria", c);


    }

    @DELETE
    public void delete() {
        Categoria p = (Categoria) Categoria.findById(getId());
        String nombre = p.getString("nombre");
        Categoria.eliminar(p);
        flash("message", "Categoria: '" + nombre + "' eliminado");
        redirect(CategoriaController.class);
    }
    
    @PUT
    public void update() {
        Categoria c = (Categoria) Categoria.findById(getId());
        c.fromMap(params1st());
        if(!Categoria.actualizar(c)){
            flash("message", "No se ha podido guardar el producto, revise los siguientes items");
            flash("errors", c.errors());
            flash("params", params1st());
            redirect(CategoriaController.class, "edit");
        }else {
            flash("message", "Categoria: '" + c.get("nombre") + "' modificada");
            redirect(CategoriaController.class);
        }
    }
}
