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
import org.javalite.activejdbc.annotations.Table;
import org.javalite.activeweb.freemarker.SelectOption;

/**
 *
 * @author Matias
 */
@Table("tokencompra")
public class Token extends Model{
    public static List lista_tokens() {
        return findAll();
    }
    public static List token() {
        
        List<SelectOption> list = new LinkedList<>();
        List tokens = findAll().orderBy("rand()").limit(1);
        for (Iterator it = tokens.iterator(); it.hasNext();) {
            Token token = (Token) it.next();
            list.add(new SelectOption(token.get("id"), token.getString("codigo")));
        }
        return list;
    }
    public static List<SelectOption> selectedToken(Integer id){
        List<SelectOption> list = new LinkedList<>();
        List token = findAll();
        for (Iterator it = token.iterator(); it.hasNext();) {
            Token tokens = (Token) it.next();
            if(tokens.get("id").equals(id)){
                list.add(new SelectOption(tokens.get("id"), tokens.getString("codigo"), true));
            } else {
                list.add(new SelectOption(tokens.get("id"), tokens.getString("codigo")));
            }
        }
        return list;
    }
    
    public static boolean crear(Token t) {
        return t.save();
    }

    public static boolean eliminar(Token t) {
        return t.delete();
    }

    public static boolean actualizar(Token t) {
        return t.saveIt();
    }
    
    public static Compra getToken(Object id){
        return findById(id);
    }
}
