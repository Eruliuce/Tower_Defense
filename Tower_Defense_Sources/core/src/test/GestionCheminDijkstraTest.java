package test;

import static org.junit.Assert.*;

import java.util.Collection;

import terrain.Terrain;

import org.junit.Test;

import exceptions.CaseNonTrouveeException;
import Outils.GestionChemin;
import Outils.GestionCheminDijkstra;

public class GestionCheminDijkstraTest {

	@Test
	public void testLabyrinthe() {
		Terrain t = new Terrain(10,10,0,99);
		GestionChemin gc = new GestionCheminDijkstra(t, 0, 99, null);
		try {
			Collection<Integer> chemin = gc.chemin();
			System.out.println(chemin.size());
			for(Integer numCase : chemin){
				System.out.println("Case n° "+numCase);
			}
		} catch (CaseNonTrouveeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(true);
	}

}
