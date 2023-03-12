/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.CPS;
import dbObject.Student;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class CPSDAO {

    public ArrayList<CPS> getAllCPS() {
        ArrayList<CPS> listCPS = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM CPS";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    CPS cps = new CPS();
                    cps.setCps_id(rs.getInt(1));
                    cps.setCourse_ID(rs.getString(2));
                    cps.setSemesterID(rs.getString(3));
                    cps.setTeacher_User_name(rs.getString(4));
                    cps.setBiographic(rs.getString(5));
                    cps.setResource(rs.getString(6));
                    listCPS.add(cps);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listCPS;
    }

    public int deleteCPS(int CPSID) {
        int rows = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "DELETE FROM CPS WHERE CPS_ID = " + CPSID + ";";
                rows = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            rows = -1;
            System.out.println(e.getMessage());
        }
        return rows;
    }

    public int insertCPS(CPS cps) {
        int rows = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO CPS(CPS_ID, Course_ID, Semester_ID, Teacher_User_name, Biographic, [Resource])"
                        + " Values (" + cps.getCps_id() + ",'" + cps.getCourse_ID() + "','" + cps.getSemesterID() + "','" + cps.getTeacher_User_name() + "','"
                        + cps.getBiographic() + "','" + cps.getResource() + "')";
                rows = st.executeUpdate(sql);
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            rows = -1;
        }
        return rows;
    }
    
    public int getMaxCPSID() {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT Max(CPS_ID)[index] From CPS";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    int maxCPS = rs.getInt("index");
                    return maxCPS;
                    
                }
                rs.close();
                st.close();
                con.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return -1;
    }
    
    public CPS getCPSByID(int CPSID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM CPS WHERE CPS_ID = " + CPSID + "";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    CPS cps = new CPS();
                    cps.setCps_id(rs.getInt(1));
                    cps.setCourse_ID(rs.getString(2));
                    cps.setSemesterID(rs.getString(3));
                    cps.setTeacher_User_name(rs.getString(4));
                    cps.setBiographic(rs.getString(5));
                    cps.setResource(rs.getString(6));
                    return cps;
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
    
    public ArrayList<CPS> getCPSByClassIDAndMajor(String ClassID, String majorID) {
        ArrayList<CPS> listCPSByClassIDAndMajor = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT cps.*\n" +
                            "FROM CPS cps, Course c\n" +
                            "WHERE cps.Course_ID = c.Course_ID and cps.Course_ID not in (SELECT c.Course_ID\n" +
                            "							FROM Enrolled e, CPS cps, Course c\n" +
                            "							WHERE E.CPS_ID = cps.CPS_ID and cps.Course_ID = c.Course_ID\n" +
                            "							and e.Class_ID = '" + ClassID + "') and c.Major_ID = '" + majorID+ "'";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    CPS cps = new CPS();
                    cps.setCps_id(rs.getInt(1));
                    cps.setCourse_ID(rs.getString(2));
                    cps.setSemesterID(rs.getString(3));
                    cps.setTeacher_User_name(rs.getString(4));
                    cps.setBiographic(rs.getString(5));
                    cps.setResource(rs.getString(6));
                    listCPSByClassIDAndMajor.add(cps);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listCPSByClassIDAndMajor;
    }
    
}
