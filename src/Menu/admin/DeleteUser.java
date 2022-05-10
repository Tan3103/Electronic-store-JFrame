package Menu.admin;
import DataBase.PackageData;
import Main.Main;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUser extends Container {
    public static JTextArea textArea;
    public DeleteUser() {
        setSize(500, 500);
        setLayout(null);

        JButton listUserButton = new JButton("LIST");
        listUserButton.setFont(new Font("Serif", Font.PLAIN, 14));
        listUserButton.setBounds(50, 60, 400, 30);
        add(listUserButton);

        textArea = new JTextArea();
        textArea.setBounds(50, 100, 400, 200);
        add(textArea);

        JButton deleteProductButton = new JButton("Delete");
        deleteProductButton.setFont(new Font("Serif", Font.PLAIN, 14));
        deleteProductButton.setBounds(50, 350, 195, 30);
        add(deleteProductButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setFont(new Font("Serif", Font.PLAIN, 14));
        backButton.setBounds(255, 350, 195, 30);
        add(backButton);

        JLabel label = new JLabel("Enter the number of the item you want to delete");
        label.setFont(new Font("Serif", Font.PLAIN, 14));
        label.setBounds(75, 310, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(350, 310, 80, 25);
        add(numberField);

        listUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                PackageData pd = new PackageData("LIST");
                Main.connect(pd);
            }
        });

        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData("Delete Customer", Integer.parseInt(numberField.getText()));
                Main.connect(pd);

                numberField.setText(null);
                textArea.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.deleteUser.setVisible(false);
                MainFrame.adminMenu.setVisible(true);
            }
        });
    }
}
