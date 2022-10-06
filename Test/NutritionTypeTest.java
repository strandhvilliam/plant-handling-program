import Model.NutritionType;
import org.junit.jupiter.api.Test;

class NutritionTypeTest {

    public NutritionType nutritionType = NutritionType.PROTEIN;

    @Test
    void getTypeDescription() {
        assert(nutritionType.getTypeDescription().equals("Proteindryck"));
    }
}