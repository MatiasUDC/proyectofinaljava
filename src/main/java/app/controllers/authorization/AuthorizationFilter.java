/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers.authorization;

import app.controllers.LoginController;
import org.javalite.activeweb.controller_filters.HttpSupportFilter;

/**
 *
 * @author universidad
 */
public class AuthorizationFilter extends HttpSupportFilter {
    @Override
    public void before() {

        if(!controllerProtected()){
            return; 
        }

        if(!sessionHas("user") && controllerProtected()){
            redirect(LoginController.class);
        }
    }

    private boolean controllerProtected() {
        return getRoute().getController().getClass().getAnnotation(Protected.class) != null;
} 
}
