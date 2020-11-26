package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Ejercicio_5 {

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
	            ResultSet rs = con.createStatement().executeQuery("Select * from producto");
	            
	            java.sql.ResultSetMetaData meta = rs.getMetaData();
	            
	            for(int i = 1; i < meta.getColumnCount(); i++) {
	            
		            System.out.println(meta.getColumnCount() + " , "+ meta.getColumnName(i) + " , " + meta.getColumnTypeName(i)
		             + " , " + meta.isNullable(i) + " , " + meta.getColumnDisplaySize(i));
		            //para el isnullable habria que hacer un if ya que solo devuelve 0 y 1, es boolean
	            }
	            
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            
	            e.printStackTrace();
	        }
		
		
		
		
	}

}
