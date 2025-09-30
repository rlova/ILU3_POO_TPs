package jeu;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import cartes.Carte;

public class Sabot implements Iterable<Carte>{
	private Carte[] cartes;
	private int nbCartes;
	private int nbOperations = 0;
	
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	public void ajouterCarte(Carte carte) {
		if (nbCartes<=cartes.length) {
			cartes[nbCartes++] = carte;
			nbOperations++;
		} else {
			throw new IllegalArgumentException("Dépassement de capacité");
		}
	}
	
	private class Iterateur implements Iterator<Carte> {
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int nbOperationsReference = nbOperations;
		@Override
		public boolean hasNext() {
			return indiceIterateur<nbCartes;
		}

		@Override
		public Carte next() {
			if (hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceIterateur++;
				nextEffectue = true;
				return carte;
			} else {
				throw new NoSuchElementException();
			}
		}

		@Override
		public void remove() {
			if (nbCartes<1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for (int i=indiceIterateur-1;i<nbCartes-1;i++) {
				cartes[i] = cartes[i+1];
			}
			nextEffectue = false;
			indiceIterateur--;
			nbCartes--;
			nbOperations++;
			nbOperationsReference++;
		}

		private void verificationConcurrence() {
			if (nbOperations!=nbOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
	}
	
	public Carte piocher() {
		Iterator<Carte> iterateur = iterator();
		Carte carteSupp = iterateur.next();
		iterateur.remove();
		return carteSupp;
	}
	
	@Override
	public Iterator<Carte> iterator() {
		return iterator();
	}
	
	
}
