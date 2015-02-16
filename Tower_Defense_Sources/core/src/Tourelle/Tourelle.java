package Tourelle;

import java.util.Collection;

public class Tourelle extends Decorateur_EffetTourelle {
	private int cout;
	private float vitesseAttaque;
	private int degat;
	private Collection<I_Modele_Tourelle> sesAmeliorations;
	private boolean antiAerien;
	private boolean seeInvisble;
	
	Tourelle (ModeleTourelle modele){
		this.cout = modele.getCout();
		this.vitesseAttaque = modele.getVitesseAttaque();
		this.sesAmeliorations = modele.ameliorations();
		this.degat = modele.getDegat();
		

	}
	/**
	 * getter vis à vis du caractère anti-aérien de la tour
	 * @author BlackNichols
	 * @return booleen : Oui/Non
	 */
	public boolean isAntiAerien() {
		return antiAerien;
	}
	/**
	 * getter vis à vis de la capacité de la tour à voir l'invisible
	 * @author BlackNichols
	 * @return booleen : Oui/Non
	 */
	public boolean canSeeInvisible() {
		return seeInvisble;
	}
}
