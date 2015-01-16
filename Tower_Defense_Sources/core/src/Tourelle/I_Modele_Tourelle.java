package Tourelle;

import java.util.Collection;

public interface I_Modele_Tourelle {
	public String infosDetaillees();
	public String resume();
	
	public Collection<I_Modele_Tourelle> ameliorations();
	public Collection<String> resumeAmelioration();
	
	public int getDegat();
	public float getVitesseAttaque();
	public int getCout();
	public float getZone();
}
