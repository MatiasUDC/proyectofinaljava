/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import org.javalite.activeweb.AppController;
import org.javalite.activeweb.annotations.GET;

/**
 *
 * @author cesar
 */
public class BowerComponentsController extends AppController {
    @GET
    public void index() throws FileNotFoundException{
        
        File f = new File(url());
        sendFile(f).status(200);
    }
}
