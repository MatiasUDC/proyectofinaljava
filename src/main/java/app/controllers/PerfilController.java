/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Perfil;
import app.models.Usuario;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;

/**
 *
 * @author Matias
 */
public class PerfilController extends AppController {
    
    @GET
    public void edit() {
            Usuario usuario;
            usuario = (Usuario) session().get("user");
            Perfil p = Usuario.getPerfil(usuario);
            view("perfil", p);
            render().layout("layouts/form_layout");
            
    }
    
    @POST
    public void update() {
            Usuario usuario;
            usuario = (Usuario) session().get("user");
            Perfil p = Usuario.getPerfil(usuario);
            
            p.fromMap(params1st());
            if(!Perfil.actualizar(p)){
                flash("message", "No se ha podido modificar el perfil, revise los siguientes items");
                flash("errors", p.errors());
                flash("params", params1st());
                redirect(PerfilController.class, "edit");
            }else {
                flash("message", "Perfil de : '" + p.get("nombre") + "'fue modificado");
                redirect(UsuarioController.class, "perfil");
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
