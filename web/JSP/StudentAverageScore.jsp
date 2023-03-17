<%-- 
    Document   : StudentAverageScore
    Created on : 04-03-2023, 17:05:54
    Author     : Zarius
--%>

<%@page import="dbObject.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="dbObject.Course"%>
<%@page import="DAO.GradeDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/home_studentstyle.css">
        <title>student's score information</title>
    </head>
    <%
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("student") != 0) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");}
    %>
    <body>
        <%
            Student stu = (Student) session.getAttribute("userStudent");
            ArrayList<Course> listCourseByStudentID = (ArrayList<Course>) request.getAttribute("listCourse");
            GradeDAO gDAO = new GradeDAO();
        %>
        <div class="ctr1">
            <a style="text-decoration: none; font-family:'Times New Roman'; margin-left:5%; margin-top:1%;" href="<%= request.getContextPath()%>/JSP/StudentHome.jsp"><H1>Home</H1></a>
            <div class="headerbutton">
                <a href="<%= request.getContextPath()%>/JSP/ChangePass.jsp"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Change Password"></a>
                <a href="<%= request.getContextPath()%>/logout"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Log out"></a>
            </div>
        </div>

        <h2>Student's Score Information</h2>

        <div class="table-wrapper">
            <table class="fl-table">
                <thead>

                    <tr>
                        <th>Course ID</th>
                        <th>Course Name</th>
                        <th>Grade</th>
                        <th>Status</th>
                        <th>Detail</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Course c : listCourseByStudentID) {
                    double avg = gDAO.getAvgScoreByStudentIDAndCourseID(stu.getStudentID(), c.getCourse_ID());
                    %>
                    <tr>
                        <td><%=c.getCourse_ID()%></td>
                        <td><%=c.getCourse_name()%></td>
                        <td><%=avg%></td>
                        <%if (avg > 5){ %>
                        <td><b style="background-color: green; color: white; padding: .3em; border-radius: .25em;">Passed</b></td>
                        <%}else{%>
                        <td><b style="background-color: red; color: white; padding: .3em; border-radius: .25em;">Not passed</b></td>
                        <%}%>
                        <td ><a style="text-decoration: none; font-weight: bold; border: 3px solid teal;" href="CourseDetailGrade?Course_ID=<%=c.getCourse_ID()%>">See Detail</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
