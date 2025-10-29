package jeu;

import java.util.Objects;

import cartes.Carte;

public class Joueur {
	private String nom;
	private ZoneDeJeu zoneDeJeu;
	private MainJoueur mainJoueur;
	
	public Joueur(String nom) {
		this.nom = nom;
		this.zoneDeJeu = new ZoneDeJeu();
		this.mainJoueur = new MainJoueur();
	}

	public String getNom() {
		return nom;
	}

	public ZoneDeJeu getZoneDeJeu() {
		return zoneDeJeu;
	}

	public MainJoueur getMainJoueur() {
		return mainJoueur;
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
	
	public void donner(Carte carte) {
		mainJoueur.prendre(carte);
	}
	
	public Carte prendreCarte(Sabot sabot) {
		Carte carte = sabot.piocher();
		if (carte != null) {
			donner(carte);
		}
		return carte;
	}
	
	public int donnerKmParcourus() {
		return zoneDeJeu.donnerKmParcourus();
	}
	
	public void deposer(Carte carte) {
		zoneDeJeu.deposer(carte);
	}
	
	public boolean estDepotAutorise(Carte carte) {
		return zoneDeJeu.estDepotAutorise(carte);
	}
}
