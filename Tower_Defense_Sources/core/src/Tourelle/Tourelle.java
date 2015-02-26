package Tourelle;

import java.util.Collection;

import monstres.Monstre;
import ZoneAttaqueTourelle.ZoneAttaqueTourelle;
import terrain.Case;

public class Tourelle extends Decorateur_EffetTourelle {
	public final static int PRIXTOURELLE = 100;
	
	private int cout;
	private float vitesseAttaque;
	private int degat;
	private Collection<I_Modele_Tourelle> sesAmeliorations;
	private boolean antiAerien;
	public int getCout() {
		return cout;
	}

	public void setCout(int cout) {
		this.cout = cout;
	}

	public float getVitesseAttaque() {
		return vitesseAttaque;
	}

	public void setVitesseAttaque(float vitesseAttaque) {
		this.vitesseAttaque = vitesseAttaque;
	}

	public Collection<I_Modele_Tourelle> getSesAmeliorations() {
		return sesAmeliorations;
	}

	public void setSesAmeliorations(Collection<I_Modele_Tourelle> sesAmeliorations) {
		this.sesAmeliorations = sesAmeliorations;
	}

	public boolean isSeeInvisble() {
		return seeInvisble;
	}

	public void setSeeInvisble(boolean seeInvisble) {
		this.seeInvisble = seeInvisble;
	}

	public Case getSaCase() {
		return saCase;
	}

	public void setSaCase(Case saCase) {
		this.saCase = saCase;
	}

	public int getPortee() {
		return portee;
	}

	public void setPortee(int portee) {
		this.portee = portee;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	}

	public void setAntiAerien(boolean antiAerien) {
		this.antiAerien = antiAerien;
	}

	private boolean seeInvisble;
	private Case saCase;
	private int portee;
	
	public Tourelle (ModeleTourelle modele, Case saCase){
		this.cout = modele.getCout();
		this.vitesseAttaque = modele.getVitesseAttaque();
		this.sesAmeliorations = modele.ameliorations();
		this.degat = modele.getDegat();
		this.saCase = saCase;
		this.seeInvisble = modele.isSeeInvisible();
		
		if (modele.isAntiAerien())
		{
			this.sonEffetTourelle = new AntiAerien_Tourelle(this);
			if(modele.isSeeInvisible()){
				this.sonEffetTourelle.setSonDecorateur(new VisionInvisible_Tourelle(sonEffetTourelle));
			}
		}
		else{
			if(modele.isSeeInvisible()) {
				this.sonEffetTourelle = new VisionInvisible_Tourelle(this);
			}
		}
		
		
		if (seeInvisble){
			this.revelerCaseDansLaZone(saCase, true);
		}

	}
	
	public int getDegat() {
		return degat;
	}

	
	/**
	 * 
	 * @author Louvetia
	 * @param caseTester
	 * @param estUneCasePrecedente
	 * @return
	 */
	private boolean revelerCaseDansLaZone(Case caseTester, boolean estUneCasePrecedente)
	{
		if((caseTester.getpos().getx() == this.saCase.getpos().getx())
			&&(caseTester.getpos().gety() == this.saCase.getpos().gety())	)
		{
			caseTester.setInvisibleAdecouvert(true);
			return revelerCaseDansLaZone(saCase.getCaseCheminPrecedente(), true) && revelerCaseDansLaZone(caseTester.getCaseCheminSuivante(), false);
		}
		else{
			if(this.caseDansLaZone(caseTester))
			{
				caseTester.setInvisibleAdecouvert(true);
				if(estUneCasePrecedente)
				{
					return revelerCaseDansLaZone(caseTester.getCaseCheminPrecedente(), true);
				}
				else
				{
					return revelerCaseDansLaZone(caseTester.getCaseCheminSuivante(), false);
				}
			}
			else
				return false;
		}
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
			monstreAttaquer.seFaireAttaquer(this);
		}
	}
	
	public boolean caseDansLaZone (Case caseTester)
	{
		return saCase.distance(caseTester) <= portee;
	}
	
	public void detruire(){
		if(this.seeInvisble) {
			this.enleverLaVisionDesCase(saCase, true);
		}
		saCase.setSaTour(null);
		try {
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @author Louvetia
	 * @param caseTester
	 * @param estUneCasePrecedente
	 * @return
	 */
	private boolean enleverLaVisionDesCase(Case caseTester, boolean estUneCasePrecedente)
	{
		if((caseTester.getpos().getx() == this.saCase.getpos().getx())
				&&(caseTester.getpos().gety() == this.saCase.getpos().gety()))
			{
				caseTester.setInvisibleAdecouvert(false);
				return enleverLaVisionDesCase(saCase.getCaseCheminPrecedente(), true) && enleverLaVisionDesCase(caseTester.getCaseCheminSuivante(), false);
			}
			else{
				if(this.caseDansLaZone(caseTester))
				{
					caseTester.setInvisibleAdecouvert(false);
					if(estUneCasePrecedente)
					{
						return enleverLaVisionDesCase(caseTester.getCaseCheminPrecedente(), true);
					}
					else
					{
						return enleverLaVisionDesCase(caseTester.getCaseCheminSuivante(), false);
					}
				}
				else
					return false;
			}
	}
}