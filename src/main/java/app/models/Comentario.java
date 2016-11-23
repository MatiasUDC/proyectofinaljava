/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.List;
import org.javalite.activejdbc.LazyList;
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
@BelongsTo(foreignKeyName="usuarios_id",parent=Usuario.class), 
@BelongsTo(foreignKeyName="productos_id",parent=Producto.class) 
}) 
public class Comentario extends Model{
    static{
        validatePresenceOf("comentario").message("Porfavor, un comentario");
    }
    
    public static List listaCompentariosProducto(Producto prod){
        return prod.get(Comentario.class, "estado = ?",1).orderBy("fecha_alta desc");
    }
    
    public static List listaComentariosUsuario(Usuario usuario){
        List comentario = usuario.getAll(Comentario.class);
        return comentario;
    }        
    public static boolean comentar(Comentario comentario){
        return comentario.saveIt();
    }
}
