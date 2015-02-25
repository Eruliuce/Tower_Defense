package terrain;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import exceptions.CaseNonTrouveeException;
import monstres.Monstre;
import Outils.GestionChemin;
import Outils.GestionCheminDijkstra;
import Tourelle.ModeleTourelle;
import Tourelle.Tourelle;


public class Terrain implements Iterrain, TerrainAlgo {
	boolean t= true;
		
	private Array2d <Case> lstCase;
	private int hauteur;
	private int largeur;
	private Point posSpawn;
	private Point posBase;
	private int numSpawn;
	private int numBase;
	private List<Case> chemin; 

	private void initTerrain(int hauteur,int largeur){
		
		for (int i=0;i<hauteur;i++){
			lstCase.addRow(largeur);
			for (int j=0;j<largeur;j++){
				lstCase.add(i,j, new Case(i,j));
				if(i==2&&j==2) lstCase.get(i, j).settraversable(t);
			}
		}
		
	} 
	/**
	 * Création d'un terrain
	 * @param hauteur (vertical)
	 * @param largeur (horizontal)
	 */
	public Terrain(int hauteur ,int largeur, Point posSpawn, Point posBase) {
		this.hauteur = hauteur;
		this.largeur = largeur;
		lstCase=new Array2d<Case>(hauteur);
		initTerrain(largeur,hauteur);
		this.posBase = posBase;
		this.posSpawn = posSpawn;
		this.numBase = numBase;
		this.numSpawn = numSpawn;
		chemin = new LinkedList<Case>();
	}
	
	
	
	
	
	public boolean ameliorerTour(/*ModeleTourelle amelioration ,*/Coordonnees position  ) {
		return false;
	}

	
	public void creerTour(ModeleTourelle tour , Coordonnees<Integer,Integer> position ) {
		Case caseTour = lstCase.get(position.getx(), position.gety());
		caseTour.setSaTour(new Tourelle(tour, caseTour));
	}

	
	public boolean vendreTour(Coordonnees<Integer,Integer> position ) {
		Case caseVendreTourellle = lstCase.get(position.getx(), position.gety());
		boolean tourelleVendu = caseVendreTourellle.vendreTourelle();
		return tourelleVendu;
	}

	public Case getCase(int ligne, int colonne){
		return lstCase.get(ligne, colonne);
	}

	
	public Point getPosBase() {

		return posBase;
	}

	
	public Point getPosSpawn() {
	
		return posSpawn;
	}

	
	public int nbCases() {

		return largeur*hauteur;
	}

	
//	public int numCase(CaseAlgo caseQuelconque) throws CaseNonTrouveeException {
//		Integer num = null;
//		int i = 0;
//		boolean caseTrouvee = false;
//		while(i<largeur && !caseTrouvee){
//			int j =0;
//			while(j<hauteur && !caseTrouvee){
//				if(caseTrouvee = caseQuelconque.equals(lstCase.get(i, j)));
//				num = largeur*i+j;
//			}
//		}
//		if(num == null){
//			CaseNonTrouveeException e = new CaseNonTrouveeException();
//			throw e;
//		}
//		return (int)num;
//	} //obsolete


