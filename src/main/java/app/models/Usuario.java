/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.List;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.BelongsToParents;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author Soraya
 */

@Table("usuarios")
@BelongsToParents({ 
@BelongsTo(foreignKeyName="perfil_id",parent=Perfil.class), 
@BelongsTo(foreignKeyName="rol_id",parent=Rol.class) 
})
public class Usuario extends Model{
    public static List getUsurio( String email, String password ){
        return where( "email = ? and password = ?", email, password );
        
    }
    public Rol getRol(Usuario user){
        return user.parent(Rol.class);
    }
}
