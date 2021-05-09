package dk.sdu.mmmi.cbse.playersystem;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dk.sdu.mmmi.cbse.common.data.*;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;

public class PlayerControlSystemTest {
    
    @Test
    public void process() {
        World world = new World();
        GameData gameData = new GameData();
        gameData.getKeys().setKey(GameKeys.UP, true);
        new PlayerPlugin().start(gameData, world);

        Entity player = world.getEntities(Player.class).get(0);
        PositionPart positionPart = player.getPart(PositionPart.class);

        System.out.println("positionPart.x: " + positionPart.getX() + " - positionPart.y: " + positionPart.getY());

        new PlayerControlSystem().process(gameData, world);

        System.out.println("positionPart.x: " + positionPart.getX() + " - positionPart.y: " + positionPart.getY());
        assertTrue(false);
    }

    @Test
    public void proces1() {
        assertNotNull(null);
        assertTrue(false);
    }
}
