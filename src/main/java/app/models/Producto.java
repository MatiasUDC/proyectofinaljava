/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.models;

import java.util.List;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.BelongsTo;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author universidad
 */
@Table("productos")
@BelongsTo(parent = Categoria.class, foreignKeyName = "categoria_id")
public class Producto extends Model{
    private static final int LIMITE_RECOMENDADO = 3;
    private static final int MINIMO_STOCK = 1;
    private static final int MAXIMO_STOCK = 1001;
    private static final int CATEGORIA_DEFAULT = 0;
    static{
        validatePresenceOf("nombre").message("Porfavor, ingrese el nombre del producto");
        validatePresenceOf("descripcion").message("Porfavor, ingrese una descripcion del producto");
        validateNumericalityOf("categoria_id")
                .allowNull(true)
                .greaterThan(CATEGORIA_DEFAULT).message("Porfavor, seleccione una categoria para el producto");
        validateNumericalityOf("stock")
                .allowNull(true).greaterThan(MINIMO_STOCK)
                .lessThan(MAXIMO_STOCK).onlyInteger()
                .message("Profavor, ingrese un numero de stock entre "+MINIMO_STOCK+" y "+MAXIMO_STOCK+".");
        //validateRegexpOf("precio", "^(\\d|-)?(\\d|,)*\\.?\\d*$").message("Ingrese un precio para el producto");
        validatePresenceOf("imagen").message("Porfavor, seleccione una imagen para el producto");
        
    }  
    
    public static List lista_productos(){
        return findAll().orderBy("nombre desc");
    }
    
    public static boolean crear(Producto producto){
        
        return producto.save();

    }
    
    public static boolean eliminar(Producto producto){
        
        return producto.delete();

    }
    
    public static boolean actualizar(Producto producto){
 
        return producto.saveIt();
    }
    public static Producto getProducto(String id){
        return findById(id);
    }
    
    public static List getProductosRecomendados(){
        return findAll().orderBy("rand()").limit(LIMITE_RECOMENDADO);
    }
    
    public static List getProductoAjax(String criterio){
        return where("upper(nombre) LIKE ?","%"+criterio.trim().toUpperCase()+"%");
    }
}
