package Menu.user;
import DataBase.PackageData;
import Main.Main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CatalogMenu extends Container {
    public static JTextArea textArea;
    public CatalogMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton guitarsButton = new JButton("Laptop");
        guitarsButton.setBounds(70, 50, 360, 25);
        add(guitarsButton);

        JButton keyboardButton = new JButton("Photo camera");
        keyboardButton.setBounds(70, 80, 360, 25);
        add(keyboardButton);

        JButton percussionButton = new JButton("Smartphone");
        percussionButton.setBounds(70, 110, 360, 25);
        add(percussionButton);

        textArea = new JTextArea();
        textArea.setBounds(70, 145, 360, 170);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to buy");
        label.setBounds(70, 320, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(350, 320, 80, 25);
        add(numberField);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 360, 175, 30);
        add(backButton);

        JButton buyButton = new JButton("Buy");
        buyButton.setBounds(70, 360, 175, 30);
        add(buyButton);

        guitarsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST S");
                Main.connect(pd);
            }
        });

        keyboardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("LIST L");
                Main.connect(pd);
            }
        });

        percussionButton.addActionListener(new ActionListener() {
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
                Main.frame.catalogMenu.setVisible(false);
                Main.frame.userMenu.setVisible(true);
            }
        });

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PackageData pd = new PackageData("Update Product", Integer.parseInt(numberField.getText()));
                    Main.connect(pd);
                    textArea.setText(null);
                }
                catch (Exception a){
                    a.printStackTrace();
                }
            }
        });
    }
}
