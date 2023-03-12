/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet.Admin;

import DAO.UserDAO;
import dbObject.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 *
 * @author HE170417
 */
public class adUserList extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO udao = new UserDAO();
        ArrayList<User> userList;
        if(req.getParameter("roleFind") == null || req.getParameter("roleFind").isEmpty()){
           userList = udao.getAllUser();
        }else{
           userList =  udao.getUsersByRole(Integer.parseInt(req.getParameter("roleFind"))); 
        }
        HttpSession session = req.getSession();
        session.setAttribute("userList", userList);
        req.getRequestDispatcher("JSP/listOfUser.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO  uDAO = new UserDAO();
        ArrayList<User>  userList =  uDAO.getAllUser();
        HttpSession session = req.getSession();
        session.setAttribute("userList", userList);
        req.getRequestDispatcher("JSP/listOfUser.jsp").forward(req, resp);
    }
   
   
}
