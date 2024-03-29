/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Admin;

import DAO.CPSDAO;
import DAO.SemesterDAO;
import dbObject.CPS;
import dbObject.Course;
import dbObject.Semester;
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
public class addCPSToList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect(req.getContextPath()+"/loginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (req.getParameter("add") != null) {
            try {
                int rows = 0;
                CPSDAO cpsDAO = new CPSDAO();
                SemesterDAO semDAO = new SemesterDAO();
                Semester s = semDAO.getSemesterIDByCurrentSemester();
                int cpsIndex = cpsDAO.getMaxCPSID();
                String selectedCourse = (String) session.getAttribute("selectedCourse");
                //set
                CPS cps = new CPS();
                cps.setCps_id(cpsIndex + 1);
                cps.setCourse_ID(selectedCourse);
                cps.setSemesterID(s.getSemester_ID());
                cps.setTeacher_User_name(req.getParameter("chooseTeacher"));
                if (req.getParameter("biographic") == null || req.getParameter("biographic").compareTo("") == 0) {
                    cps.setBiographic(null);
                } else {
                    cps.setBiographic(req.getParameter("biographic"));
                }

                if (req.getParameter("resource") == null || req.getParameter("resource").compareTo("") == 0) {
                    cps.setResource(null);
                } else {
                    cps.setResource(req.getParameter("resource"));
                }
                rows = cpsDAO.insertCPS(cps);
                if (rows < 1) {
                    throw new Exception();
                } else {
                    req.setAttribute("status", "CPS add successfully!");
                    req.setAttribute("error", null);
                    session.removeAttribute("selectedCourse");
                    req.getRequestDispatcher("adCPSList").forward(req, resp);
                }
                if (req.getParameter("BackToCPSList") != null) {
                    req.setAttribute("status", null);
                    req.setAttribute("error", null);
                    session.removeAttribute("selectedCourse");
                    req.getRequestDispatcher("adCPSList").forward(req, resp);
                }
            } catch (Exception e) {
                req.setAttribute("error", "CPS add failed!");
                req.setAttribute("status", null);
                session.removeAttribute("selectedCourse");
                req.getRequestDispatcher("adCPSList").forward(req, resp);
            }
        } else if (req.getParameter("BackToCPSList") != null) {
            req.setAttribute("status", null);
            req.setAttribute("error", null);
            session.removeAttribute("selectedCourse");
            req.getRequestDispatcher("adCPSList").forward(req, resp);
        }

    }
}
