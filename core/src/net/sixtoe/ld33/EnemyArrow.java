package net.sixtoe.ld33;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class EnemyArrow extends Entity {
	Texture img = new Texture("whitepix.png");

	private Vector2 velocity;
	static final float GRAVITY = 10f;
	
	public EnemyArrow(Vector2 position, Vector2 velocity) {
		this.velocity = velocity;
		this.position = position;
	}
	
	@Override
	public void Draw(SpriteBatch batch) {
		batch.setColor(Color.ORANGE);
		batch.draw(img, position.x - 1, position.y - 1, 2, 2);
	}

	@Override
	public void Update(float dt) {
		Vector2 delta = velocity.cpy().scl(dt);
		position.add(delta);
		
		velocity.y -= GRAVITY * dt;
		
		if (position.y > Gdx.graphics.getHeight() || position.y < 0f || position.x > Gdx.graphics.getWidth() || position.x < 0f)
			Scene.RemoveEntity(this);
	}

}
