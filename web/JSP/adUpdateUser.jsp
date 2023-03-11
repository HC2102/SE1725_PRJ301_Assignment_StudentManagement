<%-- 
    Document   : adUpdateUser
    Created on : Mar 11, 2023, 3:37:57 PM
    Author     : HE170417
--%>

<%@page import="dbObject.User"%>
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
        if (request.getAttribute("upUser") == null) {
            response.sendRedirect("JSP/Login.jsp");
        }
    %>
    <body>
        <h2>Update User</h2>
        <%
            User u = (User) request.getAttribute("upUser");
        %>
        <div class="container">

            <div class="imgdiv">
                <img src="<%= request.getContextPath()%>/image/course.png" alt="">
            </div>

            <form action="updateUser" method="post">
                <input type="hidden" name="upname" value="<%=u.getUserName()%>">
                <input type="hidden" name="uprole" value="<%=u.getRole()%>">
                <div class="row">
                    <div class="col-25">
                        <label for="text">full name:</label>

                    </div>
                    <div class="col-75">
                        <input type="text" name="fname" id="text" placeholder="full name" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="text">Email</label>

                    </div>
                    <div class="col-75">
                        <input type="text" name="email" id="text" placeholder="email" required>
                    </div>
                </div>

                <div class="row">
                    <div class="col-25">
                        <label for="text">Phone number:</label>

                    </div>
                    <div class="col-75">
                        <input type="text" name="phonenum" id="text" placeholder="Phone number" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="text">Address</label>

                    </div>
                    <div class="col-75">
                        <input type="text" name="address" id="text" placeholder="address" required>
                    </div>
                </div>

                <div class="row">

                    <input type="submit" value="Change">
                    <a href= "<%= request.getContextPath()%>/adUserList"> <input type="button" value="Back to list"></a>
                </div>


            </form>
        </div>
    </body>
</html>

