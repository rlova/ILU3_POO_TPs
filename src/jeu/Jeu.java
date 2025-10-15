package jeu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import cartes.JeuDeCartes;
import utils.GestionCartes;
import cartes.Carte;

public class Jeu {
	private Sabot sabot;	
	
	/*public Jeu(List<Carte> listeCartes) {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeuDeCartes.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}
		listeCartes = new ArrayList<>(listeCarteNonMelangee);
		listeCartes = GestionCartes.melanger(listeCartes);
		sabot = new Sabot(listeCartes.toArray());
	}*/
	/*public Jeu(Carte[] listeCartes) {
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		List<Carte> listeCarteNonMelangee = new LinkedList<>();
		for (Carte carte : jeuDeCartes.donnerCartes()) {
			listeCarteNonMelangee.add(carte);
		}
		
	}*/
}
