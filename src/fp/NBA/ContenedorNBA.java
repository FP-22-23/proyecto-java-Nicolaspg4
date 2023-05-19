package fp.NBA;

import java.util.ArrayList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Optional;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fp.common.Posicion;

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
	// ENTREGA 3:
	//1.- EXISTE (STREAMS)
	public Boolean existeJugadorParaEquipo(String equipo) {
		Boolean res = false;
		if (nba.stream().filter(x-> x.getTeam().equals(equipo)) != null) {
			res = true;
		}
		return res;
	}
	//2.- MEDIA PESO (STREAMS)
	public Double MediaPesoJugadores() {
		return nba.stream().collect(Collectors.averagingDouble(x->x.getPeso()));
	}
	//3.- SELECCIÓN CON FILTRADO (STREAMS)
	public List<String> JugadoresNoRetirados(){
		return nba.stream()
				.filter(x->x.getRetirado().equals(false))
				.map(x->x.getPlayer())
				.collect(Collectors.toList());
	}
	//4.- MÁXIMO O MÍNIMO CON FILTRADO (STREAMS)
	public Double getMaximaAlturaDeJugadorQueHaJugadoOJuegaEnUnEquipo(String equipo,String equipoHaJugado) {
		return nba.stream()
				.filter(x-> x.getTeam().equals(equipo) && x.getEquiposHaJugado().contains(equipoHaJugado))
				.mapToDouble(x-> x.getAltura())
				.max()
				.getAsDouble();
	}
	//5.- SELECCION CON FILTRADO Y ORDENACIÓN
	public List<Double> getJugadoresMasAltosConCopaOrdenados(){
		return nba.stream()
				.filter(x-> x.getCopa().equals(true))
				.map(x-> x.getAltura())
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.toList());
	}
	//6.- DEVUELVE LAS NACIONALIDADES DE LOS JUGADORES DE CADA EQUIPO
	public Map <String, List<String>> getNacionalidadesPorEquipo(){
		return nba.stream()
				.collect(Collectors.groupingBy(x->x.getTeam(), Collectors.mapping(x->x.getNacionalidad(), Collectors.toList())));
	}
	//7.- DEVUELVE EL NÚMERO DE JUGADORES DE CADA NACIONALIDAD
	public Map <String, Integer> getNumeroJugadoresCadaNacionalidad(){
		return nba.stream()
				.collect(Collectors.groupingBy(x-> x.getNacionalidad(), 
						Collectors.collectingAndThen(Collectors.counting(), x-> x.intValue())));
	}
	//8.- DEVUELVE EL SALARIO MÁS ALTO DE CADA EQUIPO
	public Map<String, Integer> getSalarioMasAltoPorEquipo(){
		return nba.stream()
				.collect(Collectors.groupingBy(NBA::getTeam, Collectors.collectingAndThen(Collectors.toList(), 
						listaSalarios -> listaSalarios.stream()
						.max(Comparator.comparingInt(NBA::getSalary))
						.map(NBA::getSalary)
						.orElse(null))));	
	}
	//9.- DEVUELVE LAS N ALTURAS MAS ALTAS DE CADA NACIONALIDAD
	public SortedMap <String, List<Double>> getNAlturasPorNacionalidad(Integer n){
		return nba.stream()
	            .collect(Collectors.groupingBy(NBA::getNacionalidad,
	                    Collectors.collectingAndThen(Collectors.toList(),
	                            nbaplayer -> nbaplayer.stream()
	                                    .sorted(Comparator.comparingDouble(NBA::getAltura).reversed())
	                                    .limit(n)
	                                    .map(NBA::getAltura)
	                                    .collect(Collectors.toList()))))
		  	.entrySet().stream()
		  	.sorted(Map.Entry.comparingByKey())
		  	.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (x, y) -> y, TreeMap::new));
	}
	
	
	//10.- DEVUELVE LA POSICION EN LA QUE HAY MAYOR NÚMERO DE JUGADORES
	public Map.Entry <Posicion, Integer> getMayorNumeroJugadoresEnPosicion(){
		return nba.stream()
				.collect(Collectors.groupingBy(x->x.getPosition(), Collectors.collectingAndThen(Collectors.counting(), x->x.intValue())))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.orElse(null);
	}
	public Map.Entry<String,Double> getMayorMediaAlturaDeTodosLosEquipos(){
		return nba.stream()
				.collect(Collectors.groupingBy(NBA::getTeam, Collectors.collectingAndThen(Collectors.averagingDouble(NBA::getAltura), x->x.doubleValue())))
				.entrySet()
				.stream()
				.max(Map.Entry.comparingByValue())
				.orElse(null);
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
