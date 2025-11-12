package jeu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import cartes.JeuDeCartes;
import utils.GestionCartes;
import cartes.Carte;

public class Jeu {
	private Sabot sabot;	
	
	public Jeu() {
//		récupère le tableau de cartes de la classe JeuDeCartes
		JeuDeCartes jeuDeCartes = new JeuDeCartes();
		Carte[] tableauCartes = jeuDeCartes.donnerCartes();
//		transforme en liste
		List<Carte> listeCartes = new ArrayList<>();
		Collections.addAll(listeCartes, tableauCartes);
//		mélanger les cartes
		listeCartes = GestionCartes.melanger(listeCartes);
//		créer sabot avec le tableau des cartes mélangées
		Carte[] cartesMelangees = listeCartes.toArray(new Carte[0]);
		sabot = new Sabot(cartesMelangees);
	}

	public Sabot getSabot() {
		return sabot;
	}
}
