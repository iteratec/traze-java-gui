package iteratec.mircomarcelalex.traze;

import static iteratec.mircomarcelalex.traze.TrazeClient.*;

class Brain {

    static int xMax = 61;
    static int yMax = 61;

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
        if (my_current_location != null && my_current_course != null && my_trail != null) {
            switch (my_current_course) {
                case "N":
                    if (!northIsFree()) {
                        eastOrWest();
                    } else
//                        System.out.println("North is free");
                    break;
                case "E":
                    if (!eastIsFree()) {
                        northOrSouth();
                    } else
//                        System.out.println("East is free");
                    break;
                case "S":
                    if (!southIsFree()) {
                        eastOrWest();
                    } else
//                        System.out.println("South is free");
                    break;
                case "W":
                    if (!westIsFree()) {
                        northOrSouth();
                    } else
//                        System.out.println("West is free");
                    break;
            }
            TrazeClient.buildSteerMessage();
        }
    }

    private static boolean northIsFree() {
        try {
            return grid.getTiles()[my_current_location.x][my_current_location.y + 1] == 0 && my_current_location.y < yMax;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private static boolean southIsFree() {
        try {
            return grid.getTiles()[my_current_location.x][my_current_location.y - 1] == 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private static boolean eastIsFree() {
        try {
            return grid.getTiles()[my_current_location.x + 1][my_current_location.y] == 0 && my_current_location.x < xMax;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private static boolean westIsFree() {
        try {
            return grid.getTiles()[my_current_location.x - 1][my_current_location.y] == 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            return false;
        }
    }

    private static void eastOrWest() {
        if (eastIsFree() && westIsFree()) {
            if (my_current_location.x < xMax / 2) {
                my_current_course = "E";
            } else {
                my_current_course = "W";
            }
        } else if (eastIsFree()) {
            my_current_course = "E";
        } else if (westIsFree()) {
            my_current_course = "W";
        }
    }

    private static void northOrSouth() {
        if (northIsFree() && southIsFree()) {
            if (my_current_location.y < yMax / 2) {
                my_current_course = "N";
            } else {
                my_current_course = "S";
            }
        } else if (northIsFree()) {
            my_current_course = "N";
        } else if (southIsFree()) {
            my_current_course = "S";
        }
    }
}
