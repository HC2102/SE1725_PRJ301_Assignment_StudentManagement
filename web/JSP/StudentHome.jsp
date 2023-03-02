
<%-- 
    Document   : StudentHome
    Created on : 01-03-2023, 23:27:10
    Author     : Zarius
--%>

<%@page import="dbObject.Student_Class"%>
<%@page import="dbObject.Student"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/home_studentstyle.css">
        <title>StudentHome</title>
    </head>
    <body>
        <% Student stu = (Student) request.getAttribute("userStudent");
            Student_Class stcl = (Student_Class) request.getAttribute("studentClass");
        %>
        <div class="ctr1">
            <H1>Home</H1>
            <input style="margin-right: 1%; font-weight: bold;" type="button" value="Log out">
        </div>
        <div class="ctr4">

            <div class="ctr3">
                <p></p>
            </div>

            <div class="ctr2">
                <P>Name: <%= stu.getStudentName()%></P>
                <P>Class: <%=stcl.getClass_ID()%></P>
                <P>Adress: <%= stu.getAddress()%></P>
                <p>Email: <%= stu.getEmail()%></p>
            </div>
        </div>
        <form style="padding-top: 5%; padding-left: 42%;">
            <input style=" padding: 1%; font-weight: bold; margin-right: 1% ;" type="button" value="Your Class">
            <input style=" padding: 1%; font-weight: bold;" type="button" value="Average Score">
        </form>
    </body>
</html>
