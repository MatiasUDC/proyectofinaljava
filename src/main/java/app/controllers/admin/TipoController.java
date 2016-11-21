/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.admin;

import app.controllers.authorization.Protected;
import app.models.Tproblema;
import app.models.Usuario;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.DELETE;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.PUT;

/**
 *
 * @author universidad
 */
@Protected
public class TipoController extends AppController{
        public void index() {
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            if(!Usuario.getRol(usuario).getString("nombre").equals("admin")){
                redirect(app.controllers.HomeController.class);
            } else {
                view("index_tipo", true);
                view("tipos", Tproblema.lista_problemas());
            }
        }
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
            redirect(app.controllers.admin.TipoController.class, "new_form");
        } else {
            flash("message", "Nuevo tipo de problema agregado ");
            redirect(app.controllers.admin.TipoController.class);
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
        Tproblema  p = (Tproblema) Tproblema.findById(getId());
        Tproblema.eliminar(p);
        flash("message", "Tipo de Problema eliminado");
        redirect(app.controllers.admin.TipoController.class);
    }
    
    @PUT
    public void update() {
        Tproblema p = (Tproblema) Tproblema.findById(getId());
        p.fromMap(params1st());
        if(!Tproblema.actualizar(p)){
            flash("message", "No se ha podido guardar el tipo de problema, revise los siguientes items");
            flash("errors", p.errors());
            flash("params", params1st());
            redirect(app.controllers.admin.TipoController.class, "edit");
        }else {
            flash("message", "El tipo de problema ha sido modificado");
            redirect(app.controllers.admin.TipoController.class);
        }
    }
}
