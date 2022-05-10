package Menu.admin;
import Main.MainFrame;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends Container {
    public AdminMenu(){
        setSize(500, 500);
        setLayout(null);
        Dimension labelSize = new Dimension(80, 80);

        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);


        JLabel centerLabel = new JLabel("ADMIN PAGE");
        centerLabel.setVerticalAlignment(JLabel.CENTER);
        centerLabel.setHorizontalAlignment(JLabel.CENTER);
        centerLabel.setPreferredSize(labelSize);
        centerLabel.setBounds(100,10,300,30);
        centerLabel.setBorder(solidBorder);
        centerLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
        add(centerLabel);

        JButton addANewProductButton = new JButton("Add a new product");
        addANewProductButton.setFont(new Font("Verdana", Font.BOLD, 12));
        addANewProductButton.setBounds(100, 100, 300, 40);
        add(addANewProductButton);

        JButton deleteProductButton = new JButton("Delete a product");
        deleteProductButton.setFont(new Font("Verdana", Font.BOLD, 12));
        deleteProductButton.setBounds(100, 150, 300, 40);
        add(deleteProductButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setFont(new Font("Verdana", Font.BOLD, 12));
        backButton.setBounds(100, 250, 300, 40);
        add(backButton);

        JButton deleteUserButton = new JButton("Delete a user");
        deleteUserButton.setFont(new Font("Verdana", Font.BOLD, 12));
        deleteUserButton.setBounds(100, 200, 300, 40);
        add(deleteUserButton);

        deleteUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.adminMenu.setVisible(false);
                MainFrame.deleteUser.setVisible(true);
            }
        });

        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.adminMenu.setVisible(false);
                MainFrame.deleteProduct.setVisible(true);
            }
        });

        addANewProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.adminMenu.setVisible(false);
                MainFrame.addProduct.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.adminMenu.setVisible(false);
                MainFrame.menu.setVisible(true);
            }
        });
    }
}
