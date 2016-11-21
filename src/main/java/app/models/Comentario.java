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
 * @author universidad
 */
@Table("comentarios")
@BelongsToParents({ 
    @BelongsTo(foreignKeyName="id_usuario",parent=Usuario.class), 
    @BelongsTo(foreignKeyName="id_producto",parent=Producto.class) 
})
public class Comentario extends Model{
    public static List listaCompentariosProducto(Producto prod){
        return prod.getAll(Comentario.class).orderBy("fecha_alta desc");
    }
    public static List comentario_usuario(Usuario usuario){
        return where("id_usuario = ?", usuario.getId()).orderBy("id_producto desc");
    }
    public static List listaCompentariosUsuario(Usuario usuario){
        return usuario.getAll(Comentario.class);
    }        
    public static boolean comentar(Comentario comentario){
        return comentario.saveIt();
    }
}
