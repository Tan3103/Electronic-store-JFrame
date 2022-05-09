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
                    "INSERT INTO smartphone (id, type, name, price, count, numberSIM) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?)");

            statement.setString(1, smartphone.getType());
            statement.setString(2, smartphone.getName());
            statement.setInt(3, smartphone.getCost());
            statement.setInt(4, smartphone.getCount());
            statement.setInt(5, smartphone.getNumberSIM());

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addLaptop(Laptop laptop) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO laptop (id, type, name, price, count, videoCard) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?)");

            statement.setString(1, laptop.getType());
            statement.setString(2, laptop.getName());
            statement.setInt(3, laptop.getCost());
            statement.setInt(4, laptop.getCount());
            statement.setString(5, laptop.getVideoCard());

            statement.executeUpdate();
            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addPhotoCamera(PhotoCamera photoCamera) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO photoCamera (id, type, name, price, count, typeAutofocus) " +
                    "VALUES (NULL, ?, ?, ?, ?, ?)");

            statement.setString(1, photoCamera.getType());
            statement.setString(2, photoCamera.getName());
            statement.setInt(3, photoCamera.getCost());
            statement.setInt(4, photoCamera.getCount());
            statement.setString(5, photoCamera.getTypeAutofocus());

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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM visitor");
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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM numberSIM");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int numberSIM = resultSet.getInt("numberSIM");

                smartphoneList.add(new Smartphone(id, type, name, price, count, numberSIM));
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
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM laptop");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                String videoCard = resultSet.getString("videoCard");

                laptopList.add(new Laptop(id, type, name, price, count, videoCard));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return laptopList;
    }

    public ArrayList<PhotoCamera> getAllPercussion(){
        ArrayList<PhotoCamera> percussionList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM percussioninstruments");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                String diameter = resultSet.getString("diameter");

                percussionList.add(new PhotoCamera(id,  type, name, price, count, discount, diameter));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return percussionList;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void deleteVisitors(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" + "DELETE FROM visitor WHERE id = ?");
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String findGuitar(String findName){
        String s = "";
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 1 AND name = '" + findName + "'");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                int strings = resultSet.getInt("strings");
                int frets = resultSet.getInt("frets");

                Guitar find = new Guitar(id, type, name, price, count, discount, strings, frets);
                s = find.info();
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public String findKeyboard(String findName){
        String s = "";
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 2 AND name = '" + findName + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                int keyss = resultSet.getInt("keyss");

                KeyboardInstruments find = new KeyboardInstruments(id, type, name, price, count, discount, keyss);
                s = find.info();
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }

    public String findPercussion(String findName){
        String s = "";
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM product WHERE type_id = 3 AND name = '" + findName + "'");
            ResultSet resultSet = statement.executeQuery();
            while(resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String type = resultSet.getString("type");
                String name = resultSet.getString("name");
                int price = resultSet.getInt("price");
                int count = resultSet.getInt("count");
                int discount = resultSet.getInt("discount");
                String diameter = resultSet.getString("diameter");

                PercussionInstruments find = new PercussionInstruments(id, type, name, price, count, discount, diameter);
                s = find.info();
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return s;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Product> getAllDiscount(){
        ArrayList<Product> discountList = new ArrayList<>();
        try{
            PreparedStatement statement1 = connection.prepareStatement("SELECT * FROM guitar");
            ResultSet resultSet1 = statement1.executeQuery();

            while(resultSet1.next()){
                Integer id = resultSet1.getInt("id");
                String type = resultSet1.getString("type");
                String name = resultSet1.getString("name");
                int price = resultSet1.getInt("price");
                int count = resultSet1.getInt("count");
                int discount = resultSet1.getInt("discount");
                int strings = resultSet1.getInt("strings");
                int frets = resultSet1.getInt("frets");

                discountList.add(new Smartphone(id, type, name, price, count, discount, strings, frets));
            }

            PreparedStatement statement2 = connection.prepareStatement("SELECT * FROM keyboardinstruments");
            ResultSet resultSet2 = statement2.executeQuery();

            while(resultSet2.next()){
                Integer id = resultSet2.getInt("id");
                String type = resultSet2.getString("type");
                String name = resultSet2.getString("name");
                int price = resultSet2.getInt("price");
                int count = resultSet2.getInt("count");
                int discount = resultSet2.getInt("discount");
                int keyss = resultSet2.getInt("keyss");

                discountList.add(new Laptop(id, type, name, price, count, discount,keyss));
            }

            PreparedStatement statement3 = connection.prepareStatement("SELECT * FROM percussioninstruments");
            ResultSet resultSet3 = statement3.executeQuery();

            while(resultSet3.next()){
                Integer id = resultSet3.getInt("id");
                String type = resultSet3.getString("type");
                String name = resultSet3.getString("name");
                int price = resultSet3.getInt("price");
                int count = resultSet3.getInt("count");
                int discount = resultSet3.getInt("discount");
                String diameter = resultSet3.getString("diameter");

                discountList.add(new PhotoCamera(id,  type, name, price, count, discount, diameter));
            }
            statement1.close();
            statement2.close();
            statement3.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return discountList;
    }

    public void addBasket(Integer visitor_id, Product product) {
        try {
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO cart (visitor_id, name, price, discount) " +
                    "VALUES (?, ?, ?, ?)");
            statement.setInt(1,visitor_id);
            statement.setString(2, product.getName());
            statement.setInt(3, product.getCost());
            statement.setInt(4, product.getDiscount());

            statement.executeUpdate();

            statement.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Customer getVisitor(String fname){
        Customer customer = new Customer();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM visitor WHERE name = '" + fname + "'");
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

    public Product getProduct(Integer id){
        Customer customer = new Customer();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM guitar WHERE name = '" + fname + "'");
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
}

