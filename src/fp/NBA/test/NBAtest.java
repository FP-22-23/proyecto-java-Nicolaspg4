package fp.NBA.test;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.NBA.NBA;
import fp.common.Posicion;

public class NBAtest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List <String> equipos = new ArrayList<>();
		equipos.add("Oklahoma City Thunders");
		equipos.add("LA Clippers");
		equipos.add("LA Lakers");
		//CONSTRUCTOR 1:
		NBA n = new NBA (40231758, "Stephen Curry", LocalDate.of(1990, 12, 12), true, 1.98, "Golden State Warriors", true, 2.08, "Sweden",Posicion.PointGuard, equipos);
		//CONSTRUCTOR 2:
		NBA p = new NBA (40231758, "Stephen Curry",1.68, "Golden State Warriors", 2.08, "Sweden", Posicion.SmallForward);
		//CONSTRUCTOR 3:
		NBA o = new NBA (LocalDate.of(2023, 01, 03));
		
		//PROBANDO LOS MÉTODOS GET DE LAS PROPIEDADES BÁSICAS
		System.out.println("Salario: "+n.getSalary());
		System.out.println("Jugador: "+n.getPlayer());
		System.out.println("Cumpleaños: "+n.getCumpleaños());
		System.out.println("Está retirado: "+n.getRetirado());
		System.out.println("Altura: "+n.getAltura());
		System.out.println("Equipo que juega: "+n.getTeam());
		System.out.println("Ha ganado alguna copa: "+n.getCopa());
		System.out.println("Peso: "+n.getPeso());
		System.out.println("Nacionalidad: "+n.getNacionalidad());
		System.out.println("Posicion: "+ n.getPosition());
		System.out.println("Equipos en los que ha jugado: "+n.getEquiposHaJugado());
		//PROBANDO LOS MÉTODOS GET DE LAS PROPIEDADES DERIVADAS
		System.out.println("Edad del jugador: "+n.getEdadJugador());
		System.out.println("Coeficiente altura/peso (Constructor 1): "+n.getCoefAlturaPeso());
		System.out.println("Coeficiente altura/peso (Constructor 2): "+p.getCoefAlturaPeso());
		//PROBANDO LOS CHECKERS
		try {
            if (o.getCumpleaños().isBefore(LocalDate.now())) {
                throw new IllegalArgumentException("La fecha del cumpleaños debe ser anterior a la fecha actual");
            }
		}catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
		//PROBANDO EL MÉTODO TOSTRING
		System.out.println("Método ToString: "+n.toString());
		System.out.println("Método ToString (Cosntructor 2): "+ p.toString());
		//PROBANDO EL EQUALS
		if (n.equals(p)) {
			System.out.println("Según el criterio de igualdad el constructor n y el constructor p son iguales");
		}else {
			System.out.println("Según el criterio de igualdad el constructor n y el constructor p son distintos");
		}
		// PROBANDO EL COMPARETO
		if (n.compareTo(p) > 0) {
			System.out.println("El jugador n va antes que el jugador p");
		}else {
			System.out.println("El jugador p va ante que el juagdor n");
		}
		
		
		
		
		

	}

}
