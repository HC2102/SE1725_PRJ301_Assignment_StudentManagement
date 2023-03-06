/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

import DAO.GradeDAO;
import DAO.StudentDAO;
import dbObject.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

/**
 *
 * @author Zarius
 */
public class CourseDetailGrade extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GradeDAO gdao = new GradeDAO();
        Double avg = 0.0;
        StudentDAO studentDAO = new StudentDAO();
        HttpSession session = req.getSession();
        String course = req.getParameter("Course_ID");
        Student st = studentDAO.getStudentByUsername((String)session.getAttribute("userName"));
        avg = gdao.getAvgScoreByStudentIDAndCourseID(st.getStudentID(), course);
        HashMap<String, Double> listDetailGrade = gdao.getDetailGradesForCourse(st.getStudentID(), course);
        HashMap<String, Double> listTestWeight = gdao.getTestWeightByCourseID(course);
        
        //set and send to jsp
        session.setAttribute("averageScore", avg);
        session.setAttribute("listDetailGrade", listDetailGrade);
        session.setAttribute("listTestWeight", listTestWeight);
        req.getRequestDispatcher("JSP/CourseDetailGrade.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
    
}
