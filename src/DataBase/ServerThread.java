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
/*
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
                    manager.addVisitor(customer);
                }
                else if(packageData.getOperationType().equals("ADDGuitar")){
                    Smartphone smartphone = packageData.getGuitar();
                    manager.addGuitar(smartphone);
                }
                else if(packageData.getOperationType().equals("ADDKeyboard")){
                    Laptop laptop = packageData.getKeyboardInstrument();
                    manager.addKeyboard(laptop);
                }
                else if(packageData.getOperationType().equals("ADDPercussion")){
                    PhotoCamera photoCamera = packageData.getPercussionInstrument();
                    manager.addPercussion(photoCamera);
                }
                else if(packageData.getOperationType().equals("LIST")){
                    ArrayList<Customer> arrayCustomer = manager.getAllVisitor();
                    PackageData toVisitor = new PackageData();
                    toVisitor.setVisitors(arrayCustomer);
                    outputStream.writeObject(toVisitor);
                }
                else if(packageData.getOperationType().equals("LIST Guitar")){
                    ArrayList<Smartphone> arraySmartphone = manager.getAllGuitar();
                    PackageData toGuitar = new PackageData();
                    toGuitar.setGuitars(arraySmartphone);
                    outputStream.writeObject(toGuitar);
                }
                else if(packageData.getOperationType().equals("LIST Keyboard")){
                    ArrayList<Laptop> arrayKeyboard = manager.getAllKeyboard();
                    PackageData toKeyboard = new PackageData();
                    toKeyboard.setKeyboardInstruments(arrayKeyboard);
                    outputStream.writeObject(toKeyboard);
                }
                else if(packageData.getOperationType().equals("LIST Percussion")){
                    ArrayList<PhotoCamera> arrayPercussion = manager.getAllPercussion();
                    PackageData toPercussion = new PackageData();
                    toPercussion.setPercussionInstruments(arrayPercussion);
                    outputStream.writeObject(toPercussion);
                }
                else if(packageData.getOperationType().equals("Delete Visitor")){
                    int idServer = packageData.getId();
                    manager.deleteVisitors(idServer);
                }
                else if(packageData.getOperationType().equals("Delete Guitar")){
                    int idServer = packageData.getId();
                    manager.deleteGuitar(idServer);
                }
                else if(packageData.getOperationType().equals("Delete Keyboard")){
                    int idServer = packageData.getId();
                    manager.deleteKeyboard(idServer);
                }
                else if(packageData.getOperationType().equals("Delete Percussion")){
                    int idServer = packageData.getId();
                    manager.deletePercussion(idServer);
                }
                else if(packageData.getOperationType().equals("Update Guitar")){
                    int idServer = packageData.getId();
                    manager.updateGuitar(idServer);
                }
                else if(packageData.getOperationType().equals("Update Keyboard")){
                    int idServer = packageData.getId();
                    manager.updateKeyboard(idServer);
                }
                else if(packageData.getOperationType().equals("Update Percussion")){
                    int idServer = packageData.getId();
                    manager.updatePercussion(idServer);
                }
                else if(packageData.getOperationType().equals("Find Guitar")){
                    String findGuitar = manager.findGuitar(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                }
                else if(packageData.getOperationType().equals("Find Keyboard")){
                    String findGuitar = manager.findKeyboard(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                }
                else if(packageData.getOperationType().equals("Find Percussion")){
                    String findGuitar = manager.findPercussion(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                }
                else if(packageData.getOperationType().equals("Find Type Guitar")){
                    String findGuitar = manager.findTypeGuitar(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                }
                else if(packageData.getOperationType().equals("Find Type Keyboard")){
                    String findGuitar = manager.findTypeKeyboard(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                }
                else if(packageData.getOperationType().equals("Find Type Percussion")){
                    String findGuitar = manager.findTypePercussion(packageData.getFind());
                    PackageData toPercussion = new PackageData();
                    toPercussion.setFind(findGuitar);
                    outputStream.writeObject(toPercussion);
                }
                else if(packageData.getOperationType().equals("LIST Discount")){
                    ArrayList<Product> arrayPercussion = manager.getAllDiscount();
                    PackageData toPercussion = new PackageData();
                    toPercussion.setProducts(arrayPercussion);
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

 */
}
