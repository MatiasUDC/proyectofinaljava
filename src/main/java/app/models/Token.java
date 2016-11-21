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
    public static List token() {
        List<SelectOption> list = new LinkedList<>();
        List tokens = findAll();
        for (Iterator it = tokens.iterator(); it.hasNext();) {
            Token token = (Token) it.next();
            list.add(new SelectOption(token.get("id"), token.getString("codigo")));
        }
        return list;
    }
}
