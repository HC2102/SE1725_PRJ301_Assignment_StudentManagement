/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Login.LoginBeans;
import dbConnect.DBContext;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author dange
 */
public class PasswordDAO {
    public static String ChangePass(LoginBeans loginbean) {
        String password = loginbean.getPassword();
        String username = loginbean.getUserName();
        String sql = "SELECT [User_name], User_Password FROM [User]";
        String userNameDB, passwordDB = "";
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            Statement st = con.createStatement(); // prepare for statement
            // take the user table
            ResultSet rs = st.executeQuery(sql);
            //check the table to find the user name and password
            while (rs.next()) {  
                userNameDB = rs.getString("User_name");
                passwordDB = rs.getString("User_Password");
                
                if (username.equals(userNameDB) && password.equals(passwordDB)) {
                    rs.close();
                    st.close();
                    con.close();
                    return "clear";
                }     
            }
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    public int UpdatePassword(String username,String newpass) {
        int rows = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "UPDATE [User] SET [user_password] = '" + newpass + "' WHERE [user_name] ='" + username + "';";
                rows = st.executeUpdate(sql);
                st.close();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rows = -1;
        }
        return rows;
    }
}
