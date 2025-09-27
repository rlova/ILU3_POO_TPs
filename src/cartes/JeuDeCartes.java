package cartes;

public class JeuDeCartes {
	private Configuration[] configurations = {
			new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10),
			new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 15),
			new Configuration(new Borne(200), 4),
			new Configuration(new Attaque(Type.FEU), 14),	// Feu Vert
			new Configuration(new FinLimite(), 6),	// Fin Limite
			new Configuration(new Parade(Type.ESSENCE), 0)	// Bidon d'essence
	};
	
	// classe interne
	private static class Configuration {
		private Carte carte;
		private int nbExemplaire;
		
		public Configuration(Carte carte, int nbExemplaire) {
			super();
			this.carte = carte;
			this.nbExemplaire = nbExemplaire;
		}

		public Carte getCarte() {
			return carte;
		}

		public int getNbExemplaire() {
			return nbExemplaire;
		}
		
		
	}
	
}
