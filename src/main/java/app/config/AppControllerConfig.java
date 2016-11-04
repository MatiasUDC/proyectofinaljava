/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.config;

import app.controllers.authorization.AuthorizationFilter;
import org.javalite.activeweb.AbstractControllerConfig;
import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.controller_filters.DBConnectionFilter;

/**
 *
 * @author universidad
 */
public class AppControllerConfig extends AbstractControllerConfig {
    @Override
    public void init(AppContext context) {
        //Para la conexión a la base de datos
        addGlobalFilters(new DBConnectionFilter(), new AuthorizationFilter());

    }
}
