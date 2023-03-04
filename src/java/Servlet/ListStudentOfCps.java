/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.TeacherDao;
import dbObject.CPS;
import dbObject.Student_Class_Mark;
import dbObject.Teacher;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ADMIN
 */
public class ListStudentOfCps extends HttpServlet {

    public static void main(String[] args) {
        TeacherDao td = new TeacherDao();
        ArrayList<Student_Class_Mark> list = new ArrayList<>();
        list = td.getStudent_Class_MarkByCid(1);
        System.out.println(list.get(1).getSt().getStudentID());
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeacherDao td = new TeacherDao();
//        String user_name = request.getParameter("name");
//        List<CPS> list=td.getCpsByUserName(user_name);
        String cid_raw = request.getParameter("subject");
        int cid;
        ArrayList<Student_Class_Mark> list = new ArrayList<>();
        try {
            cid = Integer.parseInt(cid_raw);
            list = td.getStudent_Class_MarkByCid(cid);
            CPS cps = td.getCpsByCid(cid);
            List<Double> list_marks = td.getListMarkOfStudentByCourseIdAndStudentId(list, cps.getCourse_ID());
            for (int i = 0; i < list_marks.size(); i++) {
                list.get(i).setMark(list_marks.get(i));
            }
            request.setAttribute("list", list);
            request.getRequestDispatcher("JSP/table_information_student.jsp").forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e);

        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.

     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
