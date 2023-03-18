/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet.Admin;

import DAO.EnrolledDAO;
import dbObject.Enrolled;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author Zarius
 */
public class insertEnrolled extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath() + "/loginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("add") != null) {
            try {
                int rows = 0;
                EnrolledDAO enDAO = new EnrolledDAO();
                String selectedClass = (String) session.getAttribute("selectedClass");
                int cps = Integer.parseInt(req.getParameter("chooseCPS"));
                Enrolled en = new Enrolled();
                en.setCPSID(cps);
                en.setClassID(selectedClass);
                rows = enDAO.insertEnrolled(en);
                if (rows < 1) {
                    throw new Exception();
                } else {
                    req.setAttribute("status", "Enrolled add successfully!");
                    req.setAttribute("error", null);
                    session.removeAttribute("selectedClass");
                    session.removeAttribute("selectedMajor");
                    req.getRequestDispatcher("adEnrolledList").forward(req, resp);
                }

            } catch (Exception e) {
                req.setAttribute("error", "Enrolled add failed!");
                req.setAttribute("status", null);
                session.removeAttribute("selectedClass");
                session.removeAttribute("selectedMajor");
                req.getRequestDispatcher("adEnrolledList").forward(req, resp);
            }
        } else if (req.getParameter("BackToEnrolled") != null) {
            req.setAttribute("status", null);
            req.setAttribute("error", null);
            session.removeAttribute("selectedClass");
            session.removeAttribute("selectedMajor");
            req.getRequestDispatcher("adEnrolledList").forward(req, resp);
        }
    }
}
