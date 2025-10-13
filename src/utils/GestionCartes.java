package utils;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

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
}
