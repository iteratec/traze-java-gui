package iteratec.mircomarcelalex.traze.content;

import java.awt.*;

public class Bike {
	
	private int playerId;
	private Point currentLocation;
	private String direction;
	private Point[] trail;

	public Bike(int playerId, Point currentLocation, String direction, Point[] trail) {
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

	public Point getCurrentLocation() {
		return currentLocation;
	}

	public void setCurrentLocation(Point currentLocation) {
		this.currentLocation = currentLocation;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

	public Point[] getTrail() {
		return trail;
	}

	public void setTrail(Point[] trail) {
		this.trail = trail;
	}
	
	

}
