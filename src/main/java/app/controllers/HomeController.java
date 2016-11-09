/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Categoria;
import app.models.Producto;
import java.util.List;
import org.javalite.activeweb.AppController;

/**
 *
 * @author universidad
 */
public class HomeController extends AppController {
    
    public void index() {
        view("path_imagen",appContext().get("path_imagen"));
        List recomendados = Producto.getProductosRecomendados();
        view("recomendados", recomendados);
        List productos;
        if(!xhr()){
            productos = Producto.lista_productos();
            view("productos", productos);
            render().layout("layouts/public_layout");
        } else {
            productos = Producto.getProductoAjax(params1st().get("busqueda"));
            view("productos", productos);
            render().noLayout();
        }
        
    }
    
}
