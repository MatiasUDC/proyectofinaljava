/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.admin;
import app.controllers.authorization.Protected;
import org.javalite.activeweb.AppController;
import app.models.Metodo;

import java.util.List;
import org.javalite.activeweb.annotations.DELETE;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.PUT;
/**
 *
 * @author Matias
 */
@Protected
public class MetodoController extends AppController{
   public void index(){
        List metodos = Metodo.lista_metodos();
        view("metodos", metodos);
        view("index_metodo", true );
    }
    
    @GET
    public void newForm() {
        render().layout("layouts/form_layout");
    }
    
    @POST
    public void create() {
        Metodo m = new Metodo();
        m.fromMap(params1st());

        if (!Metodo.crear(m)) {
            flash("message", "No se ha podido crear el metodo de pago, revise los siguientes items");
            flash("errors", m.errors());
            flash("params", params1st());
            redirect(MetodoController.class, "new_form");
        } else {
            flash("message", "Nuevo Metodo de Pago agregado: " + m.get("nombre"));
            redirect(MetodoController.class);
        }
    }
    @GET
    public void edit() {
       
        Metodo m = (Metodo) Metodo.findById(getId());
        render().layout("layouts/form_layout");
        view("metodos", m);


    }

    @DELETE
    public void delete() {
        Metodo  m = (Metodo) Metodo.findById(getId());
        String nombre = m.getString("nombre");
        Metodo.eliminar(m);
        flash("message", "Metodo de Pago: '" + nombre + "' eliminado");
        redirect(MetodoController.class);
    }
    
    @PUT
    public void update() {
        Metodo m = (Metodo) Metodo.findById(getId());
        m.fromMap(params1st());
        if(!Metodo.actualizar(m)){
            flash("message", "No se ha podido guardar el metodo de pago, revise los siguientes items");
            flash("errors", m.errors());
            flash("params", params1st());
            redirect(MetodoController.class, "edit");
        }else {
            flash("message", "Metodo de Pago: '" + m.get("nombre") + "' modificada");
            redirect(MetodoController.class);
        }
    }
}
