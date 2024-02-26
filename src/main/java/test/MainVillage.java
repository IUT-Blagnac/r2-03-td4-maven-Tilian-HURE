package test;

import lesschtroumpfs.Village;

public class MainVillage {

	public static void main (String[] args) {
		String nomsSchtroumpfs[] = {"Grand Schtroumpf", "Schtroumpf courant (et pas ordinaire)",
				"Schtroumpf ordinaire (et pas courant)", "Schtroumpf moralisateur à lunettes",
		        "Schtroumpf boudeur", "Schtroumpf volant", "Schtroumpf étonné",
		        "Schtroumpf acrobate", "Schtroumpf paresseux"};

		/*Cr�� un village de Schtroumpfs*/
		Village schtroumpfland = new Village("SchtroumpfLand", 83, nomsSchtroumpfs);
		System.out.println("Solstice d'�t� :");
		schtroumpfland.solstice_d_ete();
		
		/*Pr�sente le chef du village*/
		System.out.println("\nChef du village :");
		schtroumpfland.chefDuVillage().sePresenter();
		
		/*Envoie des Schtroumpfs au travail*/
		schtroumpfland.envoyerAuTravail();
		
		/*Affiche les Schtroumpfs heureux*/
		System.out.println("\nSchtroumpfs heureux :");
		schtroumpfland.schtroumpfsHeureux();
		
		/*Fait ramasser de la salsepareille aux Schtroumpfs*/
		schtroumpfland.envoyerCueillirSalsepareille();
		
		System.out.println("\nSolstice d'�t� :");
		schtroumpfland.solstice_d_ete();
		
		/*Fait diner tous les Schtroumpfs*/
		schtroumpfland.dinerTousEnsemble();
		
		System.out.println("\nSolstice d'�t� :");
		schtroumpfland.solstice_d_ete();
	}
}
