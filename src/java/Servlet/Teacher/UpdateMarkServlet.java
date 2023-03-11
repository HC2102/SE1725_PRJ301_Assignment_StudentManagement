/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Teacher;

import DAO.TeacherDao;
import dbObject.CPS;
import dbObject.Grade;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="UpdateMarkServlet", urlPatterns={"/update"})
public class UpdateMarkServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        TeacherDao td =new TeacherDao();
        String st_id=request.getParameter("st_id"); 
        String course_id=request.getParameter("course_id");
        String cps_id_raw=request.getParameter("cps_id");
        int cps_id=Integer.parseInt(cps_id_raw);
        CPS cps= td.getCpsByCid(cps_id);
        ArrayList<Grade> list=td.getListGradeByStIdAndCourseId(st_id, course_id);
        request.setAttribute("data", list);
        request.setAttribute("cps", cps);
        request.setAttribute("st_id", st_id);
        request.setAttribute("course_id", course_id);
        request.getRequestDispatcher("JSP/updateMark.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String AC_raw = request.getParameter("AC");
        String PT_raw = request.getParameter("PT");
        String PE_raw = request.getParameter("PE");
        String FE_raw = request.getParameter("FE");
        String PRJ_raw = request.getParameter("PRJ");
        String PRS_raw = request.getParameter("PRS");
        String st_id = request.getParameter("st_id"); 
        String course_id = request.getParameter("course_id");   
        String cps_id = request.getParameter("cps_id");
        this.update(AC_raw, st_id, course_id, "AC");
        this.update(PT_raw, st_id, course_id, "PT");
        this.update(PE_raw, st_id, course_id, "PE");
        this.update(FE_raw, st_id, course_id, "FE");
        this.update(PRJ_raw, st_id, course_id, "PRJ");
        this.update(PRS_raw, st_id, course_id, "PRS");
        request.setAttribute("cps_id", cps_id);
        request.getRequestDispatcher("listStudentOfCps").forward(request, response);
    }
    
    protected void update(String value_raw, String st_id, String course_id, String test_id){
        double value;
        TeacherDao td = new TeacherDao();
        try {
            value=Double.parseDouble(value_raw);
            td.updateGrade(st_id, test_id, course_id, value);
            return;
        } catch (Exception e) {
            return;
        }
    }

}
