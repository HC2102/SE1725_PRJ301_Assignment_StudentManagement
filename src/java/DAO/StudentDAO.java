/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class StudentDAO {

    public ArrayList<Student> getAllStudent() {
        ArrayList<Student> listStudent = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Student";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Student s = new Student();
                    s.setStudentID(rs.getString("Student_ID"));
                    s.setUserName(rs.getString("User_name"));
                    s.setStudentName(rs.getString("Student_name"));
                    s.setMajorID(rs.getString("Major_ID"));
                    s.setPhoneNum(rs.getString("Phone_number"));
                    s.setAddress(rs.getString("Address"));
                    s.setEmail(rs.getString("Email"));
                    listStudent.add(s);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listStudent;
    }

    public int insertStudent(Student s) {
        int row = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO Student(Student_ID, User_name, Student_name, Major_ID, Phone_number, Address, Email)"
                        + " values ('" + s.getStudentID() + "','" + s.getUserName() + "','" + s.getStudentName() + "','" + s.getMajorID() + "','"
                        + s.getPhoneNum() + "','" + s.getAddress() + "','" + s.getPhoneNum() + "')";
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

    public int deleteStudent(String username) {
        int row = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "DELETE FROM Student WHERE [User_name] = '" + username + "';";
               row = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            row = -1;
            System.out.println(e.getMessage());
        }
        return row;
    }

    public int updateStudent(Student s) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "UPDATE [Student] SET  Student_name = '"+s.getStudentName()+"', [Address] ='"+s.getAddress()+"', Phone_number ='"+s.getPhoneNum()+
                        "', Email='"+s.getEmail()+"' WHERE [User_name] = '"+s.getUserName()+"'";
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
    public Student getStudent(String ID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Student WHERE Student_ID = '" + ID + "';";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    Student s = new Student();
                    s.setStudentID(rs.getString("Student_ID"));
                    s.setUserName(rs.getString("User_name"));
                    s.setStudentName(rs.getString("Student_name"));
                    s.setMajorID(rs.getString("Major_ID"));
                    s.setPhoneNum(rs.getString("Phone_number"));
                    s.setAddress(rs.getString("Address"));
                    s.setEmail(rs.getString("Email"));
                    return s;
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

    public Student getStudentByUsername(String Username) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Student WHERE User_name = '" + Username + "';";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    Student s = new Student();
                    s.setStudentID(rs.getString("Student_ID"));
                    s.setUserName(rs.getString("User_name"));
                    s.setStudentName(rs.getString("Student_name"));
                    s.setMajorID(rs.getString("Major_ID"));
                    s.setPhoneNum(rs.getString("Phone_number"));
                    s.setAddress(rs.getString("Address"));
                    s.setEmail(rs.getString("Email"));
                    return s;
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

    public ArrayList<Student> getAllStudentFromClassID(String classID) {
        ArrayList<Student> listStudentFromClassID = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT s.*, sc.Class_ID FROM Student s, Student_Class sc WHERE s.Student_ID = sc.Student_ID and Class_ID = '" + classID + "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Student s = new Student();
                    s.setStudentID(rs.getString("Student_ID"));
                    s.setUserName(rs.getString("User_name"));
                    s.setStudentName(rs.getString("Student_name"));
                    s.setMajorID(rs.getString("Major_ID"));
                    s.setPhoneNum(rs.getString("Phone_number"));
                    s.setAddress(rs.getString("Address"));
                    s.setEmail(rs.getString("Email"));
                    listStudentFromClassID.add(s);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listStudentFromClassID;
    }
}
