package Menu.user;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends Container {
    public UserMenu(){
        setSize(500, 500);
        setLayout(null);

        JButton catalogButton = new JButton("Product catalog");
        catalogButton.setBounds(100, 100, 300, 40);
        add(catalogButton);

        JButton findButton = new JButton("Find the product");
        findButton.setBounds(100, 150, 300, 40);
        add(findButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(100, 250, 300, 40);
        add(backButton);

        catalogButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.catalogMenu.setVisible(true);
            }
        });

        findButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.findMenu.setVisible(true);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.userMenu.setVisible(false);
                MainFrame.menu.setVisible(true);
            }
        });
    }
}
