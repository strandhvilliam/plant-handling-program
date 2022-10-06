import Model.NutritionType;
import Model.Palm;
import org.junit.jupiter.api.Test;

class PalmTest {

    public Palm palm = new Palm("Laura", 3, 5);

    @Test
    void getStemWidth() {
        assert(palm.getStemWidth() == 5);
        assert(palm.getStemWidth() != 10);
    }

    @Test
    void setStemWidth() {
        assert(palm.getStemWidth() == 5);
        palm.setStemWidth(10);
        assert(palm.getStemWidth() == 10);
        assert(palm.getStemWidth() != 5);
    }

    @Test
    void getNutritionType() {
        assert(palm.getNutritionType() == NutritionType.TAP);
        assert(palm.getNutritionType() != NutritionType.MINERAL);
        assert(palm.getNutritionType().getTypeDescription().equals("Kranvatten"));
        assert(!palm.getNutritionType().getTypeDescription().equals("Mineralvatten"));
    }

    @Test
    void calculateDailyWaterAmount() {
        assert(palm.calculateDailyWaterAmount() == 1.5);
        assert(palm.calculateDailyWaterAmount() != 5);
    }
}