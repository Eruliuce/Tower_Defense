package Outils;

import GestionChemin;
import ModeleCase;
import effetDeplacementMonstreAlgo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import terrain2.CaseAlgo;
import terrain2.CaseNonTrouveeException;
import terrain2.TerrainAlgo;



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
	public Collection<CaseAlgo> chemin() throws CaseNonTrouveeException {
		
		lstCases.set(numCaseDepart,new ModeleCase(0,true));
		int caseActuelle = numCaseDepart;
		while(caseActuelle!=numCaseArrivee && caseActuelle != -1){
			Collection<Integer> voisinsActuels = terrain.voisinsTraversables(caseActuelle);
			for(Integer voisin : voisinsActuels){
				int nouvDistance = lstCases.get(caseActuelle).distance + terrain.caseNum(voisin).cout();
				if((lstCases.get(voisin).distance) > nouvDistance){
					//à vérifier
					ModeleCase modifCase = lstCases.get(voisin);
					modifCase.distance = nouvDistance;
					modifCase.indCasePrec = caseActuelle;
				}
			}
			ModeleCase modifCase = lstCases.get(caseActuelle);
			modifCase.parcouru = true;
			caseActuelle = getIndexOfMin(lstCases);
		}
		Collection<Integer> chemin = new LinkedList<Integer>();
		chemin.add(lstCases.get(numCaseArrivee))
		
		return chemin;
	}
	
	private int numCase(CaseAlgo caseNumerotee) throws CaseNonTrouveeException{
		return terrain.numCase(caseNumerotee);
	}
	
	private int max(List<ModeleCase> lstCase){
		int max = Integer.MIN_VALUE;
		for(ModeleCase mCase : lstCase){
			if(mCase.distance>max){
				max = mCase.distance;
			}
		}
		return max;
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
