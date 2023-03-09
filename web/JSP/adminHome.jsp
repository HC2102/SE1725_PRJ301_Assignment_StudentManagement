<%-- 
    Document   : AdministrationServiceMainpage
    Created on : Mar 4, 2023, 7:57:42 PM
    Author     : dange
--%>

<%@page import="dbObject.Admin"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/home_studentstyle.css">
        <title>Admin Services</title>
    </head>
    <body>
        <%
            Admin ad = (Admin) session.getAttribute("admin");
        %>
        <div class="ctr1">
            <a style="text-decoration: none; font-family:'Times New Roman'; margin-left:5%; margin-top:1%;" href="<%= request.getContextPath()%>/JSP/adminHome.jsp"><H1>Home</H1></a>
            <div class="headerbutton">
                <a href="<%= request.getContextPath()%>/JSP/ChangePass.jsp"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Change Password"></a>
                <a href="<%= request.getContextPath()%>/logout"><input style="margin-right: 1%; font-weight: bold;" type="Submit" value="Log out"></a>
            </div>
        </div>



        <div class="ctr4">

            <div class="ctr3">
                <p></p>
            </div>

            <div class="ctr2">
                <P>Welcome, <%=ad.getAdmin_name()%>!</P>
                <P>Your Address: <%=ad.getAdmin_Address()%></p>
                <p>Your Phone Number: <%=ad.getAdmin_phonenumber()%></p>
                <p>Your Email:<%=ad.getAdmin_email()%></p>
            </div>
        </div>
        <form style="padding-top: 5%; padding-left: 42%;"  action="" method="post">
            <input style=" padding: 1%; font-weight: bold; margin-right: 1% ;" type="submit" value="Your Class">
            <input style=" padding: 1%; font-weight: bold;" type="submit" value="Average Score">

        </form>

    </body>
</html>