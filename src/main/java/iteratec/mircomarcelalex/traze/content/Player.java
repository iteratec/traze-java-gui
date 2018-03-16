package iteratec.mircomarcelalex.traze.content;

public class Player {

    private int id;
    private String name;
    private String color;
    private int frags;
    private int owned;

    public Player(int id, String name, String color, int frags, int owned) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.frags = frags;
        this.owned = owned;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getFrags() {
        return frags;
    }

    public void setFrags(int frags) {
        this.frags = frags;
    }

    public int getOwned() {
        return owned;
    }

    public void setOwned(int owned) {
        this.owned = owned;
    }

}
