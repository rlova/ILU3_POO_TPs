package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Carte;

public class MainJoueur {
	private List<Carte> cartesEnMain;
	
	public MainJoueur() {
		this.cartesEnMain = new ArrayList<Carte>();
	}
	
	public void prendre(Carte carte) {
		cartesEnMain.add(carte);
	}
	
	public void joeur(Carte carte) {
		assert cartesEnMain.contains(carte) : "La carte est présente";
		cartesEnMain.remove(carte);
	}

	@Override
	public String toString() {
		StringBuilder affichage = new StringBuilder();
		affichage.append("Main du jouer : ");
		for (Carte carte : cartesEnMain) {
			affichage.append(carte).append(" ");
		}
		return affichage.toString();
	}
	
}
