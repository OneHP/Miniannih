package uk.co.onehp.display;

import com.jme3.math.Vector3f;
import com.jme3.scene.Mesh;
import com.jme3.scene.VertexBuffer.Type;
import com.jme3.util.BufferUtils;

public class SquarePlaceHolder extends Mesh {

	private static Vector3f[] VERTICES;

	private static int[] INDEXES = { 0, 3, 2, 0, 1, 3 };

	static {
		VERTICES = new Vector3f[4];
		VERTICES[0] = new Vector3f(-0.5f, 0.5f, 0);
		VERTICES[1] = new Vector3f(0.5f, 0.5f, 0);
		VERTICES[2] = new Vector3f(0.5f, -0.5f, 0);
		VERTICES[3] = new Vector3f(-0.5f, -0.5f, 0);
	}

	public SquarePlaceHolder() {
		this.setBuffer(Type.Position, 3, BufferUtils.createFloatBuffer(VERTICES));
		this.setBuffer(Type.Index, 3, BufferUtils.createIntBuffer(INDEXES));
		this.updateBound();
	}
}
