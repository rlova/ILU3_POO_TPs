package utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;
import java.util.Set;

public class GestionCartes {
	public static <T> T extraire(List<T> liste) {
		Random random = new Random();
		int index = random.nextInt(liste.size());
		return liste.remove(index);
	}
	
	public static <T> T extraireIterator(List<T> liste) {
		Random random = new Random();
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
		Set<T> elementAVerifier = new HashSet<>();	// Pour éviter de vérifier 2 fois les memes valeurs
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
		Set<T> elementTraite = new HashSet<>();	// pour contenir les élements après vérification
		for (T element : liste) {
			if (!elementTraite.contains(element)) {
				for (T elem : liste) {
					if (elem.equals(element)) {
						listeRassemblee.add(element);
					}
				}
			}
			elementTraite.add(element);
		}
		return listeRassemblee;
	}
	
	public static <T> boolean verifierRassemblement2(T element, List<T> liste) {
		ListIterator<T> reste = liste.listIterator();
		boolean present = false;
		if (reste.hasNext() && liste.contains(element)) {
			present = true;
		}
		return present;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		boolean consecutif = false;
		if (!liste.isEmpty() && liste.size()==1) {
			return true;
		}
		ListIterator<T> premier = liste.listIterator();
		T element = premier.next();
		if (premier.hasNext() && premier.next().equals(element)) {
			consecutif = true;
		} else {
			verifierRassemblement2(element,liste);
		}
		return consecutif;
	}
	
	/*public static <T> boolean verifierRassemblement2(T element, List<T> liste) {
		ListIterator<T> reste = liste.listIterator();
		boolean present = false;
		if (reste.hasNext() && liste.contains(element)) {
			present = true;
		}
		return present;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		boolean consecutif = false;
		if (!liste.isEmpty() && liste.size()==1) {
			return true;
		}
		ListIterator<T> premier = liste.listIterator();
		T element = premier.next();
		if (premier.hasNext() && !verifierRassemblement2(element,liste)) {
			consecutif = true;
		}
		return consecutif;
	}*/
	
	/*public static <T> boolean verifierRassemblement2(T element, ListIterator<T> liste) {
		boolean present = false;
		if (liste.hasNext() && element.equals(liste.next())) {
			present = true;
		}
		return present;
	}
	
	public static <T> boolean verifierRassemblement(List<T> liste) {
		boolean consecutif = false;
		if (!liste.isEmpty() && liste.size()==1) {
			return true;
		}
		ListIterator<T> premier = liste.listIterator();
		ListIterator<T> reste = liste.listIterator();
		T element = premier.next();
		while (!liste.isEmpty() && premier.hasNext()) {
			if (element.equals(premier.next())) {
				reste.next();
				reste.remove();
				consecutif = true;
				premier.next();
			} else {
				verifierRassemblement2(element, reste);
			}
		}
		return consecutif;
	}*/
}
