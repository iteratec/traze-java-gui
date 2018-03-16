package iteratec.mircomarcelalex.traze;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.json.JSONObject;

import java.util.UUID;

class BrokerClient {

    private MqttClient client;
    private SimpleMqttCallBack ourCallback = new SimpleMqttCallBack();

    BrokerClient() {
        try {
            client = new MqttClient("tcp://traze.iteratec.de:1883", MqttClient.generateClientId());
            client.setCallback(ourCallback);
            client.connect();
            client.subscribe("traze/1/grid");

            String name = join("Mirco");
            client.subscribe("traze/1/player/" + name);

//            client.subscribe("traze/1/players");
//            client.subscribe("traze/1/ticker");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String join(String nickname) {
        String topic = "traze/1/join";

        String uniqueName = "" + UUID.randomUUID();
        JSONObject joiningPlayer = new JSONObject("{\"name\": \"" + nickname + "\",\"mqttClientName\": \"" + uniqueName + "\"}");
        System.out.println(joiningPlayer.toString());

        MqttMessage message = new MqttMessage();
        message.setPayload(joiningPlayer.toString().getBytes());
        try {
            client.publish(topic, message);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return uniqueName;
    }

    public SimpleMqttCallBack getCallBack() {
        return ourCallback;
    }
}
