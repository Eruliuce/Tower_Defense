package terrain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.List;


public class Terrain implements Iterrain, TerrainAlgo {
	boolean t= true;
		
	private Array2d <Case> lstCase;
	private int hauteur;
	private int largeur;
	
	private void initTerrain(int hauteur,int largeur){
		
		for (int i=0;i<hauteur;i++){
			lstCase.addRow();
			
			
			for (int j=0;j<largeur;j++){
				
				System.out.println(i);
				System.out.println(j);
				lstCase.add(i,j, new Case(i,j));
				if(i==2&&j==2) lstCase.get(i, j).settraversable(t);
				
			}
		}
		
	} 
	
	public Terrain(int hauteur ,int largeur) {
	
		lstCase=new Array2d<Case>();
		initTerrain(largeur,hauteur);
 
		
	}
	
	
	
	
	
	public boolean ameliorerTour(/*ModeleTourelle amelioration ,*/Coordonnees position  ) {
		
		return false;
	}

	
	public boolean creerTour(/*ModeleTourelle tour , */Coordonnees position ) {
		
		return false;
	}

	
	public boolean vendreTour(Coordonnees position ) {
		
		return false;
	}
	
	public Case getCase(int ligne, int colonne){
		return lstCase.get(ligne, colonne);
	}
	
	
	public static void main(String[] args){
	//Array2d<Case>	lstCase=new Array2d<Case>();
//	lstCase.addRow();
//	lstCase.add(0, 0, new Case(0,0));
//	lstCase.addRow();
//	lstCase.add(1,0, new Case(0,0));
		Terrain t= new Terrain(4,4);
		
		
		
	}

	
	public CaseAlgo getBase() {

		return null;
	}

	
	public CaseAlgo getSpawn() {
	
		return null;
	}

	
	public int nbCases() {

		return 0;
	}

	
	public int numCase(CaseAlgo caseQuelconque) throws CaseNonTrouveeException {
		Integer num = null;
		int i = 0;
		boolean caseTrouvee = false;
		while(i<largeur && !caseTrouvee){
			int j =0;
			while(j<hauteur && !caseTrouvee){
				if(caseTrouvee = caseQuelconque.equals(lstCase.get(i, j)));
				num = largeur*i+j;
			}
		}
		if(num == null){
			CaseNonTrouveeException e = new CaseNonTrouveeException();
			throw e;
		}
		return (int)num;
	}


	public Collection<Integer> voisinsTraversables( int numCaseAlgo) {
		Hashtable<String,Integer> positionCases = new Hashtable<String,Integer>();
		positionCases.put("CaseEnHaut",1);
		positionCases.put("CaseAGauche",2);
		positionCases.put("CaseADroite",3);
		positionCases.put("CaseEnBas",4);
		int x = abscisse(numCaseAlgo);
		int y = ordonnee(numCaseAlgo);
		List<Integer> voisines = new ArrayList<Integer>();
		voisines.add(numCaseAlgo(x, y-1));
		voisines.add(numCaseAlgo(x-1, y));
		voisines.add(numCaseAlgo(x+1, y));
		voisines.add(numCaseAlgo(x, y+1));
	// tester si c'est transversable boolean par ex et retourner null si c le cas
	// modifier peut etre comment je rempli voisines j'ai peut etre mis * largeur a la place de hauteur vue que tu ne voul� pas de coordonn�es simple	 
		 
//		 if ( !getCase(ligne,colonne).traversable) return null;// comportement a d�finir
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
		
		if(y!=0 && getCase(y-1, x).gettraversable()){voisines.add(numCaseAlgo(x-1, y));}
		if(x!=0 && getCase(y, x-1).gettraversable()){voisines.add(numCaseAlgo(x, y-1));}
		if(x!=largeur-1){voisines.remove(voisines.get(positionCases.get("CaseADroite")));}
		if(y!=hauteur-1){voisines.remove(voisines.get(positionCases.get("CaseEnBas")));}
		 
		//A faire : enlever les cases nontraversables et v�rifier que l'ordre de la liste ne change pas quand on supprime un �l�ment. 
		
	
		 
		
	
		return voisines;
	}
	
	public int numCaseAlgo(int abscisse, int ordonnee){
		return abscisse * largeur + ordonnee;
	}
	
	public int abscisse(int numCaseAlgo){
		return numCaseAlgo % largeur;
	}

	public int ordonnee(int numCaseAlgo){
		return numCaseAlgo / hauteur;
	}
	
	public CaseAlgo caseNum(int indexOfMin) {
	
		return null;
	}

	

}
