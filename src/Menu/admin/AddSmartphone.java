package Menu.admin;
import DataBase.PackageData;
import com.company.Smartphone;
import Main.Main;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddSmartphone extends Container {
    public AddSmartphone(){
        setSize(500, 500);
        setLayout(null);

        String[] typeGuitar = {"Huawei", "Redmi", "Apple", "Vivo", "Samsung", "Oppo"};

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        typeLabel.setBounds(75, 75, 125, 25);
        add(typeLabel);

        JComboBox typeField = new JComboBox(typeGuitar);
        typeField.setBounds(225, 75, 200, 25);
        add(typeField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        nameLabel.setBounds(75, 110, 125, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(225, 110, 200, 25);
        add(nameField);

        JLabel numberSIMLabel = new JLabel("Number of SIM:");
        numberSIMLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        numberSIMLabel.setBounds(75, 145, 125, 25);
        add(numberSIMLabel);

        JTextField numberSIMField = new JTextField();
        numberSIMField.setBounds(225, 145, 200, 25);
        add(numberSIMField);

        JLabel costLabel = new JLabel("Product price:");
        costLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        costLabel.setBounds(75, 215, 125, 25);
        add(costLabel);

        JTextField costField = new JTextField();
        costField.setBounds(225, 215, 200, 25);
        add(costField);

        JLabel countLabel = new JLabel("Number of products:");
        countLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        countLabel.setBounds(75, 250, 125, 25);
        add(countLabel);

        JTextField countField = new JTextField();
        countField.setBounds(225, 250, 200, 25);
        add(countField);

        JButton addButton = new JButton("Add product");
        addButton.setFont(new Font("Verdana", Font.BOLD , 12));
        addButton.setBounds(75, 320, 170, 30);
        add(addButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setFont(new Font("Verdana", Font.BOLD , 12));
        backButton.setBounds(255, 320, 170, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addSmartphone.setVisible(false);
                MainFrame.addProduct.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Smartphone newSmartphone = new Smartphone(null, (String) typeField.getSelectedItem(), nameField.getText(),
                            Integer.parseInt(costField.getText()), Integer.parseInt(countField.getText()),
                            Integer.parseInt(numberSIMField.getText()));

                    PackageData packageData = new PackageData("ADD S", newSmartphone);
                    Main.connect(packageData);

                    nameField.setText(null);
                    costField.setText(null);
                    countField.setText(null);
                    numberSIMField.setText(null);
                } catch (Exception a) {
                    a.printStackTrace();
                }
            }
        });
    }
}
