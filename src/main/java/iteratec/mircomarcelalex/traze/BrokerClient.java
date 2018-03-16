package iteratec.mircomarcelalex.traze;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

class BrokerClient {

    BrokerClient() {
        try {
            MqttClient client = new MqttClient("tcp://traze.iteratec.de:1883", MqttClient.generateClientId());
            client.setCallback(new SimpleMqttCallBack());
            client.connect();
            client.subscribe("traze/1/grid");
            client.subscribe("traze/1/players");
            client.subscribe("traze/1/ticker");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
