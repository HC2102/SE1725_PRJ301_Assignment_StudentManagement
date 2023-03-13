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
        String courseID = request.getParameter("id");
        try {
            int row = 0;
            TestDAO td = new TestDAO();
            Test t = new Test();
            t.setCourse_id(courseID);
            t.setTest_id(request.getParameter("tid"));
            t.setTest_name(request.getParameter("tName"));
            t.setWeight(Integer.parseInt(request.getParameter("tWei")));
            row = td.insertTest(t);
            if (row < 1) {
                throw new Exception();
            } else {
                request.setAttribute("status", "Add test successfully!");
                request.setAttribute("error", null);
                request.setAttribute("info", null);
                request.getRequestDispatcher("CourseTest?id=" + courseID + "").forward(request, response);
            }
        } catch (Exception e) {
            request.setAttribute("info", "Failed to add! Please re-check your input!");
            request.getRequestDispatcher("JSP/addTest.jsp").forward(request, response);
        }
    }
}
