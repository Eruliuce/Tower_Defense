package test;

import static org.junit.Assert.*;

import java.security.Principal;
import java.util.ArrayList;

import monstres.ModeleMonstre;

import org.junit.Test;

import Outils.LecteurFichiers;

public class LecteurFichiersTest
{
	@Test
	public void testLectureConstantes()
	{
		assertEquals(100, LecteurFichiers.getInt("..\\desktop\\FichiersConf\\Constantes.conf", "vieBaseJoueur"));
	}
	
	@Test
	public void testLectureMonstres()
	{
		ArrayList<ModeleMonstre> listeMonstres = LecteurFichiers.getListeModelesMonstres("..\\desktop\\FichiersConf\\Monstres.conf");
		assertEquals(5, listeMonstres.size());
		assertEquals(2, (int)listeMonstres.get(0).getAttaque());
		assertEquals(10, (int)listeMonstres.get(3).getRecompense());
		assertEquals("Monstre resistant", listeMonstres.get(4).getName());
	}
}
