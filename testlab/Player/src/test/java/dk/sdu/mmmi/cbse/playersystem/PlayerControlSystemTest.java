package dk.sdu.mmmi.cbse.playersystem;

import java.util.ArrayList;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import dk.sdu.mmmi.cbse.common.data.*;
import dk.sdu.mmmi.cbse.common.data.entityparts.*;

public class PlayerControlSystemTest {
    
    @Test //Test 1
    public void process() {
        World world = new World();
        GameData gameData = new GameData();
        gameData.setDisplayHeight(400);
        gameData.setDisplayWidth(500);
        gameData.getKeys().setKey(GameKeys.UP, true);
        new PlayerPlugin().start(gameData, world);

        Entity player = world.getEntities(Player.class).get(0);
        PositionPart positionPart = player.getPart(PositionPart.class);

        // Checker om den start samme sted, som det der er programeet.
        // Det gør jeg fordi så kan jeg teste om process rykker
        // spilleren(player'en)
        assertEquals(gameData.getDisplayWidth() / 2 , positionPart.getX());
        assertEquals(gameData.getDisplayHeight() / 2 , positionPart.getY());
        gameData.setDelta(0.5f);
        new PlayerControlSystem().process(gameData, world);
        // Efter jeg har kørt methode "process" så skulle den gerne have rykket
        // sig så den er ikke ligemed.
        assertNotEquals(gameData.getDisplayWidth() / 2, positionPart.getX());
        assertNotEquals(gameData.getDisplayHeight() / 2, positionPart.getY());



    }

    @Test //Test 2
    public void TestThattheRighMethodsGetsCalled() {
        World world = mock(World.class);

        MovingPart mov = mock(MovingPart.class);
        PositionPart pos = mock(PositionPart.class);

        Player player = mock(Player.class);
        when(player.getPart(PositionPart.class)).thenReturn(pos);
        when(player.getPart(MovingPart.class)).thenReturn(mov);

        when(player.getShapeX()).thenReturn(new float[4]);
        when(player.getShapeY()).thenReturn(new float[4]);

        ArrayList<Entity> listPlayer = new ArrayList<Entity>();
        listPlayer.add(player);
        when(world.getEntities(Player.class)).thenReturn(listPlayer);

        GameData gameData = mock(GameData.class);
        when(gameData.getKeys()).thenReturn(new GameKeys());


        PlayerControlSystem pcs = new PlayerControlSystem();

        pcs.process(gameData, world);
        // Her checker den kalder methoderne på MovingPart og PositionPart
        verify(mov).process(gameData, player);
        verify(pos).process(gameData, player);
        // Her checker jeg om den kalder get entries.
        verify(world).getEntities(Player.class);
    }
}
