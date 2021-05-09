package dk.sdu.mmmi.cbse.main;

import com.badlogic.gdx.backends.lwjgl.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("Beans.xml");
        Game game = (Game) context.getBean("core");
		
		LwjglApplicationConfiguration cfg =
			new LwjglApplicationConfiguration();
		cfg.title = "Asteroids";
		cfg.width = 500;
		cfg.height = 400;
		cfg.useGL30 = false;
		cfg.resizable = false;
		
		new LwjglApplication(game, cfg);
		
	}
	
}
