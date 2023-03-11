/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.CourseDAO;
import dbObject.Course;
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
public class updateCourse extends HttpServlet {
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            
            CourseDAO cd = new CourseDAO();
            String id = request.getParameter("id");
            Course c = cd.getCourse(id);
            if(c == null){
                response.sendRedirect("Courses");
            }else{
                request.setAttribute("newcourse", c);
                request.getRequestDispatcher("JSP/UpdateCourse.jsp").forward(request, response);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            response.sendRedirect("Courses");
        }
    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try{
            HttpSession session = request.getSession();
            CourseDAO cd = new CourseDAO();
            String id = request.getParameter("id");
            String cname = request.getParameter("name");
            String bio = request.getParameter("bio");
            cd.updateCourse(id,cname,bio);
            session.setAttribute("status","Update course successfully!"); 
            
            response.sendRedirect("Courses");   
        }catch(Exception e){
            request.setAttribute("error", "Error!");
            request.getRequestDispatcher("JSP/UpdateCourse.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
   

}
