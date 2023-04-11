package fp.NBA.test;

import fp.NBA.ContenedorNBA;
import fp.NBA.FactoriaNBA;


public class testFactoriaNBA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		testLeerNBA("data\\NBA19-20.csv");
		

	}
	private static void testLeerNBA (String fichero) {
		System.out.println("TEST FACTORÍA NBA: ");
		ContenedorNBA nba = FactoriaNBA.leerNBA(fichero);
		System.out.println(nba);
	}

}
