/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examen.curro.mediavilla.garcia;

import dam.Usuario;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import singleton.HibernateUtil;

/**
 *
 * @author Curro
 */
public class ModificarContrasena {
            public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
                
                
    Scanner sc = new Scanner(System.in);
    SessionFactory sesionfac = HibernateUtil.getSessionFactory();
    Session sesion = sesionfac.openSession();
    Transaction tran = sesion.beginTransaction();
                
                
                System.out.println("Dime el usuario");
                String user = sc.nextLine();
                
                System.out.println("Dime la contraseña antigua");
                String antigua = sc.nextLine();
     
    
                System.out.println("Dime la contraseña nueva");
                String nueva = sc.nextLine();
    
                
                Query usuarios = sesion.createQuery("select e from usuarios e");
                List<Usuario> users = usuarios.list(); 
                
                
                for(int i =0;i<users.size();i++){
                    
                    if(user== users.get(i).getUsuario()){
                        users.get(i).setClave(nueva);
                        sesion.save(users);
                    }
                    
                }
                    
        tran.commit();
        sesion.close();
                
                
    }            
}
