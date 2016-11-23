/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Compra;
import app.models.Problema;
import app.models.Producto;
import app.models.Usuario;
import app.models.Comentario;
import app.models.Perfil;

import java.util.List;
import org.javalite.activeweb.AppController;

/**
 *
 * @author Matias
 */
public class UsuarioController extends AppController{
    public void index(){
        if(!control()){
            redirect(app.controllers.HomeController.class);
        } else {
            render().layout("layouts/public_layout");
        }
    }
    public void compra(){
        if(!control()){
            redirect(app.controllers.HomeController.class);
        } else {
            view("path_imagen",appContext().get("path_imagen"));
            List compras = Compra.lista_compras();
            view("compras",compras);
            render().layout("layouts/public_layout");  
        }
    }
    public void problema(){
        if(!control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Usuario usuario;
            usuario = (Usuario) session().get("user");
            List problemas = Usuario.lista_problemas_usuario(usuario);
            view("problemas",problemas);
            render().layout("layouts/public_layout");
        }
    }
    public void comentario(){
    
        if(!control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Usuario usuario;
            usuario = (Usuario) session().get("user");
            List comentario = Comentario.listaComentariosUsuario(usuario);
            view("comentarios",comentario);
            render().layout("layouts/public_layout");   
        }
    }
    public void perfil(){
        if(!control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Usuario usuario;
            usuario = (Usuario) session().get("user");
            Perfil perfil = Usuario.getPerfil(usuario);
            view("perfil", perfil);
            render().layout("layouts/public_layout"); 
        }
    }
    public void verificar(){
        String token = param("key");
        boolean verificada = Usuario.verificarCuenta(token);
        if (verificada){
            flash("login", "Cuenta verificada, puede iniciar sesión");
        }
        redirect(LoginController.class);
    }

    
    public void restaurar(){
        String token = param("key");
        Usuario user = Usuario.buscarCuenta(token);
        if (user == null){
            flash("restaurar", "No se ha encontrado el Usuario.");
            redirect(LoginController.class);
        } else {
            view("usuario", user);
            render().layout("layouts/public_layout");
        }
    }
    
    public void contrasenia(){
        Usuario user = (Usuario)Usuario.getUsurio(param("usuario_id"));
        user.set("password", param("password"));
        if(!Usuario.actualizar(user)){
            flash("password", "No se ha podido cambiar las contraseña.");
            flash("errors", user.errors());
            flash("params", params1st());
            redirect(UsuarioController.class,"restaurar?key"+user.get("token"));
        } else {
            redirect(HomeController.class);
        }
    }

    public boolean control(){
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            return Usuario.getRol(usuario).getString("nombre").equals("user");
        }
        return false;

    }
}
