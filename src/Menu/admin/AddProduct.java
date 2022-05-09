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

        JButton guitarsButton = new JButton("List of Guitars");
        guitarsButton.setBounds(70, 50, 275, 25);
        add(guitarsButton);

        JButton addGuitarsButton = new JButton("Add");
        addGuitarsButton.setBounds(355, 50, 75, 25);
        add(addGuitarsButton);

        JButton keyboardButton = new JButton("List of Keyboard instruments");
        keyboardButton.setBounds(70, 80, 275, 25);
        add(keyboardButton);

        JButton addKeyboardButton = new JButton("Add");
        addKeyboardButton.setBounds(355, 80, 75, 25);
        add(addKeyboardButton);

        JButton percussionButton = new JButton("List of Percussion instruments");
        percussionButton.setBounds(70, 110, 275, 25);
        add(percussionButton);

        JButton addPercussionButton = new JButton("Add");
        addPercussionButton.setBounds(355, 110, 75, 25);
        add(addPercussionButton);

        textArea = new JTextArea();
        textArea.setBounds(70, 150, 360, 200);
        add(textArea);

        JLabel label = new JLabel("");
        label.setBounds(70, 320, 270, 25);
        add(label);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(70, 360, 360, 30);
        add(backButton);

        guitarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST Guitar");
                Main.connect(pd);
            }
        });

        keyboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST Keyboard");
                Main.connect(pd);
            }
        });

        percussionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST Percussion");
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

        addGuitarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addProduct.setVisible(false);
                Main.frame.addSmartphone.setVisible(true);
            }
        });

        addKeyboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addProduct.setVisible(false);
                Main.frame.addNewKeyboard.setVisible(true);
            }
        });

        addPercussionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.addProduct.setVisible(false);
                Main.frame.addLaptop.setVisible(true);
            }
        });
    }
}
