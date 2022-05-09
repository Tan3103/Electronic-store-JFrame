package Menu.admin;
import DataBase.PackageData;
import Main.Main;
import Main.MainFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUser extends Container {
    public static JTextArea textArea;
    public DeleteUser() {
        setSize(500, 500);
        setLayout(null);

        /*String[] columnNames = {
                "#",
                "Email",
                "Password",
                "Name",
                "Surname"
        };

        Object[][] data = new Object[20][5];
        data[0][0] = "#";
        data[0][1] = "Email";
        data[0][2] = "Password";
        data[0][3] = "Name";
        data[0][4] = "Surname" ;
        try{
            BufferedReader reader = new BufferedReader(new FileReader("dataVisitor.txt"));
            String s = "";
            int i = 1;
            while((s=reader.readLine())!=null) {
                String[] p = s.split(" ");
                data[i][0] = i;
                data[i][1] = p[0];
                data[i][2] = p[1];
                data[i][3] = p[2];
                data[i][4] = p[3];
                i++;
            }
            reader.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        JTable table = new JTable(data, columnNames);
        table.setBounds(50, 75, 400, 225);
        TableColumn col0 = table.getColumnModel().getColumn( 0 );
        TableColumn col1 = table.getColumnModel().getColumn( 1 );
        TableColumn col2 = table.getColumnModel().getColumn( 2 );
        TableColumn col3 = table.getColumnModel().getColumn( 3 );
        TableColumn col4 = table.getColumnModel().getColumn( 4 );
        col0.setMaxWidth(10);
        col1.setMaxWidth(140);
        col2.setMaxWidth(60);
        col3.setMaxWidth(100);
        col4.setMaxWidth(100);
        add(table);*/

        JButton listUserButton = new JButton("LIST");
        listUserButton.setBounds(50, 60, 400, 30);
        add(listUserButton);

        textArea = new JTextArea();
        textArea.setBounds(50, 100, 400, 200);
        add(textArea);

        JButton deleteProductButton = new JButton("Delete");
        deleteProductButton.setBounds(50, 350, 195, 30);
        add(deleteProductButton);

        JButton backButton = new JButton("Back to menu");
        backButton.setBounds(255, 350, 195, 30);
        add(backButton);

        JLabel label = new JLabel("Enter the number of the item you want to delete");
        label.setBounds(75, 310, 270, 25);
        add(label);

        JTextField numberField = new JTextField();
        numberField.setBounds(350, 310, 80, 25);
        add(numberField);

        listUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textArea.setText(null);
                PackageData pd = new PackageData("LIST");
                Main.connect(pd);
            }
        });

        deleteProductButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PackageData pd = new PackageData("Delete Visitor", Integer.parseInt(numberField.getText()));
                Main.connect(pd);

                numberField.setText(null);
                textArea.setText(null);
            }
        });

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainFrame.deleteUser.setVisible(false);
                MainFrame.adminMenu.setVisible(true);
            }
        });
    }
}
