/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.PasswordDAO;
import Login.LoginBeans;
import dbObject.Student;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author dange
 */
public class ChangePassServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            int row = 0;
            Student username =(Student) session.getAttribute("userStudent");
            System.out.println(username.getUserName());
            String passold = req.getParameter("passold");
            String passnew = req.getParameter("passnew");
            PasswordDAO pdao = new PasswordDAO();
            LoginBeans lb = new LoginBeans(username.getUserName(), passold);
            if (pdao.ChangePass(lb).compareTo("clear") == 0) {
                row = pdao.UpdatePassword(username.getUserName(), passnew);
                if (row < 1) {
                    throw new Exception("database update error");
                }
                req.setAttribute("error", "Change password successfully");
                req.getRequestDispatcher("JSP/ChangePass.jsp").forward(req, resp);
            } else {
                throw new Exception("change password fail");
            }
        } catch (Exception e) {
            System.out.println(e);
            String error = "Password is not valid, please try again later";
            req.setAttribute("error", error);
            req.getRequestDispatcher("JSP/ChangePass.jsp").forward(req, resp);
        }
    }

}
