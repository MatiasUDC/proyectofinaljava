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
import static org.javalite.activejdbc.Model.findAll;
import org.javalite.activeweb.freemarker.SelectOption;

/**
 *
 * @author Matias
 */
public class Tproblema extends Model {

    public static List<SelectOption> selectedProblemas() {
        List<SelectOption> list = new LinkedList<>();
        List tipoproblemas = findAll();
        for (Iterator it = tipoproblemas.iterator(); it.hasNext();) {
            Tproblema tipoproblema = (Tproblema) it.next();
            list.add(new SelectOption(tipoproblema.get("id"), tipoproblema.getString("nombre")));
        }
        return list;
    }

    public static boolean crear(Tproblema p) {
        return p.save();
    }

    public static boolean eliminar(Tproblema p) {
        return p.delete();
    }

    public static boolean actualizar(Tproblema p) {
        return p.saveIt();
    }

    public static Problema getTipoProblema(Object id) {
        return findById(id);
    }

}
