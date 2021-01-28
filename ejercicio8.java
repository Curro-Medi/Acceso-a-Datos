/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3.francisco_mediavilla_garcia;

import dam.Jugadores;
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
public class ejercicio8 {
    
     public static void main(String[] args) {
         
    Scanner sc = new Scanner(System.in);
    SessionFactory sesionfac = HibernateUtil.getSessionFactory();
    Session sesion = sesionfac.openSession();
    Transaction tran = sesion.beginTransaction();
    
    int cont = 0;
         
    Jugadores jug1 = new Jugadores();
    Jugadores jug2 = new Jugadores();
         
    boolean validanombre1 = false;
    boolean validanombre2 = false;
    boolean validaequipo = false;
    
    boolean listnom = false;
    boolean listnom2 = false;
    
    String equip1 = "";
    String equip2 = "";
    String nombre= "";
    String nombre2= "";
        
        System.out.println("Dime el primer nombre ");
        nombre = sc.nextLine();
        
     for(int i = 0; i < nombre.length(); i++){
         
         if (nombre.charAt(0) >= 65 && nombre.charAt(0) <= 90 && cont == 0){
             for (int y = 0; y < nombre.length(); y++){
                 if (nombre.charAt(y) == 32 && nombre.charAt(y+1) >= 65 && nombre.charAt(y+1) <= 90){
                     
                        validanombre1 = true;
                        cont++;
                 }
                 
             }  
         }
     }
        
     System.out.println("Dime el segundo nombre ");
     nombre2 = sc.nextLine();
        
     cont = 0;
      for(int i = 0; i < nombre2.length(); i++){
         
         if (nombre2.charAt(0) >= 65 && nombre2.charAt(0) <= 90 && cont == 0){
              for (int y = 0; y < nombre.length(); y++){
                 if (nombre.charAt(y) == 32 && nombre.charAt(y+1) >= 65 && nombre.charAt(y+1) <= 90){
                     
                        validanombre2 = true;
                        cont++;
                 }
             }  
         }
     }
    
            
         Query jugadores = sesion.createQuery("select e from Jugadores e");
         
         List<Jugadores> team = jugadores.list();
    
         for (Jugadores j : team){
             
             if (nombre.equals(j.getNombre())){
                 
                 listnom = true;
                 equip1 = j.getEquipos().getNombre();
                 
                    jug1.setCodigo(j.getCodigo());
                    jug1.setNombre(j.getNombre());
                    jug1.setProcedencia(j.getProcedencia());
                    jug1.setAltura(j.getAltura());
                    jug1.setPeso(j.getPeso());
                    jug1.setPosicion(j.getPosicion());
                    jug1.setEstadisticases(j.getEstadisticases());
         
                 
             }
             
             if (nombre2.equals(j.getNombre())){
                 
                 listnom2 = true;
                 equip2 = j.getEquipos().getNombre();
                 
                     jug2.setCodigo(j.getCodigo());
                     jug2.setNombre(j.getNombre());
                     jug2.setProcedencia(j.getProcedencia());
                     jug2.setAltura(j.getAltura());
                     jug2.setPeso(j.getPeso());
                     jug2.setPosicion(j.getPosicion());
                     jug2.setEstadisticases(j.getEstadisticases());
                     
             }
                          
         }
      
         if(listnom==true && listnom2==true && !equip1.equals(equip2)){
             
             validaequipo = true;       
             
          }
      
         
         if (validaequipo == true && validanombre1 == true && validanombre2 == true){

                jug1.getEquipos().setNombre(equip2);
                jug2.getEquipos().setNombre(equip1);
         }
                  
         sesion.update(jug1);
         sesion.update(jug2);
         tran.commit();
         sesion.close();
         
    }
}