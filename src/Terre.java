import java.util.Scanner;

public class Terre {

	public static void main(String[] args) {
		Jardin j = new Jardin(10,10);
		
		j.ajouterPanier("Betterave", 7);
		j.ajouterPanier("Carotte", 2);
		j.ajouterPanier("Tomate", 9);
		j.ajouterPanier("Ail", 4);
		
		System.out.println(j);
		
		int choice = 0;
		
		do {
			
			System.out.println("1 : Semer une graine");
			System.out.println("2 : R�colter toutes les plantes");
			System.out.println("3 : Passer � la saison suivante");
			System.out.println("4 : Quitter l'application");
			
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			
			switch (choice) {
			case 1:
				//TODO Appeler methode semer
				System.out.println("Semer");
				break;
			case 2:
				//TODO Appeler m�thode r�colter
				System.out.println("R�colter");
				break;
			case 3:
				//TODO Appler m�thode saison suivante
				System.out.println("Saison suivante");
				break;

			}
			
		} while(choice != 4);
		
		System.out.println("Fin du programme !");

	}

}
