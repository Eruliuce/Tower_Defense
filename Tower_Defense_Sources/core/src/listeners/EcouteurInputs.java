package listeners;

import IHM.World;

import com.badlogic.gdx.InputProcessor;

public class EcouteurInputs implements InputProcessor
{
	World world;
	
	
	public EcouteurInputs(World world)
	{
		this.world = world;
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
		System.out.println((int)(screenX / (world.getWorldRenderer().getPpuX())));
		System.out.println((int)(screenY / (world.getWorldRenderer().getPpuY())));
		if(world.getTerrain().getCase((int)(screenX / (world.getWorldRenderer().getPpuX())), (int)(screenY / (world.getWorldRenderer().getPpuY()))).getSaTour() != null);
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
