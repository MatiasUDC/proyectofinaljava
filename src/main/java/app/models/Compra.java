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
@Table("compras")
@BelongsToParents({
    @BelongsTo(foreignKeyName = "id_producto", parent = Producto.class),
    @BelongsTo(foreignKeyName = "id_usuario", parent = Usuario.class),
    @BelongsTo(foreignKeyName = "id_metodo", parent = Metodo.class)
})
public class Compra extends Model {

    static {
        /*
        validateNumericalityOf("Cantidad")
                .allowNull(true).greaterThan(1)
                .message("Por favor, Ingrese un monto de productos validos.");   
        validateNumericalityOf("id_metodo")
                .allowNull(true)
                .greaterThan(1).message("Porfavor, Seleccione una metodo para la compra");
         */
    }

    public static List lista_compras() {

        return findAll();
    }

    public static boolean registrar(Compra compra) {

        return compra.save();

    }

    public static boolean baja(Compra compra) {

        return compra.delete();

    }

    public static boolean actualizar(Compra compra) {
        return compra.saveIt();
    }

 

    public static List<Compra> TraerProducto(int id) {
        Producto producto = Producto.findById(id);
        List<Compra> compras = producto.getAll(Compra.class);
        return compras;
    }

}
