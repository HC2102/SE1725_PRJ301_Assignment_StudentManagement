/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author HE170417
 */
public class UserDAO {
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
}
