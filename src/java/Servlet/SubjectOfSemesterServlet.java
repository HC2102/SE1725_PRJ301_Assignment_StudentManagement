/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package Servlet;

import DAO.TeacherDAO;
import dbObject.CPS;
import dbObject.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author ADMIN
 */
@WebServlet(name="SubjectOfSemesterServlet", urlPatterns={"/sos"})
public class SubjectOfSemesterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        TeacherDAO td=new TeacherDAO();
        String semester =request.getParameter("semester");
        if(semester.equalsIgnoreCase("CHOOSE SEMESTER")){
            response.sendRedirect("JSP/teacherHome.jsp");
        }else{
                    String user_name=request.getParameter("user_name");
        List<CPS> list = td.getCpsByUserNameAndSemester(user_name, semester);
        request.setAttribute("cps", list);
        request.setAttribute("semester", semester);
        request.getRequestDispatcher("JSP/teacherHome.jsp").forward(request, response);
        }

    } 

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
       
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
