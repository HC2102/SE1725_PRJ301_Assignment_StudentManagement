/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Student_Class;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class StudentClassDAO {
    public ArrayList<Student_Class> getAllStudentClass() {
        ArrayList<Student_Class> listStudentClass = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Student_Class";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Student_Class stcl = new Student_Class();
                    stcl.setStudent_ID(rs.getString("Student_ID"));
                    stcl.setClass_ID(rs.getString("Class_ID"));
                    listStudentClass.add(stcl);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listStudentClass;
    }
    
    public void insertStudentIntoClass(Student_Class stcl) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO Student_Class(Student_ID, Class_ID)"
                        + " values ('" + stcl.getStudent_ID()+ "','" + stcl.getClass_ID()+ "')";
                int rows = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteStudentFromClass(String Student_ID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "DELETE FROM Student_Class WHERE Student_ID = " + Student_ID + ";";
                int rows = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public Student_Class getStudentFromClass(String Student_ID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Student_Class WHERE Student_ID = '" + Student_ID + "';";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    Student_Class stcl = new Student_Class();
                    stcl.setStudent_ID(rs.getString("Student_ID"));
                    stcl.setClass_ID(rs.getString("Class_ID"));
                    return stcl;
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
