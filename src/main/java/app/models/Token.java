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
@Table("tokencompra")
public class Token extends Model{
    public static List token() {
        return findAll().orderBy("rand()").limit(1);
    }
}
