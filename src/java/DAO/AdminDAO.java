/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Admin;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 *
 * @author dange
 */
public class AdminDAO {
    public Admin getAdmin(String username) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM [ADMIN] WHERE [user_name] = '" + username + "';";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    Admin a = new Admin();
                    a.setAdmin_username(rs.getString("user_name"));
                    a.setAdmin_name(rs.getString("admin_name"));
                    a.setAdmin_Address(rs.getString("address"));
                    a.setAdmin_phonenumber(rs.getString("Phone_number"));
                    a.setAdmin_email(rs.getString("email"));
                    rs.close();
                    st.close();
                    con.close();
                    return a;
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
