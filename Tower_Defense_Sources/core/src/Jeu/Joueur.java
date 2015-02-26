package Jeu;

import Outils.LecteurFichiers;

public class Joueur
{
	private static int nbVies;
	private String nom;
	private int or;
	
	public Joueur(String nom)
	{
		nbVies = LecteurFichiers.getInt("..\\core\\FichiersConf\\Constantes.conf", "vieBaseJoueur");
		this.nom = nom;
		or = LecteurFichiers.getInt("..\\core\\FichiersConf\\Constantes.conf", "orBaseJoueur");
	}
	
	public static int getNbVies() {
		return nbVies;
	}

	public static void setNbVies(int nbVies) {
		Joueur.nbVies = nbVies;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getOr() {
		return or;
	}

	public void setOr(int or) {
		this.or = or;
	}

	public static void perdreVies(int nb)
	{
		nbVies = nbVies - nb > 0 ? nbVies - nb : 0;
	}
}
