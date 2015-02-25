package Outils;
import java.util.Collection;

import exceptions.CaseNonTrouveeException;


public interface GestionChemin{
	public Collection<Integer> chemin() throws CaseNonTrouveeException;
}
