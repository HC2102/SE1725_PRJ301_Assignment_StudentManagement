/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Semester;
import dbObject.Student;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zarius
 */
public class SemesterDAO {

    public ArrayList<Semester> getAllSemester() {
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
                    sem.setTime_start(rs.getDate(2).toString());
                    sem.setTime_end(rs.getDate(3).toString());
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

    public int insertSemester(Semester s) {
        int row = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT [Semester] (Semester_ID,Time_start,Time_end)VALUES('"+s.getSemester_ID()+"','"+s.getTime_start()+"','"+s.getTime_end()+"')";
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

    public int deleteSemester(String ID) {
        int row = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "DELETE FROM Semester WHERE Semester_ID = '" + ID + "'";
                row = st.executeUpdate(sql);
                st.close();
                con.close();
            }
            if(row <1){
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            row = -1;
        }
        return row;
    }

    public int setActiveSemester(String semesterID) {
        int row = 0;
        String sql = "{call proc_setActive_Semester(?)}";
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                CallableStatement st = con.prepareCall(sql);
                //dau vao
                st.setString(1, semesterID);
                //run
                row = st.executeUpdate();
                st.close();
            }
            con.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            row = -1;
        }
        return row;
    }

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
                    sem.setTime_start(rs.getDate(2).toString());
                    sem.setTime_end(rs.getDate(3).toString());
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
                    sem.setTime_start(rs.getDate(2).toString());
                    sem.setTime_end(rs.getDate(3).toString());
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
    public String changeDateFormatSQL(String oldDate){
        SimpleDateFormat inputFormat = new SimpleDateFormat("mm/dd/yyyy");
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date date;
        String formated=null;
        try {
            date = inputFormat.parse(oldDate);
            formated = newFormat.format(date);
            
        } catch (ParseException ex) {
            System.out.println(formated);
            Logger.getLogger(SemesterDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formated;
    }
   
}
