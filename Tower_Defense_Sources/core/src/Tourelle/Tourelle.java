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
	private int portee;
	
	Tourelle (ModeleTourelle modele, Case saCase){
		this.cout = modele.getCout();
		this.vitesseAttaque = modele.getVitesseAttaque();
		this.sesAmeliorations = modele.ameliorations();
		this.degat = modele.getDegat();
		this.saCase = saCase;
		
		
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
		this.enleverLaVisionDesCase(saCase, true);
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