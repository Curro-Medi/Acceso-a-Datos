package sql;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.cj.protocol.Resultset;
import org.w3c.dom.*;

//HACER UN SELECT

public class sql {

    public static void main(String[] args) throws SQLException {

        //guardamos la url de nuestra base de datos
        String url = "jdbc:mysql://localhost:3307/registro" + "?useUnicode=true" + "&serverTimezone=Europe/Madrid";
        
        //guardamos el nombre de nuestro driver
        String nombreDriver = "com.mysql.cj.jdbc.Driver";
        
        //creamos la conexion
        Connection con = null;
        
        //inizializamos la contraseña y usuario de nuestra base de datos
        String user = "root";
        
        String pass = "admin";
        
        
        try {
            //cargar driver
            Class.forName(nombreDriver);
            
            //cargar conexion pasandole la url el usuario y la contraseña
            con = DriverManager.getConnection(url,user,pass);
            
            //creamos un statemnet con la conexion anterior
            con.createStatement();
            
            //creamos una variable donde meter la consulta
            ResultSet rs = con.createStatement().executeQuery("Select * from producto");
            
            //hacemos un bucle para que busque en la base de datos , para ellos pongo el metod next para que pase el puntero
            while (rs.next()) {
                
                //guardo en una varible el resultado de la consulta
                //el numero es el numero de la tabla
                  String producto = rs.getString(2);
                  
                  //escribo el resultado
                  System.out.println(producto + "\n");
                  
                }
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            
            e.printStackTrace();
        }
        
        
        
        
            
        
        
    }

}
