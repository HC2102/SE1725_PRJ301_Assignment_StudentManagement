/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Admin;

import DAO.StudentClassDAO;
import dbObject.Student_Class;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author Zarius
 */
public class AddStudentToClass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classID = req.getParameter("classID");
        String studentID = req.getParameter("stuID");
        try {
            int row = 0;
            StudentClassDAO scDAO = new StudentClassDAO();
            Student_Class stcl = new Student_Class();
            stcl.setClass_ID(classID);
            stcl.setStudent_ID(studentID);
            row = scDAO.insertStudentIntoClass(stcl);
            if (row < 1) {
                throw new Exception();
            } else {
                req.setAttribute("status", "Add student successfully!");
                req.setAttribute("error", null);
                req.getRequestDispatcher("ClassDetail?id=" + classID + "").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("status", null);
            req.setAttribute("error", "Add Student Fail! Class already start learning");
            req.getRequestDispatcher("StudentWithClassMajor?id=" + classID + "").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
