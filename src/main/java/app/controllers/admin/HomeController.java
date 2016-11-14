/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.admin;


import org.javalite.activeweb.AppController;

/**
 *
 * @author universidad
 */
public class HomeController extends AppController{
    public void index(){
        view("index_tienda", true );
    }
}
