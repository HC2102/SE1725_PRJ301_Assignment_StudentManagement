/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.CourseDAO;
import dbObject.Course;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/**
 *
 * @author dange
 */
public class ToCourses extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO cd = new CourseDAO();
        String status = (String)request.getAttribute("status");
        String error = (String)request.getAttribute("error");
        ArrayList<Course> clist = cd.getAllCourse();
        request.setAttribute("clist", clist);
        request.setAttribute("status", status);
        request.setAttribute("error", error);
        request.getRequestDispatcher("JSP/Course.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

    
}
