package test;

import static org.junit.Assert.*;

import java.util.Collection;

import terrain.Terrain;

import org.junit.Test;

import exceptions.CaseNonTrouveeException;

public class TerrainTest {

	@Test
	public void testConversionNumCase() {
		Terrain t = new Terrain(10,10,0,0);
		
		assertEquals(45, t.numCaseAlgo(5, 4));
		assertEquals(84, t.numCaseAlgo(4, 8));
		assertEquals(62, t.numCaseAlgo(2, 6));
		assertEquals(45, t.numCaseAlgo(5, 4));
		
		assertEquals(5, t.abscisse(45));
		assertEquals(4, t.ordonnee(45));
		assertEquals(8, t.ordonnee(84));
		assertEquals(4, t.abscisse(84));
		
		t = new Terrain(7,4,0,0);
		
		assertEquals(27, t.numCaseAlgo(3, 6));
		assertEquals(18, t.numCaseAlgo(2, 4));
		assertEquals(24, t.numCaseAlgo(0, 6));
		assertEquals(21, t.numCaseAlgo(1, 5));
		
		assertEquals(3, t.abscisse(27));
		assertEquals(6, t.ordonnee(27));
		assertEquals(6, t.ordonnee(24));
		assertEquals(0, t.abscisse(24));
		assertEquals(1, t.abscisse(21));
		
	}
	
	@Test
	public void testTraversabiliteCases(){
		Terrain t = new Terrain(10,10,0,0);
		t.getCase(6, 4).settraversable(false);
		assertTrue(!t.getCase(6, 4).gettraversable());
	}
	
	@Test
	public void testVoisins(){
		Terrain t = new Terrain(10,10,0,0);
		Collection<Integer> voisins = t.voisinsTraversables(24);
		assertTrue(voisins.contains(23));
		assertTrue(voisins.contains(25));
		assertTrue(voisins.contains(14));
		assertTrue(voisins.contains(34));
		assertFalse(voisins.contains(24));
		voisins = t.voisinsTraversables(0);
		assertTrue(voisins.contains(10));
		assertTrue(voisins.contains(1));
		assertFalse(voisins.contains(-1));
		assertFalse(voisins.contains(-10));
	}

}
