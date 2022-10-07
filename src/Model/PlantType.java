package Model;

public enum PlantType {
    CACTUS("Kaktus"),
    PALM("Palm"),
    CARNIVOROUS("Köttätande växt"),
    ZZ_PLANT("Garderobsblomma");

    private final String plantType;

    PlantType(String plantType) {
        this.plantType = plantType;
    }

    public String getPlantType() {
        return plantType;
    }

    public static String[] getAllTypeDescriptions() {
        String[] allTypeDescriptions = new String[PlantType.values().length];
        for (int i = 0; i < PlantType.values().length; i++) {
            allTypeDescriptions[i] = PlantType.values()[i].getPlantType();
        }
        return allTypeDescriptions;
    }

}
