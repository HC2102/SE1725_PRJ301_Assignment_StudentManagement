/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.SemesterDAO;
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
public class deleteSemester extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SemesterDAO sDAO = new SemesterDAO();
        int row = 0;
        try {
            String delSem = req.getParameter("delSem");
            row = sDAO.deleteSemester(delSem);
            if (row <1) {
                throw new Exception();
            }
            resp.sendRedirect("adSemesterList");
            
        } catch (Exception e) {
            req.setAttribute("err", "delete fail!");
            System.out.println(e.getMessage());
            req.getRequestDispatcher("adSemesterList").forward(req, resp);
        }
    }
   
}
