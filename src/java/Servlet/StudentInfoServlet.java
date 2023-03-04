/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.StudentClassDAO;
import DAO.StudentDAO;
import dbObject.Student;
import dbObject.Student_Class;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author HE170417
 */
public class StudentInfoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Variable sections
        StudentDAO stuDAO = new StudentDAO();
        StudentClassDAO stclDAO = new StudentClassDAO();
        HttpSession session = req.getSession();

        //get user name
        String userName = (String) session.getAttribute("userName");
        //get student and class
        Student s = stuDAO.getStudentByUsername(userName);
        Student_Class stcl = stclDAO.getStudentFromClassByStudentID(s.getStudentID());

        //attribute for session
        session.setAttribute("userStudent", s);
        session.setAttribute("studentClass", stcl);
        req.getRequestDispatcher("JSP/StudentHome.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
