package DataBase;
import com.company.*;
import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    public static Connection connection = null;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bd_olzhas?useUnicode=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addSmartphone(Smartphone smartphone) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO product(id, type, name, cost, count, numberSIM, typeID) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, smartphone.getType());
            statement.setString(2, smartphone.getName());
            statement.setInt(3, smartphone.getCost());
            statement.setInt(4, smartphone.getCount());
            statement.setInt(5, smartphone.getNumberSIM());
            statement.setInt(6, 1);

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addLaptop(Laptop laptop) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO product (id, type, name, cost, count, videoCard, typeID) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, laptop.getType());
            statement.setString(2, laptop.getName());
            statement.setInt(3, laptop.getCost());
            statement.setInt(4, laptop.getCount());
            statement.setString(5, laptop.getVideoCard());
            statement.setInt(6, 2);

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPhotoCamera(PhotoCamera photoCamera) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO product (id, type, name, cost, count, typeAutofocus, typeID) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?, ?)");

            statement.setString(1, photoCamera.getType());
            statement.setString(2, photoCamera.getName());
            statement.setInt(3, photoCamera.getCost());
            statement.setInt(4, photoCamera.getCount());
            statement.setString(5, photoCamera.getTypeAutofocus());
            statement.setInt(6, 3);
            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addCustomer(Customer customer) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO customer (id, login, password, name, surname) " +
                    "VALUES (NULL, ?, ?, ?, ?)");
            statement.setString(1, customer.getLogin());
            statement.setString(2, customer.getPassword());
            statement.setString(3, customer.getName());
            statement.setString(4, customer.getSurname());
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<Customer> getAllVisitor() {
        ArrayList<Customer> customerList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                customerList.add(new Customer(id, login, password, name, surname));
            }
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerList;
    }

    public ArrayList<Smartphone> getAllSmartphone(){
        ArrayList<Smartphone> smartphoneList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE typeID= 1");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                int count = resultSet.getInt("count");
                int numberSIM = resultSet.getInt("numberSIM");

                smartphoneList.add(new Smartphone(id, type, name, cost, count, numberSIM));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return smartphoneList;
    }

    public ArrayList<Laptop> getAllLaptop(){
        ArrayList<Laptop> laptopList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE typeID= 2");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                int count = resultSet.getInt("count");
                String videoCard = resultSet.getString("videoCard");

                laptopList.add(new Laptop(id, type, name, cost, count, videoCard));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return laptopList;
    }

    public ArrayList<PhotoCamera> getAllPhotoCamera(){
        ArrayList<PhotoCamera> percussionList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE typeID= 3");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                int count = resultSet.getInt("count");
                String typeAutofocus = resultSet.getString("typeAutofocus");

                percussionList.add(new PhotoCamera(id,  type, name, cost, count, typeAutofocus));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return percussionList;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void deleteCustomer(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" + "DELETE FROM customer WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void deleteProduct(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" + "DELETE FROM product WHERE id = ?");
            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void updateProduct(Integer id) {
        try{
            PreparedStatement statement = connection.prepareStatement("" + "UPDATE product SET count=count-1 WHERE id=?");

            statement.setInt(1, id);
            statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

//////////////////////////////////


    public void updateBasket(Integer product_id, Integer customer_id) {
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO backet (id, customer_id, product_id ) " +
                    "VALUES (NULL, ?, ?)");
            statement.setInt(1, customer_id);
            statement.setInt(2, product_id);
            statement.executeUpdate();

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getAllBasket(Integer idka){
        ArrayList<Product> productList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM backet WHERE customer_id = '" + idka + "'");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int name = resultSet.getInt("product_id");
                productList.add(getProduct(name));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return productList;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<Smartphone> findSmartphone(String findName){
        ArrayList<Smartphone> smartphoneList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE typeID = 1 AND name = '" + findName + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                int count = resultSet.getInt("count");
                int numberSIM = resultSet.getInt("numberSIM");

                smartphoneList.add(new Smartphone(id, type, name, cost, count, numberSIM));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return smartphoneList;
    }

    public ArrayList<Laptop> findLaptop(String findName){
        ArrayList<Laptop> laptopList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE typeID = 2 AND name = '" + findName + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                int count = resultSet.getInt("count");
                String videoCard = resultSet.getString("videoCard");

                laptopList.add(new Laptop(id, type, name, cost, count, videoCard));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return laptopList;
    }

    public ArrayList<PhotoCamera> findPhotoCamera(String findName){
        ArrayList<PhotoCamera> photoCameraList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE typeID = 3 AND name = '" + findName + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                int count = resultSet.getInt("count");
                String typeAutofocus = resultSet.getString("typeAutofocus");

                photoCameraList.add(new PhotoCamera(id, type, name, cost, count, typeAutofocus));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return photoCameraList;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public Customer getVisitor(String fname){
        Customer customer = new Customer();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM customer WHERE login = '" + fname + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                customer = new Customer(id, login, password, name, surname);
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return customer;
    }

    public Product getProduct(Integer idka){
        Product product = new Smartphone();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE id = '" + idka + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int cost = resultSet.getInt("cost");
                int count = resultSet.getInt("count");
                product = new Smartphone(id, type, name, cost, count);
            }

            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return product;
    }
}

