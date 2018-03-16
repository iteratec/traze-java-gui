package iteratec.mircomarcelalex.traze.content;

public class Grid {
	
	private int gridWidth;
	private int gridHeight;
	private int[][] map;
	private Bike[] bikes;
	private Coordination2D[] spawns;
	
	public Grid(int[][] map, Bike[] bikes, Coordination2D[] spawns) {
		this.map = map;
		this.bikes = bikes;
		this.spawns = spawns;
//		this.gridWidth = map[0].length;
//		this.gridHeight = height;
	}

	public int getGridWidth() {
		return gridWidth;
	}

	public void setGridWidth(int gridWidth) {
		this.gridWidth = gridWidth;
	}

	public int getGridHeight() {
		return gridHeight;
	}

	public void setGridHeight(int gridHeight) {
		this.gridHeight = gridHeight;
	}

	public int[][] getMap() {
		return map;
	}

	public void setMap(int[][] map) {
		this.map = map;
	}

	public Bike[] getBikes() {
		return bikes;
	}

	public void setBikes(Bike[] bikes) {
		this.bikes = bikes;
	}

	public Coordination2D[] getSpawns() {
		return spawns;
	}

	public void setSpawns(Coordination2D[] spawns) {
		this.spawns = spawns;
	}

	
}
