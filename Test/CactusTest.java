import Model.Cactus;
import Model.NutritionType;
import org.junit.jupiter.api.Test;

class CactusTest {


    public Cactus cactus = new Cactus("Model.Cactus", 0.6, 1.2);

    @Test
    void getThornLength() {
        assert(cactus.getThornLength() == 1.2);
        assert(cactus.getThornLength() != 2.4);
    }

    @Test
    void setThornLength() {
        assert(cactus.getThornLength() == 1.2);
        cactus.setThornLength(2.4);
        assert(cactus.getThornLength() == 2.4);
        assert(cactus.getThornLength() != 1.2);
    }

    @Test
    void getNutritionType() {
        assert(cactus.getNutritionType() == NutritionType.MINERAL);
        assert(cactus.getNutritionType() != NutritionType.PROTEIN);
        assert(cactus.getNutritionType().getTypeDescription().equals("Mineralvatten"));
        assert(!cactus.getNutritionType().getTypeDescription().equals("Proteindryck"));
    }

    @Test
    void calculateDailyWaterAmount() {
        assert(cactus.calculateDailyWaterAmount() == 0.2);
        assert(cactus.calculateDailyWaterAmount() != 0.4);
    }
}