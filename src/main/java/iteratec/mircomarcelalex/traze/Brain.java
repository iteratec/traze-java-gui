package iteratec.mircomarcelalex.traze;

import iteratec.mircomarcelalex.traze.content.Coordination2D;

public class Brain {

    int xMax;
    int yMax;

    Brain(int xMax, int yMax) {
        this.xMax = xMax;
        this.yMax = yMax;
    }

    static void calculateNextDirection(String currentDirection, Coordination2D location) {
        System.out.println("You're at x: " + location.x + ", y: " + location.y + " and traveling to " + currentDirection);
    }
}
