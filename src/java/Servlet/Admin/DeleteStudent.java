/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Admin;

import DAO.StudentClassDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Zarius
 */
public class DeleteStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String studentID = req.getParameter("stuID");
        String classID = req.getParameter("classID");
        try {
            int row = 0;
            StudentClassDAO stclDAO = new StudentClassDAO();
            row = stclDAO.deleteStudentFromClass(studentID);
            if (row < 1) {
                throw new Exception();
            } else {
                req.setAttribute("status", "Delete student successfully!");
                req.setAttribute("error", null);
                req.getRequestDispatcher("ClassDetail?id=" + classID + "").forward(req, resp);
            }
        } catch (Exception E) {
            req.setAttribute("error", "Delete Student Fail");
            req.setAttribute("status", null);
            req.getRequestDispatcher("ClassDetail?id=" + classID + "").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
