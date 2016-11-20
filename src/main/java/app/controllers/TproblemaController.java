/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import org.javalite.activeweb.AppController;
import app.models.Problema;
import app.models.Tproblema;
import com.sun.org.glassfish.external.probe.provider.annotations.Probe;

import java.util.List;
import org.javalite.activeweb.annotations.DELETE;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.PUT;

/**
 *
 * @author Matias
 */
public class TproblemaController extends AppController {
     public void index(){
        List problemas = Tproblema.lista_problemas();
        view("problemas", problemas);
    }
    
    @GET
    public void newForm() {
        render().layout("layouts/form_layout");
    }
    
    @POST
    public void create() {
        Tproblema p = new Tproblema();
        p.fromMap(params1st());

        if (!Tproblema.crear(p)) {
            flash("message", "No se ha podido crear tipo de problema, revise los siguientes items");
            flash("errors", p.errors());
            flash("params", params1st());
            redirect(TproblemaController.class, "new_form");
        } else {
            flash("message", "Nuevo tipo de problema agregado ");
            redirect(TproblemaController.class);
        }
    }
    @GET
    public void edit() {
       
        Tproblema t = (Tproblema) Tproblema.findById(getId());
        render().layout("layouts/form_layout");
        view("tproblemas", t);


    }

    @DELETE
    public void delete() {
        Tproblema  p = (Tproblema) Problema.findById(getId());
        Tproblema.eliminar(p);
        flash("message", "Tipo de Problema eliminado");
        redirect(TproblemaController.class);
    }
    
    @PUT
    public void update() {
        Tproblema p = (Tproblema) Tproblema.findById(getId());
        p.fromMap(params1st());
        if(!Tproblema.actualizar(p)){
            flash("message", "No se ha podido guardar el tipo de problema, revise los siguientes items");
            flash("errors", p.errors());
            flash("params", params1st());
            redirect(TproblemaController.class, "edit");
        }else {
            flash("message", "El tipo de problema ha sido modificado");
            redirect(TproblemaController.class);
        }
    }
    
}
