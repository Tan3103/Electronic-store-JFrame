package DataBase;
import com.company.*;
import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    private String operationType;
    private int id;
    private String find;

    private Customer customer;
    private Laptop keyboardInstrument;
    private PhotoCamera percussionInstrument;
    private Smartphone smartphone;
    private Product product;

    private ArrayList<Customer> customers;
    private ArrayList<Smartphone> smartphones;
    private ArrayList<Laptop> keyboardInstruments;
    private ArrayList<PhotoCamera> percussionInstruments;
    private ArrayList<Product> products;

    public PackageData() {
    }

    public PackageData(ArrayList<Product> products) {
        this.products = products;
    }

    public PackageData(Product product) {
        this.product = product;
    }

    public PackageData(String operationType, Product product) {
        this.operationType = operationType;
        this.product = product;
    }

    public PackageData(String operationType, String find) {
        this.operationType = operationType;
        this.find = find;
    }

    public PackageData(String operationType, int id) {
        this.operationType = operationType;
        this.id = id;
    }

    public PackageData(String operationType, Customer customer) {
        this.operationType = operationType;
        this.customer = customer;
    }

    public PackageData(String operationType, Smartphone smartphone) {
        this.operationType = operationType;
        this.smartphone = smartphone;
    }

    public PackageData(String operationType, Laptop keyboardInstrument) {
        this.operationType = operationType;
        this.keyboardInstrument = keyboardInstrument;
    }

    public PackageData(String operationType, PhotoCamera percussionInstrument) {
        this.operationType = operationType;
        this.percussionInstrument = percussionInstrument;
    }

    public PackageData(String operationType) {
        this.operationType = operationType;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public Customer getVisitor() {
        return customer;
    }

    public void setVisitor(Customer customer) {
        this.customer = customer;
    }

    public Laptop getKeyboardInstrument() {
        return keyboardInstrument;
    }

    public void setKeyboardInstrument(Laptop keyboardInstrument) {
        this.keyboardInstrument = keyboardInstrument;
    }

    public PhotoCamera getPercussionInstrument() {
        return percussionInstrument;
    }

    public void setPercussionInstrument(PhotoCamera percussionInstrument) {
        this.percussionInstrument = percussionInstrument;
    }

    public Smartphone getGuitar() {
        return smartphone;
    }

    public void setGuitar(Smartphone smartphone) {
        this.smartphone = smartphone;
    }

    public ArrayList<Customer> getVisitors() {
        return customers;
    }

    public void setVisitors(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<Smartphone> getGuitars() {
        return smartphones;
    }

    public void setGuitars(ArrayList<Smartphone> smartphones) {
        this.smartphones = smartphones;
    }

    public ArrayList<Laptop> getKeyboardInstruments() {
        return keyboardInstruments;
    }

    public void setKeyboardInstruments(ArrayList<Laptop> keyboardInstruments) {
        this.keyboardInstruments = keyboardInstruments;
    }

    public ArrayList<PhotoCamera> getPercussionInstruments() {
        return percussionInstruments;
    }

    public void setPercussionInstruments(ArrayList<PhotoCamera> percussionInstruments) {
        this.percussionInstruments = percussionInstruments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFind() {
        return find;
    }

    public void setFind(String find) {
        this.find = find;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
}