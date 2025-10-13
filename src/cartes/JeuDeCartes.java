package cartes;

public class JeuDeCartes {
	private Configuration[] configurations = { new Configuration(new Borne(25), 10),
			new Configuration(new Borne(50), 10), new Configuration(new Borne(75), 10),
			new Configuration(new Borne(100), 12), new Configuration(new Borne(200), 4),
			new Configuration(new Parade(Type.FEU), 14), new Configuration(new Parade(Type.VITESSE), 6),
			new Configuration(new Parade(Type.ESSENCE), 6), new Configuration(new Parade(Type.CREVAISON), 6),
			new Configuration(new Parade(Type.ACCIDENT), 6), new Configuration(new Attaque(Type.FEU), 5),
			new Configuration(new Attaque(Type.VITESSE), 4), new Configuration(new Attaque(Type.ESSENCE), 3),
			new Configuration(new Attaque(Type.CREVAISON), 3), new Configuration(new Attaque(Type.ACCIDENT), 3),
			new Configuration(new Botte(Type.FEU), 1), new Configuration(new Botte(Type.ESSENCE), 1),
			new Configuration(new Botte(Type.CREVAISON), 1), new Configuration(new Botte(Type.ACCIDENT), 1) };

	public void affichageJeuDeCartes() {
		for (Configuration conf : configurations) {
			System.out.println(conf.nbExemplaire + " " + conf.carte);
		}
	}

	public Carte[] donnerCartes() {
		int totalCartes = 0;
		for (Configuration conf : configurations) {
			totalCartes += conf.getNbExemplaire();
		}
		Carte[] cartes = new Carte[totalCartes];
		int numCarte = 0;
		for (Configuration conf : configurations) {
			Carte carte = conf.getCarte();
			for (int i = 0; i < conf.getNbExemplaire(); i++) {
				cartes[numCarte] = carte;
				numCarte++;
			}
		}
		return cartes;
	}
	
	public boolean checkCount() {
		Carte[] cartes = donnerCartes();
		for (Configuration conf : configurations) {
			Carte carteAttendu = conf.getCarte();
			int nbCarteAttendu = conf.getNbExemplaire();
			int nbCarteTrouve = 0;
			for (Carte carte : cartes) {
				if (carte == carteAttendu) {
					nbCarteTrouve++;
				}
			}
			if (nbCarteTrouve!=nbCarteAttendu) {
				return false;
			}
		}
		return true;
	}
	
	// classe interne
	private static class Configuration {
		private Carte carte;
		private int nbExemplaire;

		private Configuration(Carte carte, int nbExemplaire) {
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
