package Model;

public class Palm extends Plant implements Waterable {

    private static final NutritionType NUTRITION_TYPE = NutritionType.TAP;

    private static final double BASE_WATER_AMOUNT = 0.5;

    private int stemWidth;

    public Palm(String name, double height, int stemWidth) {
        super(name, height);
        this.stemWidth = stemWidth;
    }

    public int getStemWidth() {
        return stemWidth;
    }

    public void setStemWidth(int stemWidth) {
        this.stemWidth = stemWidth;
    }

    @Override
    public NutritionType getNutritionType() {
        return NUTRITION_TYPE;
    }

    @Override
    public double calculateDailyWaterAmount() {
        return BASE_WATER_AMOUNT * height;
    }

    @Override
    public String toString() {
        String plantTypeInSwedish = "Palmen ";
        return plantTypeInSwedish + name;
    }
}
