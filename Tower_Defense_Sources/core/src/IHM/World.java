package IHM;

import java.awt.Point;
import java.util.ArrayList;

import terrain.Terrain;
import monstres.ModeleMonstre;
import monstres.Monstre;
import Tourelle.ModeleTourelle;
import Tourelle.Tourelle;
import Jeu.Joueur;
import Outils.LecteurFichiers;

import com.badlogic.gdx.math.Vector2;

public class World {
	/* Composants du terrain */
	public final int LARGEUR = 30;
	public final int HAUTEUR = 20;
	public final float TAILLECASE = 1f;
	public final float TAILLEMONSTRE = 1.0f;
	public final float VITESSEMONSTRE = 1.0f;
	public ArrayList<Monstre> mesMonstres;
	public ArrayList<Tourelle> mesTourelles;
	public Terrain monTerrain;
	ArrayList<ModeleMonstre> listeModeleMonstres;
	ArrayList<ModeleTourelle> listeModeleTourelles;
	public Joueur monJoueur;
	
	public World() {
        createDemoWorld();
    }
	
	private void createDemoWorld() {
		monJoueur = new Joueur("Cyril");
		listeModeleMonstres = LecteurFichiers.getListeModelesMonstres("..\\core\\FichiersConf\\Monstres.conf");
		listeModeleTourelles = LecteurFichiers.getListeModelesTourelles("..\\core\\FichiersConf\\Tourelles.conf");
		monTerrain = new Terrain(HAUTEUR, LARGEUR, new Point(1,1),new Point(2,2));
		mesMonstres = new ArrayList<Monstre>();
		mesTourelles = new ArrayList<Tourelle>();
	}

	public Terrain getTerrain() {
		return monTerrain;
	}

	public void verifierMort(Monstre monstre) {
		if (monstre.getPv() <= 0){
			mesMonstres.remove(monstre);
		}
		
	}
}
