package iteratec.mircomarcelalex.traze;

import iteratec.mircomarcelalex.traze.content.Coordination2D;

public class Brain {

    static int xMax = 62;
    static int yMax = 62;

    Brain(int xMax, int yMax) {
        Brain.xMax = xMax;
        Brain.yMax = yMax;
    }

    static void calculateNextDirection(String currentDirection, Coordination2D location) {
        System.out.println("You're at x: " + location.x + ", y: " + location.y + " and traveling to " + currentDirection);
        if (location.x < xMax / 10){
            System.out.println("You should go North!");
        }
    }
}
