package Menu.admin;
import DataBase.PackageData;
import Main.Main;
import Main.MainFrame;
import com.company.PhotoCamera;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddPhotoCamera extends Container {
    public AddPhotoCamera(){
        setSize(500, 500);
        setLayout(null);

        String[] typeKeyboard = {"Canon", "Sony", "Nikon", "FUJIFILM"};

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        typeLabel.setBounds(75, 75, 125, 25);
        add(typeLabel);

        JComboBox typeField = new JComboBox(typeKeyboard);
        typeField.setBounds(225, 75, 200, 25);
        add(typeField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        nameLabel.setBounds(75, 110, 125, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(225, 110, 200, 25);
        add(nameField);

        JLabel typeAutofocusLabel = new JLabel("Type of autofocus:");
        typeAutofocusLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        typeAutofocusLabel.setBounds(75, 145, 125, 25);
        add(typeAutofocusLabel);

        JTextField typeAutofocusField = new JTextField();
        typeAutofocusField.setBounds(225, 145, 200, 25);
        add(typeAutofocusField);

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
                MainFrame.addPhotoCamera.setVisible(false);
                MainFrame.addProduct.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    PhotoCamera newPhotoCamera = new PhotoCamera(null, (String)typeField.getSelectedItem(), nameField.getText(),
                            Integer.parseInt(costField.getText()), Integer.parseInt(countField.getText()),
                            typeAutofocusField.getText());

                    PackageData packageData = new PackageData("ADD P", newPhotoCamera);
                    Main.connect(packageData);
                }catch (Exception a){
                    a.printStackTrace();
                }

                nameField.setText(null);
                costField.setText(null);
                countField.setText(null);
                typeAutofocusField.setText(null);
            }
        });
    }
}
