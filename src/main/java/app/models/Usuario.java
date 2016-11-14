/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.List;
import org.javalite.activejdbc.Model;
import static org.javalite.activejdbc.Model.findAll;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author Matias
 */
@Table("usuario")
public class Usuario extends Model{
    
     public static List lista_usuario() {
        return findAll();
    }

    public static boolean crear(Usuario u) {
        return u.save();
    }

    public static boolean eliminar(Usuario u) {
        return u.delete();
    }

    public static boolean actualizar(Usuario u) {
        return u.saveIt();
    }
}
