/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
import app.models.Cliente;
import java.util.List;

import org.javalite.activeweb.AppController;
import org.javalite.activeweb.FormItem;
/**
 *
 * @author universidad
 */
public class ClienteController extends AppController{
    public void index(){
        List clientes = Cliente.lista_clientes();
        view("clientes", clientes);
        view("name", "John Doe");

    }
    public void newForm(){}
    public void create(){}
    public void show(){}
    public void destroy(){}

}
