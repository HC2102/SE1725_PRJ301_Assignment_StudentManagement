<%-- 
    Document   : table_information_student
    Created on : 02-03-2023, 23:38:29
    Author     : ADMIN
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="dbObject.Student_Class_Mark"%>
<%@page import="dbObject.Class"%>
<%@page import="dbObject.Student"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <html>
    <head>
        <title>Đăng nhập vào website</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/table.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>

        <h2>Student Information</h2>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>Student ID</th>
            <th>User name</th>
            <th>Student name</th>
            <th>Major ID</th>
            <th>Phone</th>
            <th>Address</th>
            <th>Email</th>
            <th>Class ID</th>
            <th>Average of Subject</th>
        </tr>
        </thead>
        <tbody>
            <% 
            ArrayList<Student_Class_Mark> list=(ArrayList<Student_Class_Mark>)request.getAttribute("list");
            for(Student_Class_Mark i : list){%>
          <tr>
            <td><%= i.getSt().getStudentID()%></td>
            <td><%= i.getSt().getUserName()%></td>
            <td><%= i.getSt().getStudentName()%></td>
            <td><%= i.getSt().getMajorID()%></td>
            <td><%= i.getSt().getPhoneNum()%></td>
            <td><%= i.getSt().getAddress()%></td>
            <td><%= i.getSt().getEmail()%></td>
            <td><%= i.getCl().getClass_ID()%></td>
            <td><%= i.getMark()%></td>
            </tr>
            
                <%}
            %>
        <tbody>
    </table>
</div>
        <button type="button" onclick="quay_lai_trang_truoc()">Quay lại trang trước</button>

  <script>
      function quay_lai_trang_truoc(){
          history.back();
      }
  </script>
  <a href="<%= request.getContextPath()%>\teacherHome.jsp"><input type="button" value="Back to homepage"></a>
    </body>
</html>
