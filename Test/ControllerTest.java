import Model.Cactus;
import Model.Palm;
import Model.Plant;
import View.MainView;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

class ControllerTest {

    MainView mainView = new MainView("TestTitle");

    List<Plant> plants = new ArrayList<>(List.of(
            new Palm("TestPalm", 10, 5),
            new Cactus("TestKaktus", 0.2, 2)));


    Controller controller = new Controller(mainView, plants);

    @Test
    void addDataToList() {
        ListModel<String> testModel = controller.addDataToList(plants);
        assert(testModel.getElementAt(0).equals("Palmen TestPalm"));
        assert(testModel.getElementAt(1).equals("Kaktusen TestKaktus"));
        assert(!testModel.getElementAt(0).equals("Palmen Felaktig"));
    }


    @Test
    void checkIfPlantExists() {
        Plant testPlant = controller.checkIfPlantExists("TestPalm", plants);
        assert(testPlant.getName().equals("TestPalm"));

        Plant wrongPlant = controller.checkIfPlantExists("WrongPlant", plants);
        assert(wrongPlant == null);
    }

}