/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.controllers.admin.MetodoController;
import app.models.Token;
import app.models.Usuario;
import java.util.List;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.DELETE;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.PUT;

/**
 *
 * @author Matias
 * Este controlador es perteneciente al token de compra
 */
public class TokenController extends AppController {
    public void index(){
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            List tokens = Token.lista_tokens();
            view("tokens", tokens);
            view("index_metodo", true );
        }
    }
    
    @GET
    public void newForm() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            render().layout("layouts/form_layout");
        }
    }
    
    @POST
    public void create() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Token t = new Token();
            t.fromMap(params1st());

            if (!Token.crear(t)) {
                flash("message", "No se ha podido generar el token de compra, revise los siguientes items");
                flash("errors", t.errors());
                flash("params", params1st());
                redirect(MetodoController.class, "new_form");
            } else {
                flash("message", "Nuevo Token generado: " + t.get("codigo"));
                redirect(TokenController.class);
            }
        }
    }
    
    @GET
    public void edit() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Token t = (Token) Token.findById(getId());
            render().layout("layouts/form_layout");
            view("tokens", t);
        }


    }

    @DELETE
    public void delete() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Token t = (Token) Token.findById(getId());
            String nombre = t.getString("codigo");
            Token.eliminar(t);
            flash("message", "Token: '" + nombre + "' eliminado");
            redirect(TokenController.class);
        }
    }
    
    @PUT
    public void update() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Token t = (Token) Token.findById(getId());
            t.fromMap(params1st());
            if(!Token.actualizar(t)){
                flash("message", "No se ha podido guardar el metodo de pago, revise los siguientes items");
                flash("errors", t.errors());
                flash("params", params1st());
                redirect(MetodoController.class, "edit");
            }else {
                flash("message", "Codigo : '" + t.get("codigo") + "' modificado");
                redirect(TokenController.class);
            }
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
