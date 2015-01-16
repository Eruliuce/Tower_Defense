package Tourelle;

import java.util.Collection;

public class Tourelle extends Decorateur_EffetTourelle {
	private int cout;
	private float vitesseAttaque;
	private int degat;
	private Collection<I_Modele_Tourelle> sesAmeliorations;
	
	Tourelle (ModeleTourelle modele){
		this.cout = modele.getCout();
		this.vitesseAttaque = modele.getVitesseAttaque();
		this.sesAmeliorations = modele.ameliorations();
		this.degat = modele.getDegat();
		

	}
}
