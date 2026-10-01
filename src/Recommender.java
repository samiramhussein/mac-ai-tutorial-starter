import java.util.ArrayList;
import java.util.List;

/**
 * Picks places for the crew and friends to invite.
 * The real scoring comes in later steps. For now these are placeholders.
 */
public class Recommender {
    DataStore data;

    Recommender(DataStore data) {
        this.data = data;
    }

    /**
     * Returns the places with the highest average fun that fit the budget.
     * type can be "any". TODO: filter by budget and type, sort by average fun.
     */
    List<Place> topPlaces(String type, int budget, int howMany) {
        List<Place> result = new ArrayList<>();
        for (int i = 0; i < Math.min(howMany, data.places.size()); i++) {
            result.add(data.places.get(i));
        }
        return result;
    }

    /** Returns friends ranked by how much they'd like this place. TODO: real scoring. */
    List<Friend> whoToInvite(Place place) {
        return new ArrayList<>(data.friends);
    }
}
