package iteratec.mircomarcelalex.traze.content;

import java.awt.*;

public class Grid {

    private int height;
    private int width;
    private Point[] tiles;
    private Bike[] bikes;
    private Point[] spawns;

    public Grid(int height, int width, Point[] tiles, Bike[] bikes, Point[] spawns) {
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

    public Point[] getTiles() {
        return tiles;
    }

    public void setTiles(Point[] tiles) {
        this.tiles = tiles;
    }

    public Bike[] getBikes() {
        return bikes;
    }

    public void setBikes(Bike[] bikes) {
        this.bikes = bikes;
    }

    public Point[] getSpawns() {
        return spawns;
    }

    public void setSpawns(Point[] spawns) {
        this.spawns = spawns;
    }


}
