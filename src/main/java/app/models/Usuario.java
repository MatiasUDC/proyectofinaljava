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
import java.security.*;
import java.math.*;
import java.util.Date;

/**
 *
 * @author Matias
 */
@Table("usuarios")
@BelongsToParents({
    @BelongsTo(foreignKeyName = "perfil_id", parent = Perfil.class),
    @BelongsTo(foreignKeyName = "rol_id", parent = Rol.class)
})
public class Usuario extends Model {

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
                u.set("verificado", 0);
                String token = u.getString("email");
                Date fecha = new Date();
                token = token.concat("" + fecha.getTime());
                MessageDigest m;
                try {
                    /* Genero MD5 */
                    m = MessageDigest.getInstance("MD5");
                    m.update(token.getBytes(), 0, token.length());
                    u.set("token", new BigInteger(1, m.digest()).toString(16));
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
                } catch (NoSuchAlgorithmException ex) {;
                }

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
        List usuario = where("token = ? AND verificado = ?", token, 0);
        if (!usuario.isEmpty()) {
            Usuario user = (Usuario) usuario.get(0);
            user.set("verificado", 1);
            user.saveIt();
            return true;
        }
        return false;
    }

    public static Perfil getPerfil(int id) {
        Perfil perfil = Perfil.findById(id);
        return perfil;
    }
   
}
