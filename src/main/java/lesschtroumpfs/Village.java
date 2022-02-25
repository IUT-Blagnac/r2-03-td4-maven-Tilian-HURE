package lesschtroumpfs;

import java.util.ArrayList;
import lesschtroumpfs.Schtroumpf;

public class Village {

	private String nom;
	private ArrayList<Schtroumpf> schtroumpfs;
	private int nbSchtroumpfs;
	private int qteSalsepareille;
	
	
	/**
	 * Constructeur.
	 * @param nom : nom du village
	 * @param qteSalsepareille : quantité de salsepareille
	 * @param nomsDesSchtroumpfs : noms des Schtroumpfs à ajouter
	 */
	public Village (String nom, int qteSalsepareille, String[] nomsDesSchtroumpfs) {
		this.nom = nom;
		this.schtroumpfs = new ArrayList<Schtroumpf>();
		this.qteSalsepareille = qteSalsepareille;
		this.nbSchtroumpfs = 0;
		
		/*Créé et ajoute les Schtroumpfs*/
		Schtroumpf nouveauSchtroumpf;
		for (int i=0; i<nomsDesSchtroumpfs.length; i++) {
			nouveauSchtroumpf = new Schtroumpf(nomsDesSchtroumpfs[i], (int)(Math.random()*150));
			nouveauSchtroumpf.setVillage(this);
		}
	}
	
	
	/**
	 * @return le nom du village
	 */
	public String getNom() {
		return this.nom;
	}
	
	
	/**
	 * @return le nombre de Schtroumpfs dans le village
	 */
	public int getNbSchtroumpfs() {
		return this.nbSchtroumpfs;
	}
	
	
	/**
	 * @return la quantité de salsepareille du village
	 */
	public int getStockSalsepareille() {
		return this.qteSalsepareille;
	}
	
	
	/**
	 * Ajoute de la salsepareille au stock du village.
	 * @param qte : quantité de salsepareille à ajouter
	 */
	public void ajouterSalsepareille(int qte) {
		this.qteSalsepareille += Math.abs(qte);
	}
	
	
	/**
	 * Retire de la salsepareille du stock du village.
	 * @param qte : quantité de salsepareille à retirer
	 */
	public void retirerSalsepareille(int qte) {
		this.qteSalsepareille -= Math.abs(qte);
	}
	
	
	/**
	 * Ajoute un Schtroumpf au village.
	 * @param schtroumpf à ajouter
	 */
	public void ajouterSchtroumpf(Schtroumpf schtroumpf) {
		this.schtroumpfs.add(schtroumpf);
		this.nbSchtroumpfs++;
	}
	
	
	/**
	 * Retire un Schtroumpf du village.
	 * @param schtroumpf à retirer
	 */
	public void retirerSchtroumpf(Schtroumpf schtroumpf) {
		for (int i = 0; i<this.getNbSchtroumpfs(); i++) {
			if (this.schtroumpfs.get(i).equals(schtroumpf)) {
				this.schtroumpfs.remove(i);				
				break;
			}
		}
		this.nbSchtroumpfs--;
	}
	
	
	/**
	 * Présente tous les Schtroumpfs du village et fait chanter ceux qui sont heureux.
	 */
	public void solstice_d_ete() {
		int nbContents = 0;
		for (int i=0; i<this.getNbSchtroumpfs(); i++) {
			this.schtroumpfs.get(i).sePresenter();
			this.schtroumpfs.get(i).chanter();
			if (this.schtroumpfs.get(i).estContent()) {
				nbContents++;
			}
		}
		System.out.println("Village : " + this.nom
				+ "\nNombre de Schtroumpfs : " + this.nbSchtroumpfs
				+ "\nNombre de Schtroumpfs contents : " + nbContents);
	}
	
	
	/**
	 * @return le chef du village, soit le Schtroumpf le plus agé
	 */
	public Schtroumpf chefDuVillage() {
		Schtroumpf chef = this.schtroumpfs.get(0);		
		for (int i=1; i<this.nbSchtroumpfs; i++) {
			if (this.schtroumpfs.get(i).getAge() > chef.getAge()) {
				chef = this.schtroumpfs.get(i);
			}
		}
		return chef;
	}
	
	
	/**
	 * Envoie un Schtroumpf content sur deux travailler.
	 */
	public void envoyerAuTravail() {
		boolean content = this.schtroumpfs.get(0).estContent();
		for (int i=0; i<this.nbSchtroumpfs; i++) {
			if (this.schtroumpfs.get(i).estContent()) {
				if (content) {
					this.schtroumpfs.get(i).allerTravailler();
					content = false;
				} else {
					content = true;
				}
			}
		}
	}
	
	
	/**
	 * Présente et fait chanter les Schtroumpfs heureux du village.
	 */
	public void schtroumpfsHeureux() {
		for (int i=0; i<this.getNbSchtroumpfs(); i++) {
			if (this.schtroumpfs.get(i).estContent()) {
				this.schtroumpfs.get(i).sePresenter();
				this.schtroumpfs.get(i).chanter();
			}
		}
	}
	
	
	/**
	 * Fait diner tous les Schtroumpfs du village.
	 */
	public void dinerTousEnsemble() {
		for (int i=0; i<this.getNbSchtroumpfs(); i++) {
			this.schtroumpfs.get(i).dinerAuVillage();
		}
	}
	
	
	/**
	 * Envoie un Schtroumpf content sur deux cueillir de la salsepareille.
	 */
	public void envoyerCueillirSalsepareille() {
		boolean content = this.schtroumpfs.get(0).estContent();
		for (int i=0; i<this.nbSchtroumpfs; i++) {
			if (this.schtroumpfs.get(i).estContent()) {
				if (content) {
					this.schtroumpfs.get(i).recolterSalsepareille();
					content = false;
				} else {
					content = true;
				}
			}
		}
	}
}
