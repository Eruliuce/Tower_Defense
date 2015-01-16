package Jeu;

import Outils.LecteurFichiers;

public class Joueur
{
	private int nbVies;
	private String nom;
	private int or;
	
	public Joueur(String nom)
	{
		nbVies = LecteurFichiers.getInt("FichiersConf\\Constantes.conf", "vieBaseJoueur");
		this.nom = nom;
		or = LecteurFichiers.getInt("FichiersConf\\Constantes.conf", "orBaseJoueur");
	}
	
	public void perdreVies(int nb)
	{
		nbVies = nbVies - nb > 0 ? nbVies - nb : 0;
	}
}
