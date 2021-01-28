/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3.francisco_mediavilla_garcia;

import dam.Equipos;
import dam.Estadisticas;
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
public class ejercicio9 {
    public static void main(String[] args) {
        
        
    Scanner sc = new Scanner(System.in);
    SessionFactory sesionfac = HibernateUtil.getSessionFactory();
    Session sesion = sesionfac.openSession();
    Transaction tran = sesion.beginTransaction();
    String nombre="";
    Jugadores jugador = new Jugadores();
    Equipos equipo = new Equipos();
        
    Query estadis = sesion.createQuery("select e from Estadisticas e");
    Query listequip = sesion.createQuery("select e from Equipos e");

    List<Estadisticas> listestad = estadis.list();
    List<Equipos> listequipos = listequip.list();

    float min = 0;
    
    for(Equipos equip: listequipos){
        for (Estadisticas estadistica : listestad){

            if(estadistica.getPuntosPorPartido() > min && estadistica.getId().getTemporada().equals("07/08") && equip.equals(estadistica.getJugadores().getEquipos())){
                equipo = estadistica.getJugadores().getEquipos();
                min = estadistica.getPuntosPorPartido();
                nombre = estadistica.getJugadores().getNombre();
                jugador = estadistica.getJugadores();
            }

        }
    }

        System.out.println("Nombre--> " + nombre + " Equipo--> " + equipo + " Puntos por partido en la temporada 07/08--> " + min);
     
    sesion.delete(jugador);
 
    tran.commit();
    
    sesion.close();
    
        
    }
}
