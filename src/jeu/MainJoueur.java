package jeu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cartes.Carte;

public class MainJoueur implements Iterable<Carte>{
	private List<Carte> cartesEnMain = new ArrayList<>();
	
	public void prendre(Carte carte) {
		cartesEnMain.add(carte);
	}
	
	public void jouer(Carte carte) {
		if (!cartesEnMain.contains(carte)) {
			throw new IllegalArgumentException("La carte n'est pas présente");
		}
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


	@Override
	public Iterator<Carte> iterator() {
		return cartesEnMain.iterator();
	}
	
}
