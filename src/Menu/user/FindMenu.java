package Menu.user;
import DataBase.PackageData;
import Main.Main;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FindMenu extends Container {
    public static  JTextArea textArea;
    public FindMenu(){
        setSize(500, 500);
        setLayout(null);

        JLabel typeLabel = new JLabel("TYPE:");
        typeLabel.setBounds(70, 50, 50, 30);
        add(typeLabel);

        JTextField typeField = new JTextField();
        typeField.setBounds(130, 50, 240, 25);
        add(typeField);

        JButton find1Button = new JButton("FIND");
        find1Button.setBounds(120, 80, 100, 25);
        add(find1Button);

        //////////////////////////////////////////////////////////////

        JLabel nameProductLabel = new JLabel("NAME:");
        nameProductLabel.setBounds(70, 125, 120, 25);
        add(nameProductLabel);

        JTextField nameProductField = new JTextField();
        nameProductField.setBounds(190, 125, 240, 25);
        add(nameProductField);

        JButton find2Button = new JButton("FIND");
        find2Button.setBounds(120, 155, 100, 25);
        add(find2Button);

        ///////////////////////////////////////////

        textArea = new JTextArea();
        textArea.setBounds(70, 190, 360, 140);
        add(textArea);

        JLabel label = new JLabel("Enter the number of the item you want to buy");
        label.setBounds(70, 340, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(350, 340, 80, 25);
        add(numberField);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 370, 175, 25);
        add(backButton);

        JButton buyButton = new JButton("BUY");
        buyButton.setBounds(70, 370, 175, 25);
        add(buyButton);


        find1Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("FIND TYPE", typeField.getText());
                Main.connect(pd);
            }
        });

        find2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);

                PackageData pd = new PackageData("FIND NAME", nameProductField.getText());
                Main.connect(pd);
            }
        });

        buyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PackageData pd = new PackageData("UPDATE", Integer.parseInt(numberField.getText()));
                    Main.connect(pd);
                    textArea.setText(null);
                }
                catch (Exception a){
                    a.printStackTrace();
                }
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.findMenu.setVisible(false);
                MainFrame.userMenu.setVisible(true);
            }
        });
    }
}
