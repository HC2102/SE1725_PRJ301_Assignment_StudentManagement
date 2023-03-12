/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Major;
import dbObject.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author HE170417
 */
public class MajorDAO {

    public int deleteMajor(String ID) {
        int row = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "DELETE FROM [Major] WHERE [Major_ID] = '" + ID + "';";
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

    public int insertUser(Major m) {
        int row = 0;
        try {

            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO Major([Major_ID],[Major_name],[Biographic])\n"
                        + "values ('"+m.getID()+"','"+m.getName()+"','"+m.getBio()+"')";
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

    public int updateStudent(Major m) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "UPDATE MAJOR SET [Major_name] ='" + m.getName() + "', [Biographic]='" + m.getBio() + "' WHERE [Major_ID] = '" + m.getID() + "'";
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

    public ArrayList<Major> getAllMajors() {
        ArrayList<Major> list = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM MAJOR";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Major m = new Major();
                    m.setID(rs.getString("Major_ID"));
                    m.setName(rs.getString("Major_name"));
                    m.setBio(rs.getString("Biographic"));
                    list.add(m);
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
}
