import java.util.*;

public class ClothingRecommenderCLI {
    private static List<ClothingItem> closet = new ArrayList<>();

    public static void main(String[] args) {
        ClosetWriter.loadCloset(closet);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println();
            System.out.println("Welcome to the Clothing Recommender!");
            System.out.println();
            System.out.println("1. Add new clothing item");
            System.out.println("2. Recommend an outfit");
            System.out.println("3. View closet");
            System.out.println("4. Exit");
            System.out.println();
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    AddToCloset.addClothingItem(scanner, closet);
                    break;
                case 2:
                    WeatherAlgo.recommendOutfit(scanner, closet);
                    break;
                case 3:
                    ClosetViewer.viewCloset(closet, scanner); //call ClosetViewer to view closet
                    break;
                case 4:
                    ClosetWriter.saveCloset(closet); // Save the closet when exiting the program
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

}