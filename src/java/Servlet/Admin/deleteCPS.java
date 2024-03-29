/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servlet.Admin;

import DAO.CPSDAO;
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
public class deleteCPS extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.deleteCPS(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
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
                req.setAttribute("status", "CPS deletion successfully!");
                req.setAttribute("error", null);
                req.getRequestDispatcher("adCPSList").forward(req, resp);
            }
        } catch (Exception e) {
            req.setAttribute("error", "CPS deletion failed!");
            req.setAttribute("status", null);
            req.getRequestDispatcher("adCPSList").forward(req, resp);
        }
    }
    
}
