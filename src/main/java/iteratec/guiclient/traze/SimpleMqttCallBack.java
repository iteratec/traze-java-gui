package iteratec.guiclient.traze;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;

public class SimpleMqttCallBack implements MqttCallback {

    public void connectionLost(Throwable throwable) {
        System.out.println("Connection to MQTT broker lost!");
        System.exit(0);
    }

    public void messageArrived(String topic, MqttMessage mqttMessage) throws Exception {
        if (topic.equals("traze/1/grid")) {
            TrazeClient.updateGrid(new String(mqttMessage.getPayload()));
        } else if (topic.equals("traze/1/player/" + BrokerClient.generatedClientId)) {
            TrazeClient.initPlayer(new String(mqttMessage.getPayload()));
        } else if (topic.equals("traze/1/players")) {
            TrazeClient.updateAllPlayers(new String(mqttMessage.getPayload()));
        }
    }

    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {
        // not used in this example
    }
}
