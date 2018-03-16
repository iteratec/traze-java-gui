package iteratec.mircomarcelalex.traze;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class TrazeClient extends BasicGame {

    public TrazeClient(String title) {
        super(title);
    }

    public static void main(String[] args) {
        new BrokerClient();

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

}
