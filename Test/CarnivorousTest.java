import Model.Carnivorous;
import Model.NutritionType;
import org.junit.jupiter.api.Test;

class CarnivorousTest {


    public Carnivorous carnivorous = new Carnivorous("Model.Carnivorous", 0.5, "green");

    @Test
    void getColor() {
        assert(carnivorous.getColor().equals("green"));
        assert(!carnivorous.getColor().equals("blue"));
    }

    @Test
    void setColor() {
        assert(carnivorous.getColor().equals("green"));
        carnivorous.setColor("blue");
        assert(carnivorous.getColor().equals("blue"));
        assert(!carnivorous.getColor().equals("green"));
    }

    @Test
    void getNutritionType() {
        assert(carnivorous.getNutritionType() == NutritionType.PROTEIN);
        assert(carnivorous.getNutritionType() != NutritionType.MINERAL);
        assert(carnivorous.getNutritionType().getTypeDescription().equals("Proteindryck"));
        assert(!carnivorous.getNutritionType().getTypeDescription().equals("Mineralvatten"));
    }

    @Test
    void calculateDailyWaterAmount() {
        assert(carnivorous.calculateDailyWaterAmount() == 0.2);
        assert(carnivorous.calculateDailyWaterAmount() != 0.8);
    }
}