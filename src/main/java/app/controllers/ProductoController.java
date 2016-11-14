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
 * @author cesar
 */
public class ProductoController extends AppController {
    public void show(){
        Producto p = (Producto) Producto.getProducto(getId());
        List cs =  Categoria.lista_categorias();
      
        render().layout("layouts/public_layout");
        view("categorias", cs);
        view("producto", p);
        view("path_imagen", appContext().get("path_imagen"));
        List recomendados = Producto.getProductosRecomendados();
        view("recomendados", recomendados);
    }
}
