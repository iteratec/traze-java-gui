package iteratec.mircomarcelalex.traze;

import org.json.JSONObject;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import iteratec.mircomarcelalex.traze.content.Grid;

public class TrazeClient extends BasicGame {

	private static BrokerClient bc;
	private static Grid grid;
	
    public TrazeClient(String title) {
        super(title);
    }

    public static void main(String[] args) {
       bc = new BrokerClient();

//        try {
//            AppGameContainer appgc;
//            appgc = new AppGameContainer(new TrazeClient("MMA Traze Client"));
//            appgc.setDisplayMode(800, 600, false);
//            appgc.start();
//
//        } catch (SlickException ex) {
//            Logger.getLogger(TrazeClient.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }

    public void render(GameContainer container, Graphics g) throws SlickException {


    }

    @Override
    public void init(GameContainer container) throws SlickException {

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        // TODO Auto-generated method stub

    }

    public static void setGrid(String grid) {
    	JSONObject gridJson = new JSONObject(grid);
    	System.out.println(gridJson + "DSASDA");
    }
}
