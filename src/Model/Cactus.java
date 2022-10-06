package Model;

//implementerar interface i subklasserna istället för i superklass utifall finns en planta som inte ska vattnas
public class Cactus extends Plant implements Waterable {

    private static final NutritionType NUTRITION_TYPE = NutritionType.MINERAL; //enum som konstant
    private static final double BASE_WATER_AMOUNT = 0.02;
    private double thornLength;

    public Cactus(String name, double height, double thornLength) {
        super(name, height);
        this.thornLength = thornLength;
    }


    //Inkapsling av variabler som kan hämtas eller ändras med getters/setters
    public double getThornLength() {
        return thornLength;
    }
    public void setThornLength(double thornLength) {
        this.thornLength = thornLength;
    }

    @Override //override av metoder från waterable interface
    public NutritionType getNutritionType() {
        return NUTRITION_TYPE;
    }

    @Override //override av metoder från waterable interface
    public double calculateDailyWaterAmount() {
        return BASE_WATER_AMOUNT;
    }

    @Override //override av metod från superklass Plant
    public String toString() {
        String plantTypeInSwedish = "Kaktusen ";
        return plantTypeInSwedish + name;
    }
}
