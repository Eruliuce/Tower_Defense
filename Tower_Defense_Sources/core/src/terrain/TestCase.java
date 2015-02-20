package terrain;

import org.junit.Assert;
import org.junit.Test;

import monstres.Monstre;



public class TestCase {

	@Test
	public void test() {
		Case casePrec = new Case(1,0);
		Case caseTest = new Case(2,0);
		Case caseSuiv = new Case(3,0);
		caseTest.setCaseCheminPrecedente(casePrec);
		caseTest.setCaseCheminSuivante(caseSuiv);
		caseTest.ajoutMonstre(new Monstre(10,5));
		caseTest.ajoutMonstre(new Monstre(15,5));
		caseTest.ajoutMonstre(new Monstre(19,5));
		caseTest.ajoutMonstre(new Monstre(12,5));
		caseTest.ajoutMonstre(new Monstre(14,5));
		
		caseTest.ajoutMonstre(new Monstre(17,5));
		
		Monstre cible = caseTest.monstreACibler(null);
		System.out.println(cible.getPosition().getx());
		Assert.assertEquals((int)cible.getPosition().getx(), 19);
		System.out.println(cible.getPosition().gety());
		Assert.assertEquals((int)cible.getPosition().gety(), 5);
//		casePrec = new Case(1,2);
//		caseTest.setCaseCheminPrecedente(casePrec);
//		caseTest.setCaseCheminSuivante(caseSuiv);
//		caseTest.ajoutMonstre(new Monstre(5,10));
//		caseTest.ajoutMonstre(new Monstre(5,5));
//		caseTest.ajoutMonstre(new Monstre(5,5));
//		caseTest.ajoutMonstre(new Monstre(5,12));
//		caseTest.ajoutMonstre(new Monstre(5,14));
//		caseTest.ajoutMonstre(new Monstre(5,17));
//		cible = caseTest.monstreACibler(null);
//		Assert.assertEquals((int)cible.getPosition().getx(), 5);
//		//System.out.println(cible.getPosition().gety());
//		Assert.assertEquals((int)cible.getPosition().gety(), 19);
	}

}
