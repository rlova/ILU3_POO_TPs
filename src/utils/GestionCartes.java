package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

public class GestionCartes {
	private static Random random = new Random();
	public static <T> T extraire(List<T> liste) {
		int index = random.nextInt(liste.size());
		return liste.remove(index);
	}
	
	public static <T> T extraireIterator(List<T> liste) {
		int index = random.nextInt(liste.size());
		ListIterator<T> it = liste.listIterator();
		T element = null; // element qu'on va supprimer
		for (int i=0; i<=index; i++) {
			element = it.next();
		}
		it.remove();
		return element;
	}
	
	public static <T> List<T> melanger(List<T> liste) {
		List<T> listeMelangee = new ArrayList<>();
		while (!liste.isEmpty()) {
			T element = extraire(liste);
			listeMelangee.add(element);
		}
		return listeMelangee;
	}
	
	public static <T> boolean verifierMelange(List<T> liste1, List<T> liste2) {
		if (liste1.size()!=liste2.size()) {
			return false;
		}
		Set<T> elementAVerifier = new HashSet<>(liste1);	// Pour éviter de vérifier 2 fois les memes valeurs
		for (T element : elementAVerifier) {
			int nbListe1 = Collections.frequency(liste1, element);
			int nbListe2 = Collections.frequency(liste2, element);
			if (nbListe1!=nbListe2) {
				return false;
			}
		}
		return true;
	}
	
	public static <T> List<T> rassembler(List<T> liste) {
		ArrayList<T> listeRassemblee = new ArrayList<>();	// pour inverser les valeurs
		ArrayList<T> listeCopie = new ArrayList<>(liste);	// pour ne pas modifier l'original
		while (!listeCopie.isEmpty()) {
//			prendre le premier elem
			T element = listeCopie.get(0);
//			parcourir avec Iterator pour supp 
			Iterator<T> it = listeCopie.iterator();
			while (it.hasNext()) {
				T elem = it.next();
				if (elem.equals(element)) {
					listeRassemblee.add(elem);
					it.remove();
				}
			}
		}
		return listeRassemblee;
	}
	
//	pour vérifier si un elem apparait dans le reste de la liste à partir de la position de l'itérateur
	public static <T> boolean verifierRassemblement2(T element, ListIterator<T> reste) {
		while (reste.hasNext()) {
			if (reste.next().equals(element)) {
				return true;
			}
		}
		return false;
	}
	
//	premier balaye la liste elem par elem
//	reste vérifie le reste de la liste pour chaque changement de valeur
	public static <T> boolean verifierRassemblement(List<T> liste) {
		if (liste == null || liste.isEmpty() || liste.size()==1) {
			return true;
		}
		ListIterator<T> premier = liste.listIterator();
		T elementCourant = premier.next();
		while (premier.hasNext()) {
			T elementSuivant = premier.next();
//			changement de valeur
			if (!elementSuivant.equals(elementCourant)) {
				ListIterator<T> reste = liste.listIterator(premier.nextIndex());
//				vérifie si l'ancien réapparait
				if (verifierRassemblement2(elementCourant, reste)) {
					return false;
				}
				elementCourant = elementSuivant;
			}
		}
		return true;
	}
}
