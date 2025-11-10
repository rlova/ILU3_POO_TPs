package cartes;

import java.util.Objects;

public class Borne extends Carte {
	private Integer km;

	public Borne(Integer km) {
		this.km = km;
	}

	public Integer getKm() {
		return km;
	}

	@Override
	public String toString() {
		return km + "KM";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!super.equals(obj)) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Borne other = (Borne) obj;
		return Objects.equals(km, other.km);
	}


	
}
