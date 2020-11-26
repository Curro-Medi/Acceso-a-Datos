package sqlprocedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EjemploProcedimiento {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String url = "jdbc:mysql://localhost:3307/registro" + "?useUnicode=true" + "&serverTimezone=Europe/Madrid";
		String preparedCall = "{ call subir_precio (?,?) }";
        String nombreDriver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        Connection con = null;
        String pass = "admin";
        
        Class.forName(nombreDriver);
        
        //cargar conexion pasandole la url el usuario y la contraseña
       
		try {
			
			
			con = DriverManager.getConnection(url,user,pass);
			CallableStatement cs = con.prepareCall(preparedCall);
			cs.setInt(1, 3);
			cs.setFloat(2,5);
			cs.execute();
			
			int colm = cs.getUpdateCount();
			System.out.println(colm);
			
			cs.close();
			con.close();
			
			
		}catch (SQLException e) {
			 e.printStackTrace();
		}
		
		
	}

}
