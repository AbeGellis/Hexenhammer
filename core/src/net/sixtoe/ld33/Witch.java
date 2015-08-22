package net.sixtoe.ld33;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Witch extends Entity {
	Texture img = new Texture("whitepix.png");
	
	public Witch() {
		order = 10f;
		Entity f1, f2;
		Scene.AddEntity(f1 = new Flame(this));
		Scene.AddEntity(f2 = new Flame(f1));
		Scene.AddEntity(new Flame(f2));
	}
	
	@Override
	public void Draw(SpriteBatch batch) {
		batch.setColor(Color.PURPLE);
		batch.draw(img, position.x - 16, position.y - 16, 32, 32);
	}

	@Override
	public void Update(float dt) {
		position.set(Gdx.input.getX(), Gdx.graphics.getHeight() - Gdx.input.getY());
	}

}
