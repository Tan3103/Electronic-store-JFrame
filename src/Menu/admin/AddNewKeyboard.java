package Menu.admin;
import DataBase.PackageData;
import com.company.Laptop;
import Main.Main;
import Main.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddNewKeyboard extends Container {
    public AddNewKeyboard(){
        setSize(500, 500);
        setLayout(null);

        String[] typeKeyboard = {"Grand_piano", "Piano", "Sintezator"};

        JLabel Label = new JLabel("Keyboard instrument");
        Label.setBounds(175, 40, 360, 25);
        Label.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(Label);

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(75, 75, 125, 25);
        add(typeLabel);

        JComboBox typeField = new JComboBox(typeKeyboard);
        typeField.setBounds(225, 75, 200, 25);
        add(typeField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(75, 110, 125, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(225, 110, 200, 25);
        add(nameField);

        JLabel numberKeysLabel = new JLabel("Number of keys:");
        numberKeysLabel.setBounds(75, 145, 125, 25);
        add(numberKeysLabel);

        JTextField numberKeysField = new JTextField();
        numberKeysField.setBounds(225, 145, 200, 25);
        add(numberKeysField);

        JLabel costLabel = new JLabel("Product price:");
        costLabel.setBounds(75, 215, 125, 25);
        add(costLabel);

        JTextField costField = new JTextField();
        costField.setBounds(225, 215, 200, 25);
        add(costField);

        JLabel countLabel = new JLabel("Number of products:");
        countLabel.setBounds(75, 250, 125, 25);
        add(countLabel);

        JTextField countField = new JTextField();
        countField.setBounds(225, 250, 200, 25);
        add(countField);

        JLabel discountLabel = new JLabel("Discount:");
        discountLabel.setBounds(75, 285, 125, 25);
        add(discountLabel);

        JTextField discountField = new JTextField();
        discountField.setBounds(225, 285, 200, 25);
        add(discountField);

        JButton addButton = new JButton("Add product");
        addButton.setBounds(75, 320, 170, 30);
        add(addButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 320, 170, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addNewKeyboard.setVisible(false);
                MainFrame.addProduct.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Laptop newKeyboard = new Laptop(null, (String)typeField.getSelectedItem(), nameField.getText(),
                            Integer.parseInt(costField.getText()), Integer.parseInt(countField.getText()),
                            Integer.parseInt(discountField.getText()), Integer.parseInt(numberKeysField.getText()));

                    PackageData packageData = new PackageData("ADDKeyboard", newKeyboard);
                    Main.connect(packageData);
                }catch (Exception a){
                    a.printStackTrace();
                }

                nameField.setText(null);
                costField.setText(null);
                countField.setText(null);
                discountField.setText(null);
                numberKeysField.setText(null);
            }
        });
    }
}
