package net.sixtoe.ld33;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;


public class Enemy extends Entity {
	Texture img = new Texture("whitepix.png");

	private Vector2 target;
	private float moveTimer;
	private float shootTimer;
	
	static final float MIN_MOVE_TIMER = 0, MAX_MOVE_TIMER = 4;
	static final float MIN_SHOOT_TIMER = 2, MAX_SHOOT_TIMER = 8;
	static final float MOVE_SPEED = 100f;
	static final Rectangle BOUNDS = new Rectangle(20f, 16f, Gdx.graphics.getWidth() - 40f, 32f);
	
	public Enemy() {
		position = new Vector2(MathUtils.randomBoolean() ? -16f : Gdx.graphics.getWidth() + 16f, MathUtils.random(16f, 48f));
		order = -position.y;
		target = new Vector2(MathUtils.random(BOUNDS.x, BOUNDS.x + BOUNDS.getWidth()), MathUtils.random(BOUNDS.y, BOUNDS.y + BOUNDS.getHeight()));
		moveTimer = MathUtils.random(MIN_MOVE_TIMER, MAX_MOVE_TIMER);
		shootTimer = MathUtils.random(MIN_SHOOT_TIMER, MAX_SHOOT_TIMER);
	}

	public void Draw(SpriteBatch batch) {
		batch.setColor(Color.RED);
		batch.draw(img, position.x - 16, position.y - 16, 32, 32);
	}

	@Override
	public void Update(float dt) {
		if (position.dst2(target) > 1f) {
			Vector2 dist = target.cpy();
			float d = dist.len();
			dist.sub(position).nor().scl(MOVE_SPEED * dt).clamp(0f, d);
			
			position.add(dist);
		}
		else {
			moveTimer -= dt;
			
			if (moveTimer <= 0f) {
				target.set(MathUtils.random(BOUNDS.x, BOUNDS.x + BOUNDS.getWidth()), MathUtils.random(BOUNDS.y, BOUNDS.y + BOUNDS.getHeight()));
				moveTimer += MathUtils.random(MIN_MOVE_TIMER, MAX_MOVE_TIMER);
			}
		}
		
		shootTimer -= dt;
		if (shootTimer <= 0f) {
			shootTimer += MathUtils.random(MIN_SHOOT_TIMER, MAX_SHOOT_TIMER);
			Scene.AddEntity(new EnemyArrow(position.cpy(), new Vector2(10f, 200f)));
			System.out.println("pew");
		}
	}

}
