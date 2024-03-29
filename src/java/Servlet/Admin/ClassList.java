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
import java.util.ArrayList;

/**
 *
 * @author dange
 */
public class ClassList extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ClassDAO cd = new ClassDAO();
        String status = (String)request.getAttribute("status");
        String error = (String)request.getAttribute("error");
        ArrayList<dbObject.Class> classlist = cd.getAllClass();
        request.setAttribute("classlist", classlist);
        request.setAttribute("status", status);
        request.setAttribute("error", error);
        request.getRequestDispatcher("JSP/ClassList.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
    

}


