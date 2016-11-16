/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.admin;


import app.models.Producto;

import java.util.List;
import org.javalite.activeweb.AppController;
import app.controllers.authorization.Protected;
import app.models.Categoria;
import app.models.Rol;
import app.models.Usuario;
import org.javalite.activeweb.annotations.GET;
import org.javalite.activeweb.annotations.POST;
/**
 *
 * @author Matias
 */
@Protected
public class UsuarioController extends AppController{
    public void index(){
        List productos = Producto.lista_productos();
        view("productos",productos);
        view("index_usuario", true );

        List usuarios = Usuario.lista_usuario();
        view("users", usuarios);  
    }
    
    @GET
    public void newForm() {
        List roles = Rol.selectedRol();
        view("roles", roles);
        render().layout("layouts/form_layout");
    }
    
    @POST
    public void create() {
        Usuario u = new Usuario();
        u.fromMap(params1st());

        if (!Usuario.crear(u)) {
            flash("message", "No se ha podido guardar la categoria, revise los siguientes items");
            flash("errors", u.errors());
            flash("params", params1st());
            redirect(CategoriaController.class, "new_form");
        } else {
            flash("message", "Nueva usuario registrado: " + u.get("nombre"));
            redirect(UsuarioController.class);
        }
    }
        @GET
    public void edit() {
       
        Usuario u = (Usuario) Usuario.findById(getId());
        List roles = Rol.selectedRol(u.get("rol_id"));
        view("roles", roles);
        view("usuario", u);
        render().layout("layouts/form_layout");
    }
}