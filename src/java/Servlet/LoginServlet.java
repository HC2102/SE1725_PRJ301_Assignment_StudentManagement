/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.LoginDao;
import Login.LoginBeans;
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
        try {
            String userRole = logindao.authenticateUser(bean);
            if (userRole.compareTo("Admin") == 0) {
                System.out.println("ADMIN");

                //StudentHome Page
            } else if (userRole.compareTo("Student") == 0) {
                HttpSession session = req.getSession();
                //attribute for session
                session.setAttribute("userName", userName);
                session.setAttribute("userType", "student");
                System.out.println("Student");
                //request Dispatcher
                req.getRequestDispatcher("studentInfo").forward(req, resp);
            } else if (userRole.compareTo("Teacher") == 0) {
                //Create a session
                HttpSession session = req.getSession();
                //attribute for session
                session.setAttribute("userName", userName);
                session.setAttribute("userType", "teacher");
                System.out.println("Teacher");
                //requestDispatcher
                req.getRequestDispatcher("teacherInfo").forward(req, resp);

            } else {
                req.setAttribute("error", "Username or password is not correct, please try again");
                req.getRequestDispatcher("JSP/Login.jsp").forward(req, resp);
            }

        } catch (Exception e) {
            System.out.println("Servlet login" + e.getMessage());
        }

    }

}
