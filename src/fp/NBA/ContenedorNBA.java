package fp.NBA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ContenedorNBA {
	private List <NBA> nba;

	public ContenedorNBA() {
		this.nba = new ArrayList<> ();
	}
	public ContenedorNBA (Collection <NBA> jugador) {
		this.nba = new ArrayList <>(jugador);
	}
	public ContenedorNBA (Stream <NBA> stream) {
		this.nba = stream.collect(Collectors.toList());
	}
		//OPERACIÓN PARA QUE DEVUELVA EL NÚMERO DE ELEMENTOS
	public Integer getNumeroElementos () {
		return nba.size();
	}
		//OPERACIÓN PARA QUE PODER AÑADIR UN ELEMENTO 
	public void agregarElemento(NBA n) {
		this.nba.add(n);
	}
		//OPERACIÓN PARA INCORPORAR UNA COLECCIÓN DE ELEMENTOS 
	public void incorporarNBA(List<NBA> totalNBA) {
		this.nba.addAll(totalNBA);
	}
		//OPERACIÓN PARA ELIMINAR UN ELEMENTO
	public void eliminarNBA(NBA a) {
		if(!nba.contains(a)) {
			throw new IllegalArgumentException("El Automovil no existe");
		}else {
			nba.remove(a);
			
		}	
	}
	//TRATAMIENTOS SECUENCIALES:
	
	//1.- EXISTE
	
	public Boolean existeJugadorConAltura(Double altura) {
		Boolean res = false;
		for(NBA a: this.nba) {
			if(Arrays.asList(a.getAltura()).contains(altura)){
				res = true;
				break;
			}
		}
		return res;
	}
	
	//2.- SUMA
	
	public Double getPesoTotal() {
		Double res = 0.;
		for(NBA a: this.nba) {
			res = res + a.getPeso();
		}
		return res;
	}
	
	//3.- FILTRADO
	
	public List<String> getJugadoresConCopa() {
		List<String> res = new ArrayList <> ();
		for (NBA a: this.nba) {
			if(a.getCopa().equals(true)) {
				res.add(a.getPlayer());
			}
				
		}
		return res;
	}
	
	//4.- MAP EN EL QUE LAS CLAVES SON UNA PROPIEDAD DEL TIPO BASE Y LOS VALORES UNA COLECCIÓN
	
	public Map <String, List <String>> agrupaJugadoresPorEquipo(){
		Map <String, List <String>> res = new HashMap<>();
		for (NBA a: this.nba) {
			if (!res.containsKey(a.getTeam())) {
				List <String> jugadores = new ArrayList<>();
				jugadores.add(a.getPlayer());
				res.put(a.getTeam(), jugadores);
			}else {
				res.get(a.getTeam()).add(a.getPlayer());
			}
			
			
		}
		return res;
		
	}
	
	// 5.- MAP EN EL QUE LAS CLAVES SON UNA PROPIEDAD DEL TIPO BASE Y LOS VALORES EL CONTEO DE LOS OBJETOS DEL TIPO BASE
	
	public Map <Boolean, Integer> numeroJugadoresRetiradosOno(){
		Map <Boolean, List<String>> res = new HashMap<>();
		Map <Boolean, Integer> res1 = new HashMap <>();
		for (NBA a: this.nba) {
			if (!res.containsKey(a.getRetirado())) {
				List <String> jugadores = new ArrayList <>();
				jugadores.add(a.getPlayer());
				res.put(a.getRetirado(), jugadores);
			}else {
				res.get(a.getRetirado()).add(a.getPlayer());
				
			}
			
			res1.put(a.getRetirado(), res.get(a.getRetirado()).size());
		}
		return res1;
	}
	
	
	
	public int hashCode() {
		return Objects.hash(nba);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContenedorNBA other = (ContenedorNBA) obj;
		return Objects.equals(nba, other.nba);
	}
	public String toString() {
		return "Lectura de datos del fichero "+ nba + " ] ";
	}
	
		

}
