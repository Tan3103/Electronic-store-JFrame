package Menu;

import DataBase.PackageData;
import Main.Main;
import com.company.Customer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SingUser extends Container {
    public SingUser(){
        setSize(500, 500);
        setLayout(null);

        JLabel label = new JLabel();
        label.setBounds(50, 50, 100, 100);
        add(label);

        JLabel nameLabel = new JLabel("NAME:");
        nameLabel.setBounds(100, 50, 100, 30);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(200, 50, 200, 30);
        add(nameField);

        JLabel surnameLabel = new JLabel("SURNAME:");
        surnameLabel.setBounds(100, 100, 100, 30);
        add(surnameLabel);

        JTextField surnameField = new JTextField();
        surnameField.setBounds(200, 100, 200, 30);
        add(surnameField);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setBounds(100, 150, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(200, 150, 200, 30);
        add(loginField);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(100, 200, 100, 30);
        add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(200, 200, 200, 30);

        add(passwordField);

        JButton singButton = new JButton("Sing up");
        singButton.setBounds(100, 250, 140, 40);
        add(singButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(250, 250, 150, 40);
        add(backButton);

        singButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                        Customer new_customer = new Customer(null, loginField.getText(), passwordField.getText(), nameField.getText(), surnameField.getText());

                        PackageData packageData = new PackageData("ADD", new_customer);
                        Main.connect(packageData);

                        label.setText("OK");

                }catch (Exception a){
                    a.printStackTrace();
                }

                nameField.setText(null);
                surnameField.setText(null);
                loginField.setText(null);
                passwordField.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.frame.singUser.setVisible(false);
                Main.frame.menu.setVisible(true);
            }
        });
    }
}
