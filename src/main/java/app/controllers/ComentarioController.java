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
import java.sql.Date;
import org.javalite.activeweb.AppController;
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
                Producto prod = Producto.getProducto(getId());
                com.set("comentario", param("comentario"));
                com.set(prod);
                com.set(usuario);
                java.util.Date utilDate = new java.util.Date();
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                com.set("fecha_alta", sqlDate);
                if(Comentario.comentar(com)){
                    flash("comentario", "No se ha podido comentar");
                    flash("errors", com.errors());
                    flash("params", params1st());
                } else {
                    flash("comentario", "Comentario Enviado!..");
                }
                redirect(ProductoController.class,"show",prod.get("id_producto"));
            }
        }
        redirect(HomeController.class);
    }
}
