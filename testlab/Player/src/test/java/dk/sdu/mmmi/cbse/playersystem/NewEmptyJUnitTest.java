/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.sdu.mmmi.cbse.playersystem;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import dk.sdu.mmmi.cbse.common.data.*;
import dk.sdu.mmmi.cbse.common.data.entityparts.PositionPart;

import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author kkmp
 */
public class NewEmptyJUnitTest {
	
	public NewEmptyJUnitTest() {
	}
	
	@BeforeAll
	public static void setUpClass() {
	}
	
	@AfterAll
	public static void tearDownClass() {
	}
	
	@BeforeEach
	public void setUp() {
	}
	
	@AfterEach
	public void tearDown() {
	}
	
	@Test
	public void niceOne() {
		assertNull(null);
	}

	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	@Test
	public void hello() {
		assertNotNull(null);
    }

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
