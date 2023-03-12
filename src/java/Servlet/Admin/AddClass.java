/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.ClassDAO;
import dbObject.Class;
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
public class AddClass extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession session = request.getSession();
            
            ServletContext context = getServletContext();
            ClassDAO cd = new ClassDAO();
            Class c = new Class();
            c.setClass_ID(request.getParameter("id"));
            
            c.setMajor_ID(request.getParameter("mid"));
            int row = 0;
            row = cd.insertClass(c);
            if (row < 1) {
                request.setAttribute("info", "Class ID already exists");
                session.setAttribute("status", null);
                session.setAttribute("error", null);
                request.getRequestDispatcher("JSP/addClass.jsp").forward(request, response);
            } else {
                session.setAttribute("status", "Add class successfully!");
                session.setAttribute("error", null);
                request.setAttribute("info", null);

                response.sendRedirect("ClassList"); 
            }  
        }catch(Exception e){

            request.setAttribute("error", "Error!");
            request.getRequestDispatcher("JSP/addClass.jsp").forward(request, response);
        }
    }
}
