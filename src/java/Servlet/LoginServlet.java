/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.LoginDao;
import DAO.StudentClassDAO;
import DAO.StudentDAO;
import DAO.TeacherDao;
import Login.LoginBeans;
import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;
import dbObject.Student;
import dbObject.Student_Class;
import dbObject.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.HashSet;

/**
 *
 * @author HE170417
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("user");
        String passWord = req.getParameter("pass");
        LoginBeans bean = new LoginBeans(userName, passWord);
        LoginDao logindao = new LoginDao();
        StudentDAO stuDAO = new StudentDAO();
        StudentClassDAO stclDAO = new StudentClassDAO();
        TeacherDao teacherDao = new TeacherDao();
        try {
            String userRole = logindao.authenticateUser(bean);
            if (userRole.compareTo("Admin") == 0) {
                System.out.println("ADMIN");

                //StudentHome Page
            } else if (userRole.compareTo("Student") == 0) {
                //working for student
                //get student object
                Student s = stuDAO.getStudentByUsername(userName);
                //get student and class
                Student_Class stcl = stclDAO.getStudentFromClass(s.getStudentID());
                //Create a session
                HttpSession session = req.getSession();
                //attribute for session
                session.setAttribute("userStudent",s);
                session.setAttribute("studentClass", stcl);
                req.setAttribute("userName", userName);
                //request Dispatcher
                req.getRequestDispatcher("JSP/StudentHome.jsp").forward(req, resp);
            } else if (userRole.compareTo("Teacher") == 0) {
                Teacher t = teacherDao.getByUserName(userName);
                //Create a session
                HttpSession session = req.getSession();
                //attribute for session
                session.setAttribute("userTeacher", t);
                req.setAttribute("userName", userName);
                System.out.println("Teacher");
                //requestDispatcher
                req.getRequestDispatcher("teacherInfo").forward(req, resp);

            } else {
                req.setAttribute("error", "User or password is not correct, please try again");
                req.getRequestDispatcher("JSP/Login.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            System.out.println("Servlet login" + e.getMessage());
        }

    }

}
