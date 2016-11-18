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

import java.util.List;
import org.javalite.activeweb.AppController;

/**
 *
 * @author Matias
 */
public class UsuarioController extends AppController{
    public void index(){
        List productos = Producto.lista_productos();
        view("productos",productos);
        render().layout("layouts/public_layout");
        /*
        List usuario = Usuario.lista_usuario();
        view("usuario", usuario);*/    
    }
    public void compra(){
        List compras = Compra.lista_compras();
        view("compras",compras);
        render().layout("layouts/public_layout");
        /*
        List usuario = Usuario.lista_usuario();
        view("usuario", usuario);*/    
    }
    public void problema(){
        List problemas = Problema.lista_problemas();
        view("problemas",problemas);
        render().layout("layouts/public_layout");
        /*
        List usuario = Usuario.lista_usuario();
        view("usuario", usuario);*/    
    }
    public void comentario(){
        Usuario usuario = Usuario.findById(getId());
        List comentario = Comentario.comentario_usuario(usuario);
        view("comentario",comentario);
        render().layout("layouts/public_layout");
        /*
        List usuario = Usuario.lista_usuario();
        view("usuario", usuario);*/    
    }
    public void perfil(){
        //List problemas = Problema.lista_problemas();
        //view("problemas",problemas);
        render().layout("layouts/public_layout");
        /*
        List usuario = Usuario.lista_usuario();
        view("usuario", usuario);*/    
    }
    public void verificar(){
        String token = param("key");
        boolean verificada = Usuario.verificarCuenta(token);
        if (verificada){
            flash("login", "Cuenta verificada, puede iniciar sesión");
        }
        redirect(LoginController.class);
    }
}
