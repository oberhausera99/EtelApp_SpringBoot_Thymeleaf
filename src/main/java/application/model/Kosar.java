package application.model;

import java.util.Map;
import java.util.HashMap;

public class Kosar {
	Map<Etel, Integer> etelek;
	
	public Kosar(){
		etelek = new HashMap<Etel, Integer>();
	}
	
	public Map<Etel, Integer> getEtelek(){
		return etelek;
	}
	
	
	public void deleteEtel(Etel etel) {
		etelek.remove(etel);
	}
	
	public void modositEtel(Etel etel, int darab) {
		if(etelek.containsKey(etel)) {
			etelek.put(etel, darab);
		}
	}
	
	public void addEtel(Etel etel) {
		if(!etelek.containsKey(etel)) {
			etelek.put(etel, 1);
		}
	}
}
