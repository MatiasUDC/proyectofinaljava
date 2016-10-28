/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.List;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author universidad
 */
@Table("clientes")
public class Cliente extends Model{
    
    public static List lista_clientes(){
        return findAll();
    }
}
