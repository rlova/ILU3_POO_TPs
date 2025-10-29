package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Attaque;
import cartes.Bataille;
import cartes.Borne;
import cartes.Carte;
import cartes.Cartes;
import cartes.DebutLimite;
import cartes.FinLimite;
import cartes.Limite;
import cartes.Parade;

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
	
	public boolean peutAvancer() {
		return !pileBataille.isEmpty() && pileBataille.get(pileBataille.size()-1).equals(Cartes.FEU_VERT);
	}
	
	private boolean estDepotFeuVertAutorise() {
		if (pileBataille.isEmpty()) {
			return true;
		}
		Bataille sommet =  pileBataille.get(pileBataille.size()-1);
		return  sommet.equals(Cartes.FEU_ROUGE) || (sommet instanceof Parade 
				&& !sommet.equals(Cartes.FEU_VERT));
	}
	
	private boolean estDepotBorneAutorise(Borne borne) {
		if (!peutAvancer()) {
			return false;
		}
		if (borne.getKm() > donnerLimitationVitesse()) {
			return false;
		}
		return (donnerKmParcourus()+borne.getKm())<=1000;
	}
	
	private boolean estDepotLimiteAutorise(Limite limite) {
		if (limite instanceof DebutLimite) {
			return pileLimites.isEmpty() || (pileLimites.get(pileLimites.size()-1)) instanceof FinLimite;
		}
		if (limite instanceof FinLimite) {
			return !pileLimites.isEmpty() && (pileLimites.get(pileLimites.size()-1)) instanceof DebutLimite;
		}
		return false;
	}
	
	private boolean estDepotBatailleAutorise(Bataille bataille) {
		if (bataille instanceof Attaque) {
			return peutAvancer();
		}
		if (bataille instanceof Parade) {
			if (bataille.equals(Cartes.FEU_VERT)) {
				return estDepotFeuVertAutorise();
			}
			if (pileBataille.isEmpty()) {
				return false;
			}
			Bataille sommet = pileBataille.get(pileBataille.size()-1);
			if (!(sommet instanceof Attaque)) {
				return false;
			}
//			même types
			return sommet.getType().equals(bataille.getType());
		}
		return false;
	}
	
	public boolean estDepotAutorise(Carte carte) {
		if (carte instanceof Borne borne) {
			return estDepotBorneAutorise(borne);
		} else if (carte instanceof Limite limite) {
			return estDepotLimiteAutorise(limite);
		} else if (carte instanceof Bataille bataille) {
			return estDepotBatailleAutorise(bataille);
		}
		return false;
	}
}
