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
        <a href= "<%= request.getContextPath()%>/AdminInfo"> <input style="margin: 1%;margin-left:5%; font-weight: bold; padding: 0.5%" type="Submit" type="button" value="Back"></a>
        <div class="table-wrapper">
            <span class="status"><%
                String info = (String) session.getAttribute("info");
                if (info != null && info.compareTo("") != 0)
                    out.println(info);
                %> 
            </span>
            <span class="error"><% String err = (String) session.getAttribute("error");
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
                        <td><a href="updateCourse?id=<%=c.getCourse_ID()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Update"></a></td> 
                        <td><a href="deleteCourse?id=<%=c.getCourse_ID()%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete"></a></td>
                    </tr>

                    <%}
                    %>

                <tbody>

            </table>

        </div>
        <div style="display: flex; justify-content: center;">
            <a href="<%= request.getContextPath()%>/JSP/addCourse.jsp"><input style=" font-weight: bold; padding: 5%" type="Submit" value="Add more courses..."></a>
        </div>

    </body>
</html>