/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

import DAO.StudentDAO;
import dbObject.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Zarius
 */
public class ClassOfStudentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        StudentDAO stDAO = new StudentDAO();
        System.out.println(session.getAttribute("studentClass"));
        if (req.getParameter("yourClass") != null) {
            String classID = (String) session.getAttribute("studentClass");
            ArrayList<Student> listStudentFromClassID = stDAO.getAllStudentFromClassID(classID);
            req.setAttribute("classID", classID);
            req.setAttribute("listStudentFromClassID", listStudentFromClassID);
            req.getRequestDispatcher("JSP/ClassOfStudent.jsp").forward(req, resp);
        }
    }

}
