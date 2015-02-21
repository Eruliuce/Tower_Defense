package Tourelle;

import java.util.Collection;

import monstres.Monstre;
import ZoneAttaqueTourelle.ZoneAttaqueTourelle;
import terrain.Case;
import terrain.CaseAlgo;

public class Tourelle extends Decorateur_EffetTourelle {
	private int cout;
	private float vitesseAttaque;
	private int degat;
	private Collection<I_Modele_Tourelle> sesAmeliorations;
	private boolean antiAerien;
	private boolean seeInvisble;
	private Case saCase;
	private ZoneAttaqueTourelle zone;
	
	Tourelle (ModeleTourelle modele, Case saCase){
		this.cout = modele.getCout();
		this.vitesseAttaque = modele.getVitesseAttaque();
		this.sesAmeliorations = modele.ameliorations();
		this.degat = modele.getDegat();
		this.saCase = saCase;

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
	
	private Monstre selectMonstreAttaquer(){
		return this.saCase.selectMonstreAttaquer(this);
		
	}
	
	public void attaquer(){
		Monstre monstreAttaquer = this.selectMonstreAttaquer();
		if (monstreAttaquer != null)
		{
			
		}
	}
	
	public boolean caseDansLaZone (CaseAlgo caseTester)
	{
		return this.zone.caseDansLaZone(caseTester);
	}
}