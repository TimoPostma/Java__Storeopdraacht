package nl.timo.store;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class LoginDataAccessObject {

    private final String DB_URL = "jdbc:mysql://localhost:3306/store";
    private final String DRIVER = "com.mysql.jdbc.Driver";
    private final String USER ;
    private final String PASS ;

    public LoginDataAccessObject(String USER, String PASS) {
        this.USER = USER;
        this.PASS = PASS;
    }
    private User createUser(ResultSet rs) {

        try{

            int id = rs.getInt("id");
            String name  = rs.getString("name");
            String password  = rs.getString("password");

            return new User(id, name, password);

        } catch (SQLException ex) {
            System.out.println("Error creating product");
        }

        return null;
    }
    public Boolean getUser(String naam, String password) {
        String sql = "SELECT * FROM users WHERE name ="+"'"+naam+"'"+ "AND password ="+"'"+password+"'";
        //User user = new User(0,null,null);
        Boolean userexist = false;
        try {
            Class.forName(DRIVER);
            Connection con = DriverManager.getConnection(DB_URL, USER, PASS);
            PreparedStatement stmt = con.prepareStatement(sql);
            System.out.println(stmt);
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println(rs);

            while (rs.next()) {
               User user = createUser(rs);
                if (user != null){
                    userexist = true;
                }
            }
            rs.close();
            con.close();
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("SQL error getting data");
        }
        return userexist;
    }

}
