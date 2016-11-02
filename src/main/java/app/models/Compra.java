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
@Table("compra")
@BelongsToParents({
    @BelongsTo(foreignKeyName = "id_producto",parent = Producto.class),
    @BelongsTo(foreignKeyName = "id_usuario",parent = Usuario.class),
    @BelongsTo(foreignKeyName = "id_metodo",parent = MetodoPago.class)    
})
public class Compra extends Model {
    static{
        validateNumericalityOf("metodo_pagos_id")
                .allowNull(true)
                .greaterThan(1).message("Porfavor, Seleccione una metodo para la compra");
        validateNumericalityOf("cantidad_producto")
                .allowNull(true).greaterThan(1)
                .message("Profavor, Ingrese un monto de productos validos.");   
    }
    public static List lista_compras(){
        
        return findAll();
    }
    
    public static boolean registrar(Compra compra){
        
        return compra.save();

    }
    
    public static boolean baja(Compra compra){
     
        return compra.delete();

    }
    
    public static boolean actualizar(Compra compra){
        return compra.saveIt();
    }
    public static Producto TraerProducto(Compra compra){
        
        Producto producto = compra.parent(Producto.class);
        
        return producto;
    }
    
    
    
    
}
