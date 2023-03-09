/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet;

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
public class addCourse extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
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
            int row=0;
            ServletContext context=getServletContext();
            CourseDAO cd = new CourseDAO();
            Course c = new Course();
            c.setCourse_ID(request.getParameter("cid"));
            c.setCourse_name(request.getParameter("cname"));
            c.setMajor_ID(request.getParameter("mid"));
            c.setBiographic(request.getParameter("nbio"));
            row=cd.insertCourse(c);
            if(row<1){
                request.setAttribute("info", "Course ID already exists");
                request.getRequestDispatcher("JSP/addCourse.jsp").forward(request, response);
            }
            else{
                session.setAttribute("status","Add course successfully!"); 
                session.setAttribute("error", null);
                response.sendRedirect("Courses"); 
            }  
        }catch(Exception e){
            request.setAttribute("error", "Error!");
            request.getRequestDispatcher("JSP/addCourse.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */


}
