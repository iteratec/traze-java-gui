package iteratec.mircomarcelalex.traze;

import org.newdawn.slick.*;

import java.util.logging.Level;
import java.util.logging.Logger;

public class TrazeClient extends BasicGame {

    public TrazeClient(String title) {
        super(title);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer appgc;
            appgc = new AppGameContainer(new TrazeClient("MMA Traze Client"));
            appgc.setDisplayMode(800, 600, false);
            appgc.start();

        } catch (SlickException ex) {
//            Logger.getLogger(TrazeClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void render(GameContainer container, Graphics g) throws SlickException {


    }

    @Override
    public void init(GameContainer container) throws SlickException {
        BrokerClient myBrokerClient = new BrokerClient();

    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        // TODO Auto-generated method stub

    }

}
