import Model.*;
import View.MainView;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class PlantHandlingProgram{

    public static void main(String[] args) {

        //Sätter look and feel på swing GUI element
        try {
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException |
               IllegalAccessException e) {
            e.printStackTrace();
        }

        Cactus igge = new Cactus("Igge", 0.2, 1.2);
        Palm laura = new Palm("Laura", 5, 2);
        Carnivorous meatLoaf = new Carnivorous("Meatloaf", 0.7, "Red");
        Palm putte = new Palm("Putte", 1, 4);

        List<Plant> plants = new ArrayList<>(List.of(igge, laura, meatLoaf, putte));

        MainView mainView = new MainView("Hotell Greenest");
        Controller controller = new Controller(mainView, plants);
    }

}