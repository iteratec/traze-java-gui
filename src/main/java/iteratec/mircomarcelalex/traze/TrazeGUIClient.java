package iteratec.mircomarcelalex.traze;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
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
		g.setDrawMode(0);
		if(TrazeClient.grid != null) {	
		for(int x = 0; x < TrazeClient.grid.getGridWidth(); x++) {
			for(int y = 0; y < TrazeClient.grid.getGridHeight(); y++) {
				g.setColor(GRID_COLOR);
				g.draw(new Rectangle(x*GRID_GRAPHIC_WIDTH, y*GRID_GRAPHIC_HEIGHT, GRID_GRAPHIC_WIDTH, GRID_GRAPHIC_HEIGHT));
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
		// TODO Auto-generated method stub
		
	}

}
