/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlet;

import DAO.TeacherDao;
import dbObject.Class;
import dbObject.CPS;
import dbObject.Student_Class_Mark;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TeacherDao td = new TeacherDao();
        String cid_raw = request.getParameter("subject");
        if (cid_raw == null) {
            cid_raw = (String) request.getAttribute("cps_id");
        }
        String class_id = request.getParameter("class");
        if (class_id == null) {
            class_id = "null";
        }
        int cid;
        ArrayList<Student_Class_Mark> list = new ArrayList<>();
        ArrayList<Class> list_class = new ArrayList<>();
        Class classStudent = new Class("null", "null");
        list_class.add(classStudent);
        try {
            cid = Integer.parseInt(cid_raw);
            list = td.getStudent_Class_MarkByCid(cid);
            CPS cps = td.getCpsByCid(cid);
            List<Double> list_marks = td.getListMarkOfStudentByCourseIdAndStudentId(list, cps.getCourse_ID());
            for (int i = 0; i < list_marks.size(); i++) {
                list.get(i).setMark(list_marks.get(i));
            }
            for (int i = 0; i < list.size(); i++) {
                for (int k = 0; k < list_class.size(); k++) {
                    if ((list.get(i).getCl().getClass_ID().equalsIgnoreCase(list_class.get(k).getClass_ID()))) {
                        break;
                    }
                    if (k == list_class.size() - 1) {
                        list_class.add(list.get(i).getCl());
                        break;
                    }
                }
            }
            request.setAttribute("cps", cps);
            request.setAttribute("classes", list_class);
            if (!(class_id.equalsIgnoreCase("null")) && !(class_id.equalsIgnoreCase("all"))) {
                List<Integer> remove = new ArrayList<>();
                for (int i = 0; i < list.size(); i++) {
                    if (!(list.get(i).getCl().getClass_ID().equalsIgnoreCase(class_id))) {
                        remove.add(i);
                    }
                }
                int index_remove = 0;
                for (int i = 0; i < remove.size(); i++) {
                    list.remove(remove.get(i) - index_remove);
                    index_remove++;
                }

            }
            request.setAttribute("cl_id", class_id);
            request.setAttribute("list", list);
            request.getRequestDispatcher("JSP/table_information_student.jsp").forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println(e);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}
