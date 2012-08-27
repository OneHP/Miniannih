package uk.co.onehp.game;

import java.util.List;

import uk.co.onehp.manufactory.Manufactory;
import uk.co.onehp.unit.UnitIdentifier;

import com.google.common.collect.Lists;
import com.jme3.app.SimpleApplication;
import com.jme3.app.StatsAppState;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;

public class Main extends SimpleApplication {

	private static final StatsAppState statsAppState = new StatsAppState();
	private final List<Displayable> gameObjects = Lists.newArrayList();

	public static void main(String[] args) {
		Main app = new Main();
		app.start();
	}

	public Main() {
		super(statsAppState);
	}

	@Override
	public void simpleInitApp() {

		Player player1 = new Player();
		Player player2 = new Player();

		Manufactory manufactory1 = new Manufactory(this, player1, new Vector3f(-20f, 30f, 0));
		Manufactory manufactory2 = new Manufactory(this, player2, new Vector3f(-20f, -30f, 0));
		manufactory1.changeTarget(manufactory2);
		manufactory2.changeTarget(manufactory1);

		manufactory1.changeOrder(UnitIdentifier.TANK);
		manufactory2.changeOrder(UnitIdentifier.TANK);

		this.gameObjects.add(manufactory1);
		this.gameObjects.add(manufactory2);

		setupWindow();
	}

	@Override
	public void simpleUpdate(float tpf) {
		for (Updateable updateable : this.gameObjects) {
			updateable.update(tpf);
		}
	}

	@Override
	public void simpleRender(RenderManager rm) {
		// TODO: add render code
	}

	public void addToGame(Displayable displayable) {
		this.gameObjects.add(displayable);
	}

	private void setupWindow() {
		this.getCamera().lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
		this.getCamera().setLocation(new Vector3f(0, 0, 100));
		this.mouseInput.setCursorVisible(true);
	}
}
