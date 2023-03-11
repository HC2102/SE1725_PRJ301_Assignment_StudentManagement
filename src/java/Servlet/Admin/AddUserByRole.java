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
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author HE170417
 */
public class AddUserByRole extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username, pass, fname, address, phone, email, role;
        UserDAO uDAO = new UserDAO();
        TeacherDAO tDAO = new TeacherDAO();
        AdminDAO aDAO = new AdminDAO();
        StudentDAO sDAO = new StudentDAO();
        HttpSession session = req.getSession();
        int row = 0;
        username = req.getParameter("username");
        pass = req.getParameter("pass");
        fname = req.getParameter("fullname");
        address = req.getParameter("Address");
        phone = req.getParameter("phone");
        email = req.getParameter("email");
        role = req.getParameter("roles");
        //check role to insert
        if (role.compareToIgnoreCase("Admin") == 0) {
            System.out.println("admin");
            //add user
            row = uDAO.insertUser(new User(username, pass, 0));
            row = aDAO.insertAdmin(new Admin(username, fname, address, phone, email));

        } else if (role.compareToIgnoreCase("Teacher") == 0) {
            System.out.println("Teacher");
            String major = req.getParameter("major");
            //add
            row = uDAO.insertUser(new User(username, pass, 2));
            row = tDAO.insertTeacher(new Teacher(username, fname, major, phone, address, email));
        } else if (role.compareToIgnoreCase("Student") == 0) {
            System.out.println("Student");
            String major = req.getParameter("major");
            String studentID = req.getParameter("studentID");
            //add
            row = uDAO.insertUser(new User(username, pass, 1));
            row = sDAO.insertStudent(new Student(studentID, username, fname, major, phone, address, email));
        }
        if (row > 0) {
            session.setAttribute("noti", "new user added successfully!");
        } else {
            session.setAttribute("noti", "Can not add because of unable connect to database or duplicated userName or studentID");
        }
        resp.sendRedirect("adAddUser");

    }

}
