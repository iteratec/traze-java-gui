package iteratec.mircomarcelalex.traze;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class TrazeGUIClient extends BasicGame {

	private static AppGameContainer appgc;
	
	public TrazeGUIClient(String title) {
		super(title);	
	}
	
	public static void main(String[] args) throws SlickException {
      appgc = new AppGameContainer(new TrazeGUIClient("MMA Traze Client"));
      appgc.setDisplayMode(800, 600, false);
      appgc.start();
	}

	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		
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
