package PracticaAPI;

import java.util.Comparator;

public class ComparadorNombre implements Comparator<Personaje>{

	@Override
	public int compare(Personaje p1, Personaje p2) {
		// TODO Auto-generated method stub
		return p1.getName().compareToIgnoreCase(p2.getName());
	}
	

}
