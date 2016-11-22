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
@Table("problemas_comentarios")
@BelongsToParents({ 
    @BelongsTo(foreignKeyName="usuario_admin_id",parent=Usuario.class), 
    @BelongsTo(foreignKeyName="problema_id",parent=Problema.class) 
}) 
public class ProblemasComentarios extends Model{
    public static List getProblemasComentarios(Problema problema){
        return problema.getAll(ProblemasComentarios.class).orderBy("fecha_alta");
    }
    
    public static boolean comentarProblema(ProblemasComentarios problemasComentarios){
        return problemasComentarios.saveIt();
    }
    
}
