/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Compra;
import app.models.Problema;
import app.models.Metodo;
import app.models.Producto;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;
import org.javalite.activeweb.FormItem;
import org.javalite.activeweb.freemarker.SelectOption;
;

/**
 *
 * @author Matias
 */
public class ProblemaController extends AppController {
    public void index() {
        
        view("problemas", Problema.lista_problemas());
    }

    @GET
    public void newForm() {
        //declaro producto
        Compra compra = Compra.findById(getId());
        view("compra", compra);
        java.util.List<SelectOption> list = Metodo.selectedMetodos();
        view("metodos", list);
        render().layout("layouts/form_layout");
    }

    @POST
    public void create() {
        Problema problema = new Problema();
        problema.fromMap(params1st());
        if (!Problema.registrar(problema)) {
            flash("message", "No se ha podido registrar el problema, revise los siguientes items");
            flash("errors", problema.errors());
            flash("params", params1st());
            redirect(ProblemaController.class, "new_form");
        } else {
            flash("message", "El problema fue registrado correctamente" );
            redirect(ProblemaController.class);
        }
    }

    @GET
    public void edit() {
       
        Problema c =  (Problema) Problema.findById(getId());
        java.util.List<SelectOption> list = Tproblema.selectedProblema();
        view("tipo", list);
        view("problema", c);

    }

    @DELETE
    public void delete() {
        Problema c = (Problema) Problema.findById(getId());
        Problema.baja(c);
        flash("message", "El problema de fue dado de baja correctamente");
        redirect(ProblemaController.class);
    }

    @PUT
    public void update() {
        Problema c = (Problema) Problema.findById(getId());
        c.fromMap(params1st());
        if(!Problema.actualizar(c)){
            flash("message", "No se ha podido actulizar el problema, revise los siguientes items");
            flash("errors", c.errors());
            flash("params", params1st());
            redirect(ProblemaController.class, "edit");
        }else {
            flash("message", "La razon del problema fue modificada");
            redirect(ProblemaController.class);
        }
    }

    
}
