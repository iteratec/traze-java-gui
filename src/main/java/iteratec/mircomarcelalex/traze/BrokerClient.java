package iteratec.mircomarcelalex.traze;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttException;

class BrokerClient {

	private SimpleMqttCallBack ourCallback = new SimpleMqttCallBack();
	
    BrokerClient() {
        try {
            MqttClient client = new MqttClient("tcp://traze.iteratec.de:1883", MqttClient.generateClientId());
            client.setCallback(ourCallback);
            client.connect();
            client.subscribe("traze/1/grid");
            client.subscribe("traze/1/players");
            client.subscribe("traze/1/ticker");
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
    
    public SimpleMqttCallBack getCallBack(){
    	return ourCallback;
    }
}
