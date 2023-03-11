/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import dbConnect.DBContext;
import dbObject.CPS;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class CPSDAO {
    public ArrayList<CPS> getAllSemester() {
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
}
