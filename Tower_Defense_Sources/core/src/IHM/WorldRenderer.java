package IHM;
import monstres.Monstre;
import Tourelle.Tourelle;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class WorldRenderer {
	
	private World world;
    private OrthographicCamera cam;
    private SpriteBatch spriteBatch;
    private int width;
    private int height;
    private float ppuX; // pixels par unité pour X
    private float ppuY; // pixels par unité pour Y
    
    /**
     * ShapeRenderer permet de dessiner facilement les
     * formes de base
     * Sera utilisé pour des fins de débogage
     * **/
    ShapeRenderer shapeRenderer;
 
    /** Textures **/
    Texture blockTexture;
    Texture monsterTexture;
    Texture towerTexture;
    
    /** Constructeur **/
    public WorldRenderer(World world) {
        this.world = world;
        this.cam = new OrthographicCamera(world.LARGEUR, world.HAUTEUR);
        this.cam.position.set(world.HAUTEUR, world.LARGEUR,0);
        this.cam.update();
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(Color.BLUE);
        loadTextures();
    }
    
    /** DPermet de faire un resize sur l'écran **/
    public void setSize (int w, int h) {
        this.width = w;
        this.height = h;
        ppuX = (float)width / world.LARGEUR;
        ppuY = (float)height / world.HAUTEUR;
    }
    
    /** Charge les textures en mémoire **/
    private void loadTextures() {
    	blockTexture = new Texture(Gdx.files.internal("images/grass.png"));
    	monsterTexture = new Texture(Gdx.files.internal("images/monster.png"));
    	towerTexture = new Texture(Gdx.files.internal("images/tourelle.png"));
    }
 
    
    /** Boucle principale appelant les différentes méthodes nécessaires **/
    public void render() {
        spriteBatch.begin();
        shapeRenderer.begin(ShapeType.Filled);
            drawTerrain();
            drawMonstres();
            drawTourelles();
        shapeRenderer.end();
        spriteBatch.end();
        //deplacerMonstres();
    }
	private void drawTourelles() {
		for(Tourelle tourelle : world.mesTourelles){
			spriteBatch.draw(towerTexture,
        			tourelle.getSaCase().getpos().getx()*ppuX,
        			tourelle.getSaCase().getpos().gety()*ppuY,
        			world.TAILLECASE*ppuX,
        			world.TAILLECASE*ppuY);			
		}
	}

    private void drawTerrain() {
        for(int i = 0; i < world.LARGEUR; i++){
        	for(int j = 0; j < world.HAUTEUR; j++){
        		spriteBatch.draw(blockTexture,
        			world.monTerrain.getCase(i, j).getpos().getx()*ppuX,
        			world.monTerrain.getCase(i, j).getpos().gety()*ppuY,
        			world.TAILLECASE*ppuX,
        			world.TAILLECASE*ppuY);
        	}
        }
    }  
    	

	private void drawMonstres() {
		for(Monstre monstre : world.mesMonstres){
			spriteBatch.draw(monsterTexture,
        			monstre.getPosition().getx()*ppuX,
        			monstre.getPosition().gety()*ppuY,
        			world.TAILLEMONSTRE*ppuX,
        			world.TAILLEMONSTRE*ppuY);	
		}	
	}
}
