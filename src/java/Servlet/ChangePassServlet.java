/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.PasswordDAO;
import DAO.UserDAO;
import Login.LoginBeans;
import dbObject.User;
import java.io.IOException;
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
         resp.sendRedirect(req.getContextPath()+"/loginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session = req.getSession();
            PasswordDAO pdao = new PasswordDAO();
            UserDAO uDao = new UserDAO();
            String username = (String) session.getAttribute("userName");
            int row = 0;
            User user = uDao.getUser(username);
            String passold = req.getParameter("passold");
            String passnew = req.getParameter("passnew");
            System.out.println(user.getUserName());
            LoginBeans lb = new LoginBeans(user.getUserName(), passold);
            if (pdao.ChangePass(lb).compareTo("clear") == 0) {
                row = pdao.UpdatePassword(user.getUserName(), passnew);
                if (row < 1) {
                    throw new Exception("database update error");
                }
                req.setAttribute("error", "Change password successfully");
                req.getRequestDispatcher("JSP/ChangePass.jsp?user=" + username).forward(req, resp);
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
