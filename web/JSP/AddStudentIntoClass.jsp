<%-- 
    Document   : AddStudentIntoClass
    Created on : 13-03-2023, 20:40:50
    Author     : Zarius
--%>

<%@page import="dbObject.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/home_studentstyle.css">
        <title>Add Student</title>
    </head>
    <body>
        <%
            ArrayList<Student> listStudentWithMajorIDAndNotInClass = (ArrayList<Student>) request.getAttribute("listStudentWithMajorIDAndNotInClass");
            String classID = (String) request.getAttribute("classID");
        %>
        <h2>Add Student To Class <%=classID%></h2>


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
        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>Student name</th>
                        <th>Major ID</th>
                        <th>Email</th>
                        <th>Add Student To Class</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Student stu : listStudentWithMajorIDAndNotInClass) {
                    %>
                    <tr>
                        <td><%=stu.getStudentID()%></td>
                        <td><%=stu.getStudentName()%></td>
                        <td><%=stu.getMajorID()%></td>
                        <td><%=stu.getEmail()%></td>
                        <td><a href="AddStudentToClass?stuID=<%=stu.getStudentID()%>&classID=<%=classID%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Add Student"></a></td> 
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <a href= "<%= request.getContextPath()%>/ClassDetail?id=<%=classID%>"> <input style="margin-top:2%;margin-left:47%; font-weight: bold; padding: 0.5%" type="Submit" type="button" value="Back"></a>
    </body>
</html>
