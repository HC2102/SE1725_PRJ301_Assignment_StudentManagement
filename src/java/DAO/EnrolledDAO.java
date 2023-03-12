/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.Enrolled;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class EnrolledDAO {
     public ArrayList<Enrolled> getAllEnrolled() {
        ArrayList<Enrolled> listEnrolled = new ArrayList<>();
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "SELECT * FROM Enrolled";
                ResultSet rs = st.executeQuery(sql);
                while (rs.next()) {
                    Enrolled e = new Enrolled();
                    e.setCPSID(rs.getInt(1));
                    e.setClassID(rs.getString(2));
                    listEnrolled.add(e);
                }
                rs.close();
                st.close();
                con.close();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return listEnrolled;
    }
     
     public int insertEnrolled(Enrolled en) {
        int rows = 0;
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO Enrolled(CPS_ID, Class_ID)"
                        + " Values (" + en.getCPSID()+ ",'" + en.getClassID() + "')";
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
}
