import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClosetViewer {

    public static void viewCloset(List<ClothingItem> closet, Scanner scanner) {
        // Sort closet by type and then by name within each type
        Collections.sort(closet, new Comparator<ClothingItem>() {
            @Override
            public int compare(ClothingItem item1, ClothingItem item2) {
                int typeComparison = Character.compare(item1.getType(), item2.getType());
                if (typeComparison == 0) {
                    return item1.getName().compareTo(item2.getName());
                }
                return typeComparison;
            }
        });

        if (closet.isEmpty()) {
            System.out.println("The closet is empty.");
            return; // Exit method if closet is empty
        }

        System.out.println();
        System.out.println("Types available: t (top), b (bottom), s (shoe), h (hat), a (accessory), c (coat), o (overwear)");
        System.out.println();
        System.out.print("Enter type of clothing you would like to see: ");
        char typeSelection = scanner.nextLine().charAt(0);
        String convertedTypeSelection = "";

        // Convert type selection to a descriptive string
        switch (typeSelection) {
            case 't':
                convertedTypeSelection = "Tops";
                break;
            case 'b':
                convertedTypeSelection = "Bottoms";
                break;
            case 's':
                convertedTypeSelection = "Shoes";
                break;
            case 'h':
                convertedTypeSelection = "Hats";
                break;
            case 'a':
                convertedTypeSelection = "Accessories";
                break;
            case 'c':
                convertedTypeSelection = "Coats";
                break;
            case 'o':
                convertedTypeSelection = "Overwear";
                break;
            default:
                System.out.println("Invalid clothing type selection.");
                return; // Exit method if invalid type selected
        }

        System.out.println();
        System.out.println("Filtered closet contents for type: " + convertedTypeSelection);

        // Prepare legend bar
        String legend = String.format("%-20s | %-7s | %-12s | %-17s | %-17s | %-15s",
                "Name", "Color", "Warmth", "Formality", "Breathability", "Rain Appropriate");
        String divider = "--------------------------------------------------------------------------------------------------------";

        System.out.println(divider);
        System.out.println(legend);
        System.out.println(divider);

        // Display items of the selected type
        boolean foundItems = false;
        for (ClothingItem item : closet) {
            if (item.getType() == typeSelection) {
                System.out.printf("%-20s | %-7s | %-12d | %-17d | %-17d | %-15s%n",
                        item.getName(), item.getColor(), item.getWarmth(),
                        item.getFormality(), item.getBreathability(), item.isRainAppropriate());
                foundItems = true;
            }
        }

        if (!foundItems) {
            System.out.println("No items found for selected type.");
        }

        System.out.println(divider);
    }
}