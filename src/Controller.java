import Model.*;
import View.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private MainView mainView;
    private List<Plant> plants;

    public Controller(MainView view, List<Plant> p) {
        mainView = view;
        plants = new ArrayList<>(p); //shallow copy

        //Knappen som utför koden som visar mängden vatten för valda växten
        mainView.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textInput = mainView.getTextField().getText(); //hämtar text från textfältet
                Plant plant = checkIfPlantExists(textInput, plants); //kollar om planten finns i listan
                displayAmountToWater(plant); //visar mängden vatten som ska ges
            }
        });
        mainView.getTextField().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textInput = mainView.getTextField().getText();
                Plant plant = checkIfPlantExists(textInput, plants);
                displayAmountToWater(plant);
            }
        });
        mainView.getList().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                mainView.getTextField().setText(mainView.getList().getSelectedValue());
            }
        });
        mainView.getNewPlantButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plant newPlant = createNewPlant();
                if (newPlant != null) {
                    plants.add(newPlant);
                    updateList();
                }
            }
        });
        updateList();
    }


    /**
     * Metoden öppnar en ny dialogruta där användaren kan skapa en ny planta.
     * Konverterar PlantTyper till en String för att kunna skicka med i dialogrutan.
     * Hanterar inmatningen och skapar en planta av den inmatade datan.
     * @return ny planta eller null om användaren avbryter.
     */
    public Plant createNewPlant() {

        //Skapar strängar för att skicka in i InputPanelViews combobox
        String[] plantTypes = PlantType.getAllTypeDescriptions();
        InputPanelView panel = new InputPanelView(plantTypes);

        int choice = JOptionPane.showConfirmDialog(null, panel, "Ny planta", JOptionPane.OK_CANCEL_OPTION);
        try {
            if (choice == JOptionPane.OK_OPTION) {
                String plantName = panel.getNameTextField().getText();
                double plantHeight = Double.parseDouble(panel.getHeightTextField().getText());
                String selectedPlantType = (String) panel.getPlantTypeComboBox().getSelectedItem();

                Plant newPlant = null;
                String standardColor = "red";
                int standardInteger = 1;

                //Beroende på vilken planta som valts i JComboBox skapas olika typer av plantor
                //(anteckning till mig själv: bygg om så att man kan lägga till fler arter utan att behöva ändra i koden)
                if (selectedPlantType.equals(PlantType.CACTUS.getPlantType())) {
                    newPlant = new Cactus(plantName, plantHeight, standardInteger);
                } else if (selectedPlantType.equals(PlantType.PALM.getPlantType())) {
                    newPlant = new Palm(plantName, plantHeight, standardInteger);
                } else if (selectedPlantType.equals(PlantType.CARNIVOROUS.getPlantType())) {
                    newPlant = new Carnivorous(plantName, plantHeight, standardColor);
                } else if (selectedPlantType.equals(PlantType.ZZ_PLANT.getPlantType())) {
                    newPlant = new ZZPlant(plantName, plantHeight);
                }
                return newPlant;
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Ogiltig inmatning");
            return null;
        }

    }

    /**
     * Metoden uppdaterar listan med plantor i mainView
     */
    public void updateList() {
        ListModel<String> listModel = addDataToList(plants); //default listmodel
        mainView.getList().setModel(listModel);
        mainView.getScrollPane().setViewportView(mainView.getList());
        mainView.getList().ensureIndexIsVisible(mainView.getList().getModel().getSize() - 1); //scrollar till botten
    }

    /**
     * Metoden lägger till plantorna i en listModel för att senare visas i JList
     * Använder polymorfism för att få fram olika strängar beroende av objekt.
     * @param data är en lista med plant-objekt
     * @return en listModel med strängar som ska visas i JList
     */
    public ListModel<String> addDataToList(List<Plant> data) {
        List<String> stringData = new ArrayList<>();

        //POLYMORFISM - samma metod, olika strängar
        for (Plant plant : data) {
            stringData.add(plant.toString());
        }
        DefaultListModel<String> listModel = new DefaultListModel<>();
        listModel.addAll(stringData);
        return listModel;
    }

    /**
     * Metoden kontrollerar om en planta finns i listan med plantor.
     * @param textInput är namnet på plantan som användaren matat in
     * @param plants är en lista med plantor som ska jämföras
     * @return en planta om den finns i listan, annars null
     */
    public Plant checkIfPlantExists(String textInput, List<Plant> plants) {
        Plant validPlant = null;
        for (Plant plant : plants) {
            if (textInput.toLowerCase().contains(plant.getName().toLowerCase())) {
                validPlant = plant;
            }
        }
        return validPlant;
    }

    /**
     * Metoden skriver ut hur mycket vatten en planta behöver.
     * Använder polymorfism för att beräkna olika mängder vatten beroende på objekt.
     * Om parametern är null skrivs ett felmeddelande ut.
     * @param plant är en planta som ska beräknas, eller null om inte finns
     */
    public void displayAmountToWater(Plant plant) {
        String message;
        if (plant == null) {
            message = "Växten finns inte";
            JOptionPane.showMessageDialog(null, message);

        } else if (plant instanceof Waterable) {
            Waterable plantToWater = (Waterable) plant;
            double waterAmount = plantToWater.calculateDailyWaterAmount(); //Polymorfism, samma metod med olika resultat
            message = String.format("Näringstyp: %s%nMängd(l): %.2f", plantToWater.getNutritionType().getTypeDescription(), waterAmount);
            JOptionPane.showMessageDialog(null, message);

        } else {
            message = "Växten behöver inte vattnas";
            JOptionPane.showMessageDialog(null, message);
        }
    }


}
