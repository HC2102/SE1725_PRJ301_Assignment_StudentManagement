/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Semester;
import dbObject.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class SemesterDAO {

    public ArrayList<Semester> getAllStudent() {
        ArrayList<Semester> listSemester = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Semester";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Semester sem = new Semester();
                    sem.setSemester_ID(rs.getString(1));
                    sem.setTime_start(rs.getDate(2));
                    sem.setTime_end(rs.getDate(3));
                    sem.setCurrent_Semester(rs.getBoolean(4));
                    listSemester.add(sem);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listSemester;
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

//    public void deleteStudent(String ID) {
//        try {
//            DBContext db = new DBContext();
//            Connection con = db.getConnection();
//            if (con != null) {
//                Statement st = con.createStatement();
//                String sql = "DELETE FROM Student WHERE ID = " + ID + ";";
//                int rows = st.executeUpdate(sql);
//                st.close();
//                con.close();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public Semester getSemesterByID(String SemID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Semester WHERE Semester_ID = '" + SemID + "';";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    Semester sem = new Semester();
                    sem.setSemester_ID(rs.getString(1));
                    sem.setTime_start(rs.getDate(2));
                    sem.setTime_end(rs.getDate(3));
                    sem.setCurrent_Semester(rs.getBoolean(4));
                    return sem;
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

    public Semester getSemesterIDByCurrentSemester() {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM SEMESTER WHERE current_Semester = 1";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    Semester sem = new Semester();
                    sem.setSemester_ID(rs.getString(1));
                    sem.setTime_start(rs.getDate(2));
                    sem.setTime_end(rs.getDate(3));
                    sem.setCurrent_Semester(rs.getBoolean(4));
                    return sem;
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
