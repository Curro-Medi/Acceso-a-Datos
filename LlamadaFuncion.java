/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen.curro.mediavilla.garcia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

/**
 *
 * @author Curro
 */
public class LlamadaFuncion {
        public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
            
            
        String url = "jdbc:mysql://localhost:3307/curro-mediavilla-garcia" + "?useUnicode=true" + "&serverTimezone=Europe/Madrid";
        String nombreDriver = "com.mysql.cj.jdbc.Driver";
        String preparedCall = "{ call salario_maximo }";
        String user = "curro";
        Connection con = null;
        String pass = "examen1";
        Scanner sc = new Scanner(System.in);
        Class.forName(nombreDriver);
        con = DriverManager.getConnection(url,user,pass); 
            
        String nombre="";
        int sueldo=0;
        CallableStatement cs = con.prepareCall(preparedCall);
        cs.registerOutParameter(1, Types.VARCHAR);
        cs.registerOutParameter(2, Types.INTEGER);
        
        
        ResultSet rs = cs.executeQuery();
		
	while (rs.next()) {
		System.out.println(rs.getString(1));
				
	}
        
        
        cs.close();
        con.close();
            
        }
}
