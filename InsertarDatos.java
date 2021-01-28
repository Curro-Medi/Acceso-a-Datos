/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen.curro.mediavilla.garcia;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author Curro
 */
public class InsertarDatos {
    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        
        String url = "jdbc:mysql://localhost:3307/curro-mediavilla-garcia" + "?useUnicode=true" + "&serverTimezone=Europe/Madrid";
        String nombreDriver = "com.mysql.cj.jdbc.Driver";
        String user = "curro";
        Connection con = null;
        String pass = "examen1";
        Scanner sc = new Scanner(System.in);
        Class.forName(nombreDriver);
        
        
        System.out.println("Dime el Cargo");
        String cargo = sc.nextLine();
        
        System.out.println("Dime el sueldo minimo");
        int sueldomin = sc.nextInt();
        
        System.out.println("Dime el sueldo maximo");
        int sueldomax = sc.nextInt();
        
        con = DriverManager.getConnection(url,user,pass);
                
        Statement query = con.createStatement();
        ResultSet rs = query.executeQuery("Select * from cargo");
        int contador = 0;

        while (rs.next()) {

            contador++;

        }
        
        System.out.println(contador);
        
        int idcar = contador++;
        
        String idcargo = "C" + idcar ;
        
        int rs2 = con.createStatement().executeUpdate("Insert into cargo (idcargo,nombre,sueldo_min,sueldo_max) values('"+ idcargo + "', " + cargo + ", " + sueldomin + ", " + sueldomax + ")");

        
        
        
    }
}

