/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.ClassDAO;
import DAO.MajorDAO;
import dbObject.Class;
import dbObject.Major;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author dange
 */
public class AddClass extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("admin") != 0) {
            response.sendRedirect(request.getContextPath() + "/loginServlet");
        }else{
            MajorDAO mdao = new MajorDAO();
            ArrayList<Major> mlist = mdao.getAllMajors();
            request.setAttribute("mlist", mlist);
            request.getRequestDispatcher("JSP/addClass.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            ClassDAO cd = new ClassDAO();
            Class c = new Class();
            c.setClass_ID(request.getParameter("id"));
            c.setMajor_ID(request.getParameter("mid"));
            int row = 0;
            row = cd.insertClass(c);
            if (row < 1) {
                request.setAttribute("info", "Class ID already exists");
                request.setAttribute("status", null);
                request.setAttribute("error", null);
                this.doGet(request, response);
            } else {
                request.setAttribute("status", "Add class successfully!");
                request.setAttribute("error", null);
                request.setAttribute("info", null);
                request.getRequestDispatcher("ClassList").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("info", "Error!");
            this.doGet(request, response);
        }
    }
}
