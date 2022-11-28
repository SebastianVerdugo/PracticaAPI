package PracticaAPI;

import java.util.Comparator;

public class ComparadorID implements Comparator <Personaje> {

	@Override
	public int compare(Personaje p1, Personaje p2) {
	
		return p1.getID() < p2.getID() ? -1 : p1.getID() > p2.getID() ? 1 : 0;
	}

}
