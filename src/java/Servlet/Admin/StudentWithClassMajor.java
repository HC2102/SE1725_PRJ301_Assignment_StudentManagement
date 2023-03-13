/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.ClassDAO;
import DAO.StudentDAO;
import dbObject.Student;
import dbObject.Class;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;



/**
 *
 * @author Zarius
 */
public class StudentWithClassMajor extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classID = req.getParameter("id");
        StudentDAO sDAO = new StudentDAO();
        ClassDAO cDAO = new ClassDAO();
        Class selectedClass = cDAO.getClass(classID);
        ArrayList<Student> listStudentWithMajorIDAndNotInClass = sDAO.getAllStudentWithMajorIDAndNotInClass(selectedClass.getMajor_ID(), classID);
        req.setAttribute("listStudentWithMajorIDAndNotInClass", listStudentWithMajorIDAndNotInClass);
        req.setAttribute("classID", classID);
        req.getRequestDispatcher("JSP/AddStudentIntoClass.jsp").forward(req, resp);
        
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
    

}
