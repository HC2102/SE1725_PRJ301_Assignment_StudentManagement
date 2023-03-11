/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.AdminDAO;
import DAO.StudentDAO;
import DAO.TeacherDAO;
import DAO.UserDAO;
import dbObject.Teacher;
import dbObject.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author HE170417
 */
public class deleteUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO uDAO = new UserDAO();
        TeacherDAO tDAO = new TeacherDAO();
        StudentDAO sDAO = new StudentDAO();
        AdminDAO aDAO = new AdminDAO();
        String err=null;
        int row = 0;
        try {
            String username = req.getParameter("delname");
            int role = Integer.parseInt(req.getParameter("role"));
            User delU = uDAO.getUser(username);
            //delete
            switch (role) {
                case 0:
                    if (username.compareTo("admin") != 0) {
                        row = aDAO.deleteAdmin(username);
                        row = uDAO.deleteUser(username);
                    }else{
                        throw new Exception("must not delete admin");
                    }
                    break;
                case 1:
                    break;
                case 2:
                    break;
                default:
                    throw new Exception("undefine role");
            }
            if(row <1){
                throw new Exception("cannot delete because of constraint or not exists");
            }
        } catch (Exception e) {
            err =  e.getMessage();
        }
        req.setAttribute("err", err);
        req.getRequestDispatcher("adUserList").forward(req, resp);
    }
}
