package Menu.user;
import DataBase.PackageData;
import Main.Main;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Menu.MainMenu;

public class FindMenu extends Container {
    public static  JTextArea textArea;
    public FindMenu(){
        setSize(500, 500);
        setLayout(null);

        JLabel nameProductLabel = new JLabel("FIND BY NAME:");
        nameProductLabel.setFont(new Font("Serif", Font.BOLD , 12));
        nameProductLabel.setBounds(70, 50, 175, 25);
        add(nameProductLabel);

        JTextField nameProductField = new JTextField();
        nameProductField.setBounds(190, 50, 240, 25);
        add(nameProductField);

        JButton findSmartphoneButton = new JButton("SMARTPHONE");
        findSmartphoneButton.setFont(new Font("Verdana", Font.BOLD , 12));
        findSmartphoneButton.setBounds(25, 100, 130, 25);
        add(findSmartphoneButton);

        JButton findLaptopButton = new JButton("LAPTOP");
        findLaptopButton.setFont(new Font("Verdana", Font.BOLD , 12));
        findLaptopButton.setBounds(175, 100, 130, 25);
        add(findLaptopButton);

        JButton findPhotoCameraButton = new JButton("CAMERA");
        findPhotoCameraButton.setFont(new Font("Verdana", Font.BOLD , 12));
        findPhotoCameraButton.setBounds(325, 100, 130, 25);
        add(findPhotoCameraButton);

        ///////////////////////////////////////////

        textArea = new JTextArea();
        textArea.setBounds(70, 150, 360, 200);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to buy");
        label.setFont(new Font("Serif", Font.BOLD , 12));
        label.setBounds(70, 375, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(350, 375, 80, 25);
        add(numberField);

        JButton backButton = new JButton("Back to menu");
        backButton.setFont(new Font("Verdana", Font.BOLD , 12));
        backButton.setBounds(255, 400, 175, 25);
        add(backButton);

        JButton buyButton = new JButton("BUY");
        buyButton.setFont(new Font("Verdana", Font.BOLD , 12));
        buyButton.setBounds(70, 400, 175, 25);
        add(buyButton);


        findSmartphoneButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("Find S", nameProductField.getText());
                Main.connect(pd);
            }
        });

        findLaptopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("Find L", nameProductField.getText());
                Main.connect(pd);
            }
        });

        findPhotoCameraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("Find P", nameProductField.getText());
                Main.connect(pd);
            }
        });

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PackageData pd = new PackageData("Update Product", Integer.parseInt(numberField.getText()));
                    Main.connect(pd);

                    PackageData pd_basket = new PackageData("ADD Basket", Integer.parseInt(numberField.getText()), MainMenu.customer.getId());
                    Main.connect(pd_basket);

                    textArea.setText(null);
                    numberField.setText(null);
                }
                catch (Exception a){
                    a.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.findMenu.setVisible(false);
                MainFrame.userMenu.setVisible(true);
            }
        });
    }
}
