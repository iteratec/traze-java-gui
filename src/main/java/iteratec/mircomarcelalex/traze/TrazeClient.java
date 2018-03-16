package iteratec.mircomarcelalex.traze;

import iteratec.mircomarcelalex.traze.content.Grid;
import org.json.JSONArray;
import org.json.JSONObject;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

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
    	for(int x = 0; x < grid.getGridWidth(); x++) {
    		for(int y = 0; y < grid.getGridHeight(); y++) {
        		g.setColor(Color.green);
        		g.draw(new Rectangle(x, y, 800/grid.getGridWidth(), 600/grid.getGridWidth()));
        	}
    	}
    }

    @Override
    public void init(GameContainer container) throws SlickException {

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        // TODO Auto-generated method stub

    }

    public static void setGrid(String gridString) {
        JSONObject gridJson = new JSONObject(gridString);
        JSONArray tiles = (JSONArray) gridJson.get("tiles");

        System.out.println("parsing beginnt...");

        int height = tiles.length();
        int width = ((JSONArray) tiles.get(0)).length();

        int[][] map = new int[width][height];

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                map[x][y] = (int) ((JSONArray) tiles.get(x)).get(y);
            }
        }
        System.out.println("hat geklappt " + tiles);

//        int[][] map = (int[][]) gridJson.get("tiles");
//        Bike[] bikes = (Bike[]) gridJson.get("bikes");
//        Coordination2D[] spawns = (Coordination2D[]) gridJson.get("spawns");
//
//        grid = new Grid(map, bikes, spawns);
    }
}
