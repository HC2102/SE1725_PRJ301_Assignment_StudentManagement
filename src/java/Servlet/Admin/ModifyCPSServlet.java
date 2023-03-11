/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Admin;

import DAO.CPSDAO;
import DAO.CourseDAO;
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
public class ModifyCPSServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cpsOption = req.getParameter("cpsOption");
        switch (cpsOption) {
            case "delete":
                this.deleteCPS(req, resp);
                break;
            default:
                throw new AssertionError();
        }
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    public void deleteCPS(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        try {
            int row = 0;
            CPSDAO cpsDAO = new CPSDAO();
            int id = Integer.parseInt(req.getParameter("id"));
            row = cpsDAO.deleteCPS(id);
            if (row < 1) {
                throw new Exception();
            } else {
                session.setAttribute("status", "CPS deletion successfully!");
                resp.sendRedirect("Courses");
            }
        } catch (Exception e) {
            session.setAttribute("error", "CPS deletion failed! This CPS is active!");
            resp.sendRedirect("Courses");
        }
    }
}
