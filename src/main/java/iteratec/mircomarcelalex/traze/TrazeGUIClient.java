package iteratec.mircomarcelalex.traze;

import iteratec.mircomarcelalex.traze.content.Bike;
import iteratec.mircomarcelalex.traze.content.Coordination2D;
import iteratec.mircomarcelalex.traze.content.Player;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TrazeGUIClient extends BasicGame {

    private static AppGameContainer appgc;
    private static final int WINDOW_WIDTH = 806;
    private static final int WINDOW_HEIGHT = 620;
    private static final float GRID_GRAPHIC_WIDTH = 13f;
    private static final float GRID_GRAPHIC_HEIGHT = 10f;
    private static final Color GRID_COLOR = new Color(176, 65, 167, 0.1f);

    public TrazeGUIClient(String title) {
        super(title);
    }

    public static void startClient() throws SlickException {
        appgc = new AppGameContainer(new TrazeGUIClient("MMA Traze Client"));
        appgc.setDisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT, false);
        appgc.start();
        Logger.getLogger(TrazeGUIClient.class.getName()).setLevel(Level.OFF);
    }

    @Override
    public void render(GameContainer container, Graphics g) throws SlickException {
        if (TrazeClient.grid != null) {
            for (int x = 0; x < TrazeClient.grid.getGridWidth(); x++) {
                for (int y = 0; y < TrazeClient.grid.getGridHeight(); y++) {
                    for (Coordination2D c : TrazeClient.grid.getSpawns()) {
                        if (c.getX() == x && c.getY() == y) {
                            g.setColor(new Color(255, 255, 255, 0.85f));
                            g.fill(new Rectangle(x * GRID_GRAPHIC_WIDTH, WINDOW_HEIGHT - y * GRID_GRAPHIC_HEIGHT, GRID_GRAPHIC_WIDTH, GRID_GRAPHIC_HEIGHT));
                        }
                    }
                    g.setColor(GRID_COLOR);
                    g.draw(new Rectangle(x * GRID_GRAPHIC_WIDTH, WINDOW_HEIGHT - y * GRID_GRAPHIC_HEIGHT, GRID_GRAPHIC_WIDTH, GRID_GRAPHIC_HEIGHT));
                }
            }
        }
        
     	if(TrazeClient.grid != null && TrazeClient.players != null && TrazeClient.grid.getBikes() != null) { 
        	for(Bike b : TrazeClient.grid.getBikes()) {
        		Color c = getColor(b.getPlayerId());
        		c.a = 0.7f;
        		g.setColor(c);
        		for(Coordination2D cord : b.getTrail()) {
        			g.fill(new Rectangle(cord.getX() * GRID_GRAPHIC_WIDTH, WINDOW_HEIGHT - cord.getY() * GRID_GRAPHIC_HEIGHT, 13f, 10f));
        		}
        		c = getColor(b.getPlayerId());
        		g.setColor(c);
        		Player name = findPlayerByBike(b);
        		String nameString;
        		if(name != null) {
        		nameString = name.getName();	
        		g.setColor(Color.white);
        		if(findPlayerByBike(b).getName().length() >= 7) {
        		nameString = findPlayerByBike(b).getName().substring(0, 8);
        		}
        		g.drawString(nameString, b.getCurrentLocation().getX() * GRID_GRAPHIC_WIDTH , WINDOW_HEIGHT - b.getCurrentLocation().getY() * GRID_GRAPHIC_HEIGHT);
        		}
          		c = getColor(b.getPlayerId());
        		g.setColor(c);
        		g.fill(new Rectangle(b.getCurrentLocation().getX() * GRID_GRAPHIC_WIDTH , WINDOW_HEIGHT - b.getCurrentLocation().getY() * GRID_GRAPHIC_HEIGHT, 13f, 10f));
        	}

        }
    }

    private Player findPlayerByBike(Bike b) {
        for (Player p : TrazeClient.players) {
            if (b != null && p != null) {
                if (b.getPlayerId() == p.getId()) {
                    return p;
                }
            }
        }
        return null;
    }

    @Override
    public void init(GameContainer container) throws SlickException {
        // TODO Auto-generated method stub

    }

    public Color getColor(int playerId) {
        for (Player p : TrazeClient.players) {
            if (p != null) {
                if (playerId == p.getId()) {
                    return (hex2Rgb(p.getColor()));
                }
            }
        }
        return Color.red;
    }

    public static Color hex2Rgb(String colorStr) {
        return new Color(
                Integer.valueOf(colorStr.substring(1, 3), 16),
                Integer.valueOf(colorStr.substring(3, 5), 16),
                Integer.valueOf(colorStr.substring(5, 7), 16)
        );
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        String wantedCourse = null;

        if (container.getInput().isKeyPressed(Input.KEY_A)) {
            System.out.println("Pressed A");
            wantedCourse = "W";
        } else if (container.getInput().isKeyPressed(Input.KEY_S)) {
            System.out.println("Pressed S");
            wantedCourse = "S";
        } else if (container.getInput().isKeyPressed(Input.KEY_D)) {
            System.out.println("Pressed D");
            wantedCourse = "E";
        } else if (container.getInput().isKeyPressed(Input.KEY_W)) {
            System.out.println("Pressed W");
            wantedCourse = "N";
        }

        for (Bike bike : TrazeClient.grid.getBikes()) {
            if (bike.getPlayerId() == TrazeClient.playerId) {
                Brain.calculateNextDirection(wantedCourse, bike.getCurrentLocation());
                break;
            }
        }

    }

}
