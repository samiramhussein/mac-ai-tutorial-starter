/**
 * A place the crew can go: a restaurant, bar, activity, music venue or night out spot.
 * CSV format: name,type,style,cost,vibe
 */
public class Place {
    static final String[] TYPES = {"food", "bar", "activity", "music", "night out"};

    String name;
    String type;   // one of TYPES
    String style;  // cuisine or style, like "tacos", "karaoke" or "jazz"
    int cost;      // usual cost per person, in dollars
    String vibe;   // chill, lively or fancy

    Place(String name, String type, String style, int cost, String vibe) {
        this.name = name;
        this.type = type;
        this.style = style;
        this.cost = cost;
        this.vibe = vibe;
    }

    static Place fromCsv(String line) {
        String[] parts = line.split(",", -1);
        return new Place(parts[0].trim(), parts[1].trim(), parts[2].trim(),
                Integer.parseInt(parts[3].trim()), parts[4].trim());
    }

    String toCsv() {
        return String.join(",", name, type, style, String.valueOf(cost), vibe);
    }

    @Override
    public String toString() {
        return name + " (" + type + ", " + style + ", ~$" + cost + " each, " + vibe + ")";
    }
}
