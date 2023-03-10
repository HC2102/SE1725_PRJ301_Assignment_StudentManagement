/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Student;
import dbObject.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HE170417
 */
public class UserDAO {
    public ArrayList<User> getAllUser() {
        ArrayList<User> list = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM [User]";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    User u = new User();
                    u.setUserName(rs.getString("User_name"));
                    u.setPassWord(rs.getString("User_Password"));
                    u.setRole(rs.getInt("Role_ID"));
                    list.add(u);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }
    public User getUser(String username) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM [User] WHERE User_name = '" + username + "';";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    User u = new User();
                    u.setUserName(rs.getString("User_name"));
                    u.setPassWord(rs.getString("User_Password"));
                    u.setRole(rs.getInt("Role_ID"));
                    return u;
                }
                rs.close();
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public int insertUser(User u) {
        int row = 0;
        try {
            
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO [User](User_name,User_Password,Role_ID)"
                        + " values ('" + u.getUserName() + "','" + u.getPassWord() + "','"+u.getRole()+"')";
                row = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            row =  -1;
        }
        return row;
    }
    //warning: delete cascade will delete the user and all common entirely? make sure to user them
    public int deleteCascadeUser(User u) {
        int row = 0;
        try {
            
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO [User](User_name,User_Password,Role_ID)"
                        + " values ('" + u.getUserName() + "','" + u.getPassWord() + "','"+u.getRole()+"')";
                row = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            row =  -1;
        }
        return row;
    }
}
