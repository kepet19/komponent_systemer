/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.astroid6shapes;

import dk.sdu.mmmi.cbse.common.asteroids.Astroid6shapes;
import dk.sdu.mmmi.cbse.common.data.Entity;
import dk.sdu.mmmi.cbse.common.data.GameData;
import dk.sdu.mmmi.cbse.common.data.World;
import dk.sdu.mmmi.cbse.common.data.entityparts.LifePart;
import dk.sdu.mmmi.cbse.common.data.entityparts.MovingPart;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import org.openide.util.lookup.ServiceProvider;

/**
 *
 * @author kkmp
 */
@ServiceProvider(service = IGamePluginService.class)
public class AsteroidPlugin implements IGamePluginService{
	@Override
    public void start(GameData gameData, World world) {
        // Add entities to the world
        for(int i=0; i < 3; i++){
            Entity asteroid = createAsteroid(gameData);
			System.out.println("hello astroid6Shapes");
            world.addEntity(asteroid);
        }
    }

    @Override
    public void stop(GameData gameData, World world) {
		world.getEntities(Astroid6shapes.class).forEach(asteroid -> {
			world.removeEntity(asteroid);
		});
    }

    private Entity createAsteroid(GameData gameData) {
        Entity asteroid = new Astroid6shapes();
        float radians = (float) Math.random() * 2 * 3.1415f;
        float speed = (float) Math.random() * 10f + 20f;

        asteroid.setRadius(20);
        asteroid.add(new MovingPart(0, speed, speed, 0));
        asteroid.add(new PositionPart(
				gameData.getDisplayWidth() * (float) Math.random(), 
				gameData.getDisplayHeight() * (float) Math.random(), 
				(float) Math.random() * 2 * 3.1415f
		));
        asteroid.add(new LifePart(4));

        return asteroid;
    }
	
}
