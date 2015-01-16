package IHM;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Rectangle;

public class WorldRenderer {
	
	private static final float CAMERA_WIDTH = 10f;
	private static final float CAMERA_HEIGHT = 7f;
	
	private World world;
    private OrthographicCamera cam;
    private SpriteBatch spriteBatch;
    private boolean debug = false;
    private int width;
    private int height;
    private float ppuX; // pixels par unit� pour X
    private float ppuY; // pixels par unit� pour Y
    
    /**
     * ShapeRenderer permet de dessiner facilement les
     * formes de base
     * Sera utilis� pour des fins de d�bogage
     * **/
    ShapeRenderer debugRenderer = new ShapeRenderer();
 
    /** Textures **/
    Texture blockTexture;
    
    
    
    
    /** Constructeur **/
    public WorldRenderer(World world, boolean debug) {
        this.world = world;
        this.cam = new OrthographicCamera(CAMERA_WIDTH, CAMERA_HEIGHT);
        this.cam.position.set(CAMERA_WIDTH / 2f, CAMERA_HEIGHT / 2f, 0);
        this.cam.update();
        this.debug = debug;
        spriteBatch = new SpriteBatch();
        loadTextures();
    }
    
    /** DPermet de faire un resize sur l'�cran **/
    public void setSize (int w, int h) {
        this.width = w;
        this.height = h;
        ppuX = (float)width / CAMERA_WIDTH;
        ppuY = (float)height / CAMERA_HEIGHT;
    }
    
    /** Charge les textures en m�moire **/
    private void loadTextures() {
    	blockTexture = new Texture(Gdx.files.internal("images/block.png"));
    }
 
    
    /** Boucle principale appelant les diff�rentes m�thodes n�cessaires **/
    public void render() {
        spriteBatch.begin();
            drawBlocks();
        spriteBatch.end();
        if (debug)
            drawDebug();
    }
    
    /** Dessine les blocs de fa�on normale ou avec le mode debug (avec des formes pour debug) **/
    private void drawBlocks() {
        for (Block block : world.getBlocks()) {
            spriteBatch.draw(
                blockTexture,
                block.getPosition().x * ppuX,
                block.getPosition().y * ppuY,
                Block.SIZE * ppuX,
                Block.SIZE * ppuY);
        }
    }
    
    private void drawDebug() {
        // D�marrage du renderer
        debugRenderer.setProjectionMatrix(cam.combined);
        debugRenderer.begin(ShapeType.Line);
 
        // render blocks
        for (Block block : world.getBlocks()) {
            Rectangle rect = block.getBounds();
            float x1 = block.getPosition().x + rect.x;
            float y1 = block.getPosition().y + rect.y;
            debugRenderer.setColor(new Color(1, 0, 0, 1));
            debugRenderer.rect(x1, y1, rect.width, rect.height);
        }
        debugRenderer.end();
    }
    
}
