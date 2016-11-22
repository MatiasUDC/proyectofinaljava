/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.admin;

import java.util.List;
import org.javalite.activeweb.AppController;
import app.controllers.authorization.Protected;
import app.models.Perfil;

import app.models.Rol;
import app.models.Usuario;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;


/**
 *
 * @author Matias
 */
@Protected
public class UsuarioController extends AppController {

    public void index() {
         if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            view("index_usuario", true);
            Usuario usuario;
            usuario = (Usuario) session().get("user");
            List usuarios = Usuario.lista_usuario(usuario.get("id"));
            view("users", usuarios);
        }
    }

    @GET
    public void newForm() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            List roles = Rol.selectedRol();
            view("roles", roles);
            render().layout("layouts/form_layout");
        }
    }

    @POST
    public void create() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Usuario u = new Usuario();
            u.fromMap(params1st());

            if (!Usuario.crear(u, false)) {
                flash("message", "No se ha podido guardar la categoria, revise los siguientes items");
                flash("errors", u.errors());
                flash("params", params1st());
                redirect(CategoriaController.class, "new_form");
            } else {
                flash("message", "Nueva usuario registrado: " + u.get("nombre"));
                redirect(UsuarioController.class);
            }
        }
    }

    @GET
    public void edit() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Usuario u = (Usuario) Usuario.findById(getId());
            List roles = Rol.selectedRol(u.get("rol_id"));
            view("roles", roles);
            view("usuario", u);
            render().layout("layouts/form_layout");
        }
    }
    
    public void delete() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Usuario user = (Usuario) Usuario.getUsurio(getId());
            Perfil perfil = user.parent(Perfil.class);
            if(Usuario.eliminar(user)){
                perfil.delete();
                flash("message", "Usuario eliminado correctamente!...");
            } else {
                flash("message", "No se ha podido eliminado el usuario!...");
            }
            redirect(app.controllers.admin.UsuarioController.class);
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
