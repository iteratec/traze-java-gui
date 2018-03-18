package iteratec.mircomarcelalex.traze;

import com.fasterxml.jackson.databind.ObjectMapper;
import iteratec.mircomarcelalex.traze.content.Bike;
import iteratec.mircomarcelalex.traze.content.Grid;
import iteratec.mircomarcelalex.traze.content.Player;
import org.json.JSONArray;
import org.json.JSONObject;
import org.newdawn.slick.SlickException;

import java.awt.*;
import java.io.IOException;

public class TrazeClient {

    static Grid grid;
    static Player[] players;
    static String current_course;
    private static String playerToken;
    private static int playerId;
    private static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) throws SlickException {
        new BrokerClient();
        TrazeGUIClient.startClient();
    }

    static void setGrid(String gridString) {
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
            Point currentLocation;
            String direction;
            Point[] trail;

            JSONObject bikeJson = (JSONObject) bikesJsonArray.get(j);
            playerId = (int) bikeJson.get("playerId");

            int x = (int) ((JSONArray) bikeJson.get("currentLocation")).get(0);
            int y = (int) ((JSONArray) bikeJson.get("currentLocation")).get(1);
            currentLocation = new Point(x, y);

            direction = (String) bikeJson.get("direction");
            int trailLength = ((JSONArray) bikeJson.get("trail")).length();
            trail = new Point[trailLength];

            for (int i = 0; i < trailLength; ++i) {
                JSONArray trailJson = (JSONArray) ((JSONArray) bikeJson.get("trail")).get(i);
                trail[i] = new Point((int) trailJson.get(0), (int) trailJson.get(1));
            }

            bike = new Bike(playerId, currentLocation, direction, trail);
            bikes[j] = bike;
        }

        JSONArray spawnJsonArray = (JSONArray) gridJson.get("spawns");
        Point[] spawns = new Point[spawnJsonArray.length()];

        for (int k = 0; k < spawnJsonArray.length(); ++k) {
            JSONArray currentArray = (JSONArray) spawnJsonArray.get(k);
            spawns[k] = new Point((int) (currentArray.get(0)), (int) (currentArray.get(1)));
        }

        TrazeClient.grid = new Grid(height, width, tiles, bikes, spawns);
    }

    static void setPlayers(String playersString) {
        try {
            players = objectMapper.readValue(playersString, Player[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void initPlayer(String playerJsonString) {
        JSONObject player = new JSONObject(playerJsonString);
        playerId = (int) player.get("id");
        playerToken = player.get("secretUserToken").toString();
        System.out.println("Spieler " + player.get("name") + " erfolgreich registriert!");
        System.out.println(" >>> Farbe: " + player.get("color"));
    }

    static void buildSteerMessage() {
        if (playerToken != null && current_course != null) {
            String messageString = " {\"course\":\"" + current_course + "\", \"playerToken\": \"" + playerToken + "\" }";
            String topic = "traze/1/" + playerId + "/steer";
            BrokerClient.publishSteerMessage(messageString, topic);
        }
    }
}
