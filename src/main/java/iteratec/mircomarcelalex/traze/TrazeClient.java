package iteratec.mircomarcelalex.traze;

import com.fasterxml.jackson.databind.ObjectMapper;
import iteratec.mircomarcelalex.traze.content.Bike;
import iteratec.mircomarcelalex.traze.content.Grid;
import iteratec.mircomarcelalex.traze.content.Player;
import org.json.JSONObject;
import org.newdawn.slick.SlickException;

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
        try {
            int[][] tiles = objectMapper.readValue(gridJson.get("tiles").toString(), int[][].class);
            Bike[] bikes = objectMapper.readValue(gridJson.get("bikes").toString(), Bike[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        JSONArray tilesJsonArray = (JSONArray) gridJson.get("tiles");
//        JSONArray bikesJsonArray = (JSONArray) gridJson.get("bikes");
//        playerId = (int) bikeJson.get("playerId");
//        int x = (int) ((JSONArray) bikeJson.get("currentLocation")).get(0);
//        direction = (String) bikeJson.get("direction");
//        int trailLength = ((JSONArray) bikeJson.get("trail")).length();
//        JSONArray trailJson = (JSONArray) ((JSONArray) bikeJson.get("trail")).get(i);
//        JSONArray spawnJsonArray = (JSONArray) gridJson.get("spawns");
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

    static void steer() {
        if (playerToken != null && current_course != null) {
            String messageString = " {\"course\":\"" + current_course + "\", \"playerToken\": \"" + playerToken + "\" }";
            String topic = "traze/1/" + playerId + "/steer";
            BrokerClient.steer(messageString, topic);
        }
    }

}
