package ExpresionesRegulares;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Ejercicio1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		String regex = "a{1,1} /\\w{6}/ n$ \\s + [-1-1] \r\n";
		
		System.out.println(Pattern.matches(regex, "arcsin 1"));
		
		
		String fecha = "01/01/2001";

				
	    Pattern patron = Pattern.compile("\\d{2}/\\d{2}/(\\d{4})");
		Matcher matcher = patron.matcher(fecha);
		matcher.find();

		System.out.println("La fecha es: " + matcher.group(1));

		
	}

}
