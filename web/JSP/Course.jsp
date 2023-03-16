<%-- 
    Document   : Course
    Created on : Mar 7, 2023, 9:41:11 PM
    Author     : dange
--%>
<%@page import="dbObject.Course" %>
<%@page import="java.util.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of courses</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            if (request.getAttribute("clist") == null) {
                response.sendRedirect("Login.jsp");
            }
        %>
        <h2>Course List</h2>

        <div class="table-wrapper">
            <span class="status"><%
                String info = (String) request.getAttribute("status");
                if (info != null && info.compareTo("") != 0)
                    out.println(info);
                %> 
            </span>
            <span class="error"><% String err = (String) request.getAttribute("error");
                if (err != null && err.compareTo("") != 0)
                    out.println(err); %>
            </span>
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>Course ID</th>
                        <th>Course name</th>
                        <th>Major ID</th>
                        <th>Biographic</th>
                        <th>Action 1</th>
                        <th>Action 2</th>
                        <th>Details</th>
                    </tr>
                </thead>
                <tbody>
                    <%
                ArrayList<Course> clist = (ArrayList<Course>) request.getAttribute("clist");
                for (Course c : clist) {%>
                    <tr>
                        <td><%= c.getCourse_ID()%></td>
                        <td><%= c.getCourse_name()%></td>
                        <td><%= c.getMajor_ID()%></td>
                        <td><%= c.getBiographic()%></td>
                        <td><a href="updateCourse?id=<%=c.getCourse_ID()%>"><input class="id" style="margin-right: 1%; font-weight: bold;" type="Submit" value="Update"></a></td> 
                        <td><a href="deleteCourse?id=<%=c.getCourse_ID()%>"><input class="id" style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete"></a></td>
                        <td><a href="CourseTest?id=<%=c.getCourse_ID()%>"><input class="id" style="margin-right: 1%; font-weight: bold;" type="Submit" value="Details"></a></td>
                    </tr>

                    <%}
                    %>

                <tbody>

            </table>

        </div>

        <div style="display: flex; margin-left: 42%; margin-top: 2%">
            <a style="margin-right: 2%"  href= "<%= request.getContextPath()%>/AdminInfo"> <input class="id" style="; font-weight: bold; padding: 10%;" type="Submit" type="button" value="Back"></a>
            <div>
                <a href="<%= request.getContextPath()%>/JSP/addCourse.jsp"><input class="id" style=" font-weight: bold; padding: 3%" type="Submit" value="Add more courses"></a>
            </div>
        </div>

    </body>
</html>
