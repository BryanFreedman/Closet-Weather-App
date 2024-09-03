public class ClothingItem {
    private String name;
    private char type;
    private String color;
    private int warmth;
    private int formality;
    private int breathability;
    private boolean rainAppropriate;

    public ClothingItem(String name, char type, String color, int warmth, int formality, int breathability, boolean rainAppropriate) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.warmth = warmth;
        this.formality = formality;
        this.breathability = breathability;
        this.rainAppropriate = rainAppropriate;
    }

    public String getName() {
        return name;
    }

    public char getType() {
        return type;
    }

    public String getColor() {
        return color;
    }

    public int getWarmth() {
        return warmth;
    }

    public int getFormality() {
        return formality;
    }

    public int getBreathability() {
        return breathability;
    }

    public boolean isRainAppropriate() {
        return rainAppropriate;
    }

    public String toFileString() {
        return String.format("%s|%c|%s|%d|%d|%d|%b", name, type, color, warmth, formality, breathability, rainAppropriate);
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - Color: %s, Warmth: %d, Formality: %d, Breathability: %d, Rain Appropriate: %b", name, type, color, warmth, formality, breathability, rainAppropriate);
    }
}