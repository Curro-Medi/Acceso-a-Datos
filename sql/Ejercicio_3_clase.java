package sql;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

//INSERTAR DATOS

public class Ejercicio_3_clase {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
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
            //ResultSet rs = con.createStatement().executeQuery("Select * from producto");
            
            int cont = 0;
            int precio = 0;
            String nombreproducto = null;
            int categoria = 0;
            
            
            System.out.println("Dime el nombre ");
            System.out.println("El nombre del producto");
            nombreproducto = sc.nextLine();
            
            System.out.println("El precio");
            precio = sc.nextInt();
            
            System.out.println("El id de categoria");
            categoria = sc.nextInt();
            
            int rs = con.createStatement().executeUpdate("Insert into producto (nombre_producto,precio,categoria_id) values('"+ nombreproducto + "', " + precio + ", " + categoria + ")");

		
            if(rs==1) {
            	
            	System.out.println("Muy bienn");
            	
            }else {
            	
            	System.out.println("Noooo");
            	
            }
            
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            
            e.printStackTrace();
        }
		
	}

}
