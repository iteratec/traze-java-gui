package iteratec.mircomarcelalex.traze.content;

public class Bike {
	
	private int playerId;
	private Coordination2D currentLocation;
	private String direction;
	private Coordination2D[] trail;
	
	public Bike(int playerId, Coordination2D currentLocation, String direction, Coordination2D[] trail) {
		this.playerId = playerId;
		this.currentLocation = currentLocation;
		this.direction = direction;
		this.trail = trail;
	}
	
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public Coordination2D getCurrentLocation() {
		return currentLocation;
	}
	public void setCurrentLocation(Coordination2D currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public Coordination2D[] getTrail() {
		return trail;
	}
	public void setTrail(Coordination2D[] trail) {
		this.trail = trail;
	}
	
	

}
