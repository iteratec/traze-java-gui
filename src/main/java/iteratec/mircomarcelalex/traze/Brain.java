package iteratec.mircomarcelalex.traze;

import java.awt.*;

public class Brain {

    static int xMax = 62;
    static int yMax = 62;

    Brain(int xMax, int yMax) {
        Brain.xMax = xMax;
        Brain.yMax = yMax;
    }

    static void calculateNextDirection(String wantedDirection, Point location) {
        if (wantedDirection != null) {
            System.out.println("last: " + TrazeClient.current_course + ", want: " + wantedDirection);
            if (TrazeClient.current_course.equals("N")) {
                if (wantedDirection.equals("S")) {
                    TrazeClient.current_course = "E";
                }
            } else if (TrazeClient.current_course.equals("E")) {
                if (wantedDirection.equals("W")) {
                    TrazeClient.current_course = "N";
                }
            } else if (TrazeClient.current_course.equals("S")) {
                if (wantedDirection.equals("N")) {
                    TrazeClient.current_course = "E";
                }
            } else if (TrazeClient.current_course.equals("W")) {
                if (wantedDirection.equals("E")) {
                    TrazeClient.current_course = "N";
                }
            }

        }

    }
}
