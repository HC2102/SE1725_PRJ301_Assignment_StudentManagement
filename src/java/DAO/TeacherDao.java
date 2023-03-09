/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.CPS;
import dbObject.Student_Class_Mark;
import dbObject.Teacher;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dbObject.Class;
import dbObject.Student;
import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author ADMIN
 */
public class TeacherDao extends DBContext {

    public int insertTeacher(Teacher t) {
        int row = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();

            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO Teacher(User_name, Teacher_name, Major_ID, Phone_number, Address, Email)"
                        + " values ('" + t.getUserName() + "','" + t.getTeacherName() + "','" + t.getMajorID() + "','" + t.getPhoneNum() + "','"
                        + t.getAddress() + "','" + t.getEmail() + "')";
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

    public Teacher getByUserName(String user_name) {
        String sql = "select * from Teacher where User_name = ?";
        try {
            PreparedStatement st = (PreparedStatement) getConnection().prepareStatement(sql);
            st.setString(1, user_name);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Teacher t = new Teacher(rs.getString("User_name"), rs.getString("Teacher_name"), rs.getString("Major_ID"), rs.getString("Phone_number"), rs.getString("Address"), rs.getString("Email"));
                return t;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<CPS> getCpsByUserName(String user_name) {
        /*
        [CPS_ID] [int] NOT NULL,
	[Course_ID] [nvarchar](10) NOT NULL,
	[Semester_ID] [nvarchar](15) NOT NULL,
	[Teacher_User_name] [nvarchar](30) NOT NULL,
	[Biographic] [ntext] NULL,
	[Resource] [ntext] NULL,
         */
        List<CPS> list = new ArrayList<>();
        String sql = "select * from CPS\n"
                + "where Teacher_User_name = ?";
        try {
            PreparedStatement st = (PreparedStatement) getConnection().prepareStatement(sql);
            st.setString(1, user_name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CPS cps = new CPS(rs.getInt("CPS_ID"), rs.getString("Course_ID"), rs.getString("Semester_ID"), rs.getString("Teacher_User_name"), rs.getString("Biographic"), rs.getString("Resource"));
                list.add(cps);
            }
            st.close();
        } catch (Exception e) {
        }
        return list;
    }

    public CPS getCpsByCid(int cid) {
//        select * from CPS where  CPS_ID= 
        String sql = "select * from CPS where  CPS_ID= ?";
        try {
            PreparedStatement st = (PreparedStatement) getConnection().prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                CPS cps = new CPS(rs.getInt("CPS_ID"), rs.getString("Course_ID"), rs.getString("Semester_ID"), rs.getString("Teacher_User_name"), rs.getString("Biographic"), rs.getString("Resource"));
                return cps;
            }
            st.close();
        } catch (Exception e) {
        }
        return null;
    }

    public ArrayList<Student_Class_Mark> getStudent_Class_MarkByCid(int cid) {
        ArrayList<Student_Class_Mark> list = new ArrayList<>();
        ClassDAO cd = new ClassDAO();
        StudentDAO sd = new StudentDAO();
        String sql = "select sc.* from Enrolled e, Class c, Student_Class sc where e.CPS_ID =? and e.Class_ID=c.Class_ID and c.Class_ID=sc.Class_ID";
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            PreparedStatement st = con.prepareStatement(sql);
            st.setInt(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Student_Class_Mark sc = new Student_Class_Mark();
                Class c = cd.getClass(rs.getString("Class_ID"));
                sc.setCl(c);
                Student s = sd.getStudent(rs.getString("Student_ID"));
                sc.setSt(s);
                list.add(sc);
            }
            st.close();
            con.close();
        } catch (Exception e) {
            System.out.println("gCM: " + e.getMessage());
        }
        return list;
    }

    public List<Double> getListMarkOfStudentByCourseIdAndStudentId(List<Student_Class_Mark> list, String course_id) {
        List<Double> list_marks = new ArrayList<>();
        for (Student_Class_Mark Student_Class_Mark : list) {
            String sql = "With R as\n"
                    + "(\n"
                    + "select G.Student_ID, G.Course_ID, G.Test_ID ,G.Value\n"
                    + "from Test T, Grade G\n"
                    + "where G.Course_ID = T.Course_ID and G.Test_ID = T.Test_ID\n"
                    + ") \n"
                    + "\n"
                    + "select(sum(R.Value * T.Weight))/100 [DiemTB]\n"
                    + "from R, Test T\n"
                    + "where r.Student_ID=? and  r.Course_ID=? and  r.Test_ID = T.Test_ID and R.Course_ID = T.Course_ID\n"
                    + "group by  R.Student_ID, R.Course_ID";
            try {
                PreparedStatement st = (PreparedStatement) getConnection().prepareStatement(sql);
                st.setString(1, Student_Class_Mark.getSt().getStudentID());
                st.setString(2, course_id);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    double mark = rs.getDouble("DiemTB");
                    list_marks.add(mark);
                }
            } catch (Exception e) {
            }
        }
        return list_marks;
    }

    public static void main(String[] args) {
        List<Student_Class_Mark> list = new ArrayList<>();
        TeacherDao td = new TeacherDao();
        list = td.getStudent_Class_MarkByCid(1);
        List<Double> list_marks = td.getListMarkOfStudentByCourseIdAndStudentId(list, "PRF192");
        System.out.println(list_marks.get(0) + " " + list_marks.get(1));
        CPS cps = td.getCpsByCid(5);
        System.out.println(cps.getCourse_ID());
    }
}
