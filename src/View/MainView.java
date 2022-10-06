package View;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {

    private JLabel label;
    private JButton button;
    private JButton newPlantButton;
    private JTextField textField;
    private JList<String> list;
    private JScrollPane scrollPane;

    public MainView(String title) {
        Dimension windowSize = new Dimension(700, 300);
        setTitle(title);
        setSize(windowSize);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null); //centrerar fönstret
        setResizable(false);

        Font regularFont = new Font("Arial", Font.PLAIN, 16);
        Font boldFont = new Font("Arial", Font.BOLD, 16);

        //Initierar komponenter
        int labelX = 60, labelY = 40, labelWidth = 260, labelHeight = 40;
        String labelHeader = "Vilken växt ska få vätska?";
        label = new JLabel(labelHeader);
        label.setBounds(labelX, labelY, labelWidth, labelHeight);
        label.setFont(boldFont);
        label.setOpaque(true);

        int textFieldX = 60, textFieldY = 80, textFieldWidth = 240, textFieldHeight = 40;
        textField = new JTextField();
        textField.setBounds(textFieldX, textFieldY, textFieldWidth, textFieldHeight);
        textField.setFont(regularFont);

        String buttonText = "Ok";
        int buttonX = 60, buttonY = 130, buttonWidth = 80, buttonHeight = 40;
        button = new JButton(buttonText);
        button.setBounds(buttonX, buttonY, buttonWidth, buttonHeight);
        button.setFont(boldFont);

        list = new JList<>();
        list.setFont(regularFont);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setFixedCellHeight(28);

        int scrollPaneX = 380, scrollPaneY = 40, scrollPaneWidth = 280, scrollPaneHeight = 120;
        scrollPane = new JScrollPane();
        scrollPane.setBounds(scrollPaneX, scrollPaneY, scrollPaneWidth, scrollPaneHeight);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        String newPlantButtonText = "Lägg till växt";
        int newPlantButtonX = 380, newPlantButtonY = 170, newPlantButtonWidth = 150, newPlantButtonHeight = 40;
        newPlantButton = new JButton(newPlantButtonText);
        newPlantButton.setBounds(newPlantButtonX, newPlantButtonY, newPlantButtonWidth, newPlantButtonHeight);
        newPlantButton.setFont(boldFont);

        //Lägger till komponenter till fönstret
        add(label);
        add(button);
        add(textField);
        add(list);
        add(scrollPane);
        add(newPlantButton);
        setVisible(true);
    }

    public JLabel getLabel() {
        return label;
    }

    public JButton getButton() {
        return button;
    }

    public JTextField getTextField() {
        return textField;
    }

    public JList<String> getList() {
        return list;
    }

    public JButton getNewPlantButton() {
        return newPlantButton;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

}
