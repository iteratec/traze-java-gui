package iteratec.mircomarcelalex.traze;

import static iteratec.mircomarcelalex.traze.TrazeClient.my_current_course;
import static iteratec.mircomarcelalex.traze.TrazeClient.my_current_location;

class Brain {

    static int xMax = 62;
    static int yMax = 62;

    Brain(int xMax, int yMax) {
        Brain.xMax = xMax;
        Brain.yMax = yMax;
    }

    static String calculateNextDirection(String wantedDirection) {
        if (my_current_course != null) {
            switch (my_current_course) {
                case "N":
                    if (wantedDirection.equals("S")) {
                        return "E";
                    }
                    break;
                case "E":
                    if (wantedDirection.equals("W")) {
                        return "N";
                    }
                    break;
                case "S":
                    if (wantedDirection.equals("N")) {
                        return "E";
                    }
                    break;
                case "W":
                    if (wantedDirection.equals("E")) {
                        return "N";
                    }
                    break;
            }
        }
        return wantedDirection;
    }

    static void calculateNextDirection() {
        if (my_current_location != null && my_current_course != null) {
            if (my_current_location.x == 0 && my_current_course.equals("W")) {
                if (my_current_location.y < yMax / 2)
                    my_current_course = "N";
                else
                    my_current_course = "S";
                TrazeClient.buildSteerMessage();
            } else if (my_current_location.x == 61 && my_current_course.equals("E")) {
                if (my_current_location.y < yMax / 2)
                    my_current_course = "N";
                else
                    my_current_course = "S";
                TrazeClient.buildSteerMessage();
            }
            if (my_current_location.y == 0 && my_current_course.equals("S")) {
                if (my_current_location.x < yMax / 2)
                    my_current_course = "E";
                else
                    my_current_course = "W";
                TrazeClient.buildSteerMessage();
            } else if (my_current_location.y == 61 && my_current_course.equals("N")) {
                if (my_current_location.x < yMax / 2)
                    my_current_course = "E";
                else
                    my_current_course = "W";
                TrazeClient.buildSteerMessage();
            }
        }
    }
}
