package iteratec.mircomarcelalex.traze;

import iteratec.mircomarcelalex.traze.content.Bike;
import iteratec.mircomarcelalex.traze.content.Coordination2D;
import iteratec.mircomarcelalex.traze.content.Grid;
import iteratec.mircomarcelalex.traze.content.Player;
import org.json.JSONArray;
import org.json.JSONObject;
import org.newdawn.slick.SlickException;

public class TrazeClient {

    private static BrokerClient bc;
    public static Grid grid;
    public static Player[] players;
    public static String current_course;
    private static String playerToken;
    private static int playerId;

    public static void main(String[] args) throws SlickException {
        bc = new BrokerClient();
        TrazeGUIClient.startClient();
    }

    public static void setGrid(String gridString) {
        JSONObject gridJson = new JSONObject(gridString);
        JSONArray tilesJsonArray = (JSONArray) gridJson.get("tiles");

        int height = tilesJsonArray.length();
        int width = ((JSONArray) tilesJsonArray.get(0)).length();

        int[][] tiles = new int[width][height];

        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                tiles[x][y] = (int) ((JSONArray) tilesJsonArray.get(x)).get(y);
            }
        }

        JSONArray bikesJsonArray = (JSONArray) gridJson.get("bikes");
        Bike[] bikes = new Bike[bikesJsonArray.length()];

        for (int j = 0; j < bikesJsonArray.length(); ++j) {
            Bike bike;
            int playerId;
            Coordination2D currentLocation;
            String direction;
            Coordination2D[] trail;

            JSONObject bikeJson = (JSONObject) bikesJsonArray.get(j);
            playerId = (int) bikeJson.get("playerId");

            int x = (int) ((JSONArray) bikeJson.get("currentLocation")).get(0);
            int y = (int) ((JSONArray) bikeJson.get("currentLocation")).get(1);
            currentLocation = new Coordination2D(x, y);

            direction = (String) bikeJson.get("direction");
            int trailLength = ((JSONArray) bikeJson.get("trail")).length();
            trail = new Coordination2D[trailLength];

            for (int i = 0; i < trailLength; ++i) {
                JSONArray trailJson = (JSONArray) ((JSONArray) bikeJson.get("trail")).get(i);
                trail[i] = new Coordination2D((int) trailJson.get(0), (int) trailJson.get(1));
            }

            bike = new Bike(playerId, currentLocation, direction, trail);
            bikes[j] = bike;
        }

        JSONArray spawnJsonArray = (JSONArray) gridJson.get("spawns");
        Coordination2D[] spawns = new Coordination2D[spawnJsonArray.length()];

        for (int k = 0; k < spawnJsonArray.length(); ++k) {
            JSONArray currentArray = (JSONArray) spawnJsonArray.get(k);
            spawns[k] = new Coordination2D((int) (currentArray.get(0)), (int) (currentArray.get(1)));
        }

        TrazeClient.grid = new Grid(tiles, bikes, spawns);
    }

    public static void setPlayers(String playersString) {
        JSONArray playersJsonArray = new JSONArray(playersString);

        for (int i = 0; i < playersJsonArray.length(); ++i) {
            JSONObject playerJson = (JSONObject) playersJsonArray.get(i);
            Player player = new Player();
            player.setId((int) playerJson.get("id"));
            player.setName((String) playerJson.get("name"));
            player.setColor((String) playerJson.get("color"));
            player.setFrags((int) playerJson.get("frags"));
            player.setOwned((int) playerJson.get("owned"));
            players[i] = player;
        }
    }

    public static void initPlayer(String playerJsonString) {
        JSONObject player = new JSONObject(playerJsonString);
        playerId = (int) player.get("id");
        System.out.println(" >>> Farbe: " + player.get("color"));
        playerToken = player.get("secretUserToken").toString();
        System.out.println("Spieler erfolgreich registriert!");
    }

    public static void steer() {
        if (playerToken != null && current_course != null) {
            String messageString = " 'course':'" + current_course + "', 'playerToken': '" + playerToken + "' ";
            String topic = "traze/1/" + playerId + "/steer";
            BrokerClient.steer(messageString, topic);
        }
    }

}
