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
public class Metodo extends Model{
    
     static{
        validatePresenceOf("nombre").message("Porfavor, ingrese el nombre del metodo de pago");
     }
    
    public static List lista_metodos() {
        return findAll();
    }
    
    public static List<SelectOption> selectedMetodos(){
        List<SelectOption> list = new LinkedList<>();
        List metodospagos = findAll();
        for (Iterator it = metodospagos.iterator(); it.hasNext();) {
            Metodo metodos = (Metodo) it.next();
            list.add(new SelectOption(metodos.get("id"), metodos.getString("nombre")));
        }
        return list;
    }

        public static List<SelectOption> selectedMetodos(Integer id){
        List<SelectOption> list = new LinkedList<>();
        List metodo = findAll();
        for (Iterator it = metodo.iterator(); it.hasNext();) {
            Metodo metodos = (Metodo) it.next();
            if(metodos.get("id").equals(id)){
                list.add(new SelectOption(metodos.get("id"), metodos.getString("nombre"), true));
            } else {
                list.add(new SelectOption(metodos.get("id"), metodos.getString("nombre")));
            }
        }
        return list;
    }
    
    public static boolean crear(Metodo m) {
        return m.save();
    }

    public static boolean eliminar(Metodo m) {
        return m.delete();
    }

    public static boolean actualizar(Metodo m) {
        return m.saveIt();
    }
    
    public static Categoria getMetodo(Object id){
        return findById(id);
    }
}
