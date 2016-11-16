package app.models;

import java.util.List;
import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;

/**
 *
 * @author universidad
 */
@Table("tienda")
public class Tienda extends Model{
    public static boolean actualizarInfoTienda(Tienda tienda){
    	return tienda.saveIt();
    }
    public static List getTienda(){
    	return findAll().limit(1);
    }
}