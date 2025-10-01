package cartes;

public abstract class Carte {
	public boolean equals(Object obj) {
		if (obj instanceof Carte carte) {
			return getClass().equals(carte.getClass());
		}
		return false; 
	}
	// methode equals
	// if (obj instanceof (Carte carte)) => carte et tout des enfants 
	// if (obj!=null && obj.getClass()==getClass()) => hierarcihe donnée, il faut que ça soit exactement les mêmes enfants
	
}
