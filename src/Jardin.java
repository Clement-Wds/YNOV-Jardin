import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

import Flore.Ail;
import Flore.Betterave;
import Flore.Carotte;
import Flore.Etat;
import Flore.IOgm;
import Flore.IRacePure;
import Flore.Tomate;

public class Jardin {

	//ATTRIBUTS
	private int longueur;
	private int largeur;
	private HashMap<String, Integer> panier;
	private Emplacement emplacement[][];
		
	//CONSTRUCTEUR
	public Jardin(int longueur, int largeur) {
		this.longueur = longueur;
		this.largeur = largeur;
		this.panier = new HashMap<String, Integer>();
		emplacement = new Emplacement[this.longueur][this.largeur];
	}
	
	public void ajouterPanier(String vegetal, Integer quantite) {
		if(this.panier.get(vegetal) == null) {
			this.panier.put(vegetal, quantite);
		}else {
			int oldQuantite = this.panier.get(vegetal);
			this.panier.put(vegetal, oldQuantite + quantite);
		}
		
	}
	
	//Penser à StringBuffer et StringBuilder !!
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Voici notre jardin \n");
		
		for(int i = 0; i < this.longueur; i++) {
			for(int j = 0; j < this.largeur; j++) {
				if(emplacement[i][j] == null) {
					sb.append("o");
				} else {
					sb.append(emplacement);
				}
			}
			sb.append("\n");
		}
		Iterator<String> iterator = this.panier.keySet().iterator();
		while(iterator.hasNext()) {
			String nom = iterator.next();
			int quantite = this.panier.get(nom);
			sb.append(nom).append(" : ").append(quantite).append("\n");
		}
				
		return sb.toString();
	}
	
	public void semer() {
		//Demande choix utilisateur
		Scanner sc = new Scanner(System.in);
		
		System.out.println("indiquer la valeur X");
		int x = sc.nextInt();
		
		System.out.println("indiquer la valeur Y");
		int y = sc.nextInt();
		
		System.out.println("Quel végétal ? 1. Ail / 2. Betterave / 3. Carotte / 4. Tomate");
		int choiceVegetal = sc.nextInt();
		
		//Semer le végétal qu'il faut
		
		switch(choiceVegetal) {
			case 1:
				if(panier.get("Ail") > 0 ) {
					//semer
					this.emplacement[x][y] = new Emplacement(new Ail());
					//Décrémenter le panier
					this.panier.put("Ail", this.panier.get("Ail") - 1);
				}
				break;
			case 2:
				if(panier.get("Betterave") > 0 ) {
					this.emplacement[x][y] = new Emplacement(new Betterave());
					this.panier.put("Betterave", this.panier.get("Betterave") - 1);
				}
				break;
			case 3:
				if(panier.get("Carotte") > 0 ) {
					this.emplacement[x][y] = new Emplacement(new Carotte());
					this.panier.put("Carotte", this.panier.get("Carotte") - 1);
				}
				break;
			case 4:
				if(panier.get("Tomate") > 0 ) {
					this.emplacement[x][y] = new Emplacement(new Tomate());
					this.panier.put("Tomate", this.panier.get("Tomate") - 1);
				}
				break;
			default:
				System.out.println("Attention, vous devez choisir un nombre entre 1 et 4");
				break;
		}
		
	}
	
	public void saisonSuivante() {
		
		for(int x = 0; x < this.longueur; x++) {
			for(int y = 0; y < this.largeur; y++) {
				
				if(emplacement[x][y] != null) {
					
					if(emplacement[x][y].getVeg().getEtat() != Etat.MORT) {
						
						emplacement[x][y].getVeg().grandir();
						
					} else {
						
						emplacement[x][y] = null;
						
					}
				}
			}
		}
	}
	
	public void recolter() {
		for(int x = 0; x < this.longueur; x++) {
			for(int y = 0; y < this.largeur; y++) {
				
				if(emplacement[x][y] != null) {
					if(emplacement[x][y].getVeg().getEtat() == Etat.FLEUR) {
						
						if(emplacement[x][y].getVeg() instanceof IRacePure) {
							IRacePure v = (IRacePure)emplacement[x][y].getVeg(); //CAST
							v.seReproduire(this.panier);
						}
						emplacement[x][y] = null;
					}
				}
				
				if(emplacement[x][y].getVeg() instanceof IOgm) {
					IOgm v = (IOgm)emplacement[x][y].getVeg();//CAST
					SimpleEntry<Integer, Integer> newXY = v.seDupliquer(longueur, largeur); // Methode se dupliquer
					emplacement[newXY.getKey()][newXY.getKey()] = new Emplacement(emplacement[x][y].getVeg()); // dans la case du tableau d'emplacement, j'instancie un nouvel emplacement avec le nouveau végétal
					
				}
			
				
			}
		}
	}
}
