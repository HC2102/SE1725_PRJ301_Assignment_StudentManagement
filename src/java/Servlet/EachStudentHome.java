/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet;

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
        StudentDAO stuDAO = new StudentDAO();
        StudentClassDAO stclDAO = new StudentClassDAO();
        String studentID = req.getParameter("id");
        Student s = stuDAO.getStudent(studentID);
        //get student and class
        Student_Class stcl = stclDAO.getStudentFromClassByStudentID(studentID);
        //Create a session
        HttpSession session = req.getSession();
        //attribute for session
        session.setAttribute("userGuest", s);
        session.setAttribute("GuestClass", stcl);
        req.getRequestDispatcher("JSP/EachStudentHome.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

}
