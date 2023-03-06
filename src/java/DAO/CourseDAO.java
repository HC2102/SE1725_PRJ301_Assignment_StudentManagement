/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Course;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class CourseDAO {
    public ArrayList<Course> getAllStudent() {
        ArrayList<Course> listCourse = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Course";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Course c = new Course();
                    c.setCourse_ID(rs.getString("Course_ID"));
                    c.setCourse_name(rs.getString("Course_name"));
                    c.setMajor_ID(rs.getString("Major_ID"));
                    c.setBiographic(rs.getString("Biographic"));
                    listCourse.add(c);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listCourse;
    }

    public void insertCourse(Course c) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO Course(Course_ID, Course_name, Major_ID, Biographic)"
                        + " values ('" + c.getCourse_ID() + "','" + c.getCourse_name() + "','" + c.getMajor_ID() + "','" + c.getBiographic() + "')";
                int rows = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteCourse(String Course_ID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "DELETE FROM Course WHERE Course_ID = " + Course_ID + ";";
                int rows = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

//    public void updateStudent(Student s) {
//        try {
//            DBContext db = new DBContext();
//            Connection con = db.getConnection();
//            if (con != null) {
//                Statement st = con.createStatement();
//                String sql = "UPDATE Student SET Name = '" + cat.getName() + "' WHERE ID = " + cat.getID() + ";";
//                int rows = st.executeUpdate(sql);
//                st.close();
//                con.close();
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }
    public Course getCourse(String Course_ID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Course WHERE Course_ID = '" + Course_ID + "';";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    Course c = new Course();
                    c.setCourse_ID(rs.getString("Course_ID"));
                    c.setCourse_name(rs.getString("Course_name"));
                    c.setMajor_ID(rs.getString("Major_ID"));
                    c.setBiographic(rs.getString("Biographic"));
                    return c;
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

    public Course getCourseByStudentID(String studentID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT DISTINCT c.Course_ID, c.Course_name\n" +
                                "FROM Course c, Grade g WHERE c.Course_ID = g.Course_ID and g.Student_ID = '" + studentID + "';";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    Course c = new Course();
                    c.setCourse_ID(rs.getString("Course_ID"));
                    c.setCourse_name(rs.getString("Course_name"));
                    return c;
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

    public ArrayList<Course> getAllCourseFromStudentID(String studentID) {
        ArrayList<Course> listCourseFromStudentID = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT DISTINCT c.Course_ID, c.Course_name\n" +
                                "FROM Course c, Grade g WHERE c.Course_ID = g.Course_ID and g.Student_ID = '" + studentID + "';";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Course c = new Course();
                    c.setCourse_ID(rs.getString("Course_ID"));
                    c.setCourse_name(rs.getString("Course_name"));
                    listCourseFromStudentID.add(c);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listCourseFromStudentID;
    }
}

