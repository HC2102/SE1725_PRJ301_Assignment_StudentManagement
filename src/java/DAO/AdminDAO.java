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
     public int updateAdmin(Admin a) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "Update [Admin] Set Admin_name = '"+a.getAdmin_name()+"', [Address] = '"+a.getAdmin_Address()+
                        "',Phone_number='"+a.getAdmin_phonenumber()+"',Email='"+a.getAdmin_email()+"'  WHERE [User_name] ='"+a.getAdmin_username()+"'";
                int rows = st.executeUpdate(sql);
                st.close();
                con.close();
                return rows;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return 0;
    }

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

    public int insertAdmin(Admin a) {
        int row = 0;
        try {

            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO [Admin](User_name,Admin_name,Address,Phone_number,Email)"
                        + " values ('" + a.getAdmin_username() + "','" + a.getAdmin_name() + "','" + a.getAdmin_Address() + "','" + a.getAdmin_phonenumber() + "','" + a.getAdmin_email() + "')";
                row = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            row = -1;
        }
        return row;
    }

    public int deleteAdmin(String username) {
        int row = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "DELETE FROM [Admin] WHERE [User_name] = '" + username + "';";
                row = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            row = -1;
        }
        return row;
    }
}
