package Tourelle;

import java.util.Collection;

import terrain.CaseAlgo;

public class Tourelle extends Decorateur_EffetTourelle {
	private int cout;
	private float vitesseAttaque;
	private int degat;
	private CaseAlgo saCase;
	
	private Collection<I_Modele_Tourelle> sesAmeliorations;
	
	Tourelle (ModeleTourelle modele, CaseAlgo caseChoisi){
		this.cout = modele.getCout();
		this.vitesseAttaque = modele.getVitesseAttaque();
		this.sesAmeliorations = modele.ameliorations();
		this.degat = modele.getDegat();
		this.saCase = caseChoisi;

	}
}
