/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package practica3.francisco_mediavilla_garcia;

import dam.Equipos;
import dam.Partidos;
import java.util.Collections;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import singleton.HibernateUtil;

/**
 *
 * @author Curro
 */
public class ejercicio7 {
     public static void main(String[] args) {
    SessionFactory sesionfac = HibernateUtil.getSessionFactory();
    Session sesion = sesionfac.openSession();
    Transaction tran = sesion.beginTransaction();
    
    Query nombresequipos = sesion.createQuery("select e from Equipos e");
    int idpar = (int)sesion.createQuery("select p.codigo froint idpar = (int)sesion.createQuery(m Partidos p where p.codigo = (select max(c2.codigo) from Partidos c2)").uniqueResult() ;
         
    List<Equipos> team = nombresequipos.list();
    int entero = team.size();
    int cont = 0;
        
    if((entero%2)!=0){
            
            System.out.println("ERROR: EL NUMERO DE EQUIPOS TOTAL DEBE DE SER PAR");
            System.exit(-1);

    }else{
        System.out.println(team.size());
        System.out.println("wuenaa esos equipos"); 
        
         Collections.shuffle(team);
         System.out.println(team);
        
       for(int i =0;i<team.size();i=i+2){

               idpar=idpar+1;
               Partidos partido = new Partidos(idpar,team.get(i),team.get(i+1),null,null,"08/09");
               sesion.save(partido);

               System.out.println("Codigo -> " + partido.getCodigo() + ", Equipo visitante -> " + partido.getEquiposByEquipoVisitante() + ", Equipo local -> " + partido.getEquiposByEquipoLocal() + ", Temporada -> " + partido.getTemporada());

           }

        
        tran.commit();
        sesion.close();
        
    }
       
  }
}
