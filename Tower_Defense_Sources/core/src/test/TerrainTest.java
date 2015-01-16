package test;

import static org.junit.Assert.*;
import terrain.Terrain;

import org.junit.Test;

import exceptions.CaseNonTrouveeException;

public class TerrainTest {

	@Test
	public void testNumCase() {
		Terrain t = new Terrain(10,10);
		int numCase;
		try {
			numCase = t.numCase(t.getCase(4,5));
			assertEquals(45, numCase);
			numCase = t.numCase(t.getCase(8,9));
			assertEquals(89, numCase);
			numCase = t.numCase(t.getCase(0,0));
			assertEquals(0, numCase);
			numCase = t.numCase(t.getCase(4,5));
			assertNotEquals(80, numCase);
			numCase = t.numCase(t.getCase(4,5));
			assertEquals(45, numCase);
		} catch (CaseNonTrouveeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
