/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.StudentDAO;
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

public class ClassDetail extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            String classID = req.getParameter("id");
            StudentDAO sDAO = new StudentDAO();
            ArrayList<Student> listStudentFromClassID = sDAO.getAllStudentFromClassID(classID);
            req.setAttribute("listStudentFromClassID", listStudentFromClassID);
            req.setAttribute("classID", classID);
            req.getRequestDispatcher("JSP/AllStudentOfClass.jsp").forward(req, resp);
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
    
}
