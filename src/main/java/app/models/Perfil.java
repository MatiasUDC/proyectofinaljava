/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.BelongsToParents;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author universidad
 */
@Table("perfiles")
/*
@BelongsToParents({
    @BelongsTo(foreignKeyName = "cuidad_id", parent = Producto.class)
})
*/


public class Perfil extends Model{
    public static boolean actualizar(Perfil perfil){
 
        return perfil.saveIt();
    }
}
