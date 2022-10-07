package View;

import javax.swing.*;
import java.awt.*;

public class InputPanelView extends JPanel {

    private JLabel nameLabel;
    private JTextField nameTextField;
    private JLabel heightLabel;
    private JTextField heightTextField;

    private JLabel plantTypeLabel;
    private JComboBox<String> plantTypeComboBox;

    public InputPanelView(String[] plantTypes) {
        GridLayout layout = new GridLayout(3, 2);
        layout.setVgap(4);
        layout.setHgap(-44);
        setLayout(layout);

        Font regFont = new Font("Arial", Font.PLAIN, 14);

        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(regFont);
        nameTextField = new JTextField();
        heightLabel = new JLabel("Height: ");
        heightLabel.setFont(regFont);
        heightTextField = new JTextField();
        plantTypeLabel = new JLabel("Type: ");
        plantTypeLabel.setFont(regFont);
        plantTypeComboBox = new JComboBox<>(plantTypes);
        plantTypeComboBox.setFont(regFont);

        add(nameLabel);
        add(nameTextField);
        add(heightLabel);
        add(heightTextField);
        add(plantTypeLabel);
        add(plantTypeComboBox);

        setVisible(true);
    }

    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getHeightTextField() {
        return heightTextField;
    }

    public JComboBox<String> getPlantTypeComboBox() {
        return plantTypeComboBox;
    }
}
