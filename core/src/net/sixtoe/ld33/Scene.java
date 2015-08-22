package net.sixtoe.ld33;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeSet;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Scene implements Screen {

	public static Game game;
	SpriteBatch batch;
	
	public Scene(SpriteBatch batch) {this.batch = batch;}
	
	static Comparator<Entity> c = new Comparator<Entity>() {
			public int compare(Entity e1, Entity e2) {
				return e1.order > e2.order ? 1 : e1.order < e2.order ? -1 : 0;
			}
		};
	
	TreeSet<Entity> entities = new TreeSet<Entity>(c);
	LinkedList<Entity> toRemove = new LinkedList<Entity>();
	LinkedList<Entity> toAdd = new LinkedList<Entity>();

	public static void AddEntity(Entity e) {
		((Scene) game.getScreen()).toAdd.add(e);
	}
	
	public static void RemoveEntity(Entity e) {

		((Scene) game.getScreen()).toRemove.add(e);
	}
	
	
	@Override
	public void show() {
		// TODO Auto-generated method stub

	}


	@Override
	public void render(float delta) {
		batch.begin();
		
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.15f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		for (Entity e : entities) 
			e.Update(delta);

		while (!toRemove.isEmpty()) 
			entities.remove(toRemove.removeFirst());
		while (!toAdd.isEmpty()) 
			entities.add(toAdd.removeFirst());
		
		for (Entity e : entities)
			e.Draw(batch);
		
		batch.end();
	}
	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub

	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub

	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub

	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

}
