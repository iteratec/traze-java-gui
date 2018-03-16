package iteratec.mircomarcelalex.traze;

import iteratec.mircomarcelalex.traze.content.Coordination2D;

public class Brain {

    static int xMax = 62;
    static int yMax = 62;
    static String lastDirection;

    Brain(int xMax, int yMax) {
        Brain.xMax = xMax;
        Brain.yMax = yMax;
    }

    static void calculateNextDirection(String wantedDirection, Coordination2D location) {
        if (lastDirection == null) {
            lastDirection = wantedDirection;
        } else {
            if (lastDirection.equals("N")) {
                if (wantedDirection.equals("S")) {
                    TrazeClient.current_course = "E";
                }
            } else if (lastDirection.equals("E")) {
                if (wantedDirection.equals("W")) {
                    TrazeClient.current_course = "N";
                }
            } else if (lastDirection.equals("S")) {
                if (wantedDirection.equals("N")) {
                    TrazeClient.current_course = "E";
                }
            } else if (lastDirection.equals("W")) {
                if (wantedDirection.equals("E")) {
                    TrazeClient.current_course = "N";
                }
            }

        }

    }
}
