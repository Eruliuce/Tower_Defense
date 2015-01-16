package Outils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import terrain.TerrainAlgo;
import exceptions.CaseNonTrouveeException;


public class GestionCheminDijkstra implements GestionChemin{
	private List<ModeleCase> lstCases;
	TerrainAlgo terrain;
	int numCaseDepart;
	int numCaseArrivee;
	
	public GestionCheminDijkstra(TerrainAlgo terrain, int numCaseDepart, int numCaseArrivee, effetDeplacementMonstreAlgo effet) {
		super();
		this.terrain = terrain;
		this.numCaseDepart = numCaseDepart;
		this.numCaseArrivee = numCaseArrivee;
		lstCases = new ArrayList<ModeleCase>();
		for(int i = 0;i<terrain.nbCases();i++){
			lstCases.add(new ModeleCase());
		}
	}
	@Override
	public Collection<Integer> chemin() throws CaseNonTrouveeException {
		
		lstCases.set(numCaseDepart,new ModeleCase(0,true));
		int numCaseActuelle = numCaseDepart;
		while(numCaseActuelle!=numCaseArrivee && numCaseActuelle != -1){
			Collection<Integer> voisinsActuels = terrain.voisinsTraversables(numCaseActuelle);
			for(Integer voisin : voisinsActuels){
				int nouvDistance = lstCases.get(numCaseActuelle).distance + terrain.caseNum(voisin).cout();
				if((lstCases.get(voisin).distance) > nouvDistance){
					//à vérifier
					ModeleCase modifCase = lstCases.get(voisin);
					modifCase.distance = nouvDistance;
					modifCase.indCasePrec = numCaseActuelle;
				}
			}
			ModeleCase modifCase = lstCases.get(numCaseActuelle);
			modifCase.parcouru = true;
			numCaseActuelle = getIndexOfMin(lstCases);
		}
		Collection<Integer> chemin = new LinkedList<Integer>();
		numCaseActuelle = numCaseArrivee;
		
		while(numCaseActuelle != numCaseDepart){
			chemin.add((Integer)numCaseActuelle);
		}
		return chemin;
	}
	
	private int getIndexOfMin(List<ModeleCase> data) {
	    int index = -1;
	    int min = Integer.MAX_VALUE;
	    for (int i=0;i<data.size();i++) {
	    	ModeleCase mCase = data.get(i);
	        if (!mCase.parcouru && mCase.distance < min) {
	            min = mCase.distance;
	            index = i;
	        }
	    }
	    return index;
	}
}
