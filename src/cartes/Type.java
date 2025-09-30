package cartes;

public enum Type {
	FEU("Feu rouge","Feu vert","Prioritaire"),
	ESSENCE("Panne d'essence","Bidon d'essence","Citerne"),
	CREVAISON("Crevaison","Roue de secours","Increvable"),
	ACCIDENT("Accident","Réparation","As du volant"),
	VITESSE("Limite 50","Fin Limite","Prioritaire"); 
	
	private String attaque;
	private String parade;
	private String botte;
	
	private Type(String attaque, String parade, String botte) {
		this.attaque = attaque;
		this.parade = parade;
		this.botte = botte;
	} 

	public String getAttaque() {
		return attaque;
	}

	public String getParade() {
		return parade;
	}

	public String getBotte() {
		return botte;
	}
	
	public String nomCarte(String role) {
		switch (role) {
			case "attaque" : return attaque;
			case "parade" : return parade;
			case "botte" : return botte;
			default : return null;
		}
	}

}

