package Outils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
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
		lstCases = new ArrayList<ModeleCase>(terrain.nbCases());
		for(int i = 0;i<terrain.nbCases();i++){
			lstCases.add(new ModeleCase(i));
		}
	}
	@Override
	public Collection<Integer> chemin() throws CaseNonTrouveeException {
		
		lstCases.set(numCaseDepart,new ModeleCase(0,false));
		int numCaseActuelle = numCaseDepart;
		while((numCaseActuelle != -1) && (lstCases.get(numCaseActuelle).distance != Integer.MAX_VALUE)){
			//System.out.println("entrée while");
			Collection<Integer> voisinsActuels = terrain.voisinsTraversables(numCaseActuelle);
			for(Integer voisin : voisinsActuels){
				//System.out.println(lstCases.get(0));
				int nouvDistance = lstCases.get(numCaseActuelle).distance + terrain.coutCaseNum(voisin);
				if((lstCases.get(voisin).distance) > nouvDistance){
					ModeleCase modifCase = lstCases.get(voisin);
					modifCase.distance = nouvDistance;
					modifCase.indCasePrec = numCaseActuelle;
				}
			}
			ModeleCase caseActuelle = lstCases.get(numCaseActuelle);
			caseActuelle.parcouru = true;
			numCaseActuelle = getIndexOfMin(lstCases);
		}
		List<Integer> chemin = new LinkedList<Integer>();
		numCaseActuelle = numCaseArrivee;
		//System.out.println("sortie boucles");
		while(numCaseActuelle != numCaseDepart){
			chemin.add(numCaseActuelle);
			numCaseActuelle = lstCases.get(numCaseActuelle).indCasePrec;
		}
		chemin.add(numCaseActuelle);
		Collections.reverse(chemin);
		return chemin;
	}
	
//	private boolean caseRestantes(List<ModeleCase> lstCases) {
//		boolean casesRestantes = false;
//		Iterator<ModeleCase> iterator = lstCases.iterator();
//		while(iterator.hasNext() && !casesRestantes){
//			ModeleCase caseM = iterator.next();
//			casesRestantes = casesRestantes || (!caseM.parcouru && caseM.distance != Integer.MAX_VALUE);
//		}
//		return casesRestantes;
//	}
	
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
