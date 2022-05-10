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

        JButton guitarsButton = new JButton("Smartphone");
        guitarsButton.setBounds(70, 40, 360, 25);
        add(guitarsButton);

        JButton keyboardButton = new JButton("Laptop");
        keyboardButton.setBounds(70, 70, 360, 25);
        add(keyboardButton);

        JButton percussionButton = new JButton("Photo camera");
        percussionButton.setBounds(70, 100, 360, 25);
        add(percussionButton);

        textArea = new JTextArea();
        textArea.setBounds(70, 130, 360, 200);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to delete:");
        label.setFont(new Font("Serif", Font.PLAIN, 14));
        label.setBounds(70, 340, 280, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setFont(new Font("Verdana", Font.BOLD , 12));
        numberField.setBounds(360, 340, 70, 25);
        add(numberField);

        JButton deleteButton = new JButton("Delete");
        deleteButton.setFont(new Font("Verdana", Font.BOLD , 12));
        deleteButton.setBounds(70, 375, 175, 25);
        add(deleteButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setFont(new Font("Verdana", Font.BOLD , 12));
        backButton.setBounds(255, 375, 175, 25);
        add(backButton);

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

