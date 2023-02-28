package fp.NBA;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import fp.utiles.Checkers;
// DECLARACIÓN DE LAS PROPIEDADES BÁSICAS
public class NBA implements Comparable <NBA>{
	private Integer salary;
	private String player;
	private LocalDate cumpleaños;
	private Boolean retirado;
	private Double altura;
	private String team;
	private String copa;
	private Double peso;
	private String nacionalidad;
	private Posicion position;
	private List <String> equiposHaJugado;
//CONSTRUCTOR 1
	public NBA(Integer salary, String player, LocalDate cumpleaños, Boolean retirado,
			Double altura, String team, String copa, Double peso, String nacionalidad, Posicion position, String equiposHaJugado) {
		Checkers.check("El salario del jugador debe ser 0 o mayor que 0: ", salary >=0);
		Checkers.check("La altura debe ser positiva: ", altura >0);
		Checkers.check("El peso debe ser positivo: ", peso >0);
		Checkers.check("La fecha del cumpleaños debe ser anterior a la fecha de hoy: ", cumpleaños.isBefore(LocalDate.now()));
		this.salary = salary;
		this.player = player;
		this.cumpleaños = cumpleaños;
		this.retirado = retirado;
		this.altura = altura;
		this.team = team;
		this.copa = copa;
		this.peso = peso;
		this.nacionalidad = nacionalidad;
		this.position = position;
		this.equiposHaJugado = Arrays.asList(equiposHaJugado.split(","));
		
	}
//CONSTRUCTOR 2
	public NBA(Integer salary, String player,Double altura,  String team,Double peso, String nacionalidad, Posicion position) {
		this.salary = salary;
		this.player = player;
		this.altura = altura;
		this.nacionalidad = nacionalidad;
		this.team = team;
		this.peso = peso;
		Checkers.check("La altura debe ser positiva: ", altura >0);
		Checkers.check("El peso debe ser positivo: ", peso >0);
		Checkers.check("El salario del jugador debe ser 0 o mayor que 0: ", salary >=0);
		
	}
	// CONSTRUCTOR 3
	public NBA(LocalDate cumpleaños) {
		Checkers.check("La fecha del cumpleaños debe ser anterior a la fecha de hoy: ", cumpleaños.isBefore(LocalDate.now()));
		this.cumpleaños = cumpleaños;
		
//MÉTODOS GETTERS Y SETTERS		
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getPlayer() {
		return player;
	}
	public LocalDate getCumpleaños() {
		return cumpleaños;
	}
	
	public Boolean getRetirado() {
		return retirado;
	}
	
	public Double getAltura() {
		return altura;
	}
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public Boolean getCopa() {
		Boolean res = true;
		if (copa == "F") {
			res = false;	
		}
		return res;
	}
	
	public Double getPeso() {
		return peso;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	// PROPIEDAD ENUMERADA
	public Posicion getPosition() {
		return position;
	}
	//PROPIEDAD LISTA
	public List<String> getEquiposHaJugado() {
		return equiposHaJugado;
	}
	public void setEquiposHaJugado(List<String> equiposHaJugado) {
		this.equiposHaJugado = equiposHaJugado;
	}
	public Integer getEdadJugador() {
		LocalDateTime now = LocalDateTime.now();
		Period p = Period.between(getCumpleaños(), now.toLocalDate());
		return p.getYears();
	}
	//PROPIEDAD DERIVADA
	public Double getCoefAlturaPeso() {
		return getAltura()/getPeso();	
	}
//REPRESENTACIÓN COMO CADENA
	public String toString() {
		return "NBA [salary=" + salary + ", player=" + player + ", cumpleaños=" + cumpleaños + ", retirado=" + retirado
				+ ", altura=" + altura + ", team=" + team + ", copa=" + copa + ", peso=" + peso + ", nacionalidad="
				+ nacionalidad + ", position=" + position + "]";
	}
//IGUALDADES
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NBA other = (NBA) obj;
		return Objects.equals(nacionalidad, other.nacionalidad) && Objects.equals(player, other.player)
				&& Objects.equals(team, other.team) && Objects.equals(altura, other.altura);
	}
// ORDEN NATURAL
	public int compareTo(NBA o) {
		int r = this.getAltura().compareTo(o.getAltura());
		if (r == 0) 
			r = this.getPlayer().compareTo(o.getPlayer());
			if (r == 0) 
				r = this.getNacionalidad().compareTo(o.getNacionalidad());
				if (r == 0)
					r = this.getPeso().compareTo(o.getPeso());
		return r;
	}
	
	
	
	


}

