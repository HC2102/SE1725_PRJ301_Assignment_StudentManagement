<%-- 
    Document   : UpdateCourse
    Created on : Mar 8, 2023, 1:26:54 AM
    Author     : dange
--%>
<%@page import="dbObject.Course" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Update</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/CourseStyle.css">
    </head>
    <%
    if (request.getAttribute("newcourse")==null) {
        response.sendRedirect("Login.jsp");
    }
%>
    <body>
        <h2>Update Course...</h2>
        <%
            Course c = (Course)request.getAttribute("newcourse");
            
        %>
       <div class="container">
           
            <div class="imgdiv">
                <img src="<%= request.getContextPath()%>/image/course.png" alt="">
            </div>
            
            <form action="<%= request.getContextPath()%>/updateCourse?id=<%=c.getCourse_ID()%>" method="post">
                           
                <div class="row">
                    <div class="col-25">
                        <label for="text">Change Course Name:</label>
                        
                    </div>
                    <div class="col-75">
                        <input type="text" name="name" id="text" placeholder="Course name" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="desc">Change Biographic: </label>
                        
                    </div>
                    <div class="col-75" >
                        <textarea name="bio" id="desc" rows="5" placeholder="Course Biographic" required></textarea>
                    </div>
                </div>
                <div class="row">
                    
                    <input type="submit" value="Change">
                    <a href= "<%= request.getContextPath()%>/Courses"> <input type="button" value="Back to list"></a>
                </div>
                
                 
            </form>
       </div>
    </body>
</html>
