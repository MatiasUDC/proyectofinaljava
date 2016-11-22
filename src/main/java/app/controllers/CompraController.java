/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.controllers.authorization.Protected;
import app.models.Compra;
import app.models.Metodo;
import app.models.Producto;
import app.models.Token;
import app.models.Usuario;
import java.util.List;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;
import org.javalite.activeweb.freemarker.SelectOption;

/**
 *
 * @author Matias
 */
@Protected
public class CompraController extends AppController {

    @GET
    public void index() {
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            if(Usuario.getRol(usuario).getString("nombre").equals("admin")){
                redirect(app.controllers.admin.HomeController.class);
            } else {
                //view("producto", Compra.TraerProducto()
                view("compras", Compra.lista_compras());
            }
        }

    }

    @GET
    public void newForm() {
        //declaro producto
        Producto producto = Producto.findById(getId());
        view("producto", producto);
        java.util.List<SelectOption> token = Token.token();
        view("token", token);
        java.util.List<SelectOption> list = Metodo.selectedMetodos();
        view("metodos", list);
        render().layout("layouts/form_layout");
    }

    @POST
    public void create() {
        Compra compra = new Compra();
        compra.fromMap(params1st());
        
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        
        int id_usu = usuario.getInteger("id");
        compra.set("usuario_id",id_usu);
        
        Producto producto = Compra.TraerProducto(compra.getInteger("id_producto"));
        
        int stock = producto.getInteger("stock");
        int cantidad = compra.getInteger("cantidad");
        
        if (compra.getInteger("id_token") == 0){
            compra.set("id_token", null);
        }
        
        if (stock != 0) {
            if (stock > cantidad) {
                int resta = stock - cantidad;
                producto.set("stock", resta);

                if (!Compra.registrar(compra)) {
                    
                    flash("message", "No se ha podido registar la compra, revise los siguientes items");
                    flash("errors", compra.errors());
                    flash("params", params1st());
                    redirect(CompraController.class, "new_form");
                } else {
                    Producto.actualizar(producto);
                    flash("message", "La Compra fue realizada correctamente");
                    redirect(HomeController.class);
                }
            } else {
                flash("message", "Stock insuficiente disponible para la compra, por favor prueba con otra cantidad");
                flash("errors", compra.errors());
                flash("params", params1st());
                redirect(CompraController.class, "new_form");
            }
        } else {
            flash("message", "Producto no Disponible para compra por falta de Stock");
            flash("errors", compra.errors());
            flash("params", params1st());
            redirect(CompraController.class, "index");
        }

    }

    @GET
    public void edit() {

        Compra c = (Compra) Compra.findById(getId());
        java.util.List<SelectOption> list = Metodo.selectedMetodos();
        view("metodos", list);
        view("compra", c);

    }

    @DELETE
    public void delete() {
        Compra c = (Compra) Compra.findById(getId());
        Producto p = Compra.TraerProducto(c.getInteger("id_producto"));
        String nombre = p.getString("nombre");
        int stock = p.getInteger("stock");
        int cantidad = c.getInteger("cantidad");
        int suma = stock + cantidad;
        p.set("stock", suma);
        Producto.actualizar(p); 
        Compra.baja(c);
        flash("message", "La compra de : '" + nombre + "'fue dada de baja correctamente");
        redirect(UsuarioController.class);
    }

    @PUT
    public void update() {
        Compra c = (Compra) Compra.findById(getId());
        c.fromMap(params1st());
        if (!Compra.actualizar(c)) {
            flash("message", "No se ha podido actulizar la compra, revise los siguientes items");
            flash("errors", c.errors());
            flash("params", params1st());
            redirect(CompraController.class, "edit");
        } else {
            flash("message", "Los datos de Compra del producto : '" + c.get("producto") + "' fueron modificados");
            redirect(CompraController.class);
        }
    }


}
