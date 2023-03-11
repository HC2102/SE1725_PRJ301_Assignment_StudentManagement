/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.AdminDAO;
import DAO.StudentDAO;
import DAO.TeacherDAO;
import DAO.UserDAO;
import dbObject.Admin;
import dbObject.Student;
import dbObject.Teacher;
import dbObject.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author HE170417
 */
public class updateUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserDAO uDao = new UserDAO();
        String username = req.getParameter("upname");
//        HttpSession session = req.getSession();
        User u = uDao.getUser(username);
        if (u == null) {
            resp.sendRedirect("adUserList");
        } else {
            req.setAttribute("upUser", u);
            req.getRequestDispatcher("JSP/adUpdateUser.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            HttpSession session =  req.getSession();
            UserDAO uDAO = new UserDAO();
            TeacherDAO tDAO = new TeacherDAO();
            StudentDAO sDAO = new StudentDAO();
            AdminDAO aDAO = new AdminDAO();
            int row = 0;
            String upname = req.getParameter("upname");
            int role = Integer.parseInt(req.getParameter("uprole"));
            String newFname = req.getParameter("fname");
            String newEmail = req.getParameter("email");
            String newPhone = req.getParameter("phonenum");
            String newAddress = req.getParameter("address");
            switch (role) {
                case 0:
                    Admin newAd =  aDAO.getAdmin(upname);
                    newAd.setAdmin_Address(newAddress);
                    newAd.setAdmin_email(newEmail);
                    newAd.setAdmin_phonenumber(newPhone);
                    newAd.setAdmin_name(newFname);
                    row = aDAO.updateAdmin(newAd);
                    break;
                case 1:
                    Student newSt = sDAO.getStudentByUsername(upname);
                    newSt.setAddress(newAddress);
                    newSt.setEmail(newEmail);
                    newSt.setPhoneNum(newPhone);
                    newSt.setStudentName(newFname);
                    row = sDAO.updateStudent(newSt);
                    break;
                case 2:
                    Teacher newT = tDAO.getByUserName(upname);
                    newT.setAddress(newAddress);
                    newT.setEmail(newEmail);
                    newT.setPhoneNum(newPhone);
                    newT.setTeacherName(newFname);
                    row = tDAO.updateTeacher(newT);
                    break;
                default:
                    throw new AssertionError();
            }
            session.setAttribute("status","Update record successfully!"); 
            resp.sendRedirect("adUserList");
        } catch (Exception e) {
            req.setAttribute("error", "Error! "+e.getMessage());
            req.getRequestDispatcher("JSP/adUpdateUser.jsp").forward(req, resp);
        }
    }

}
