package Tourelle;

import java.util.ArrayList;
import java.util.Collection;

public class ModeleTourelle implements I_Modele_Tourelle{
	private int cout;
	private float vitesseAttaque;
	private int degat;
	private float zone;
	private ArrayList<I_Modele_Tourelle> sesAmeliorations;
	
	public ModeleTourelle(String nomFicConf) {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String infosDetaillees() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String resume() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<I_Modele_Tourelle> ameliorations() {
		// TODO Auto-generated method stub
		return this.sesAmeliorations;
	}
	@Override
	public Collection<String> resumeAmelioration() {
		// TODO Auto-generated method stub
		return null;
	}

	public int getCout() {
		return cout;
	}


	public float getVitesseAttaque() {
		return vitesseAttaque;
	}

	public int getDegat() {
		return degat;
	}
	
	public float getZone(){
		return this.zone;
	}
}
