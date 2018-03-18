package iteratec.mircomarcelalex.traze;

class Brain {

    static int xMax = 62;
    static int yMax = 62;

    Brain(int xMax, int yMax) {
        Brain.xMax = xMax;
        Brain.yMax = yMax;
    }

    static String calculateNextDirection(String wantedDirection) {
        if (TrazeClient.current_course != null) {
            switch (TrazeClient.current_course) {
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
}
