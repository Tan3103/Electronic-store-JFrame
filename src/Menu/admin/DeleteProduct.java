package Menu.admin;
import DataBase.PackageData;
import Main.Main;
import DataBase.DBManager;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteProduct extends Container {
    public static JTextArea textArea;
    public DeleteProduct(){
        setSize(500, 500);
        setLayout(null);

        JButton smartphoneButton = new JButton("List of smartphone");
        smartphoneButton.setBounds(70, 40, 360, 25);
        add(smartphoneButton);

        JButton laptopButton = new JButton("List of laptop");
        laptopButton.setBounds(70, 70, 360, 25);
        add(laptopButton);

        JButton photoCameraButton = new JButton("List of photo camera");
        photoCameraButton.setBounds(70, 100, 360, 25);
        add(photoCameraButton);

        textArea = new JTextArea();
        textArea.setBounds(70, 130, 360, 200);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to delete:");
        label.setBounds(70, 340, 280, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(360, 340, 70, 25);
        add(numberField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setBounds(70, 375, 175, 25);
        add(deleteButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 375, 175, 25);
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

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData("Delete Product", Integer.parseInt((numberField.getText())));
                Main.connect(pd);

                numberField.setText(null);
                textArea.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.deleteProduct.setVisible(false);
                Main.frame.adminMenu.setVisible(true);
            }
        });
    }
}

