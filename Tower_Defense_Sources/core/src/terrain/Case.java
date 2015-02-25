package terrain;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

//<<<<<<< HEAD
//import terrain2.CaseAlgo;
//import terrain2.Coordonnees;


//=======
import Tourelle.Tourelle;
import monstres.Monstre;
//>>>>>>> cff0fb5887195671ad315c7ed3db71c8442bae9f
public class Case implements CaseAlgo{

	private Coordonnees<Integer,Integer> position;	
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
	 * ajoute un monstre � la liste des monstres pr�sents sur la case
	 * @param monstre : le monstre � ajouter
	 * @return booleen : True si l'ajout s'est fait
	 * @author BlackNichols
	 */
	public boolean ajoutMonstre(Monstre monstre){
		return sesMonstres.add(monstre);
	}
	/**
	 * retire un monstre � la liste des monstres pr�sents sur la case
	 * @param monstre : le monstre � retirer
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
	 * Cherche le monstre attaquable par la tour le plus proche de l'arriv�e
	 * @param tour
	 * @return monstre : le monstre qui sera cibl� par la tour
	 * @author BlackNichols
	 */
	public Monstre monstreACibler(Tourelle tour){
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
		return triMonstreSale(xmax,modifX,ymax,modifY);
	}
	/**
	 * Cette fonction permet d'optimiser les tests de mani�re un peu d�gueu
	 * @param xmax 0 ou Integer.max_value
	 * @param modifX -1, 0 ou 1
	 * @param ymax 0 ou Integer.max_value
	 * @param modifY -1, 0 ou 1
	 * @return le monstre � cibler
	 * @author un type qui n'assume pas
	 */
	private Monstre triMonstreSale(int xmax,int modifX,int ymax,int modifY){
		Monstre monstreCible = null;
		for(Monstre monstre : sesMonstres){
			if((monstre.getPosition().getx() * modifX >= xmax * modifX) && (monstre.getPosition().gety() * modifY >= ymax * modifY)){
				monstreCible = monstre;
				xmax = monstre.getPosition().getx();
				ymax = monstre.getPosition().gety();
			}
		}
		return monstreCible;
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
	
	public boolean vendreTourelle()
	{
		if(this.saTour != null)
		{
			this.saTour.detruire();	
			return true;
		}
		else {
			return false;
		}
	}
}