package iteratec.mircomarcelalex.traze.content;

public class Grid {

    private int height;
    private int width;
    private int[][] tiles;
    private Bike[] bikes;
    private Coordination2D[] spawns;

    public Grid(int height, int width, int[][] tiles, Bike[] bikes, Coordination2D[] spawns) {
        this.tiles = tiles;
        this.bikes = bikes;
        this.spawns = spawns;
        this.height = height;
        this.width = width;
    }

    public Grid() {
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int[][] getTiles() {
        return tiles;
    }

    public void setTiles(int[][] tiles) {
        this.tiles = tiles;
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
