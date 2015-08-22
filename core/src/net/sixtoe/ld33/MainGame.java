package net.sixtoe.ld33;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MainGame extends Game {
	SpriteBatch batch;
	
	public MainGame() {
		Scene.game = this;
	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		setScreen(new GameScene(batch));
	}

}
