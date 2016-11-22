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
@Table("problemas")
@BelongsToParents({
    @BelongsTo(foreignKeyName = "id_compra", parent = Compra.class),
    @BelongsTo(foreignKeyName = "problema", parent = Tproblema.class)
})
public class Problema extends Model{
    static {
        /*
        validateNumericalityOf("Cantidad")
                .allowNull(true).greaterThan(1)
                .message("Por favor, Ingrese un monto de productos validos.");   
        validateNumericalityOf("id_metodo")
                .allowNull(true)
                .greaterThan(1).message("Porfavor, Seleccione una metodo para la problema");
         */
    }

    public static List lista_problemas() {

        return findAll();
    }
    public static boolean registrar(Problema problema) {

        return problema.save();

    }

    public static boolean baja(Problema problema) {

        return problema.delete();

    }

    public static boolean actualizar(Problema problema) {
        return problema.saveIt();
    }

}
