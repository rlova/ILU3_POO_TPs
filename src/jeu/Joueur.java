package jeu;

import java.util.Objects;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.zoneDeJeu = new ZoneDeJeu();
	}

	public String getNom() {
		return nom;
	}

	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}
	
	

	@Override
	public int hashCode() {
		return nom.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) 
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Joueur joueur = (Joueur) obj;
		return nom.equals(joueur.nom);
	}

	@Override
	public String toString() {
		return nom;
	}
	
}
