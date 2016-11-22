/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.controllers.authorization.Protected;
import app.models.Comentario;
import app.models.Usuario;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.DELETE;
import org.javalite.activeweb.annotations.POST;

/**
 *
 * @author universidad
 */
@Protected
public class ComentarioController extends AppController {
    
    @POST
    public void create(){
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            if(Usuario.getRol(usuario).getString("nombre").equals("admin")){
                redirect(app.controllers.admin.HomeController.class);
            } else {
                Comentario com  = new Comentario();
                com.fromMap(params1st());
                com.set("estado", 0);
                usuario.add(com);
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                com.set("fecha_alta", sqlDate);
                Comentario.comentar(com);
                flash("comentario", "Comentario Enviado!..");
                redirect(ProductoController.class,"show",com.get("productos_id"));
            }
        } else {
            redirect(HomeController.class);
        }
    }
    
    @DELETE
    public void delete(){
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            Comentario comentario = (Comentario) Comentario.findById(getId());
            if(!(usuario.get("id").equals(comentario.parent(Usuario.class).get("id")) 
                    || Usuario.getRol(usuario).getString("nombre").equals("admin"))){
                redirect(ProductoController.class,"show",comentario.get("productos_id"));
            } else {
                comentario.set("estado", 0);
                Comentario.comentar(comentario);
                flash("comentario", "Comentario Eliminado!..");
                if(!Usuario.getRol(usuario).getString("nombre").equals("admin")){
                    redirect(ProductoController.class,"show",comentario.get("productos_id"));
                } else {
                    redirect(app.controllers.admin.ProductoController.class,"show",comentario.get("productos_id"));
                }   
            }
        } else {
            redirect(HomeController.class);
        }
    }
}
