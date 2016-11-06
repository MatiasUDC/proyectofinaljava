/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import app.controllers.admin.ProductoController;
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
            flash("message", "Enter both, email and password");
            redirect();
        }else if (param("email").equals("admin@admin.com") && param("password").equals("1234")){
            session("user", "admin");
            redirect(ProductoController.class);
        }else{
            session("user", param("email"));
            redirect(HomeController.class);
            //flash("message","Correctos valores para login: admin@admin.com/1234 :)");
            //redirect();
        }
    }

    public void logout(){
        session("user", null);
        redirect(HomeController.class);
    }
}