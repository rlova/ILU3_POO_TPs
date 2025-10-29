package jeu;

import java.util.ArrayList;
import java.util.List;

import cartes.Bataille;
import cartes.Borne;
import cartes.Limite;

public class ZoneDeJeu {
	private List<Limite> pileLimites;
	private List<Bataille> pileBataille;
	private List<Borne> collectionBornes;
	
	public ZoneDeJeu() {
		this.pileLimites = new ArrayList<Limite>();
		this.pileBataille = new ArrayList<Bataille>();
		this.collectionBornes = new ArrayList<Borne>();
	}
}
