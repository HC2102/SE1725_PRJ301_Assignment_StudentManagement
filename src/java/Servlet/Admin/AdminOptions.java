/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Admin;

import DAO.CPSDAO;
import dbObject.CPS;
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
public class AdminOptions extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/loginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String adminOption = req.getParameter("option");
        switch (adminOption) {
            case "List CPS":
                resp.sendRedirect("adCPSList");
                break;
            case "User Data":
                resp.sendRedirect("adUserList");
                break;

            case "List Enrolled":
                resp.sendRedirect("adEnrolledList");
                break;

            case "Add course":
                resp.sendRedirect("ToCourses");
                break;
            case "Major Data":
                resp.sendRedirect("majorList");
                break;
            case "Classes":
//                resp.sendRedirect("ClassList");
                req.getRequestDispatcher("ClassList").forward(req, resp);
                break;
            case "Semester setting":
                req.getRequestDispatcher("adSemesterList").forward(req, resp);
//                resp.sendRedirect("adSemesterList");
                break;
            default:
                throw new AssertionError();
        }
    }

}
