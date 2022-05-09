package Menu.user;
import DataBase.DBManager;
import Main.MainFrame;
import com.company.Customer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import static DataBase.DBManager.connection;

public class LoginUser extends Container {
    public static Customer customer;
    public LoginUser(){
        setSize(500, 500);
        setLayout(null);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setBounds(100, 100, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(200, 100, 200, 30);
        add(loginField);

        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setBounds(100, 150, 100, 30);
        add(passwordLabel);

        JTextField passwordField = new JTextField();
        passwordField.setBounds(200, 150, 200, 30);
        add(passwordField);

        JButton logInButton = new JButton("Log in");
        logInButton.setBounds(100, 200, 140, 40);
        add(logInButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(250, 200, 150, 40);
        add(backButton);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginField.getText().equals("admin") && passwordField.getText().equals("password")) {
                    MainFrame.loginUser.setVisible(false);
                    MainFrame.adminMenu.setVisible(true);
                }

                try {
                    DBManager result = new DBManager();
                    result.connect();
                    Statement stmt = connection.createStatement();
                    String sql = "select * from  visitor where login='"  + loginField.getText() + "' and password='" + passwordField.getText() +  "' ";
                    ResultSet rs = stmt.executeQuery(sql);
                    if(rs.next()){
                        MainFrame.loginUser.setVisible(false);
                        MainFrame.userMenu.setVisible(true);
                    }

                    DBManager manager = new DBManager();
                    manager.connect();

                } catch(Exception a){
                    a.printStackTrace();
                }

                loginField.setText(null);
                passwordField.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.loginUser.setVisible(false);
                MainFrame.menu.setVisible(true);
            }
        });
    }
}
