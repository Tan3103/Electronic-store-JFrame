package Menu.admin;
import DataBase.PackageData;
import Main.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddProduct extends Container {
    public static JTextArea textArea;
    public AddProduct(){
        setSize(500, 500);
        setLayout(null);

        JButton smartphoneButton = new JButton("Smartphone");
        smartphoneButton.setBounds(70, 50, 275, 25);
        add(smartphoneButton);

        JButton addSmartphoneButton = new JButton("Add");
        addSmartphoneButton.setBounds(355, 50, 75, 25);
        add(addSmartphoneButton);

        JButton laptopButton = new JButton("Laptop");
        laptopButton.setBounds(70, 80, 275, 25);
        add(laptopButton);

        JButton addLaptopButton = new JButton("Add");
        addLaptopButton.setBounds(355, 80, 75, 25);
        add(addLaptopButton);

        JButton photoCameraButton = new JButton("Photo camera");
        photoCameraButton.setBounds(70, 110, 275, 25);
        add(photoCameraButton);

        JButton addPhotoCameraButton = new JButton("Add");
        addPhotoCameraButton.setBounds(355, 110, 75, 25);
        add(addPhotoCameraButton);

        textArea = new JTextArea();
        textArea.setBounds(70, 150, 360, 200);
        add(textArea);

        JLabel label = new JLabel("");
        label.setBounds(70, 320, 270, 25);
        add(label);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(70, 360, 360, 30);
        add(backButton);

        smartphoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST S");
                Main.connect(pd);
            }
        });

        laptopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST L");
                Main.connect(pd);
            }
        });

        photoCameraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST P");
                Main.connect(pd);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addProduct.setVisible(false);
                Main.frame.adminMenu.setVisible(true);
            }
        });

        addSmartphoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addProduct.setVisible(false);
                Main.frame.addSmartphone.setVisible(true);
            }
        });

        addLaptopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addProduct.setVisible(false);
                Main.frame.addLaptop.setVisible(true);
            }
        });

        addPhotoCameraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addProduct.setVisible(false);
                Main.frame.addPhotoCamera.setVisible(true);
            }
        });
    }
}
