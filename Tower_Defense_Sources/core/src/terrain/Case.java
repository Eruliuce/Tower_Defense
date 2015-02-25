package terrain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

//<<<<<<< HEAD

//import terrain2.CaseAlgo;
//import terrain2.Coordonnees;




import Tourelle.Tourelle;
import monstres.Monstre;

public class Case implements CaseAlgo
{

	private Coordonnees<Integer,Integer> position;	
	public Coordonnees<Integer, Integer> getPosition() {
		return position;
	}
	private Collection<Monstre> sesMonstres;
	private boolean traversable=true;
	private Case caseCheminSuivante;
	private Case caseCheminPrecedente;
	private Terrain sonTerrain;
	public static final int TAILLECASE = 32;
	private boolean invisibleAdecouvert;
	private Tourelle saTour;
	
	
		{
			sesMonstres = new LinkedList<Monstre>();
			invisibleAdecouvert = false;
		}
	public Case (int x,int y){
		position=new Coordonnees<Integer,Integer>(x,y);
	    	
	}
	/**
	 * ajoute un monstre à la liste des monstres présents sur la case
	 * @param monstre : le monstre à ajouter
	 * @return booleen : True si l'ajout s'est fait
	 * @author BlackNichols
	 */
	public boolean ajoutMonstre(Monstre monstre){
		return sesMonstres.add(monstre);
	}
	/**
	 * retire un monstre à la liste des monstres présents sur la case
	 * @param monstre : le monstre à retirer
	 * @return booleen : True si le retrait s'est fait
	 * @author BlackNichols
	 */
	public boolean retirerMonstre(Monstre monstre){
		return sesMonstres.remove(monstre);
	}
	
	public Case(Coordonnees<Integer,Integer> c){
		position = c;
	}
	
	public Coordonnees<Integer,Integer> getpos(){
		
		return position;
	}
	
	
	
	public Tourelle getSaTour() {
		return saTour;
	}
	public void setSaTour(Tourelle saTour) {
		this.saTour = saTour;
	}
	public boolean gettraversable(){
		return traversable;
		 
	}
	 public void settraversable(boolean t){
		traversable=t; 
		 
	 }
	
	public int cout() {
		return 1;
	}	
	
	public boolean isInvisibleAdecouvert() {
		return invisibleAdecouvert;
	}
	
	public void setInvisibleAdecouvert(boolean invisibleAdecouvert) {
		this.invisibleAdecouvert = invisibleAdecouvert;
	}
	
	public Monstre selectMonstreAttaquer(Tourelle tour){
		return this.sonTerrain.selectMonstreAttaquer(tour);
	}
	
	
	
	/**
	 * Cherche le monstre attaquable par la tour le plus proche de l'arrivée
	 * @param tour
	 * @return monstre : le monstre qui sera ciblé par la tour
	 * @author BlackNichols
	 * @deprecated Cette fonction est valble dans le cas de "grosses cases" que le monstres doit parcourir. On a fait 
	 * autre chose au final
	 */
	public Monstre monstreACibler1(Tourelle tour){
		int ymax = 0, xmax = 0, modifX = 0, modifY = 0;
		if(caseCheminPrecedente != null){
			if(position.getx()>caseCheminPrecedente.position.getx()){
				xmax = 0;
				modifX = 1;
				System.out.println("1,1");
			}else if(position.getx()<caseCheminPrecedente.position.getx()){
				xmax = Integer.MAX_VALUE;
				modifX = -1;
				System.out.println("1,2");
			}else if(position.gety()>caseCheminPrecedente.position.gety()){
				ymax = 0;
				modifY = 1;
				System.out.println("1,3");
			}else if(position.gety()<caseCheminPrecedente.position.gety()){
				ymax = Integer.MAX_VALUE;
				modifY = -1;
				System.out.println("1,4");
			}
		}
		if(caseCheminSuivante != null){
			if(position.getx()<caseCheminSuivante.position.getx()){
				xmax = 0;
				modifX = 1;
				System.out.println("2,1");
			}else if(position.getx()>caseCheminSuivante.position.getx()){
				xmax = Integer.MAX_VALUE;
				modifX = -1;
				System.out.println("2,2");
			}else if(position.gety()<caseCheminSuivante.position.gety()){
				ymax = 0;
				modifY = 1;
				System.out.println("2,3");
			}else if(position.gety()>caseCheminSuivante.position.gety()){
				ymax = Integer.MAX_VALUE;
				modifY = -1;
				System.out.println("2,4");
			}
		}
		return triMonstreSale(xmax,modifX,ymax,modifY,tour);
	}
//<<<<<<< HEAD
	//return triMonstreSale(xmax,modifX,ymax,modifY,tour);
//}
/**
 * Cette fonction permet d'optimiser les tests de manière un peu dégueu
 * @param xmax 0 ou Integer.max_value
 * @param modifX -1, 0 ou 1
 * @param ymax 0 ou Integer.max_value
 * @param modifY -1, 0 ou 1
 * @return le monstre à cibler
 * @author un type qui n'assume pas
 * @deprecated 
 */
	private Monstre triMonstreSale(int xmax,int modifX,int ymax,int modifY, Tourelle tour){
		Monstre monstreCible = null;
		for(Monstre monstre : sesMonstres){
			if(monstre.attaquable(tour) && (monstre.getPosition().getx() * modifX >= xmax * modifX) && (monstre.getPosition().gety() * modifY >= ymax * modifY)){
				monstreCible = monstre;
				xmax = monstre.getPosition().getx();
				ymax = monstre.getPosition().gety();
			}
		}
		return monstreCible;
	}

	public Monstre monstreACibler(Tourelle tour){
		boolean monstreTrouve = false;
		Iterator<Monstre> iterator = sesMonstres.iterator();
		while (!monstreTrouve && iterator.hasNext()){
			Monstre monstre;
			if( (monstre = sesMonstres.iterator().next()).attaquable(tour))
				return monstre;
		}
		return null;
	}
	
	protected void setCaseCheminSuivante(Case caseCheminSuivante) {
		this.caseCheminSuivante = caseCheminSuivante;
	}
	protected void setCaseCheminPrecedente(Case caseCheminPrecedente) {
		this.caseCheminPrecedente = caseCheminPrecedente;
	}
	public boolean presenceMonstres(){
		return !sesMonstres.isEmpty();
	}
	
	public Case getCaseCheminSuivante() {
		return caseCheminSuivante;
	}
	public Case getCaseCheminPrecedente() {
		return caseCheminPrecedente;
	}
	public int distance(Case caseEloigner)
	{
		return Math.abs(position.getx()-caseEloigner.getpos().getx()) + Math.abs(position.gety()-caseEloigner.getpos().gety());
	}
}
