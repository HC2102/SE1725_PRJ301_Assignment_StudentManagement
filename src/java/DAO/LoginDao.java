/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Login.LoginBeans;
import dbConnect.DBContext;
import java.sql.*;

/**
 *
 * @author HE170417
 */
public class LoginDao {

    public String authenticateUser(LoginBeans loginbean) {

        String userName = loginbean.getUserName();
        String password = loginbean.getPassword();
        String sql = "SELECT [User_name], User_Password, Role_ID FROM [User]";
        String userNameDB, passwordDB, roleDB = "";
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
                roleDB = rs.getString("Role_ID");

                if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("0")) {
                    rs.close();
                    st.close();
                    con.close();
                    return "Admin";
                }
                if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("1")) {
                    
                    rs.close();
                    st.close();
                    con.close();
                    return "Student";
                }
                if (userName.equals(userNameDB) && password.equals(passwordDB) && roleDB.equals("2")) {
                    rs.close();
                    st.close();
                    con.close();
                    return "Teacher";
                }
            }
            rs.close();
            st.close();
            con.close();

        } catch (Exception e) {
            System.out.println("DAO login: " + e.getMessage());
        }
        return "Invalid authentication";

    }
}
