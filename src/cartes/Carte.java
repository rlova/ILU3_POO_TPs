package cartes;

public abstract class Carte {
	@Override
	public boolean equals(Object obj) {
		return obj!=null && obj.getClass()==getClass();
	}
	// methode equals
	// if (obj instanceof (Carte carte)) => carte et tout des enfants 
	// if (obj!=null && obj.getClass()==getClass()) => hiérarchie donnée, il faut que ça soit exactement les mêmes enfants
	
}

/*public boolean equals(Object obj) {
if (obj instanceof Carte carte) {
	return getClass().equals(carte.getClass());
}
return false; 
}*/
