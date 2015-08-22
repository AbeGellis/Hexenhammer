package net.sixtoe.ld33;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScene extends Scene {

	public GameScene(SpriteBatch batch) {
		super(batch);
	}

	@Override
	public void show() {
		Scene.AddEntity(new Witch());
		Scene.AddEntity(new Enemy());
	}
}
