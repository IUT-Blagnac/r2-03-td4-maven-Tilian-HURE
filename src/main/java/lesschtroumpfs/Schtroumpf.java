package lesschtroumpfs;

public class Schtroumpf {
	
	private String nom;
	private int age;
	private boolean content;
	private Village village;
	
	
	/**
	 * Constructeur pour un Schtroumpf ermite.
	 * @param nom : nom du Schtroumpf
	 * @param age : age du Schtroumpf
	 */
	public Schtroumpf(String nom, int age) {
		this.nom = nom;
		this.age = age;
		this.content = true;
		this.village = null;
	}
	
	
	/**
	 * Constructeur pour un Schtroumpf villageois.
	 * @param nom : nom du Schtroumpf
	 * @param age : age du Schtroumpf
	 * @param village : village du Schtroumpf
	 */
	public Schtroumpf(String nom, int age, Village village) {
		this.nom = nom;
		this.age = age;
		this.content = true;
		this.village = village;
	}
	
	
	/**
	 * @return le nom du Schtroumpf
	 */
	public String getNom() {
		return this.nom;
	}
	
	
	/**
	 * @return l'âge du Schtroumpf
	 */
	public int getAge() {
		return this.age;
	}
	
	
	/**
	 * @return la contentitude du Schtroumpf
	 */
	public boolean estContent() {
		return this.content;
	}
	
	
	/**
	 * @return la chaîne toString des informations du Schtroumpf
	 */
	public String toString() {
		String chaine;
		chaine = "Je suis " + this.nom + ", j'ai " + this.age + " ans, ";
		
		/*Village*/
		if (this.village != null) {
			chaine += "j'habite à " + this.village.getNom();
		} else {
			chaine += "je suis ermite";
		}
		chaine += " et je suis";
		
		/*Contentitude*/
		if (!this.estContent()) {
			chaine += " PAS";
		}
		chaine += " content.";
		
		return chaine;
	}
	
	
	/**
	 * Présente un Schtroumpf.
	 */
	public void sePresenter() {
		System.out.println(this.toString());
	}
	
	
	/**
	 * @return le chant du Schtroumpf en fonction de son humeur
	 */
	public String leChant() {
		String chaine;
		if (this.estContent()) {
			chaine = "La, la, et Schtroumpf la, la, ...";
		} else {
			chaine = "Gloups.";
		}
		return chaine;
	}
	
	
	/**
	 * Fait chanter le Schtroumpf.
	 */
	public void chanter() {
		System.out.println(this.leChant());
	}
	
	
	/**
	 * Fait vieillir le Schtroumpf d'un an.
	 */
	public void anniversaire() {
		this.age++;
	}
	
	
	/**
	 * Fait manger le Schtroumpf.
	 * @param qte : quantité de salspareille mangée
	 */
	public void manger(int qte) {
		if (qte > 0) {
			this.content = true;
		}
	}
	
	
	/**
	 * Envoie travailler le Schtroumpf, ce qui le rend malheureux.
	 */
	public void allerTravailler() {
		this.content = false;
	}
	
	
	/**
	 * @return le village du Schtroumpf si ce dernier en possède un, sinon null
	 */
	public Village getVillage() {
		return this.village;
	}
	
	
	/**
	 * Met à jour le village du Schtroumpf.
	 * @param village : nouveau village
	 */
	public void setVillage(Village village) {
		if (this.village != null) {
			this.village.retirerSchtroumpf(this);
		}		
		this.village = village;
		this.village.ajouterSchtroumpf(this);
	}
	
	
	/**
	 * Fait récolter et stocker ou manger de la salsepareille au Schtroumpf.
	 */
	public void recolterSalsepareille() {
		if (this.getVillage() != null) {
			this.allerTravailler();
			this.village.ajouterSalsepareille(5);
		} else {
			this.manger(5);
		}
	}
	
	
	/**
	 * Fait diner un Schtroumpf s'il possède un village et que la quantité de salsepareille
	 * dans ce dernier est suffisante.
	 */
	public void dinerAuVillage() {
		if (this.getVillage() != null && this.village.getStockSalsepareille() >= 3) {
			this.manger(3);
			this.village.retirerSalsepareille(3);
		} else {
			this.content = false;
		}
	}
}
