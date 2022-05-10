package Menu.admin;
import DataBase.PackageData;
import Main.Main;
import Main.MainFrame;
import com.company.Laptop;
import com.company.PhotoCamera;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddLaptop extends Container {
    public AddLaptop(){
        setSize(500, 500);
        setLayout(null);

        String[] typePercussion = {"Acer", "Asus", "Lenovo", "Macbook", "Neo"};

        JLabel typeLabel = new JLabel("Type:");
        typeLabel.setBounds(75, 75, 125, 25);
        add(typeLabel);

        JComboBox typeField = new JComboBox(typePercussion);
        typeField.setBounds(225, 75, 200, 25);
        add(typeField);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(75, 110, 125, 25);
        add(nameLabel);

        JTextField nameField = new JTextField();
        nameField.setBounds(225, 110, 200, 25);
        add(nameField);

        JLabel videoCardLabel = new JLabel("Type video card:");
        videoCardLabel.setBounds(75, 145, 125, 25);
        add(videoCardLabel);

        JTextField videoCardField = new JTextField();
        videoCardField.setBounds(225, 145, 200, 25);
        add(videoCardField);

        JLabel costLabel = new JLabel("Product price:");
        costLabel.setBounds(75, 215, 125, 25);
        add(costLabel);

        JTextField costField = new JTextField();
        costField.setBounds(225, 215, 200, 25);
        add(costField);

        JLabel countLabel = new JLabel("Number of products:");
        countLabel.setBounds(75, 250, 125, 25);
        add(countLabel);

        JTextField countField = new JTextField();
        countField.setBounds(225, 250, 200, 25);
        add(countField);

        JButton addButton = new JButton("Add product");
        addButton.setBounds(75, 320, 170, 30);
        add(addButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 320, 170, 30);
        add(backButton);

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.addLaptop.setVisible(false);
                MainFrame.addProduct.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    Laptop newLaptop = new Laptop(null, (String)typeField.getSelectedItem(), nameField.getText(),
                            Integer.parseInt(costField.getText()), Integer.parseInt(countField.getText()),
                            videoCardField.getText());

                    PackageData packageData = new PackageData("ADD L", newLaptop);
                    Main.connect(packageData);
                }catch (Exception a){
                    a.printStackTrace();
                }

                nameField.setText(null);
                costField.setText(null);
                countField.setText(null);
                videoCardField.setText(null);
            }
        });
    }
}
