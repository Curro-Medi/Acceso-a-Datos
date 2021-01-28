/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3.francisco_mediavilla_garcia;

import dam.Equipos;
import dam.Jugadores;
import java.util.Scanner;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import singleton.HibernateUtil;

/**
 *
 * @author Curro
 */
public class ejercicio6 {
        public static void main(String[] args) {
        // TODO code application logic here
        SessionFactory sesionfac = HibernateUtil.getSessionFactory();
        Session sesion = sesionfac.openSession();
        String nombre="";
        Scanner sc = new Scanner(System.in);
        int cont = 0;
        
        System.out.println("Dime el nombre del equipo ");
        nombre = sc.next();
       
        try{
            
            Equipos equipo = (Equipos) sesion.get(Equipos.class, nombre);
            Set<Jugadores> equi = equipo.getJugadoreses();
        
            for(Jugadores j : equi){
                
                cont++;
                System.out.println("Nombre: " + j.getNombre() + ", Posicion: " + j.getPosicion());
      
            }
           
        System.out.println("El equipo consta de " + cont + " jugadores");
            
        }catch(Exception e ){
            System.out.println("ERROR: El nombre del equipo no existe");
        }        
        
        sc.close();
        sesion.close();
    }
    
}
