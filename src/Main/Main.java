package Main;
import DataBase.PackageData;
import Menu.admin.AddProduct;
import Menu.admin.DeleteProduct;
import Menu.admin.DeleteUser;
import Menu.user.CatalogMenu;
import Menu.user.FindMenu;
import com.company.*;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static MainFrame frame;
    public static void connect(PackageData pd){
        try{
            Socket socket = new Socket("127.0.0.1", 4855);
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            if(pd.getOperationType().equals("ADD") || pd.getOperationType().equals("ADD S") || pd.getOperationType().equals("ADD L") ||
                    pd.getOperationType().equals("ADD P") || pd.getOperationType().equals("Delete Customer") ||
                    pd.getOperationType().equals("Delete Product") || pd.getOperationType().equals("Update Product")){
                outputStream.writeObject(pd);
            }
            else if(pd.getOperationType().equals("LIST")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<Customer> arrayListFromServer = infoFromServer.getCustomers();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).info()+ "\n";
                }
                DeleteUser.textArea.append(s);
            }
            else if(pd.getOperationType().equals("LIST S")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<Smartphone> arrayListFromServer = infoFromServer.getSmartphones();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).info()+ "\n";
                }
                AddProduct.textArea.append(s);
                DeleteProduct.textArea.append(s);
                CatalogMenu.textArea.append(s);
            }
            else if(pd.getOperationType().equals("LIST L")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<Laptop> arrayListFromServer = infoFromServer.getLaptops();
                String s1 = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s1 += arrayListFromServer.get(i).info()+ "\n";
                }
                AddProduct.textArea.append(s1);
                DeleteProduct.textArea.append(s1);
                CatalogMenu.textArea.append(s1);
            }
            else if(pd.getOperationType().equals("LIST P")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                ArrayList<PhotoCamera> arrayListFromServer = infoFromServer.getPhotoCameras();
                String s = "";

                for(int i=0; i< arrayListFromServer.size(); i++){
                    s += arrayListFromServer.get(i).info()+ "\n";
                }
                AddProduct.textArea.append(s);
                DeleteProduct.textArea.append(s);
                CatalogMenu.textArea.append(s);
            }
            else if(pd.getOperationType().equals("Find S")){
                 outputStream.writeObject(pd);
                 PackageData infoFromServer = (PackageData)inputStream.readObject();
                 String smartphone = infoFromServer.getFind();

                 FindMenu.textArea.append(smartphone);
            }
            else if(pd.getOperationType().equals("Find L")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                String laptop = infoFromServer.getFind();

                FindMenu.textArea.append(laptop);
            }
            else if(pd.getOperationType().equals("Find P")){
                outputStream.writeObject(pd);
                PackageData infoFromServer = (PackageData)inputStream.readObject();
                String photoCamera = infoFromServer.getFind();

                FindMenu.textArea.append(photoCamera);
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        MainFrame frame = new MainFrame();
        frame.setVisible(true);
    }
}