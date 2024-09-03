import java.io.*;
import java.util.List;

public class ClosetWriter {
    private static final String FILE_NAME = "closet.txt";

    public static void loadCloset(List<ClothingItem> closet) {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            loadClosetFromFile(closet);
        } else {
            addDefaultClothes(closet);
            saveCloset(closet);
        }
    }

    private static void loadClosetFromFile(List<ClothingItem> closet) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 7) {
                    String name = parts[0];
                    char type = parts[1].charAt(0);
                    String color = parts[2];
                    int warmth = Integer.parseInt(parts[3]);
                    int formality = Integer.parseInt(parts[4]);
                    int breathability = Integer.parseInt(parts[5]);
                    boolean rainAppropriate = Boolean.parseBoolean(parts[6]);
                    closet.add(new ClothingItem(name, type, color, warmth, formality, breathability, rainAppropriate));
                }
            }
        } catch (IOException e) {
            System.err.println("Error loading closet: " + e.getMessage());
        }
    }

    private static void addDefaultClothes(List<ClothingItem> closet) {
        closet.add(new ClothingItem("T-Shirt", 't', "Red", 3, 1, 7, false));
        closet.add(new ClothingItem("Jeans", 'b', "Blue", 5, 2, 5, false));
        closet.add(new ClothingItem("Sneakers", 's', "White", 4, 1, 6, true));
        closet.add(new ClothingItem("Hat", 'h', "Black", 2, 1, 9, false));
        closet.add(new ClothingItem("Suit Jacket", 'c', "Gray", 8, 5, 3, false));
        closet.add(new ClothingItem("Overcoat", 'o', "Black", 9, 4, 2, true));
    }

    public static void saveCloset(List<ClothingItem> closet) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (ClothingItem item : closet) {
                writer.write(item.toFileString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error saving closet: " + e.getMessage());
        }
    }
}