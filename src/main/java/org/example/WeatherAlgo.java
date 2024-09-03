import java.util.*;

public class WeatherAlgo {

    public static void recommendOutfit(Scanner scanner, List<ClothingItem> closet) {
        System.out.print("Do you want to input temperature in Fahrenheit (f) or Celsius (c)? ");
        char tempUnit = scanner.nextLine().charAt(0);
        System.out.print("What is the temperature? ");
        int temperature = scanner.nextInt();
        System.out.print("What is the cloud cover (0-100)? ");
        int cloudCover = scanner.nextInt();
        System.out.print("What is the humidity (0-100)? ");
        int humidity = scanner.nextInt();
        System.out.print("What is the probability of rain (0-100)? ");
        int rainProbability = scanner.nextInt();
        System.out.print("What is the desired level of formality on a scale of 1-5? ");
        int formality = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (tempUnit == 'f') {
            temperature = (temperature - 32) * 5 / 9; // Convert to Celsius
        }

        List<ClothingItem> recommendedOutfit = OutfitRecommender.findBestOutfit(closet, temperature, humidity, rainProbability, formality);

        System.out.println("Recommended outfit:");
        for (ClothingItem item : recommendedOutfit) {
            System.out.println(item);
        }
    }
}