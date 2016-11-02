/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import org.javalite.activeweb.AppController;
import app.models.MetodoPago;

import java.util.List;
import org.javalite.activeweb.annotations.DELETE;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;
import org.javalite.activeweb.annotations.PUT;
/**
 *
 * @author Matias
 */
public class MetodoPagoController extends AppController{
    public void index(){
        List metodos = MetodoPago.lista_metodos();
        view("metodos", metodos);
    }
    
    @GET
    public void newForm() {
        render().layout("layouts/form_layout");
    }
    
    @POST
    public void create() {
        MetodoPago m = new MetodoPago();
        m.fromMap(params1st());

        if (!MetodoPago.crear(m)) {
            flash("message", "No se ha podido registrar el metodo de pago, revise los siguientes items");
            flash("errors", m.errors());
            flash("params", params1st());
            redirect(CategoriaController.class, "new_form");
        } else {
            flash("message", "Nuevo metodo de pago registrado: " + m.get("nombre"));
            redirect(CategoriaController.class);
        }
    }
    @GET
    public void edit() {
       
        MetodoPago m = (MetodoPago) MetodoPago.findById(getId());
        render().layout("layouts/form_layout");
        view("metodos", m);


    }

    @DELETE
    public void delete() {
        MetodoPago m = (MetodoPago) MetodoPago.findById(getId());
        String nombre = m.getString("nombre");
        MetodoPago.eliminar(m);
        flash("message", "Metodo de Pago: '" + nombre + "' eliminado");
        redirect(MetodoPagoController.class);
    }
    
    @PUT
    public void update() {
        MetodoPago m = (MetodoPago) MetodoPago.findById(getId());
        m.fromMap(params1st());
        if(!MetodoPago.actualizar(m)){
            flash("message", "No se ha podido guardar el Metodo de Pago, revise los siguientes items");
            flash("errors", m.errors());
            flash("params", params1st());
            redirect(CategoriaController.class, "edit");
        }else {
            flash("message", "Metodo de Pago : '" + m.get("nombre") + "' modificado");
            redirect(CategoriaController.class);
        }
    }
}
