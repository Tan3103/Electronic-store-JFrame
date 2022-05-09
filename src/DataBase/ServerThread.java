package DataBase;
import com.company.*;
import java.net.Socket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class ServerThread extends Thread  {
    private Socket socket;
    public ServerThread(Socket socket){
        this.socket = socket;
    }

    public void run(){
        try{
            DBManager manager = new DBManager();
            manager.connect();

            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());

            PackageData packageData = null;

            while((packageData = ((PackageData)inputStream.readObject())) != null){
                if(packageData.getOperationType().equals("ADD")){
                    Customer customer = packageData.getVisitor();
                    manager.addCustomer(customer);
                }
                else if(packageData.getOperationType().equals("ADD S")){
                    Smartphone smartphone = packageData.getGuitar();
                    manager.addSmartphone(smartphone);
                }
                else if(packageData.getOperationType().equals("ADD L")){
                    Laptop laptop = packageData.getKeyboardInstrument();
                    manager.addLaptop(laptop);
                }
                else if(packageData.getOperationType().equals("ADD P")){
                    PhotoCamera photoCamera = packageData.getPercussionInstrument();
                    manager.addPhotoCamera(photoCamera);
                }
                else if(packageData.getOperationType().equals("LIST")){
                    ArrayList<Customer> arrayCustomer = manager.getAllVisitor();
                    PackageData toVisitor = new PackageData();
                    toVisitor.setVisitors(arrayCustomer);
                    outputStream.writeObject(toVisitor);
                }
                else if(packageData.getOperationType().equals("LIST S")){
                    ArrayList<Smartphone> arraySmartphone = manager.getAllSmartphone();
                    PackageData toGuitar = new PackageData();
                    toGuitar.setGuitars(arraySmartphone);
                    outputStream.writeObject(toGuitar);
                }
                else if(packageData.getOperationType().equals("LIST L")){
                    ArrayList<Laptop> arrayKeyboard = manager.getAllLaptop();
                    PackageData toKeyboard = new PackageData();
                    toKeyboard.setKeyboardInstruments(arrayKeyboard);
                    outputStream.writeObject(toKeyboard);
                }
                else if(packageData.getOperationType().equals("LIST P")){
                    ArrayList<PhotoCamera> arrayPercussion = manager.getAllPhotoCamera();
                    PackageData toPercussion = new PackageData();
                    toPercussion.setPercussionInstruments(arrayPercussion);
                    outputStream.writeObject(toPercussion);
                }
                else if(packageData.getOperationType().equals("Delete Customer")){
                    int idServer = packageData.getId();
                    manager.deleteCustomer(idServer);
                }
                else if(packageData.getOperationType().equals("Delete Product")){
                    int idServer = packageData.getId();
                    manager.deleteProduct(idServer);
                }
                else if(packageData.getOperationType().equals("Update Product")){
                    int idServer = packageData.getId();
                    manager.updateProduct(idServer);
                }
                else if(packageData.getOperationType().equals("Find S")){
                    String findGuitar = manager.findSmartphone(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                }
                else if(packageData.getOperationType().equals("Find L")){
                    String findGuitar = manager.findLaptop(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                }
                else if(packageData.getOperationType().equals("Find P")){
                    String findGuitar = manager.findPhotoCamera(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                }
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
