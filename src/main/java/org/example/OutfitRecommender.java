import java.util.*;

public class OutfitRecommender {

    public static List<ClothingItem> findBestOutfit(List<ClothingItem> closet, int temperature, int humidity, int rainProbability, int formality) {
        List<ClothingItem> recommendedOutfit = new ArrayList<>();

        List<ClothingItem> possibleItems = new ArrayList<>(closet);
        possibleItems.sort(Comparator.comparingInt((ClothingItem item) -> calculateScore(item, temperature, humidity, rainProbability, formality)));

        for (ClothingItem item : possibleItems) {
            if (item.getFormality() == formality &&
                    ((temperature <= 20 && item.getWarmth() >= 7) || (temperature > 20 && item.getWarmth() <= 7)) &&
                    ((rainProbability > 50 && item.isRainAppropriate()) || rainProbability <= 50)) {
                recommendedOutfit.add(item);
            }
        }

        if (recommendedOutfit.isEmpty()) {
            recommendedOutfit.add(possibleItems.get(0));
        }

        return recommendedOutfit;
    }

    private static int calculateScore(ClothingItem item, int temperature, int humidity, int rainProbability, int formality) {
        int formalityScore = Math.abs(item.getFormality() - formality);
        int temperatureScore = Math.abs(item.getWarmth() - temperature);
        int breathabilityScore = Math.abs(item.getBreathability() - (humidity / 10));
        int rainScore = item.isRainAppropriate() ? 0 : (rainProbability > 50 ? 10 : 0);

        return formalityScore + temperatureScore + breathabilityScore + rainScore;
    }
}
