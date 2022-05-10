package Menu.user;
import Main.MainFrame;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserMenu extends Container {
    public static JLabel centerLabel;
    public static JTextArea textArea;
    public UserMenu(){
        setSize(500, 500);
        setLayout(null);

        Dimension labelSize = new Dimension(80, 80);

        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);


        centerLabel = new JLabel();
        centerLabel.setVerticalAlignment(JLabel.CENTER);
        centerLabel.setHorizontalAlignment(JLabel.CENTER);
        centerLabel.setPreferredSize(labelSize);
        centerLabel.setBounds(100,10,300,30);
        centerLabel.setBorder(solidBorder);
        centerLabel.setFont(new Font("Courier New", Font.PLAIN, 20));
        add(centerLabel);

        JButton basket = new JButton("BASKET");
        basket.setFont(new Font("Verdana", Font.BOLD , 12));
        basket.setBounds(200, 400, 100, 30);
        basket.setVerticalAlignment(JLabel.CENTER);
        basket.setHorizontalAlignment(JLabel.CENTER);
        add(basket);


        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(70, 200, 360, 170);
        add(textArea);

        JButton catalogButton = new JButton("Product catalog");
        catalogButton.setFont(new Font("Verdana", Font.BOLD , 12));
        catalogButton.setBounds(100, 50, 300, 40);
        add(catalogButton);

        JButton findButton = new JButton("Find the product");
        findButton.setFont(new Font("Verdana", Font.BOLD , 12));
        findButton.setBounds(100, 100, 300, 40);
        add(findButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setFont(new Font("Verdana", Font.BOLD , 12));
        backButton.setBounds(100, 150, 300, 40);
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
