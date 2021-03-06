/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.models.Categoria;
import app.models.Producto;
import app.models.Comentario;
import app.models.Usuario;
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
        List comentarios = Comentario.listaCompentariosProducto(p);
        List recomendados = Producto.getProductosRecomendados();
        
        view("categorias", cs);
        view("producto", p);
        view("path_imagen", appContext().get("path_imagen"));
        view("recomendados", recomendados);
        view("comentarios", comentarios);
        Usuario usuario;
        usuario = (Usuario) session().get("user");
        if(usuario != null){
            if(Usuario.getRol(usuario).getString("nombre").equals("admin")){
                redirect(app.controllers.admin.HomeController.class);
            } else {
                view("usuario", usuario);
                render().layout("layouts/public_layout");
            }
        } else {
            render().layout("layouts/public_layout");
        }
    }
}
