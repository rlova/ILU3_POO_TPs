package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.FinLimite;
import cartes.Limite;

public class ZoneDeJeu {
	private List<Limite> pileLimites;
	private List<Bataille> pileBataille;
	private List<Borne> collectionBornes;
	
	public ZoneDeJeu() {
		this.pileLimites = new ArrayList<>();
		this.pileBataille = new ArrayList<>();
		this.collectionBornes = new ArrayList<>();
	}
	
	public int donnerLimitationVitesse() {
		if (pileLimites.isEmpty() || pileLimites.get(pileLimites.size()-1) instanceof FinLimite) {
			return 200;
		}
		return 50;
	}
	
	public int donnerKmParcourus() {
		int totalKm = 0;;
		for (Borne borne : collectionBornes) {
			totalKm += borne.getKm();
		}
		return totalKm;
	}
	
	public void deposer(Carte c) {
		if (c instanceof Borne borne) {
			collectionBornes.add(borne);
		} else if (c instanceof Limite limite) {
			pileLimites.add(limite);
		} else if (c instanceof Bataille bataille) {
			pileBataille.add(bataille);
		}
	}
}
