/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import org.javalite.activeweb.AppController;
import app.models.Categoria;
import java.util.List;

/**
 *
 * @author universidad
 */
public class CategoriaController extends AppController {
    public void index(){
        List categorias = Categoria.lista_categorias();
        view("categorias", categorias);
    }

}
