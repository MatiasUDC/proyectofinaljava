/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Comentario;
import app.models.Producto;
import app.models.Usuario;
import org.javalite.activeweb.AppController;

/**
 *
 * @author universidad
 */
public class ComentarioController extends AppController {
    public void create (){
        Producto prod = Producto.getProducto(getId());
        Comentario com  = new Comentario();
        com.fromMap(params1st());
        com.set(prod);
        Usuario user = (Usuario) session().get("usuario");
        com.set(user);
    }
}
