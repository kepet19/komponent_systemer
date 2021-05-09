package dk.sdu.mmmi.cbse.playersystem;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dk.sdu.mmmi.cbse.common.data.*;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;

public class PlayerControlSystemTest {
    
    @Test
    public void process() {
        World world = new World();
        GameData gameData = new GameData();
        gameData.setDisplayHeight(400);
        gameData.setDisplayWidth(500);
        gameData.getKeys().setKey(GameKeys.UP, true);
        new PlayerPlugin().start(gameData, world);

        Entity player = world.getEntities(Player.class).get(0);
        PositionPart positionPart = player.getPart(PositionPart.class);

        assertEquals(gameData.getDisplayWidth() / 2 , positionPart.getX());
        assertEquals(gameData.getDisplayHeight() / 2 , positionPart.getY());
        gameData.setDelta(0.5f);
        new PlayerControlSystem().process(gameData, world);
        System.out.println("positionPart.x: " + positionPart.getX() + " - positionPart.y: " + positionPart.getY());



    }

    @Test
    public void proces1() {
    }
}
