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
                    Customer customer = packageData.getCustomer();
                    manager.addCustomer(customer);
                    break;
                }
                else if(packageData.getOperationType().equals("ADD S")){
                    Smartphone smartphone = packageData.getSmartphone();
                    manager.addSmartphone(smartphone);
                    break;
                }
                else if(packageData.getOperationType().equals("ADD L")){
                    Laptop laptop = packageData.getLaptop();
                    manager.addLaptop(laptop);
                    break;
                }
                else if(packageData.getOperationType().equals("ADD P")){
                    PhotoCamera photoCamera = packageData.getPhotoCamera();
                    manager.addPhotoCamera(photoCamera);
                    break;
                }
                else if(packageData.getOperationType().equals("LIST")){
                    ArrayList<Customer> arrayCustomer = manager.getAllVisitor();
                    PackageData toVisitor = new PackageData();
                    toVisitor.setCustomers(arrayCustomer);
                    outputStream.writeObject(toVisitor);
                    break;
                }
                else if(packageData.getOperationType().equals("LIST S")){
                    ArrayList<Smartphone> arraySmartphone = manager.getAllSmartphone();
                    PackageData toGuitar = new PackageData();
                    toGuitar.setSmartphones(arraySmartphone);
                    outputStream.writeObject(toGuitar);
                    break;
                }
                else if(packageData.getOperationType().equals("LIST L")){
                    ArrayList<Laptop> arrayKeyboard = manager.getAllLaptop();
                    PackageData toKeyboard = new PackageData();
                    toKeyboard.setLaptops(arrayKeyboard);
                    outputStream.writeObject(toKeyboard);
                    break;
                }
                else if(packageData.getOperationType().equals("LIST P")){
                    ArrayList<PhotoCamera> arrayPercussion = manager.getAllPhotoCamera();
                    PackageData toPercussion = new PackageData();
                    toPercussion.setPhotoCameras(arrayPercussion);
                    outputStream.writeObject(toPercussion);
                    break;
                }
                else if(packageData.getOperationType().equals("Delete Customer")){
                    int idServer = packageData.getId();
                    manager.deleteCustomer(idServer);
                    break;
                }
                else if(packageData.getOperationType().equals("Delete Product")){
                    int idServer = packageData.getId();
                    manager.deleteProduct(idServer);
                    break;
                }
                else if(packageData.getOperationType().equals("Update Product")){
                    int idServer = packageData.getId();
                    manager.updateProduct(idServer);
                    break;
                }
                else if(packageData.getOperationType().equals("Find S")){
                    ArrayList<Smartphone> arraySmartphone = manager.findSmartphone(packageData.getFind());
                    PackageData toGuitar = new PackageData();
                    toGuitar.setSmartphones(arraySmartphone);
                    outputStream.writeObject(toGuitar);
                    break;
                }
                else if(packageData.getOperationType().equals("Find L")){
                    ArrayList<Laptop> arrayLaptop = manager.findLaptop(packageData.getFind());
                    PackageData toGuitar = new PackageData();
                    toGuitar.setLaptops(arrayLaptop);
                    outputStream.writeObject(toGuitar);
                    break;
                }
                else if(packageData.getOperationType().equals("Find P")){
                    ArrayList<PhotoCamera> arrayPhotoCamera = manager.findPhotoCamera(packageData.getFind());
                    PackageData toGuitar = new PackageData();
                    toGuitar.setPhotoCameras(arrayPhotoCamera);
                    outputStream.writeObject(toGuitar);
                    break;
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
