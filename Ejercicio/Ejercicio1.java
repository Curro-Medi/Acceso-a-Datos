package Dia2;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		
		Scanner te = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre del archivo");
		
		String nom = te.nextLine();
		
		FileWriter archi = new FileWriter("C:/Users/Curro/Desktop/2º DAM/Acceso a datos/pruebas/" + nom + ".txt");
		
		archi.write("Major Lazer\n");
		archi.write("Dj Snake\n");
		archi.write("David Guetta\n");
		archi.write("Martin Garrix\n");
		
		archi.close();
		te.close();
		
		
	}

}
