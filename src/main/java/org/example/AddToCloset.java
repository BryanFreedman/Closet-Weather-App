import java.util.List;
import java.util.List;
import java.util.Scanner;

public class AddToCloset {

    public static void addClothingItem(Scanner scanner, List<ClothingItem> closet) {
        System.out.print("What is the item called? ");
        String name = scanner.nextLine();
        System.out.print("Is it a top (t), bottom (b), shoe (s), hat (h), accessory (a), coat (c), overwear (o)? ");
        char type = scanner.nextLine().charAt(0);
        System.out.print("What color is it? ");
        String color = scanner.nextLine();
        System.out.print("How warm is the item of clothing from a scale of 1-10? ");
        int warmth = scanner.nextInt();
        System.out.print("What is this item's level of formality on a scale of 1-5? ");
        int formality = scanner.nextInt();
        System.out.print("How breathable is the item of clothing from a scale of 1-10? ");
        int breathability = scanner.nextInt();
        System.out.print("Is this item appropriate for rain (true/false)? ");
        boolean rainAppropriate = scanner.nextBoolean();
        scanner.nextLine(); // Consume newline

        ClothingItem item = new ClothingItem(name, type, color, warmth, formality, breathability, rainAppropriate);
        closet.add(item);
        System.out.println("Clothing item added successfully!");

        ClosetWriter.saveCloset(closet); // Save the closet after adding the new item
    }
}