import java.io.IOException;
import java.util.Scanner;

/**
 * Crew Night Out: plan nights out with your friends.
 * Run from the project folder so the CSV files are found.
 */
public class CrewNightOut {
    public static void main(String[] args) throws IOException {
        DataStore data = new DataStore();
        data.load();
        Scanner in = new Scanner(System.in);

        System.out.println("Loaded " + data.places.size() + " places, "
                + data.friends.size() + " friends, " + data.ratings.size() + " ratings.");

        while (true) {
            System.out.println();
            System.out.println("=== Crew Night Out ===");
            System.out.println("1. Set up / view friend profiles");
            System.out.println("2. Where should we go?");
            System.out.println("3. Rate a night out");
            System.out.println("4. Quit");
            System.out.print("Choose 1-4: ");

            if (!in.hasNextLine()) {
                break;
            }
            String choice = in.nextLine().trim();
            switch (choice) {
                case "1" -> System.out.println("Profiles: coming soon!");
                case "2" -> System.out.println("Recommendations: coming soon!");
                case "3" -> System.out.println("Ratings: coming soon!");
                case "4" -> {
                    System.out.println("Have a great night out!");
                    return;
                }
                default -> System.out.println("Please type 1, 2, 3 or 4.");
            }
        }
    }
}
