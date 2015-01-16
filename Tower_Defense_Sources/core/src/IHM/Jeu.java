package IHM;

import com.badlogic.gdx.Game;

public class Jeu extends Game {
	static final float BLOCSIZE = 0.5f; // Demi unité
	
	
	public void create () {
		setScreen(new GameScreen());
	}
}
