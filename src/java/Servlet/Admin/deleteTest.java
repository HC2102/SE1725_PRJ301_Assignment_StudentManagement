/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.TestDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author dange
 */
public class deleteTest extends HttpServlet {
   
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
        try {
            int row = 0;
            TestDAO td = new TestDAO();
            String id = request.getParameter("id");
            row = td.deleteTest(id);
            if (row < 1) {
                request.setAttribute("error", "Test deletion failed! This course is active!");
                request.setAttribute("status", null);
                request.getRequestDispatcher("CourseTest?id="+id).forward(request, response);
            } else {
                request.setAttribute("status", "Test deletion successfully!");
                request.setAttribute("error", null);
                request.getRequestDispatcher("CourseTest?id="+id).forward(request, response);
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
