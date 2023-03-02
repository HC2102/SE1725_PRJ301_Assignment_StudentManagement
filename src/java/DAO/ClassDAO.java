/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Class;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class ClassDAO {
    public ArrayList<Class> getAllClass() {
        ArrayList<Class> listClass = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Class";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Class cl = new Class();
                    cl.setClass_ID(rs.getString("Class_ID"));
                    cl.setMajor_ID(rs.getString("Major_ID"));
                    listClass.add(cl);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listClass;
    }
    
    public void insertClass(Class cl) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO Class(Class_ID, Major_ID)"
                        + " values ('" + cl.getClass_ID() + "','" + cl.getMajor_ID()+ "')";
                int rows = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteClass(String Class_ID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "DELETE FROM Class WHERE Class_ID = " + Class_ID + ";";
                int rows = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Class getClass(String Class_ID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Class WHERE Class_ID = '" + Class_ID + "';";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    Class cl = new Class();
                    cl.setClass_ID(rs.getString("Class_ID"));
                    cl.setMajor_ID(rs.getString("Major_ID"));
                    return cl;
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
