package nl.timo.store;

/**
 * @author Timo Postma
 * @version 1.0
 * @since feb 2020
 * MIT License
 * Copyright 2020 Voornaam Achternaam
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreDataAccessObject {

    private final String DB_URL = "jdbc:mysql://localhost:3306/store";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String USER ;
    private final String PASS ;

    public StoreDataAccessObject(String USER, String PASS) {
        this.USER = USER;
        this.PASS = PASS;
    }

    /**
     * Create a product object from a result set
     *
     * @param rs result set from database data
     * @return product of database data
     */
    private Product createProduct(ResultSet rs) {

        try{

            int id = rs.getInt("id");
            String brand  = rs.getString("brand");
            String type  = rs.getString("type");
            double price = rs.getDouble("price");

            return new Product(id, brand, type, price);

        } catch (SQLException ex) {
            System.out.println("Error creating product");
        }

        return null;
    }

    /**
     * Get all products from the database
     *
     * @return list of product objects
     */
    public List<Product> getProducts() {
        String sql = "SELECT * FROM products ORDER BY brand";
        List<Product> list = new ArrayList<>();
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Product product = createProduct(rs);
                if (product != null){
                    list.add(product);
                }
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQL error getting data");
        }
        return list;
    }
    public Void addProduct(String brand,String type,String price){
        String sql = "INSERT INTO products (brand,type,price) VALUES";
        sql += "("+brand+","+brand+","+price+")";
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQL error getting data");
        }

      return null;
    }
    public Void editProduct(String brand,String type,String price){
        String sql = "UPDATE products (brand,type,price) VALUES";
        sql += "("+brand+","+brand+","+price+")";
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery(sql);
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQL error getting data");
        }

        return null;
    }


}
