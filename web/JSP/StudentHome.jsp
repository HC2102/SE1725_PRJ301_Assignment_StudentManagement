
<%-- 
    Document   : StudentHome
    Created on : 01-03-2023, 23:27:10
    Author     : Zarius
--%>

<%@page import="dbObject.Student_Class"%>
<%@page import="dbObject.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<%
    if (session.getAttribute("userStudent") == null) {
        response.sendRedirect("JSP/Login.jsp");
    }
%>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/home_studentstyle.css">
        <title>Student homepage</title>
    </head>
    <body>
        <%
            Student stu = (Student) session.getAttribute("userStudent");
            Student_Class stcl = (Student_Class) session.getAttribute("studentClass");
        %>

        <div class="ctr1">
            <a style="text-decoration: none; font-family:'Times New Roman'; margin-left:5%; margin-top:1%;" href="<%= request.getContextPath()%>/JSP/StudentHome.jsp"><H1>Home</H1></a>
            <div class="headerbutton">
                <a href="<%= request.getContextPath()%>/JSP/ChangePass.jsp"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Change Password"></a>
                <a href="<%= request.getContextPath()%>/logout"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Log out"></a>
            </div>
        </div>

        <div class="ctr4">

            <div class="ctr3">
                <img src="<%= request.getContextPath()%>\image\anh2.jpg" style="width:100%; height: 100%;" class="" alt="">
            </div>

            <div class="ctr2">
                <P>Name: <%= stu.getStudentName()%></P>
                <P>Class: <%=stcl.getClass_ID()%></P>
                <P>Adress: <%= stu.getAddress()%></P>
                <P>Phone number: <%= stu.getPhoneNum()%></P>
                <p>Email: <%= stu.getEmail()%></p>
            </div>
        </div>
        <form style="padding-top: 5%; padding-left: 42%;"  action="<%= request.getContextPath()%>/classofstudent" method="post"> 
            <input style=" padding: 1%; font-weight: bold; margin-right: 1% ;" type="submit" value="Your Class" name="yourClass">
            <input style=" padding: 1%; font-weight: bold;" type="submit" value="Average Score" name="avgScore">
        </form>
    </body>
</html>
