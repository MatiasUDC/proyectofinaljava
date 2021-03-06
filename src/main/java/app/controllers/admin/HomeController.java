/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.admin;


import org.javalite.activeweb.AppController;
import app.models.Tienda;
import app.models.Usuario;
import java.util.List;
import org.javalite.activeweb.annotations.PUT;
/**
 *
 * @author universidad
 */
public class HomeController extends AppController{
    public void index(){

        if(control()){
            redirect(app.controllers.HomeController.class);
        }
        else
        {
            view("index_tienda", true );
            List tienda = Tienda.getTienda();
            Tienda t = (Tienda) tienda.get(0);
            view( "tienda",t );
        }

    }
    public void edit(){
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            List tienda = Tienda.getTienda();
            Tienda t = (Tienda) tienda.get(0);
            view( "tienda",t );
            render().layout("layouts/form_layout");
        }
    }

    @PUT
    public void update() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            List tienda = Tienda.getTienda();
            Tienda t = (Tienda) tienda.get(0);
            t.fromMap(params1st());
            if(!Tienda.actualizarInfoTienda(t)){
                flash("message", "No se ha podido guardar la informacion, revise los siguientes items");
                flash("errors", t.errors());
                flash("params", params1st());
                redirect(HomeController.class, "edit");
            }else {
                flash("message", "informacion: actualizada modificada");
                redirect(HomeController.class);
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
