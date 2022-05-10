package DataBase;
import com.company.*;
import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private int id;
    private Integer customer_id;
    private Integer product_id;
    private String find;

    private Customer customer;
    private Laptop laptop;
    private PhotoCamera photoCamera;
    private Smartphone smartphone;

    private ArrayList<Customer> customers;
    private ArrayList<Smartphone> smartphones;
    private ArrayList<Laptop> laptops;
    private ArrayList<PhotoCamera> photoCameras;

    public PackageData() {
    }


    public PackageData(Customer customer) {
        this.customer = customer;
    }

    /*
    public PackageData(String operationType, Integer customer_id, Integer product_id) {
        this.operationType = operationType;
        this.customer_id = customer_id;
        this.product_id = product_id;
    }

     */

    public PackageData(String operationType, Smartphone smartphone) {
        this.operationType = operationType;
        this.smartphone = smartphone;
    }

    public PackageData(String operationType, PhotoCamera photoCamera) {
        this.operationType = operationType;
        this.photoCamera = photoCamera;
    }

    public PackageData(String operationType, String find) {
        this.operationType = operationType;
        this.find = find;
    }

    public PackageData(String operationType, int id) {
        this.operationType = operationType;
        this.id = id;
    }

    public PackageData(String operationType, Laptop laptop) {
        this.operationType = operationType;
        this.laptop = laptop;
    }

    public PackageData(String operationType, Customer customer) {
        this.operationType = operationType;
        this.customer = customer;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public int getId() {
        return id;
    }

    public String getFind() {
        return find;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFind(String find) {
        this.find = find;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setSmartphone(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public void setSmartphones(ArrayList<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }

    public Smartphone getSmartphone() {
        return smartphone;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public ArrayList<Smartphone> getSmartphones() {
        return smartphones;
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }

    public PhotoCamera getPhotoCamera() {
        return photoCamera;
    }

    public void setPhotoCamera(PhotoCamera photoCamera) {
        this.photoCamera = photoCamera;
    }

    public ArrayList<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(ArrayList<Laptop> laptops) {
        this.laptops = laptops;
    }

    public ArrayList<PhotoCamera> getPhotoCameras() {
        return photoCameras;
    }

    public void setPhotoCameras(ArrayList<PhotoCamera> photoCameras) {
        this.photoCameras = photoCameras;
    }

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }
}
