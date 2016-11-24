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
import app.models.Usuario;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.*;
import org.javalite.activeweb.freemarker.SelectOption;

/**
 *
 * @author Matias
 */
@Protected
public class CompraController extends AppController {
    private static final int MAXIMO_TAMANIO_TOKEN = 12;
    @GET
    public void index() {
        if(!control()){
            redirect(app.controllers.HomeController.class);
        } else {
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
    }

    @GET
    public void newForm() {
        if(control()){
            redirect(app.controllers.HomeController.class);
        } else {
            //declaro producto
            Producto producto = Producto.findById(getId());
            view("producto", producto);
            java.util.List<SelectOption> list = Metodo.selectedMetodos();
            view("metodos", list);
            render().layout("layouts/public_layout");
        }
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
        Integer cantidad = compra.getInteger("cantidad");
        Double precio = producto.getDouble("precio");
        Double totalPagar = (Double)(cantidad*precio);
        compra.set("monto", totalPagar);
        int stock = producto.getInteger("stock");

        compra.set("token", generarToken());

        
        if (stock != 0) {
            if (stock > cantidad) {
                int resta = stock - cantidad;
                producto.set("stock", resta);

                if (!Compra.registrar(compra)) {
                    
                    flash("message", "No se ha podido registar la compra, revise los siguientes items");
                    flash("errors", compra.errors());
                    flash("params", params1st());
                    redirect(CompraController.class, "new_form",producto.get("id"));
                } else {
                    Producto.actualizar(producto);
                    flash("message", "La Compra fue realizada correctamente");
                    redirect(HomeController.class);
                }
            } else {
                flash("message", "Stock insuficiente disponible para la compra, por favor prueba con otra cantidad");
                flash("errors", compra.errors());
                flash("params", params1st());
                redirect(CompraController.class, "new_form", producto.get("id"));
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
        if(!control()){
            redirect(app.controllers.HomeController.class);
        } else {
            Compra c = (Compra) Compra.findById(getId());
            java.util.List<SelectOption> list = Metodo.selectedMetodos();
            view("metodos", list);
            view("compra", c);
        }
    }

    @DELETE
    public void delete() {
        if(!control()){
            redirect(app.controllers.HomeController.class);
        } else {
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
    public boolean control(){
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            return Usuario.getRol(usuario).getString("nombre").equals("user");
        }
        return false;

    }
    public String generarToken() {
        String token = new Date().getTime()+""+new Date().getSeconds();
        try {
            MessageDigest m;
            /* Genero MD5 */
            m = MessageDigest.getInstance("MD5");
            m.update(token.getBytes(), 0, token.length());
            return new BigInteger(1, m.digest()).toString(MAXIMO_TAMANIO_TOKEN);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.INFO, null, ex);
        }
        return null;
    }
}
