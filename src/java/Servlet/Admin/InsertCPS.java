/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Admin;

import DAO.CPSDAO;
import DAO.CourseDAO;
import DAO.SemesterDAO;
import dbObject.CPS;
import dbObject.Course;
import dbObject.Semester;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class InsertCPS extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/loginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("addCPS") != null) {
            SemesterDAO semDAO = new SemesterDAO();
            CourseDAO cDAO = new CourseDAO();
            Semester currentSem = semDAO.getSemesterIDByCurrentSemester();
            ArrayList<Course> listCourse = cDAO.getAllCourse();
            req.setAttribute("listCourse", listCourse);
            req.setAttribute("currentSem", currentSem.getSemester_ID());
            req.getRequestDispatcher("JSP/adAddCPS.jsp").forward(req, resp);
        }
    }
}
