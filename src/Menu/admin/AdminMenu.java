package Menu.admin;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu extends Container {
    public AdminMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton deleteUserButton = new JButton("Show all user and Delete a user");
        deleteUserButton.setBounds(100, 100, 300, 40);
        add(deleteUserButton);

        JButton addANewProductButton = new JButton("Add a new product");
        addANewProductButton.setBounds(100, 150, 300, 40);
        add(addANewProductButton);

        JButton deleteProductButton = new JButton("Delete a product");
        deleteProductButton.setBounds(100, 200, 300, 40);
        add(deleteProductButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(100, 250, 300, 40);
        add(backButton);

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
