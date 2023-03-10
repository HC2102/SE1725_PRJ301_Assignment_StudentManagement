<%-- 
    Document   : ChangePass
    Created on : Mar 2, 2023, 3:34:04 PM
    Author     : dange
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Change Password</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>\css\PWStyle.css">
    </head>
    <%
    if (session.getAttribute("userType")==null) {
        response.sendRedirect("Login.jsp");
    }
%>
    <body>
        <h2>Change Password</h2>
       <div class="container">
            <form action="<%= request.getContextPath()%>\ChangePassServlet" method="post">
                
                <div class="row">
                    <div class="col-25">
                        <label for="password">Old Password:</label>
                    </div>
                    <div class="col-75">
                        <input type="password" name="passold" required>
                    </div>
                </div>            
                
                <div class="row">
                    <div class="col-25">
                        <label for="password">New Password: </label>                       
                    </div>
                    <div class="col-75" >
                        <input type="password" name="passnew" required>
                    </div>
                </div>
                <div class="row">
                    <span><%
                        String error = (String) request.getAttribute("error");
                        if(error!=null && error.compareTo("")!=0) out.println(error);
                        %> 
                    </span>
                        <a href= "<%= request.getContextPath()%>/<%=(String)session.getAttribute("userType")%>Info"> <input type="button" value="Back to homepage"></a>
                    <input type="submit" value="Change">
                    
                </div>
                    
            </form>
       </div>
    </body>
</html>
