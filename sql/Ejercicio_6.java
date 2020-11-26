package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class Ejercicio_6 {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		
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
	            PreparedStatement suit = con.prepareStatement("Select nombre_producto,precio from producto where id_producto=?");
	            
	            suit.setInt(1,5);

	            ResultSet rs = suit.executeQuery();
	            
	            while (rs.next()) {
	                
	               System.out.println("Nombre: " + rs.getString(1) + "    Precio: " + rs.getString(2));
	                  
	                }
	            
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            
	            e.printStackTrace();
	        }
		
		
		
	}

}
