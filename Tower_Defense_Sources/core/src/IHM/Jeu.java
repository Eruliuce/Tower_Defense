package IHM;

import com.badlogic.gdx.Game;

public class Jeu extends Game {
	static final float BLOCSIZE = 0.5f; // Demi unit�
	
	
	public void create () {
		setScreen(new GameScreen());
	}
}
