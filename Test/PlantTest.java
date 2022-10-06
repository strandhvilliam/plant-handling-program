import Model.Cactus;
import Model.Plant;
import org.junit.jupiter.api.Test;

class PlantTest {

    Plant plant = new Cactus("Cactus", 0.2, 2);

    @Test
    void getName() {
        assert(plant.getName().equals("Cactus"));
        assert(!plant.getName().equals("Cactus2"));
    }

    @Test
    void getHeight() {
        assert(plant.getHeight() == 0.2);
        assert(plant.getHeight() != 0.4);
    }
}