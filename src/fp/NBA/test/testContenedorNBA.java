package fp.NBA.test;


import fp.NBA.ContenedorNBA;
import fp.NBA.FactoriaNBA;


public class testContenedorNBA {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ContenedorNBA nba = FactoriaNBA.leerNBA("data\\NBA19-20.csv");
		
		
		testExisteJugadorConAltura(nba, 1.68);
		testGetPesoTotal(nba);
		testGetJugadoresConCopa(nba);
		testAgrupaJugadoresPorEquipo(nba);
		testNumeroJugadoresRetiradosOno(nba);

	}
	private static void testExisteJugadorConAltura(ContenedorNBA cn, Double altura) {
		System.out.println("¿Existe algún que mida " + altura + " metros ? : " + cn.existeJugadorConAltura(altura));
	}
	private static void testGetPesoTotal(ContenedorNBA cn) {
		System.out.println("La suma de todos los pesos es: " + cn.getPesoTotal());
	}
	private static void testGetJugadoresConCopa(ContenedorNBA cn) {
		System.out.println("Devuelve una lista con todos los jugadores que tienen una copa: " + cn.getJugadoresConCopa());
		
	}
	private static void testAgrupaJugadoresPorEquipo(ContenedorNBA cn) {
		System.out.println("Agrupa jugadores por equipo: " + cn.agrupaJugadoresPorEquipo());
	}
	private static void testNumeroJugadoresRetiradosOno(ContenedorNBA cn) {
		System.out.println("Agrupa jugadores por si están retirados o no: " + cn.numeroJugadoresRetiradosOno());
	}

}
