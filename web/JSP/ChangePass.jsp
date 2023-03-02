<%-- 
    Document   : ChangePass
    Created on : Mar 2, 2023, 3:34:04 PM
    Author     : dange
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <body>
        <h2>Change Password</h2>
       <div class="container">
            <form action="<%= request.getContextPath()%>\ChangePassServlet" method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="text">Username:</label>
                    </div>
                    <div class="col-75">
                        <input type="text" name="usern" required>
                    </div>
                </div> 
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
                    
                    <input type="submit" value="Change"> <br>
                    <span style="color:red"><%
                        String error = (String) request.getAttribute("error");
                        if(error!=null && error.compareTo("")!=0) out.println(error);
                        %> </span>
                </div>
            </form>
       </div>
    </body>
</html>
