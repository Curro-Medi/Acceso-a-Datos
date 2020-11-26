package Dia2;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Ejercicio2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		FileWriter archi = new FileWriter("C:/Users/Curro/Desktop/2º DAM/Acceso a datos/pruebas/FichData.dat");

		String[] nombre={"David","Pepe","Maria","Antonio"};
		int[] edad = {15,17,20,12};
		
		BufferedWriter escr = new BufferedWriter(archi);
	    for(int i=0;i<nombre.length;i++){
	    	escr.write(nombre[i]);
	    	escr.newLine();
	    	escr.write(edad[i]);
	    	escr.newLine();

	    }

	    escr.close();
		archi.close();
		
		FileReader fr=new FileReader("C:/Users/Curro/Desktop/2º DAM/Acceso a datos/pruebas/FichData.dat");
        int valor=fr.read();
        while(valor!=-1){
            System.out.print((char)valor);
            valor=fr.read();
        }
	}

}
