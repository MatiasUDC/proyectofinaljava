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

/**
 *
 * @author universidad
 */
public class CategoriaController extends AppController{
    public void show(){
        
        Categoria c = Categoria.getCategoria(getId());
        List productos = Producto.where("categoria_id = ?", c.get("id"));

        view("path_imagen",appContext().get("path_imagen"));
        List recomendados = Producto.getProductosRecomendados();
        List cs = Categoria.lista_categorias();
        view("categorias", cs);
        view("recomendados", recomendados);
        view("productos", productos);
                Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            if(Usuario.getRol(usuario).getString("nombre").equals("admin")){
                redirect(app.controllers.admin.HomeController.class);
            }
            else
            {
                view("usuario", usuario);
                render("/home/index").layout("layouts/public_layout");
            }
        }else{
            render("/home/index").layout("layouts/public_layout"); 
        }
        
        
    }
}
