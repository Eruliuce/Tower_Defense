package listeners;

import IHM.*;

import com.badlogic.gdx.InputProcessor;

public class EcouteurInputs implements InputProcessor
{
	WorldRenderer worldRenderer;
	
	
	public EcouteurInputs(WorldRenderer worldRenderer)
	{
		this.worldRenderer = worldRenderer;
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
				return false;
	}

	@Override
	public boolean keyUp(int keycode){
		// TODO Auto-generated method stub
				return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button)
	{
		System.out.println((int)(screenX / (worldRenderer.getPpuX())));
		System.out.println((int)(screenY / (worldRenderer.getPpuY())));
		if(worldRenderer.getWorld().getTerrain().getCase((int)(screenX / worldRenderer.getPpuX()), (int)(screenY / worldRenderer.getPpuY())).getSaTour() != null);
			System.out.println("test");
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}

}
