<%-- 
    Document   : addCourse
    Created on : Mar 8, 2023, 4:21:38 PM
    Author     : dange
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Major</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/CourseStyle_1.css">
    </head>
    <%
        if (session.getAttribute("userName") == null || session.getAttribute("userType").toString().compareToIgnoreCase("admin") != 0) {
            response.sendRedirect(request.getContextPath()+"/loginServlet");}
    %>
    <body>
        <h2>Add New Major...</h2>
        <div class="container">
            <div class="imgdiv">
                <img src="<%= request.getContextPath()%>/image/class.png" alt="">
            </div>
            <form action="<%= request.getContextPath()%>/addMajor" method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="text">New Major ID:</label>
                    </div>
                    <div class="col-75">
                        <input type="text" name="mID" id="text" placeholder="Major ID" required>
                        <span class="err"><%
                        String err = (String) request.getAttribute("info");
                        if(err!=null && err.compareTo("")!=0) out.println(err);
                            %> 
                        </span>
                    </div>
                </div>            
                <div class="row">
                    <div class="col-25">
                        <label for="text">Major name:</label>

                    </div>
                    <div class="col-75">
                        <input type="text" name="mName" id="text" placeholder="Major name" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="text">Major bios:</label>
                    </div>
                    <div class="col-75">
                        <textarea  name="mBios" rows="4" cols="50"> </textarea>
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Add">
                    <a href= "<%= request.getContextPath()%>/majorList"> <input type="button" value="Back to list"></a>
                </div>              
            </form>                
        </div>
    </body>
</html>