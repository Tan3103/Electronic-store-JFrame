package Menu.user;
import DataBase.DBManager;
import DataBase.PackageData;
import Main.Main;
import Main.MainFrame;
import Menu.user.UserMenu;
import com.company.Customer;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

import static DataBase.DBManager.connection;
public class MainMenu extends Container {
    public static String name;
    public static String surname;
    public static Customer customer;

    public MainMenu(){
        setSize(500, 500);
        setLayout(null);

        JLabel loginLabel = new JLabel("LOGIN:");
        loginLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        loginLabel.setBounds(100, 150, 100, 30);
        add(loginLabel);

        JTextField loginField = new JTextField();
        loginField.setBounds(200, 150, 200, 30);
        add(loginField);


        Dimension labelSize = new Dimension(80, 80);

        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);


        JPanel alignmentPanel = new JPanel(new FlowLayout());
        alignmentPanel.setBorder(BorderFactory.createTitledBorder("Alignment"));


        JLabel passwordLabel = new JLabel("PASSWORD:");
        passwordLabel.setFont(new Font("Serif", Font.PLAIN, 14));
        passwordLabel.setBounds(100, 200, 100, 30);
        add(passwordLabel);

        JLabel centerLabel = new JLabel("ELECTRONIC STORE");
        centerLabel.setVerticalAlignment(JLabel.CENTER);
        centerLabel.setHorizontalAlignment(JLabel.CENTER);
        centerLabel.setPreferredSize(labelSize);
        centerLabel.setBounds(100,10,300,30);
        centerLabel.setBorder(solidBorder);
        centerLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
        add(centerLabel);

        JLabel ins = new JLabel("Welcome");
        ins.setVerticalAlignment(JLabel.CENTER);
        ins.setHorizontalAlignment(JLabel.CENTER);
        ins.setBounds(175,40,150,30);
        ins.setFont(new Font("Courier New", Font.BOLD , 15));
        add(ins);


        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 200, 200, 30);
        add(passwordField);

        JButton logInButton = new JButton("Log in");
        logInButton.setFont(new Font("Verdana", Font.BOLD , 12));
        logInButton.setBounds(100, 250, 145, 30);
        add(logInButton);

        JButton singButton = new JButton("Sign up");
        singButton.setFont(new Font("Verdana", Font.BOLD , 12));
        singButton.setBounds(255, 250, 145, 30);
        add(singButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Verdana", Font.BOLD , 12));
        exitButton.setBounds(100, 300, 300, 30);
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

                    PackageData pd2 = new PackageData("Get Customer", loginField.getText());
                    Main.connect(pd2);


                    if(rs.next()){
                        name = rs.getString("name");
                        surname = rs.getString("surname");
                        UserMenu.centerLabel.setText("WELCOME " + name + " " + surname);
                        MainFrame.menu.setVisible(false);
                        MainFrame.userMenu.setVisible(true);
                        JOptionPane.showInternalMessageDialog(null, "WELCOME");
                    }
                    else{
                        JOptionPane.showInternalMessageDialog(null, "LOGIN OR PASSWORD WRONG");
                    }


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
