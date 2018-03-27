package iteratec.mircomarcelalex.traze;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.persist.MqttDefaultFilePersistence;
import org.json.JSONObject;

class BrokerClient {

    private static final String lockFileDirectory = "../../../paho-lock-files";
    private static MqttClient client;
    static String generatedClientId;

    BrokerClient() {
        try {
            generatedClientId = MqttClient.generateClientId();
            client = new MqttClient("tcp://traze.iteratec.de:1883", generatedClientId);//, new MqttDefaultFilePersistence(lockFileDirectory));
            SimpleMqttCallBack ourCallback = new SimpleMqttCallBack();
            client.setCallback(ourCallback);
            client.connect();
            client.subscribe("traze/1/grid");

            join();
            client.subscribe("traze/1/player/" + generatedClientId);
            client.subscribe("traze/1/players");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void publishSteerMessage(String messageString, String topic) {
        MqttMessage message = new MqttMessage();
        message.setPayload(messageString.getBytes());
        try {
            // System.out.println("publishing: " + messageString);
            client.publish(topic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void join() {
        String topic = "traze/1/join";

        JSONObject joiningPlayer = new JSONObject("{\"name\": \"" + NameGenerator.generateHeroName() + "\",\"mqttClientName\": \"" + generatedClientId + "\"}");

        MqttMessage message = new MqttMessage();
        message.setPayload(joiningPlayer.toString().getBytes());
        try {
            // System.out.println("publishing: " + joiningPlayer.toString());
            client.publish(topic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
