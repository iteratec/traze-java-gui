package iteratec.mircomarcelalex.traze;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttMessage;

class BrokerClient {

    BrokerClient() {
        MqttClient client = null;
        try {
            client = new MqttClient("tcp://localhost:1883", MqttClient.generateClientId());
            client.connect();
            MqttMessage message = new MqttMessage();
            message.setPayload("Hello world from Java".getBytes());
            client.publish("iot_data", message);
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
