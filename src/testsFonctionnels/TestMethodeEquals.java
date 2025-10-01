package testsFonctionnels;

import cartes.Attaque;
import cartes.Borne;
import cartes.JeuDeCartes;
import cartes.Parade;
import cartes.Type;
import jeu.Sabot;

public class TestMethodeEquals {
	public static void main(String[] args) {
		Borne carte25 = new Borne(25);
		System.out.println("Deux cartes de 25km sont identiques ? "+carte25.equals(carte25));
		Attaque feuRouge = new Attaque(Type.FEU);
		System.out.println("Deux cartes de feux rouge sont identiques ? "+feuRouge.equals(feuRouge));
		Parade feuVert = new Parade(Type.FEU);
		System.out.println("La carte feu rouge et la carte feu vert sont identiques ? "+feuRouge.equals(feuVert));
	}
}
