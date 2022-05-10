package Menu.user;
import DataBase.PackageData;
import Main.Main;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindMenu extends Container {
    public static  JTextArea textArea;
    public FindMenu(){
        setSize(500, 500);
        setLayout(null);

        JLabel nameProductLabel = new JLabel("NAME:");
        nameProductLabel.setBounds(70, 125, 120, 25);
        add(nameProductLabel);

        JTextField nameProductField = new JTextField();
        nameProductField.setBounds(190, 125, 240, 25);
        add(nameProductField);

        JButton findSmartphoneButton = new JButton("FIND S");
        findSmartphoneButton.setBounds(100, 155, 100, 25);
        add(findSmartphoneButton);

        JButton findLaptopButton = new JButton("FIND L");
        findLaptopButton.setBounds(200, 155, 100, 25);
        add(findLaptopButton);

        JButton findPhotoCameraButton = new JButton("FIND P");
        findPhotoCameraButton.setBounds(300, 155, 100, 25);
        add(findPhotoCameraButton);

        ///////////////////////////////////////////

        textArea = new JTextArea();
        textArea.setBounds(70, 190, 360, 140);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to buy");
        label.setBounds(70, 340, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(350, 340, 80, 25);
        add(numberField);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 370, 175, 25);
        add(backButton);

        JButton buyButton = new JButton("BUY");
        buyButton.setBounds(70, 370, 175, 25);
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
                    textArea.setText(null);
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
