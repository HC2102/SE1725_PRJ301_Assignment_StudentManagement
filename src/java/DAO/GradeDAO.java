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

/**
 *
 * @author Zarius
 */
public class GradeDAO {
    public Double getAvgScoreByStudentIDAndCourseID(String StudentID, String Course_ID) {
        try {
            DBContext db = new DBContext();
            Connection con = db.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "With R as (\n" +
                            "   SELECT G.Student_ID, G.Course_ID, G.Test_ID ,G.Value\n" +
                            "   FROM Test T, Grade G\n" +
                            "   WHERE G.Course_ID = T.Course_ID and G.Test_ID = T.Test_ID\n" +
                            "   )\n" +
                            "SELECT R.Course_ID, (SUM(R.Value * T.Weight))/100 [DiemTB]\n" +
                            "FROM R, Test T\n" +
                            "WHERE r.Student_ID= '" + StudentID + "' and  r.Course_ID= '" + Course_ID + "' and  r.Test_ID = T.Test_ID and R.Course_ID = T.Course_ID\n" +
                            "GROUP BY R.Student_ID, R.Course_ID;";
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    Double avg;
                    avg = rs.getDouble("DiemTB");
                    return avg;
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
