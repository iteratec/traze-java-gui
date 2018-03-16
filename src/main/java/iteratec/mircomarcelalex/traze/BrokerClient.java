package iteratec.mircomarcelalex.traze;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

class BrokerClient {

    BrokerClient() {
        try {
            MqttClient client = new MqttClient("tcp://traze.iteratec.de:1883", MqttClient.generateClientId());
            client.setCallback(new SimpleMqttCallBack());
            client.connect();
            client.subscribe("traze/games");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
