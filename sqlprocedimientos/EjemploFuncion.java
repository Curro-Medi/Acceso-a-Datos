package sqlprocedimientos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class EjemploFuncion {

	public static void main(String[] args) throws ClassNotFoundException {


		String url = "jdbc:mysql://localhost:3307/registro" + "?useUnicode=true" + "&serverTimezone=Europe/Madrid";
		String preparedCall = "{ ? = call get_categoria (?) }";
        String nombreDriver = "com.mysql.cj.jdbc.Driver";
        String user = "prac2";
        Connection con = null;
        String pass = "qwerty";
        
        Class.forName(nombreDriver);
        
        //cargar conexion pasandole la url el usuario y la contraseña
       
		try {
			
			
			con = DriverManager.getConnection(url,user,pass);
			CallableStatement cs = con.prepareCall(preparedCall);
			cs.registerOutParameter(1, Types.VARCHAR);
			cs.setString(2, "Dulces");


			ResultSet rs = cs.executeQuery();
			
			while (rs.next()) {
				System.out.println(rs.getString(1));
				
			}
			
			
			rs.close();
			cs.close();
			con.close();
			
			
		}catch (SQLException e) {
			 e.printStackTrace();
		}
		

	}

}
