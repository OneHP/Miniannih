package uk.co.onehp.game;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import uk.co.onehp.manufactory.Manufactory;
import uk.co.onehp.manufactory.workshop.BasicWorkshop;
import uk.co.onehp.unit.UnitIdentifier;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.jme3.app.SimpleApplication;
import com.jme3.app.StatsAppState;
import com.jme3.math.Vector3f;
import com.jme3.renderer.RenderManager;

public class Main extends SimpleApplication {

	private static final StatsAppState statsAppState = new StatsAppState();
	private final List<Displayable> gameObjects = Lists.newArrayList();
	private final List<Displayable> gameObjectsQueue = Lists.newArrayList();

	public static void main(String[] args) {
		Main app = new Main();
		app.start();
	}

	public Main() {
		super(statsAppState);
	}

	@Override
	public void simpleInitApp() {

		setupWindow();
		setupGame();
	}

	@Override
	public void simpleUpdate(float tpf) {
		for (Updateable updateable : this.gameObjects) {
			updateable.update(tpf);
		}
		this.gameObjects.addAll(this.gameObjectsQueue);
		this.gameObjectsQueue.clear();
	}

	@Override
	public void simpleRender(RenderManager rm) {
		// TODO: add render code
	}

	public void addToGame(Displayable displayable) {
		this.gameObjectsQueue.add(displayable);
	}

	/**
	 * Returns objects from the game that are in the area surrounding a central
	 * point. Ordered by distance from the centre, ascending.
	 * 
	 * @param centre
	 * @param radius
	 * @return
	 */
	public List<Displayable> getGameObjects(Vector3f centre, float radius) {
		Map<Displayable, Float> objectsInArea = Maps.newHashMap();
		for (Displayable object : this.gameObjects) {
			if (!(object instanceof Manufactory)) {
				float distance = object.getGeometry().getLocalTranslation().distance(centre);
				if (distance < radius) {
					objectsInArea.put(object, distance);
				}
			}
		}

		List<Entry<Displayable, Float>> entries = Lists.newArrayList(objectsInArea.entrySet().iterator());

		Collections.sort(entries, new Comparator<Entry<Displayable, Float>>() {
			@Override
			public int compare(Entry<Displayable, Float> arg0, Entry<Displayable, Float> arg1) {
				return arg1.getValue().compareTo(arg1.getValue());
			}
		});

		return Lists.transform(entries, new Function<Entry<Displayable, Float>, Displayable>() {
			@Override
			public Displayable apply(Entry<Displayable, Float> input) {
				return input.getKey();
			}
		});
	}

	private void setupWindow() {
		this.getCamera().lookAt(Vector3f.ZERO, Vector3f.UNIT_Y);
		this.getCamera().setLocation(new Vector3f(0, 0, 100));
		this.mouseInput.setCursorVisible(true);
	}

	private void setupGame() {
		Player player1 = new Player();
		Player player2 = new Player();

		Manufactory manufactory1 = new Manufactory(this, player1, new Vector3f(-20f, 30f, 0));
		Manufactory manufactory2 = new Manufactory(this, player1, new Vector3f(0f, 30f, 0));
		Manufactory manufactory3 = new Manufactory(this, player1, new Vector3f(20f, 30f, 0));
		Manufactory manufactory4 = new Manufactory(this, player2, new Vector3f(-20f, -30f, 0));
		Manufactory manufactory5 = new Manufactory(this, player2, new Vector3f(0f, -30f, 0));
		Manufactory manufactory6 = new Manufactory(this, player2, new Vector3f(20f, -30f, 0));

		manufactory1.addWorkshop(new BasicWorkshop());
		manufactory2.addWorkshop(new BasicWorkshop());
		manufactory3.addWorkshop(new BasicWorkshop());
		manufactory4.addWorkshop(new BasicWorkshop());
		manufactory5.addWorkshop(new BasicWorkshop());
		manufactory6.addWorkshop(new BasicWorkshop());

		manufactory1.changeTarget(manufactory6);
		manufactory2.changeTarget(manufactory5);
		manufactory3.changeTarget(manufactory4);
		manufactory4.changeTarget(manufactory2);
		manufactory5.changeTarget(manufactory1);
		manufactory6.changeTarget(manufactory3);

		manufactory1.changeOrder(UnitIdentifier.TANK);
		manufactory2.changeOrder(UnitIdentifier.TANK);
		manufactory3.changeOrder(UnitIdentifier.TANK);
		manufactory4.changeOrder(UnitIdentifier.TANK);
		manufactory5.changeOrder(UnitIdentifier.TANK);
		manufactory6.changeOrder(UnitIdentifier.TANK);

		this.gameObjects.add(manufactory1);
		this.gameObjects.add(manufactory2);
		this.gameObjects.add(manufactory3);
		this.gameObjects.add(manufactory4);
		this.gameObjects.add(manufactory5);
		this.gameObjects.add(manufactory6);
	}
}
