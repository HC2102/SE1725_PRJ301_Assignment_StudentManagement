/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.ClassDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

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
            ClassDAO cd = new ClassDAO();
            String id = request.getParameter("id");
            row = cd.deleteClass(id);
            if (row < 1) {
                request.setAttribute("error", "Class deletion failed! This class is in learning process!");
                request.setAttribute("status",null);
                request.getRequestDispatcher("ClassList").forward(request, response);
            } else {
                request.setAttribute("status", "Class deletion successfully!");
                request.setAttribute("error", null);
                request.getRequestDispatcher("ClassList").forward(request, response);
            }           
        } catch (Exception E) {
        }
    } 

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        this.doGet(request, response);
    }

}
