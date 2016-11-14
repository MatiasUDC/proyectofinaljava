/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import app.controllers.admin.ProductoController;
import app.models.Rol;
import app.models.Usuario;
import java.util.List;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
/**
 *
 * @author universidad
 */
public class LoginController extends AppController {


    public void index(){
        render().layout("layouts/public_layout");
    }

    @POST
    public void login(){

        if(blank("email", "password")){
            flash("message", "Ingerse , email y contraseña");
            redirect();
        }else{
            List users = Usuario.getUsurio(param("email"), param("password"));
            if(users.isEmpty()){
                flash("message", "No se ha encontrado la convinacion de email y contraseña");
                redirect();
            }
            Usuario user = (Usuario) users.get(0);
            if (user.parent(Rol.class).get("nombre").equals("admin")){
                session("user", "admin");
                session("id_user", user.get("id").toString());
                redirect(ProductoController.class);
            } else if (user.parent(Rol.class).get("nombre").equals("user")){
                session("user", param("email"));
                session("id_user", user.get("id").toString());
                redirect(HomeController.class);
            }
        }
    }

    public void logout(){
        session("user", null);
        redirect(HomeController.class);
    }
}