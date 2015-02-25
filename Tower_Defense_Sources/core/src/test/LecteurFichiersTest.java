package test;

import static org.junit.Assert.*;

import java.security.Principal;
import java.util.ArrayList;

import monstres.ModeleMonstre;

import org.junit.Test;

import Outils.LecteurFichiers;
import Tourelle.ModeleTourelle;

public class LecteurFichiersTest
{
	@Test
	public void testLectureConstantes()
	{
		assertEquals(100, LecteurFichiers.getInt("FichiersConfTest\\Constantes.conf", "vieBaseJoueur"));
	}
	
	@Test
	public void testLectureMonstres()
	{
		ArrayList<ModeleMonstre> listeMonstres = LecteurFichiers.getListeModelesMonstres("FichiersConfTest\\Monstres.conf");
		assertEquals(5, listeMonstres.size());
		assertEquals(2, (int)listeMonstres.get(0).getAttaque());
		assertEquals(10, (int)listeMonstres.get(3).getRecompense());
		assertEquals("Monstre resistant", listeMonstres.get(4).getName());
	}
	
	@Test
	public void testLectureTourelles()
	{
		ArrayList<ModeleTourelle> listeTourelle = LecteurFichiers.getListeModelesTourelles("FichiersConfTest\\Tourelles.conf");
		assertEquals(5, listeTourelle.size());
		assertEquals(2, (int)listeTourelle.get(0).getVitesseAttaque());
		assertEquals("Tourelle anti-aerienne", listeTourelle.get(4).getName());
		assertEquals(true, listeTourelle.get(4).isAntiAerien());
		assertEquals(false, listeTourelle.get(4).isSeeInvisible());
		assertEquals(false, listeTourelle.get(3).isAntiAerien());
		assertEquals(true, listeTourelle.get(3).isSeeInvisible());
	}
}
