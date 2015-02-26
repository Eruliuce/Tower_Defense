package IHM;

import java.awt.Point;
import java.util.ArrayList;

import terrain.Terrain;
import monstres.ModeleMonstre;
import monstres.Monstre;
import Tourelle.Tourelle;
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
	
	
	public World() {
        createDemoWorld();
    }
	
	private void createDemoWorld() {
		monTerrain = new Terrain(HAUTEUR, LARGEUR, new Point(1,1),new Point(2,2));
		mesMonstres = new ArrayList<Monstre>();
		ArrayList<ModeleMonstre> listeMonstres = LecteurFichiers.getListeModelesMonstres("..\\core\\FichiersConf\\Monstres.conf");
		for(int i = 5 ; i < 10; i++){
			mesMonstres.add(new Monstre(i,i, listeMonstres.get(0)));
		}
		mesTourelles = new ArrayList<Tourelle>();
	}
	
}
