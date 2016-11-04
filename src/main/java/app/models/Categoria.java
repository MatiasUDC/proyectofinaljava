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
import org.javalite.activejdbc.annotations.*;
import org.javalite.activeweb.freemarker.SelectOption;

/**
 *
 * @author universidad
 */
@Table("categorias")
public class Categoria extends Model{
    static{
        validatePresenceOf("nombre").message("Porfavor, ingrese el nombre del producto");
        validatePresenceOf("descripcion").message("Porfavor, ingrese una descripcion del producto");
    }
    
    public static List lista_categorias() {
        return findAll();
    }
    
    public static List<SelectOption> selectedCategoria(){
        List<SelectOption> list = new LinkedList<>();
        List categorias = findAll();
        for (Iterator it = categorias.iterator(); it.hasNext();) {
            Categoria categoria = (Categoria) it.next();
            list.add(new SelectOption(categoria.get("id"), categoria.getString("nombre")));
        }
        return list;
    }

        public static List<SelectOption> selectedCategoria(Object id){
        List<SelectOption> list = new LinkedList<>();
        List categorias = findAll();
        for (Iterator it = categorias.iterator(); it.hasNext();) {
            Categoria categoria = (Categoria) it.next();
            if(categoria.getId().equals(id)){
                list.add(new SelectOption(categoria.get("id"), categoria.getString("nombre"), true));
            } else {
                list.add(new SelectOption(categoria.get("id"), categoria.getString("nombre")));
            }
        }
        return list;
    }
    
    public static boolean crear(Categoria c) {
        return c.save();
    }

    public static boolean eliminar(Categoria c) {
        return c.delete();
    }

    public static boolean actualizar(Categoria c) {
        return c.saveIt();
    }
    
    public static Categoria getCategoria(Object id){
        return findById(id);
    }
}
