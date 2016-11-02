/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;
import org.javalite.activeweb.freemarker.SelectOption;


/**
 *
 * @author Matias
 */
@Table("metodos")
public class MetodoPago extends Model{
    
    static{
        validatePresenceOf("nombre").message("Por favor, ingrese el nombre del Metodo de Pago");   
    }
     
    public static List lista_metodos() {
        return findAll();
    }
    
    public static List<SelectOption> selectedMetodoPago(){
        List<SelectOption> list = new LinkedList<>();
        List metodos = findAll();
        for (Iterator it = metodos.iterator(); it.hasNext();) {
            MetodoPago metodo = (MetodoPago) it.next();
            list.add(new SelectOption(metodo.get("id"), metodo.getString("nombre")));
        }
        return list;
    }
          
    public static boolean crear(MetodoPago m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void eliminar(MetodoPago m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean actualizar(MetodoPago m) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
