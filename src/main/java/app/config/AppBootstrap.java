/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.config;

import org.javalite.activeweb.AppContext;
import org.javalite.activeweb.Bootstrap;
import org.javalite.activeweb.Configuration;

/**
 *
 * @author universidad
 */
public class AppBootstrap extends Bootstrap {

    @Override
    public void init(AppContext ac) {
        Configuration.setUseDefaultLayoutForErrors(false);
        ac.set("path_imagen_disc", "C:\\Users\\Soraya\\Documents\\NetBeansProjects\\proyectofinaljava\\src\\main\\webapp\\imagenes\\");
        ac.set("path_imagen", "imagenes\\");
    }
    
}
