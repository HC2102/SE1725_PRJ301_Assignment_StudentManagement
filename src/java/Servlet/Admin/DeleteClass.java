/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.ClassDAO;
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
public class DeleteClass extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        try {
            int row = 0;
            HttpSession session = request.getSession();
            ClassDAO cd = new ClassDAO();
            String id = request.getParameter("id");
            row = cd.deleteClass(id);
            if (row < 1) {
                session.setAttribute("error", "Class deletion failed! This class is in learning process!");
                session.setAttribute("status",null);
                response.sendRedirect("ClassList"); 
            } else {
                session.setAttribute("status", "Class deletion successfully!");
                session.setAttribute("error", null);
                response.sendRedirect("ClassList"); 
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

}
