/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.CourseDAO;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author dange
 */
public class deleteCourse extends HttpServlet {
   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            int row = 0;
            HttpSession session = request.getSession();
            CourseDAO cd = new CourseDAO();
            String id = request.getParameter("id");
            row = cd.deleteCourse(id);
            if (row < 1) {
                session.setAttribute("error", "Course deletion failed! This course is active!");
                session.setAttribute("status",null);
                response.sendRedirect("ToCourses"); 
            } else {
                session.setAttribute("status", "Course deletion successfully!");
                session.setAttribute("error", null);
                response.sendRedirect("ToCourses"); 
            }           
        } catch (Exception E) {
            return;
        }
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.doGet(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
