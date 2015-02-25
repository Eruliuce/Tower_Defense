package IHM;

import java.util.ArrayList;

import com.badlogic.gdx.math.Vector2;

public class World {
	/* Composants du terrain */
	public static final int LARGEUR = 16;
	public static final int HAUTEUR = 9;
	ArrayList<Block> blocks = new ArrayList<Block>();
	
	
	public World() {
        createDemoWorld();
    }
	
	private void createDemoWorld() {
		for(int i = 0; i < LARGEUR; i++){
			for(int j = 0; j < HAUTEUR; j++){
				 blocks.add(new Block(new Vector2(i, j)));
				 
				 
				 
			}
		}
		
	}

	public ArrayList<Block> getBlocks() {
        return blocks;
    }
}
