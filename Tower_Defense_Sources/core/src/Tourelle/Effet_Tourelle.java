package Tourelle;

public abstract class Effet_Tourelle extends Decorateur_EffetTourelle {
	protected Decorateur_EffetTourelle sonDecorateur;
	
	Effet_Tourelle(Decorateur_EffetTourelle decorateur) {
		sonDecorateur = decorateur;
	}

	public Decorateur_EffetTourelle getSonDecorateur() {
		return sonDecorateur;
	}

	public void setSonDecorateur(Decorateur_EffetTourelle sonDecorateur) {
		this.sonDecorateur = sonDecorateur;
	}
	
	

}
