package IHM;
import listeners.EcouteurInputs;
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
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;

public class WorldRenderer {
	
	private World world;
    private OrthographicCamera cam;
    private SpriteBatch spriteBatch;
    private int width;
    private int height;
    public float delay;
    private float ppuX; // pixels par unité pour X
    private float ppuY; // pixels par unité pour Y
    private EcouteurInputs ecouteurInputs;
    
    public float getPpuX() {
		return ppuX;
	}

	public float getPpuY() {
		return ppuY;
	}


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
        ecouteurInputs = new EcouteurInputs(this);
        this.cam = new OrthographicCamera(world.LARGEUR, world.HAUTEUR);
        this.cam.position.set(world.HAUTEUR, world.LARGEUR,0);
        this.cam.update();
        spriteBatch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setColor(Color.BLUE);
        loadTextures();
        delay = 0;
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
        
        // On bouge le monstre chaque seconde
        delay += Gdx.graphics.getDeltaTime();
        if(delay >= 1.0){
        	deplacerMonstresTemp();
        	delay = 0;
        }
    }
    
	protected void deplacerMonstresTemp() {
		for(Monstre monstre : world.mesMonstres){
			monstre.getPosition().setx((int) (monstre.getPosition().getx() + world.VITESSEMONSTRE));
		}
		
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

	public World getWorld()
	{
		return world;
	}
	
	private void deplacerMonstres(){
		for(Monstre monstre : world.mesMonstres){
			monstre.deplacer();
		}
	}
}
