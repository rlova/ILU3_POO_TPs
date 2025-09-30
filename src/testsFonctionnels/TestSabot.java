package testsFonctionnels;

import cartes.Carte;
import cartes.JeuDeCartes;
import jeu.Sabot;

public class TestSabot {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		Carte[] cartes = jeu.donnerCartes();
		Sabot sabot = new Sabot(cartes);
		//jeu.affichageJeuDeCartes();
		while (!sabot.estVide()) {
			Carte cartepiocher = sabot.piocher();
			System.out.println("je pioche "+cartepiocher);
		}
	}
}
 