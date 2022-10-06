package Model;

public enum NutritionType {
    TAP("Kranvatten"),
    MINERAL("Mineralvatten"),
    PROTEIN("Proteindryck");

    private final String typeDescription;

    NutritionType(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public String getTypeDescription() {
        return typeDescription;
    }
}
