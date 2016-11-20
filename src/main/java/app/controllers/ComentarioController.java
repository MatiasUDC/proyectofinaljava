/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.controllers.authorization.Protected;
import app.models.Comentario;
import app.models.Producto;
import app.models.Usuario;
import org.javalite.activeweb.AppController;

/**
 *
 * @author universidad
 */
@Protected
public class ComentarioController extends AppController {
    public void create (){
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            if(Usuario.getRol(usuario).getString("nombre").equals("admin")){
                redirect(app.controllers.admin.HomeController.class);
            } else {
                Producto prod = Producto.getProducto(getId());
                Comentario com  = new Comentario();
                com.fromMap(params1st());
                com.set(prod);
                com.set(usuario);
            }
        }

    }
}
