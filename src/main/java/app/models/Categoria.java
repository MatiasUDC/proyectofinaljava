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

    public static boolean crear(Categoria c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static void eliminar(Categoria p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public static boolean actualizar(Categoria p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
