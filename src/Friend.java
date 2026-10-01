import java.util.ArrayList;
import java.util.List;

/**
 * A friend's profile: what they like and how much they want to spend.
 * CSV format: name,types,vibes,budget,likedPlaces
 * Lists inside a field are separated by semicolons, like "bar;music".
 */
public class Friend {
    String name;
    List<String> types;        // favorite types, like bar or activity
    List<String> vibes;        // favorite vibes, like chill or lively
    int budget;                // most they want to spend per night, in dollars
    List<String> likedPlaces;  // places they already like

    Friend(String name, List<String> types, List<String> vibes, int budget, List<String> likedPlaces) {
        this.name = name;
        this.types = types;
        this.vibes = vibes;
        this.budget = budget;
        this.likedPlaces = likedPlaces;
    }

    static Friend fromCsv(String line) {
        String[] parts = line.split(",", -1);
        return new Friend(parts[0].trim(), splitList(parts[1]), splitList(parts[2]),
                Integer.parseInt(parts[3].trim()), splitList(parts[4]));
    }

    String toCsv() {
        return String.join(",", name, String.join(";", types), String.join(";", vibes),
                String.valueOf(budget), String.join(";", likedPlaces));
    }

    /** Turns "a;b; c" into [a, b, c]. An empty field becomes an empty list. */
    static List<String> splitList(String field) {
        List<String> result = new ArrayList<>();
        for (String item : field.split(";")) {
            if (!item.trim().isEmpty()) {
                result.add(item.trim());
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return name + " | likes: " + types + " | vibes: " + vibes
                + " | budget: $" + budget + " | favorite spots: " + likedPlaces;
    }
}
