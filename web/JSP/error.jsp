<%-- 
    Document   : error
    Created on : Mar 3, 2023, 11:17:36 AM
    Author     : HE170417
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mua haha this is a notification</title>
    </head>
    <style>
        body{
            text-align: center;
        }
    </style>
    <body>
        <h1>Haha look who made a mistake!</h1>
        <img style="width:80%" src="<%=request.getContextPath()%>\image\error.png" alt="error"> <br>
        Exception: <%= exception%>

    </body>
</html>
