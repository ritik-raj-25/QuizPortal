package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserDAO {
    private final static String URL = "jdbc:derby://localhost:1527/QuizAppDB";
    private final static String USER_NAME = "team1";
    private final static String PASSWORD = "team1";
    public static Connection getConnection(){
        Connection con = null;
        try{
            con = DriverManager.getConnection(URL,USER_NAME,PASSWORD);
        }catch(SQLException e){
            System.out.println(e);
        }
        return con;
    }
    
    public static int saveUser(User u){
        int status = 0;
        String query = "insert into users (userName,password,email,userType) values (?,?,?,?)";
        try(Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query);){
            String userName = u.getUserName();
            String password = u.getPassword();
            String email = u.getEmail();
            String userType = u.getUserType();
           
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, userType);
            status = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return status;
    }
    
    public static int updateUser(User u){
        int status = 0;
        String query = "update users set userName=?, password=?, email=?, userType=? where userName = ?";
        try(Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)){
            String userName = u.getUserName();
            String password = u.getPassword();
            String email = u.getEmail();
            String userType = u.getUserType();
            
            ps.setString(1, userName);
            ps.setString(2, password);
            ps.setString(3, email);
            ps.setString(4, userType);
            ps.setString(5, userName);
            status = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return status;
    }
    
    public static int deleteUser(String userName){
        int status = 0;
        String query = "delete from users where userName = ?";
        try(Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)){  
            ps.setString(1, userName);
            status = ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
        }
        return status;
    }
    
    public static User getUserByUsername(String username) {
        User user = null;
        String query = "SELECT userId, userName, password, email, userType FROM users WHERE userName = ?";
        try (Connection con = getConnection(); PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getInt("userId"));  // Fetch and set the userId from the result set
                user.setUserName(rs.getString("userName"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setUserType(rs.getString("userType"));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return user;
    }
    
    public static List<User> viewUser(){
        List<User> users = new ArrayList<>();
        String query = "select userName, password, email, userType from users";
        try(Connection con = getConnection(); Statement stmt = con.createStatement()){  
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                User u = new User();
                u.setUserName(rs.getString(2));
                u.setPassword(rs.getString(3));
                u.setEmail(rs.getString(4));
                u.setUserType(rs.getString(5));
                users.add(u);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return users;
    }
}