	public Collection<Integer> voisinsTraversables( int numCaseAlgo) {
//		Hashtable<String,Integer> positionCases = new Hashtable<String,Integer>();
//		positionCases.put("CaseEnHaut",1);
//		positionCases.put("CaseAGauche",2);
//		positionCases.put("CaseADroite",3);
//		positionCases.put("CaseEnBas",4);
		int x = abscisse(numCaseAlgo);
		int y = ordonnee(numCaseAlgo);
		Collection<Integer> voisines = new ArrayList<Integer>();
//		voisines.add(numCaseAlgo(x, y-1));
//		voisines.add(numCaseAlgo(x-1, y));
//		voisines.add(numCaseAlgo(x+1, y));
//		voisines.add(numCaseAlgo(x, y+1));
	// tester si c'est transversable boolean par ex et retourner null si c le cas
	// modifier peut etre comment je rempli voisines j'ai peut etre mis * largeur a la place de hauteur vue que tu ne voulé pas de coordonnées simple	 
//		 int colonne = x;
//		 int ligne = y;
//		 if ( !getCase(ligne,colonne).traversable) return null;// comportement a définir
//		 
//		 
//		 if(ligne==0){
//		if (colonne==0) {voisines.add(ligne*largeur+colonne+1); 
//					voisines.add((ligne+1)*largeur+colonne);
//					
//		
//		}
//		else if(colonne<largeur-1) {
//			voisines.add(ligne*largeur+colonne+1);
//			voisines.add((ligne+1)*largeur+colonne);   
//			voisines.add(ligne*largeur+(colonne-1));
//			}
//			else {
//				voisines.add((ligne+1)*largeur+colonne);   
//				voisines.add(ligne*largeur+(colonne-1));	
//			}
//		
//		}else if(ligne==hauteur-1){
//			if(colonne==0){
//				voisines.add(ligne*largeur+colonne+1); 
//				voisines.add((ligne-1)*largeur+colonne);	
//			}
//			
//			else if(colonne<largeur-1){
//				voisines.add(ligne*largeur+colonne+1);
//				voisines.add((ligne-1)*largeur+colonne);   
//				voisines.add(ligne*largeur+(colonne-1));
//				
//			} else { 
//				
//				voisines.add((ligne-1)*largeur+colonne);   
//				voisines.add(ligne*largeur+(colonne-1));
//				
//			}
//			
//			
//		} else if(colonne==0 && ligne<hauteur-1 && ligne>0){
//			
//			voisines.add(ligne+1*largeur+colonne);
//			voisines.add((ligne)*largeur+colonne+1);   
//			voisines.add(ligne-1*largeur+(colonne));
//			
//			
//		}else if(colonne==largeur-1 && ligne<hauteur-1 && ligne>0){
//			
//			voisines.add(ligne+1*largeur+colonne);
//			voisines.add((ligne)*largeur+colonne-1);   
//			voisines.add(ligne-1*largeur+(colonne));
//			
//			
//		}else {
//			
//			
//			voisines.add(ligne+1*largeur+colonne);
//			voisines.add((ligne-1)*largeur+colonne);   
//			voisines.add(ligne*largeur+(colonne+1));
//			voisines.add(ligne*largeur+(colonne-1));
//			
//			
//		}
		
		if(y!=0 && getCase(y-1, x).gettraversable()){voisines.add(numCaseAlgo(x, y-1));}
		if(x!=0 && getCase(y, x-1).gettraversable()){voisines.add(numCaseAlgo(x-1, y));}
		if(x!=largeur-1 && getCase(y, x+1).gettraversable()){voisines.add(numCaseAlgo(x+1, y));}
		if(y!=hauteur-1 && getCase(y+1, x).gettraversable()){voisines.add(numCaseAlgo(x, y+1));}
		
	
		 
		
	
		return voisines;
	}
	
	public int numCaseAlgo(int abscisse, int ordonnee){
		return ordonnee * largeur + abscisse;
	}
	
	public int abscisse(int numCaseAlgo){
		return numCaseAlgo % largeur;
	}

	public int ordonnee(int numCaseAlgo){
		return numCaseAlgo / largeur;
	}
	
	public int coutCaseNum(int indexOfMin) {
		return getCase(ordonnee(indexOfMin), abscisse(indexOfMin)).cout();
	}
	
	public void majCasesChemin(){
		for (int i=1;i <= chemin.size(); i++){			
			if (i == 1){
				chemin.get(i).setCaseCheminPrecedente(null);
				chemin.get(i).setCaseCheminSuivante(chemin.get(i+1));
			} else {
				if (i == chemin.size()){
					chemin.get(i).setCaseCheminPrecedente(chemin.get(i-1));
					chemin.get(i).setCaseCheminSuivante(null);
				} else {
					chemin.get(i).setCaseCheminPrecedente(chemin.get(i-1));
					chemin.get(i).setCaseCheminSuivante(chemin.get(i+1));
				}
			}
		}
	}	
	
	/** 
	 * @author Louvetia
	 * @param tour
	 * @return Monstre dans la zone de la tour et le plus pres de la base
	 */
	public Monstre selectMonstreAttaquer(Tourelle tour){
		Monstre monstreCible = null;
		int i = chemin.size() - 1; // Pas sur de l'indice le plus pres de la base mais il me semble quon avait dis 0->spawn dernier indice-> base
		boolean monstreTrouve = false;
		while(!monstreTrouve && i>=0)
		{
			if(tour.caseDansLaZone(chemin.get(i)))
			{
				monstreCible = chemin.get(i).monstreACibler(tour);
				monstreTrouve = (monstreCible != null);
			}
			i--;
		}
		return monstreCible;
	}
	
	public void resetChemin() throws CaseNonTrouveeException {
		GestionChemin gc = new GestionCheminDijkstra(this, 0, hauteur * largeur - 1, null);
		Collection<Integer> cheminInt = gc.chemin();
		chemin = new LinkedList<Case>();
		for(int numCase : cheminInt){
			chemin.add(this.getCase(numCase));
		}
	}
	private Case getCase(int numCase) {
		return getCase(ordonnee(numCase), abscisse(numCase));
	}
	@Override
	public int getNumBase() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getNumSpawn() {
		// TODO Auto-generated method stub
		return 0;
	}

}
