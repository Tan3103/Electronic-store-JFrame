package Menu;
import DataBase.DBManager;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import static DataBase.DBManager.connection;
public class MainMenu extends Container {
    public MainMenu(){
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

        JButton singButton = new JButton("Sign up");
        singButton.setBounds(260, 200, 140, 40);
        add(singButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(100, 250, 300, 40);
        add(exitButton);

        logInButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginField.getText().equals("admin") && passwordField.getText().equals("password")) {
                    MainFrame.menu.setVisible(false);
                    MainFrame.adminMenu.setVisible(true);
                    JOptionPane.showInternalMessageDialog(null, "WELCOME ADMIN");
                }

                try {
                    DBManager result = new DBManager();
                    result.connect();
                    Statement stmt = connection.createStatement();
                    String sql = "select * from  customer where login='"  + loginField.getText() + "' and password='" + passwordField.getText() +  "' ";
                    ResultSet rs = stmt.executeQuery(sql);
                    if(rs.next()){
                        MainFrame.menu.setVisible(false);
                        MainFrame.userMenu.setVisible(true);
                        JOptionPane.showInternalMessageDialog(null, "WELCOME");
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

        singButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.singUser.setVisible(true);
                MainFrame.menu.setVisible(false);
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
