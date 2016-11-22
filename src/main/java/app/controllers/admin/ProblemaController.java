/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.admin;

import app.controllers.authorization.Protected;

import app.models.Problema;

import app.models.Usuario;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;

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
            if(!Usuario.getRol(usuario).getString("nombre").equals("admin")){
                redirect(app.controllers.HomeController.class);
            } else {
                view("index_problema", true);
                view("problemas", Problema.lista_problemas());
            }
        }
    }

    @GET
    public void responder() {
        Problema c = (Problema) Problema.findById(getId());
        Problema.baja(c);
        flash("message", "El problema fue dado de baja correctamente");
        redirect(ProblemaController.class);
    }
    
}
