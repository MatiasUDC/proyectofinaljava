/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.config;

import org.javalite.activeweb.AbstractDBConfig;
import org.javalite.activeweb.AppContext;

/**
 *
 * @author rmpalacio
 */
public class DbConfig extends AbstractDBConfig {

    public void init(AppContext context) {

        String pool = "java:comp/env/jdbc/tienda_java"; //ver context.xml
        //descomentar para habilitar
        environment("development").jndi(pool);
        //environment("production").jndi(pool);
    }
}
