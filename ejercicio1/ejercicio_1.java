package ejercicio1;
import java.io.*;
import java.util.*;

public class ejercicio_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String input = "C:/Users/Curro/Desktop/Ejercicio1/";
		Date fecha;
		
		Scanner te = new Scanner(System.in);
		
		System.out.println("Ingrese el nombre del archivo");
		
		String nom = te.nextLine();
		
		File f1 = new File( input, nom);
		
		Long ult_mod = f1.lastModified();
		fecha = new Date(ult_mod);
		
		/*if (f1.exists()) {
			
			System.out.println("Illo cabesa que ya existe eso");
			
		}
		else {
			System.out.println("Ave pichita que eso no existe, no lo has creado o lo has borrao sin quere");
		}*/
		
		System.out.println();
	
		System.out.println("Nombre -->" +f1.getName());
		
		System.out.println("Ruta absoluta -->" + f1.getAbsolutePath());
		
		System.out.println("Tamanio --> " +f1.length() + " B");
		
		System.out.println("Ultima modificacion -->" + fecha.toString());
		
		
		
	}

}
