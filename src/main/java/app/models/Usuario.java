/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.List;
import org.javalite.activejdbc.Model;
import static org.javalite.activejdbc.Model.findAll;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.BelongsToParents;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author Matias
 */
@Table("usuarios")
@BelongsToParents({ 
@BelongsTo(foreignKeyName="perfil_id",parent=Perfil.class), 
@BelongsTo(foreignKeyName="rol_id",parent=Rol.class) 
})
public class Usuario extends Model{
    
    public static List lista_usuario() {
        return findAll();
    }

    public static boolean crear(Usuario u) {  
        boolean save = u.save();
        if(save){
            String name = u.get("email").toString().
                    substring(u.get("email").toString().
                            lastIndexOf('@'));
            Perfil perfil = new Perfil();
            perfil.set("nombre", name);
            perfil.saveIt();
            u.set(perfil);
            save = u.saveIt();
        }
        return save;
    }

    public static boolean eliminar(Usuario u) {
        return u.delete();
    }

    public static boolean actualizar(Usuario u) {
        return u.saveIt();
    }
    
    public static List getUsurio( String email, String password ){
        return where( "email = ? and password = ?", email, password );
        
    }
    public static Rol getRol(Usuario user){
        return user.parent(Rol.class);
    }
    public static List getUsurio( String email ){
        return where( "email = ?", email );
        
    }
    public static List getUsersRol(Rol rol){
        return where( "rol_id = ? ", rol.get("id") );
    }

}
