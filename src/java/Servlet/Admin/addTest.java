/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.TestDAO;
import dbObject.Test;
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
public class addTest extends HttpServlet {
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int row = 0;
            TestDAO td = new TestDAO();
            Test t = new Test();
            t.setCourse_id(request.getParameter("cid"));
            t.setTest_id(request.getParameter("tid"));
            t.setTest_name(request.getParameter("name"));
            t.setWeight(Integer.parseInt(request.getParameter("weight")));
            row = td.insertTest(t);
            if (row < 1) {
                request.setAttribute("info", "Failed to add! Please re-check your input!");    
                request.getRequestDispatcher("JSP/addTest.jsp").forward(request, response);
            } else {
                request.setAttribute("status", "Add test successfully!");
                request.setAttribute("error", null);
                request.setAttribute("info", null);

                request.getRequestDispatcher("CourseTest").forward(request, response);
            }  
        }catch(Exception e){

            request.setAttribute("error", "Error!");
            request.getRequestDispatcher("JSP/addTest.jsp").forward(request, response);
        }
    }
}
