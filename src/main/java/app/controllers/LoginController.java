/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;
/**
 *
 * @author universidad
 */
public class LoginController extends AppController {


    public void index(){}

    @POST
    public void login(){

        if(blank("email", "password")){
            flash("message", "Enter both, email and password");
            redirect();
        }else if (param("email").equals("activeweb@javalite.io") && param("password").equals("password1")){
            session("user", "activeweb@javalite.io");
            redirect(HomeController.class);
        }else{
            flash("message","Correct values to login: activeweb@javalite.io/password1 :)");
            redirect();
        }
    }

    public void logout(){
        session("user", null);
        redirect("/");
    }
}