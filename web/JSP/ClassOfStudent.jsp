<%-- 
    Document   : ClassOfStudent
    Created on : 02-03-2023, 19:54:21
    Author     : Zarius
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="dbObject.Student"%>
<%@page import="dbObject.Class"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("student") != 0) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");}
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/home_studentstyle.css">
        <title>Class information</title>
    </head>
    <body>
        <div class="ctr1">
            <a style="text-decoration: none; font-family:'Times New Roman'; margin-left:5%; margin-top:1%;" href="<%= request.getContextPath()%>/JSP/StudentHome.jsp"><H1>Home</H1></a>
            <div class="headerbutton">
                <a href="<%= request.getContextPath()%>/JSP/ChangePass.jsp"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Change Password"></a>
                <a href="<%= request.getContextPath()%>/logout"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Log out"></a>
            </div>
        </div>
        <% 
            ArrayList<Student> list = (ArrayList<Student>)request.getAttribute("listStudentFromClassID"); 
            String classID = (String)request.getAttribute("classID");
            ArrayList<Class> listClass = (ArrayList<Class>)request.getAttribute("listClass");
        %>
        <h2>Student Information In Class <span style="color: white; font-weight: bold;"><%=classID%></span> </h2>

        <form id='f1' action="<%= request.getContextPath()%>/ListStudentOfClass" method="post" class="table-wrapper" style="margin-bottom: 0; box-shadow: none">
            <label for="classFind">Search class: </label>
            <select name="chooseClass" onchange="change()">
                <option disabled selected value> -- select a class -- </option>
                <%for (Class cl : listClass) {
                %>
                <option value="<%=cl.getClass_ID()%>"><%=cl.getClass_ID()%></option>
                <%}%>
            </select>
        </form>

        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>Student ID</th>
                        <th>Student name</th>
                        <th>Major ID</th>
                        <th>Class ID</th>
                        <th>More detail</th>
                    </tr>
                </thead>
                <tbody>
                    <%for (Student stu : list) {
                    %>

                    <tr>
                        <td><%=stu.getStudentID()%></td>
                        <td><%=stu.getStudentName()%></td>
                        <td><%=stu.getMajorID()%></td>
                        <td><%=classID%></td>
                        <td><a style="text-decoration: none; font-weight: bold; border: 3px solid teal; "href="EachStudentHome?id=<%=stu.getStudentID()%>">See More</a></td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
        <script type="text/javascript">
            function change() {
                document.getElementById("f1").submit();
            }
        </script>
    </body>

</html>
