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
		Set<T> elementAVerifier = new HashSet<T>();	// Pour éviter 2 fois les memes valeurs
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
		ArrayList<T> listeRassemblee = new ArrayList<T>();	// pour inverser les valeurs
		Set<T> elementTraite = new HashSet<T>();	// pour contenir les élements après vérification
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
}
