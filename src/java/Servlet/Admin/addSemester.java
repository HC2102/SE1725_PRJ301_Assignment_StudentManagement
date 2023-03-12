/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.SemesterDAO;
import dbObject.Semester;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author HE170417
 */
public class addSemester extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("JSP/adAddSemester.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SemesterDAO sDAO = new SemesterDAO();
        int row=0;
        try {
            String semesterID = req.getParameter("sID");
            String startDate = sDAO.changeDateFormatSQL(req.getParameter("sStart"));
            String endDate = sDAO.changeDateFormatSQL(req.getParameter("sEnd"));
            row = sDAO.insertSemester(new Semester(semesterID,startDate,endDate,false));
            if (row <1) {
                throw new Exception();
            }
            req.setAttribute("err", "add success!");
            resp.sendRedirect("adSemesterList");
            
        } catch (Exception e) {
            req.setAttribute("err", "add failed!");
            req.getRequestDispatcher("adSemesterList").forward(req, resp);
        }
    }
   
}
