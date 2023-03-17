/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Student;

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
        try{
            //Variable sections
        StudentDAO stuDAO = new StudentDAO();
        StudentClassDAO stclDAO = new StudentClassDAO();
        HttpSession session = req.getSession();

        //get user name
        String userName = (String) session.getAttribute("userName");
        System.out.println(userName);
        //get student and class
        Student s = stuDAO.getStudentByUsername(userName);
        Student_Class stcl = stclDAO.getStudentFromClassByStudentID(s.getStudentID());
            System.out.println(s.toString());
            System.out.println(stcl);
        //attribute for session
        session.setAttribute("userStudent", s);
        if(stcl != null){
             session.setAttribute("studentClass", stcl);
        }else{
            stcl = new Student_Class(userName, "null");
            session.setAttribute("studentClass", stcl);
        }
        req.getRequestDispatcher("JSP/StudentHome.jsp").forward(req, resp);
        }catch(Exception  e){
            System.out.println("StudentInfoServlet, there may be empty in this class or other unexpected error");
            resp.sendRedirect(req.getContextPath()+"/loginServlet");
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }

}
