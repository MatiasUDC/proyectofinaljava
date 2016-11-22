/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.controllers.authorization.Protected;
import app.models.Compra;
import app.models.Problema;
import app.models.Tproblema;
import app.models.Usuario;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;
import org.javalite.activeweb.freemarker.SelectOption;
;

/**
 *
 * @author Matias
 */
@Protected
public class ProblemaController extends AppController {
    public void index() {
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            if(Usuario.getRol(usuario).getString("nombre").equals("admin")){
                redirect(app.controllers.HomeController.class);
            } else {
                view("problemas", Problema.lista_problemas());
            }
        }
    }

    @GET
    public void newForm() {
        //declaro producto
        Compra compra = Compra.findById(getId());
        view("compra", compra);
        java.util.List<SelectOption> list = Tproblema.selectedProblemas();
        view("tipos", list);
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
        java.util.List<SelectOption> list = Tproblema.selectedProblemas();
        view("tipo", list);
        view("problema", c);

    }

    @DELETE
    public void delete() {
        Problema c = (Problema) Problema.findById(getId());
        Problema.baja(c);
        flash("message", "El problema fue dado de baja correctamente");
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
