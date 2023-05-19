package fp.common;

import java.util.Objects;

public record NBARecord(Integer salary, String player, String nacionalidad) implements Comparable <NBARecord> {

	
	
	public int hashCode() {
		return Objects.hash(nacionalidad, player, salary);
	}
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NBARecord other = (NBARecord) obj;
		return Objects.equals(nacionalidad, other.nacionalidad) && Objects.equals(player, other.player)
				&& Objects.equals(salary, other.salary);
	}

	public String toString() {
		return "NBARecord [salary=" + salary + ", player=" + player + ", nacionalidad=" + nacionalidad + "]";
	}
	
	public int compareTo(NBARecord o) {
		int r = this.salary().compareTo(o.salary());
		if (r == 0) 
			r = this.player().compareTo(o.player());
			if (r == 0) 
				r = this.nacionalidad().compareTo(o.nacionalidad());
		return r;
	}
	

}
