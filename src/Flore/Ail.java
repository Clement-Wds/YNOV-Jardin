package Flore;

import java.util.HashMap;

public class Ail extends Vegetal implements IRacePure {
	public Ail() {
		super();
		dessin[3] = 'a';
		dessin[4] = 'A';
	}
	
	public void seReproduire(HashMap<String, Integer> panier) {
		
		int quantite = 3;
		
		if(panier.get("Ail") != null) {
			quantite = panier.get("Ail") + quantite;
		}
		panier.put("Ail", panier.get("Ail" + 3));
	}
}
