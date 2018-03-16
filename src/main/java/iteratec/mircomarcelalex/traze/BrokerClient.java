package iteratec.mircomarcelalex.traze;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

class BrokerClient {

    private MqttClient client;
    public static String generatedClientId;
    private SimpleMqttCallBack ourCallback = new SimpleMqttCallBack();

    BrokerClient() {
        try {
            generatedClientId = MqttClient.generateClientId();
            client = new MqttClient("tcp://traze.iteratec.de:1883", generatedClientId);
            client.setCallback(ourCallback);
            client.connect();
            client.subscribe("traze/1/grid");

            join("Mirco");
            client.subscribe("traze/1/player/" + generatedClientId);

//            client.subscribe("traze/1/players");
//            client.subscribe("traze/1/ticker");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void join(String nickname) {
        String topic = "traze/1/join";

        JSONObject joiningPlayer = new JSONObject("{\"name\": \"" + nickname + "\",\"mqttClientName\": \"" + generatedClientId + "\"}");

        MqttMessage message = new MqttMessage();
        message.setPayload(joiningPlayer.toString().getBytes());
        try {
            client.publish(topic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SimpleMqttCallBack getCallBack() {
        return ourCallback;
    }
}
