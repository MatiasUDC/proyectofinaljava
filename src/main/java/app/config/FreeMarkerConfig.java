/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.config;

/**
 * 
 * @author rmpalacio
 */

public class FreeMarkerConfig extends org.javalite.activeweb.freemarker.AbstractFreeMarkerConfig {
    @Override
    public void init() {
        //https://www.stuartgunter.org/posts/freemarker-default-number-formatting/
        getConfiguration().setNumberFormat("0.##");
    }
}
