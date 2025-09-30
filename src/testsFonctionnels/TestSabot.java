package testsFonctionnels;

import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {
	public static void main(String[] args) {
		JeuDeCartes jeu = new JeuDeCartes();
		
		// 2a) avec piocher
		Carte[] cartes1 = jeu.donnerCartes();
		Sabot sabot1 = new Sabot(cartes1);
		//jeu.affichageJeuDeCartes();
		while (!sabot1.estVide()) {
			Carte cartepiocher = sabot1.piocher();
			System.out.println("je pioche "+cartepiocher);
		}
		
		// 2b) avec itérateur
		Carte[] cartes2 = jeu.donnerCartes();
		Sabot sabot2 = new Sabot(cartes2);
		Iterator<Carte> iterateur = sabot2.iterator();
		while (iterateur.hasNext()) {
			Carte carte = iterateur.next();
			System.out.println("je pioche "+carte);
			iterateur.remove();
		}
		
		// 2c) appel à piocher dans la boucle pour lever l'exception
		Carte[] cartes3 = jeu.donnerCartes();
		Sabot sabot3 = new Sabot(cartes3);
		Iterator<Carte> iterateurPioche = sabot3.iterator();
		while (iterateurPioche.hasNext()) {
			Carte carte = iterateurPioche.next();
			sabot3.piocher();	
			System.out.println("je pioche "+carte);
			iterateurPioche.remove();
		}
		
		// appel a piocher + as du volant
		Carte[] cartes4 = jeu.donnerCartes();
		Sabot sabot4 = new Sabot(cartes4);
		sabot4.piocher();	
		Iterator<Carte> iterateurAs = sabot4.iterator();
		while (iterateurAs.hasNext()) {
			Carte carte = iterateurAs.next();
			Botte as = new Botte(Type.ACCIDENT);
			sabot4.ajouterCarte(as);
			System.out.println("je pioche "+carte);
			iterateurAs.remove();
		}
	}
}
 