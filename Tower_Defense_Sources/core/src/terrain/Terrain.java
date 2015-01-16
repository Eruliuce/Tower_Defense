package terrain;
import java.util.ArrayList;
import java.util.Collection;

import terrain2.Coordonnees;
import terrain2.TerrainAlgo;
import exceptions.CaseNonTrouveeException;
import Outils.Array2d;


public class Terrain implements Iterrain, TerrainAlgo {
		
	private Array2d <Case> lstCase;
	private int hauteur;
	private int largeur;
	
	private void initTerrain(int hauteur,int largeur){
		
		for (int i=0;i<hauteur;i++){
			lstCase.addRow();
			System.out.println(i);
			
			for (int j=0;j<largeur;j++){
				System.out.println(j);
				lstCase.add(i, new Case(i,j));
				
			}
		}
		
	} 
	
	public Terrain(int largeur ,int hauteur) {
	
		lstCase=new Array2d<Case>();
		initTerrain(largeur,hauteur);
	//lstCase.add(0, 0, new Case(0,0));
		
			
			
		
		
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
	
	public Case getCase(int largeur, int hauteur){
		return lstCase.get(largeur, hauteur);
	}
	
	
	public static void main(String[] args){
	//Array2d<Case>	lstCase=new Array2d<Case>();
//	lstCase.addRow();
//	lstCase.add(0, 0, new Case(0,0));
//	lstCase.addRow();
//	lstCase.add(1,0, new Case(0,0));
		Terrain t= new Terrain(2,2);
		
		
		
	}

	@Override
	public CaseAlgo getBase() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CaseAlgo getSpawn() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nbCases() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
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

	@Override
	public Collection<CaseAlgo> voisinsTraversables(CaseAlgo caseActuelle) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CaseAlgo caseNum(int indexOfMin) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
