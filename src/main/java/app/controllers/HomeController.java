/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Categoria;
import app.models.Producto;
import app.models.Usuario;
import java.util.List;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.POST;

/**
 *
 * @author universidad
 */
public class HomeController extends AppController {
    
    public void index() {
        view("path_imagen",appContext().get("path_imagen"));
        List recomendados = Producto.getProductosRecomendados();
        List cs = Categoria.lista_categorias();
        view("categorias", cs);
        view("recomendados", recomendados);
        List productos;
        productos = Producto.lista_productos();
        view("productos", productos);
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            if(Usuario.getRol(usuario).getString("nombre").equals("admin")){
                redirect(app.controllers.admin.HomeController.class);
            }
            view("usuario", usuario);
        }
        render().layout("layouts/public_layout"); 
    }
    @POST
    public void busqueda(){
        List productos = Producto.getProductoAjax(params1st().get("busqueda"));
        if(productos.isEmpty()){
            String message = "No se han econtrado resultados...";
            view("message", message);
        }
        view("productos", productos);
        view("path_imagen",appContext().get("path_imagen"));
        render().noLayout();
    }
}
