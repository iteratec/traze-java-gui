package iteratec.mircomarcelalex.traze;

import static iteratec.mircomarcelalex.traze.TrazeClient.my_current_course;

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
//        Point currentBikeLocation = getCurrentBikeLocation();
//        if (currentBikeLocation.x == 0) {
//            current_course = "E";
//            TrazeClient.buildSteerMessage();
//        } else if (currentBikeLocation.x == 61) {
//            current_course = "W";
//            TrazeClient.buildSteerMessage();
//        }
//        if (currentBikeLocation.y == 0) {
//            current_course = "S";
//            TrazeClient.buildSteerMessage();
//        } else if (currentBikeLocation.y == 61) {
//            current_course = "N";
//            TrazeClient.buildSteerMessage();
//        }
    }
}
