package net.sixtoe.ld33;

import com.badlogic.gdx.math.*;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Entity {
	public Vector2 position = Vector2.Zero;
	public float order;
	public abstract void Draw(SpriteBatch batch);
	public abstract void Update(float dt);
}
