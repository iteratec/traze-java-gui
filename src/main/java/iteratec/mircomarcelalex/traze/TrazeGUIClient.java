package iteratec.mircomarcelalex.traze;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

public class TrazeGUIClient extends BasicGame {

	private static AppGameContainer appgc;
	private static final float GRID_GRAPHIC_WIDTH = 13f;
	private static final float GRID_GRAPHIC_HEIGHT = 10f;
	private static final Color GRID_COLOR = new Color(176,65,167,0.1f);
	
	public TrazeGUIClient(String title) {
		super(title);	
	}
	
    public static void startClient() throws SlickException {
        appgc = new AppGameContainer(new TrazeGUIClient("MMA Traze Client"));
        appgc.setDisplayMode(806, 620, false);
        appgc.start();
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        if (TrazeClient.grid != null) {
            for (int x = 0; x < TrazeClient.grid.getGridWidth(); x++) {
                for (int y = 0; y < TrazeClient.grid.getGridHeight(); y++) {
                    g.setColor(GRID_COLOR);
                    g.draw(new Rectangle(x * GRID_GRAPHIC_WIDTH, y * GRID_GRAPHIC_HEIGHT, GRID_GRAPHIC_WIDTH, GRID_GRAPHIC_HEIGHT));
                }
            }
        }
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        // TODO Auto-generated method stub

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        if (container.getInput().isKeyPressed(Input.KEY_A)) {
            System.out.println("Pressed A");
            TrazeClient.current_course = "W";
        } else if (container.getInput().isKeyPressed(Input.KEY_S)) {
            System.out.println("Pressed S");
            TrazeClient.current_course = "S";
        } else if (container.getInput().isKeyPressed(Input.KEY_D)) {
            System.out.println("Pressed D");
            TrazeClient.current_course = "O";
        } else if (container.getInput().isKeyPressed(Input.KEY_W)) {
            System.out.println("Pressed W");
            TrazeClient.current_course = "N";
        }

    }

}
