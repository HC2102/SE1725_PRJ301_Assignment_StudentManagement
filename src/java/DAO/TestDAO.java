/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Test;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author dange
 */
public class TestDAO {
     public ArrayList<Test> getAllTest() {
        ArrayList<Test> listT = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Test";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Test t = new Test();
                    t.setCourse_id(rs.getString("Course_id"));
                    t.setTest_id(rs.getString("Test_id"));
                    t.setTest_name(rs.getString("Test_name"));
                    t.setWeight(rs.getInt("weight"));
                    listT.add(t);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listT;
    }
    public ArrayList<Test> getTestbyID(String id) {
        ArrayList<Test> listT = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Test where Course_id = '"+ id +"'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Test t = new Test();
                    t.setCourse_id(rs.getString("Course_id"));
                    t.setTest_id(rs.getString("Test_id"));
                    t.setTest_name(rs.getString("Test_name"));
                    t.setWeight(rs.getInt("weight"));
                    listT.add(t);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listT;
    }
    public int insertTest(Test t) {
        int row = 0;
        try {
            
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO [Test](Test_ID,Course_ID,Test_name,weight)"
                        + " values ('" + t.getTest_id() + "','" + t.getCourse_id() + "','"+t.getTest_name()+"','"+t.getWeight()+"')";
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
    public int deleteTest(String id) {
         int row = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "DELETE FROM [Test] WHERE [Test_id] = '" + id + "';";
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
