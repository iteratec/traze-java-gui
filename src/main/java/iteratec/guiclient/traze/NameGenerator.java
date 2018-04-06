package iteratec.guiclient.traze;

import java.util.Random;

class NameGenerator {

    private static String[] Beginning = {"Kr", "Ca", "Ra", "Mrok", "Cru",
            "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
            "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
            "Mar", "Luk"};
    private static String[] Middle = {"air", "ir", "mi", "sor", "mee", "clo",
            "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
            "marac", "zoir", "slamar", "salmar", "urak"};
    private static String[] End = {"d", "ed", "ark", "arc", "es", "er", "der",
            "tron", "med", "ure", "zur", "cred", "mur"};

    private static String[] heroes = {"Adam Warlock", "Americop", "Ant-Man", "Anti-Venom", "Black Bolt", "Black Panther", "Black Widow", "Blade", "Blue Marvel", "Bucky Barnes", "Captain America", "Captain Britain", "Captain Mar-Vell", "Cloak", "Dagger", "Daredevil", "Das Ding", "Deadpool", "Die menschliche Fackel", "Die Unsichtbare", "Doctor Strange", "Drax the Destroyer", "Elektra", "Falcon", "Gamora", "Ghost Rider", "Gorilla-Man", "Groot", "Hawkeye", "Daimon Hellstrom", "Howard the Duck", "Hulk", "Roter Hulk", "Hulkling", "Hybrid", "Iron Fist", "Iron Man", "Jewel", "Mister Fantastic", "Mockingbird", "Moon Knight", "Namor the Sub-Mariner", "Northstar", "Nova", "Star-Lord", "Power Man", "Punisher", "Quake", "Rocket Raccoon", "Silver Sable", "Silver Surfer", "Slingshot", "Spark Plug", "Speedball", "Spider-Man", "Squirrel Girl", "The Living Tribunal", "Thor", "Vision", "War Machine", "Wasp"};

    private static Random rand = new Random();

    static String generateName() {
        return Beginning[rand.nextInt(Beginning.length)] +
                Middle[rand.nextInt(Middle.length)] +
                End[rand.nextInt(End.length)];

    }

    static String generateHeroName() {
        return heroes[rand.nextInt(heroes.length)];
    }
}
