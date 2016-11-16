/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.admin;


import org.javalite.activeweb.AppController;
import app.models.Tienda;
/**
 *
 * @author universidad
 */
public class HomeController extends AppController{
    public void index(){
        view("index_tienda", true );
    }
    public void edit(){
    	List tienda = Tienda.getTienda();
    	Tienda t = (Tienda) tienda.get(0);
    	view( "tienda",t );
    	render().layout("layouts/form_layout");
    }

    @PUT
    public void update() {
    	List tienda = Tienda.getTienda();
    	Tienda t = (Tienda) tienda.get(0);
        if(!Tienda.actualizarInfoTienda(t)){
            flash("message", "No se ha podido guardar la informacion, revise los siguientes items");
            flash("errors", c.errors());
            flash("params", params1st());
            redirect(HomeController.class, "edit");
        }else {
            flash("message", "informacion: actualizada modificada");
            redirect(HomeController.class);
        }
    }
}