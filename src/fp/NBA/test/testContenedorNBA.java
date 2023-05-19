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
		testExisteJugadoresParaEquipo(nba, "Golden State Warriors");
		testMediaPesoJugadores(nba);
		testJugadoresNoRetirados(nba);
		testgetMaximaAlturaDeJugadorQueHaJugadoOJuegaEnUnEquipo(nba, "Toronto Raptors", "Dallas Mavericks" );
		testgetJugadoresMasAltosConCopaOrdenados(nba);
		testgetNacionalidadesPorEquipo(nba);
		testGetNumeroJugadoresCadaNacionalidad(nba);
		testGetSalarioMasAltoPorEquipo(nba);
		testgetNAlturasPorNacionalidad(nba, 2);
		testgetMayorNumeroJugadoresEnPosicion(nba);
		testGetMayorMediaAlturaDeTodosLosEquipos(nba);
		

	}
	private static void testExisteJugadorConAltura(ContenedorNBA cn, Double altura) {
		System.out.println("¿Existe algún jugador que mida " + altura + " metros ? : " + cn.existeJugadorConAltura(altura));
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
	private static void testExisteJugadoresParaEquipo(ContenedorNBA cn, String equipo) {
		System.out.println("Muestra si ese equipo tiene algún jugador en el csv: " + cn.existeJugadorParaEquipo(equipo));
	}
	private static void testMediaPesoJugadores(ContenedorNBA cn) {
		System.out.println(cn.MediaPesoJugadores());
	}
	private static void testJugadoresNoRetirados(ContenedorNBA cn) {
		System.out.println(cn.JugadoresNoRetirados());
	}
	private static void testgetMaximaAlturaDeJugadorQueHaJugadoOJuegaEnUnEquipo(ContenedorNBA cn, String equipo,String equipoHaJugado) {
		System.out.println(cn.getMaximaAlturaDeJugadorQueHaJugadoOJuegaEnUnEquipo(equipo, equipoHaJugado));
	}
	private static void testgetJugadoresMasAltosConCopaOrdenados(ContenedorNBA cn) {
		System.out.println(cn.getJugadoresMasAltosConCopaOrdenados());
	}
	private static void testgetNacionalidadesPorEquipo(ContenedorNBA cn) {
		System.out.println(cn.getNacionalidadesPorEquipo());
	}
	private static void testGetNumeroJugadoresCadaNacionalidad(ContenedorNBA cn) {
		System.out.println(cn.getNumeroJugadoresCadaNacionalidad());
	}
	private static void testGetSalarioMasAltoPorEquipo(ContenedorNBA cn) {
		System.out.println(cn.getSalarioMasAltoPorEquipo());
	}
	private static void testgetNAlturasPorNacionalidad(ContenedorNBA cn, Integer n) {
		System.out.println(cn.getNAlturasPorNacionalidad(n));
	}
	private static void testgetMayorNumeroJugadoresEnPosicion(ContenedorNBA cn) {
		System.out.println(cn.getMayorNumeroJugadoresEnPosicion());
	}
	private static void testGetMayorMediaAlturaDeTodosLosEquipos(ContenedorNBA cn) {
		System.out.println(cn.getMayorMediaAlturaDeTodosLosEquipos());
	}
	

}
