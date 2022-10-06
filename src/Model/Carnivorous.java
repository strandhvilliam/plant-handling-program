package Model;

public class Carnivorous extends Plant implements Waterable {

    private static final NutritionType NUTRITION_TYPE = NutritionType.PROTEIN;
    private static final double BASE_WATER_AMOUNT = 0.1;
    private static final double EXTRA_WATER_AMOUNT = 0.2;

    private String color;

    public Carnivorous(String name, double height, String color) {
        super(name, height);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public NutritionType getNutritionType() {
        return NUTRITION_TYPE;
    }

    @Override
    public double calculateDailyWaterAmount() {
        return BASE_WATER_AMOUNT + (height * EXTRA_WATER_AMOUNT);
    }

    @Override
    public String toString() {
        String plantTypeInSwedish = "Köttätande växten ";
        return plantTypeInSwedish + name;
    }
}


