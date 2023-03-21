/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Student;

import DAO.StudentClassDAO;
import DAO.StudentDAO;
import dbObject.Student;
import dbObject.Student_Class;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Zarius
 */
public class EachStudentHome extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        StudentDAO stuDAO = new StudentDAO();
        StudentClassDAO stclDAO = new StudentClassDAO();
        String studentID = req.getParameter("id");
        Student s = stuDAO.getStudent(studentID);
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("student") != 0) {
            resp.sendRedirect(req.getContextPath() + "/loginServlet");
        } else {
            if (s == null) {
                req.getRequestDispatcher("/studentInfo").forward(req, resp);
            } else {
                Student_Class stcl = stclDAO.getStudentFromClassByStudentID(studentID);
                //Create a session
                //attribute for session
                session.setAttribute("userGuest", s);
                session.setAttribute("GuestClass", stcl);
                req.getRequestDispatcher("JSP/EachStudentHome.jsp").forward(req, resp);
            }
        }

        //get student and class
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
