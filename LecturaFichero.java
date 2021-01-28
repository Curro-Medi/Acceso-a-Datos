/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen.curro.mediavilla.garcia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Curro
 */
public class LecturaFichero {
     public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        
        String archivo = "C:\\Users\\Curro\\Desktop\\2º DAM\\Acceso a datos\\RecursosHumanos.sql";
        FileReader lectura = new FileReader(archivo);
        BufferedReader leer = new BufferedReader(lectura);
        
        String url = "jdbc:mysql://localhost:3307/curro-mediavilla-garcia" + "?useUnicode=true" + "&serverTimezone=Europe/Madrid";
        String nombreDriver = "com.mysql.cj.jdbc.Driver";
        String user = "curro";
        Connection con = null;
        String pass = "examen1";
        
        Class.forName(nombreDriver);

        String Linea;
        int linintroducidas = 0;
                    
            try{
		con = DriverManager.getConnection(url,user,pass);
                
                con.createStatement();
                            
            while((Linea = leer.readLine()) != null){
                
                if(Linea.endsWith(";")){
                     int rs = con.createStatement().executeUpdate(Linea);                   
                    //System.out.println(Linea);
                    linintroducidas++;
            }else{
                    Linea += leer.readLine()+1;
                    int rs = con.createStatement().executeUpdate(Linea);     
                }
        }
                
                System.out.println("Se han introducido--> " + linintroducidas + " filas");
                
                
            }catch (SQLException e) {
                e.printStackTrace();
            }
            
         
        
        
    }
}
    

