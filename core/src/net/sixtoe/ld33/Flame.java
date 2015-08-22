package net.sixtoe.ld33;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Flame extends Entity {
	Texture img = new Texture("whitepix.png");
	public Entity Follow;
	private Vector2 prevFollowPos;
	
	public Flame(Entity follow) {
		Follow = follow;
		order = follow.order - 1f;
		position = follow.position.cpy();
		prevFollowPos = position.cpy();
	}
	
	
	@Override
	public void Draw(SpriteBatch batch) {
		batch.setColor(Color.BLUE);
		batch.draw(img, position.x - 10, position.y - 10, 20, 20);

	}

	@Override
	public void Update(float dt) {
		position.set(prevFollowPos);
		prevFollowPos.set(Follow.position);
	}

}
