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
import java.security.*;
import java.math.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Matias
 */
@Table("usuarios")
@BelongsToParents({
    @BelongsTo(foreignKeyName = "perfil_id", parent = Perfil.class)
    ,
    @BelongsTo(foreignKeyName = "rol_id", parent = Rol.class)
})
public class Usuario extends Model {

    private static final int NO_VERIFICADO = 0;
    private static final int VERIFICADO = 1;
    private static final int MAXIMO_TAMANIO_TOKEN = 16;
    
    static{
        validateEmailOf("email").message("EL email es requerido");
        validatePresenceOf("password").message("La contraseña es requerida");
    }
    
    public static List lista_usuario(Object id) {
        return where("id != ?", id);
    }

    public static boolean crear(Usuario u, boolean usuario) {

        boolean save = u.save();
        if (save) {
            if (!usuario) {
                u.set("verificado", 1);
                String name = u.get("email").toString().
                        substring(0, u.get("email").toString().
                                lastIndexOf('@'));
                Perfil perfil = new Perfil();
                perfil.set("nombre", name);
                perfil.set("apellido", name);
                perfil.saveIt();
                List rolUsuer = Rol.getRol("admin");
                if (rolUsuer.isEmpty()) {
                    perfil.delete();
                    u.delete();
                    return false;
                }
                u.set("perfil_id", perfil.get("id"));
                save = u.saveIt();
            } else {
                u.set("verificado", NO_VERIFICADO);
                String token = u.getString("email");
                Date fecha = new Date();
                token = token.concat("" + fecha.getTime());

                u.set("token", generarToken(token));
                /* genero nombre de perfil */
                String name = u.get("email").toString().
                        substring(0, u.get("email").toString().
                                lastIndexOf('@'));
                Perfil perfil = new Perfil();
                perfil.set("nombre", name);
                perfil.set("apellido", name);
                perfil.saveIt();
                List rolUsuer = Rol.getRol("usuario");
                if (rolUsuer.isEmpty()) {
                    perfil.delete();
                    u.delete();
                    return false;
                }
                u.set("perfil_id", perfil.get("id"));
                save = u.saveIt();

            }
        }
        return save;
    }

    public static boolean eliminar(Usuario u) {
        return u.delete();
    }

    public static boolean actualizar(Usuario u) {
        return u.saveIt();
    }

    public static List getUsurio(String email, String password) {
        return where("email = ? and password = ?", email, password);

    }

    public static Usuario getUsurioEmail(String email) {
        
        List usuario  = where("email = ?", email);
        if(usuario.isEmpty()){
            return null;
        }
        return (Usuario)usuario.get(0);
    }

    public static Rol getRol(Usuario user) {
        return user.parent(Rol.class);
    }

    public static List getUsurio(String id) {
        return where("id = ?", id);

    }

    public static List getUsersRol(Rol rol) {
        return where("rol_id = ? ", rol.get("id"));
    }

    public static boolean verificarCuenta(String token) {
        List usuario = where("token = ? AND verificado = ?", token, NO_VERIFICADO);
        if (!usuario.isEmpty()) {
            Usuario user = (Usuario) usuario.get(0);
            user.set("verificado", VERIFICADO);
            user.saveIt();
            return true;
        }
        return false;
    }

    public static Perfil getPerfil(Usuario u) {
        
        Perfil perfil = u.parent(Perfil.class);
        return perfil;
    }


    public static String generarToken(String token) {
        try {
            MessageDigest m;
            /* Genero MD5 */
            m = MessageDigest.getInstance("MD5");
            m.update(token.getBytes(), 0, token.length());
            return new BigInteger(1, m.digest()).toString(MAXIMO_TAMANIO_TOKEN);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public static Usuario buscarCuenta(String token) {
        List users = Usuario.where("token = ?", token);
        if(users.isEmpty()){
            return null;
        }
        return (Usuario)users.get(0);
    }


    public static List<Problema> lista_problemas_usuario(Usuario u) {
        List<Problema> problemas = u.getAll(Problema.class);
        return problemas;
    }

}
