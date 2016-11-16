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
 * @author universidad
 */
@Table("rol")
public class Rol extends Model{
    public static List getRol(String nombre){
    	return where("nombre = ?", nombre).limit(1);
    }
    
    public static List<SelectOption> selectedRol(){
        List<SelectOption> list = new LinkedList<>();
        List roles = findAll().orderBy("nombre desc");
        for (Iterator it = roles.iterator(); it.hasNext();) {
            Rol rol = (Rol) it.next();
            list.add(new SelectOption(rol.get("id"), rol.getString("nombre")));
        }
        return list;
    }
    public static List<SelectOption> selectedRol(Object id){
        List<SelectOption> list = new LinkedList<>();
        List roles = findAll().orderBy("nombre desc");
        for (Iterator it = roles.iterator(); it.hasNext();) {
            Rol rol = (Rol) it.next();
            if(rol.getId().equals(id)){
                list.add(new SelectOption(rol.get("id"), rol.getString("nombre"), true));
            } else {
                list.add(new SelectOption(rol.get("id"), rol.getString("nombre")));
            }
        }
        return list;
    }
}
