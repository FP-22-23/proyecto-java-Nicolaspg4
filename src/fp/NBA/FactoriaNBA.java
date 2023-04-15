package fp.NBA;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import fp.common.Posicion;
import fp.utiles.Checkers;

public class FactoriaNBA {
	
	public static ContenedorNBA leerNBA(String fichero) {
		ContenedorNBA res=null;
		try {
			Stream<NBA>datos=Files.lines(Paths.get(fichero))
					.skip(1)
					.map(FactoriaNBA::parseaNBA);
			 res= new ContenedorNBA(datos);
			} catch(IOException e) {
			System.out.println("Fichero no encontrado: "+fichero);
			e.printStackTrace();
		}
	return res;
	}
	
	public static NBA parseaNBA (String lineaCSV) {
		String [] campos = lineaCSV.split(";");
		Checkers.check("El número de campos tiene que ser 11", campos.length == 11);
		Integer salary = Integer.parseInt(campos[0].trim());
		String player = campos[1].trim();
		LocalDate cumpleaños = LocalDate.parse(campos[2].trim(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		Boolean retirado = parseaRetirado(campos[3].trim());
		Double altura = Double.parseDouble(campos[4].trim());
		String team = campos[5].trim();
		Boolean copa = parseaCopa(campos[6].trim());
		Double peso = Double.parseDouble(campos[7].trim());
		String nacionalidad = campos[8].trim() ;
		Posicion position = Posicion.valueOf(campos[9].trim());
		List<String> equiposHaJugado = Arrays.asList(campos[10].trim().split(","));
		return new NBA(salary, player, cumpleaños, retirado, altura, team, copa, peso, nacionalidad, position, equiposHaJugado);
	}
	private static Boolean parseaRetirado(String cadena) {
		Boolean res = null;
		if (cadena.equals("true")) {
			res = true;
		}else {
			res = false;
		}
		return res;
	}
	private static Boolean parseaCopa(String cadena) {
		Boolean res = null;
		if (cadena.equals("T")) {
			res = true;
		}else {
			res = false;
		}
		return res;
	}


}
