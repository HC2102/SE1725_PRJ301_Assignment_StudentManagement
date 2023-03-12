/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Student;

import DAO.ClassDAO;
import DAO.StudentDAO;
import dbObject.Class;
import dbObject.Student;
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
public class ListStudentOfClass extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String selectedClass = req.getParameter("chooseClass");
            StudentDAO stDAO = new StudentDAO();
            ClassDAO cDAO = new ClassDAO();
            ArrayList<Class> listClass = cDAO.getAllClassExceptClassID(selectedClass);
            ArrayList<Student> listStudentFromClassID = stDAO.getAllStudentFromClassID(selectedClass);
            req.setAttribute("listClass", listClass);
            req.setAttribute("classID", selectedClass);
            req.setAttribute("listStudentFromClassID", listStudentFromClassID);
            req.getRequestDispatcher("JSP/ClassOfStudent.jsp").forward(req, resp);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
