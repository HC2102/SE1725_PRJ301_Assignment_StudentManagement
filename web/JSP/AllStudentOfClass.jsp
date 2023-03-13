<%-- 
    Document   : AllStudentOfClass
    Created on : 13-03-2023, 13:48:50
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
        <title>Class information</title>
    </head>
    <body>
        <%
            ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("listStudentFromClassID");
            String classID = (String) request.getAttribute("classID");

        %>
        <h2>Class <%=classID%></h2>
        <a href= "<%= request.getContextPath()%>/ClassList"> <input style="margin: 1%;margin-left:5%; font-weight: bold; padding: 0.5%" type="Submit" type="button" value="Back"></a>
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
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Student stu : list) {
                    %>
                    <tr>
                        <td><%=stu.getStudentID()%></td>
                        <td><%=stu.getStudentName()%></td>
                        <td><%=stu.getMajorID()%></td>
                        <td><%=stu.getEmail()%></td>
                        <td><a href="DeleteStudent?stuID=<%=stu.getStudentID()%>&classID=<%=classID%>"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Delete Student"></a></td> 
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <div style="display: flex; justify-content: center;">
            <a href="<%= request.getContextPath()%>/StudentWithClassMajor?id=<%=classID%>"><input style=" font-weight: bold; padding: 5%" type="Submit" value="Add Student"></a>
        </div>
    </body>
</html>
