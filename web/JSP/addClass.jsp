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
        <title>Add course</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/CourseStyle_1.css">
    </head>
    <body>
        <h2>Add New Class...</h2>
       <div class="container">
                
            <div class="imgdiv">
                
                <img src="<%= request.getContextPath()%>/image/class.png" alt="">
            </div>
            <form action="<%= request.getContextPath()%>/AddClass" method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="text">New Class ID:</label>
                    </div>
                    <div class="col-75">
                        <input type="text" name="id" id="text" placeholder="Class ID" required>
                        <span class="err"><%
                        String err = (String) request.getAttribute("info");
                        if(err!=null && err.compareTo("")!=0) out.println(err);
                        %> 
                        </span>
                    </div>
                </div>            
                <div class="row">
                    <div class="col-25">
                        <label for="text">Major ID:</label>
                        
                    </div>
                    <div class="col-75">
                        <select name="mid">
                        <option value="LA">LA</option>
                        <option value="GD">GD</option>
                        <option value="SE">SE</option>
                        <option value="BA">BA</option>
                        </select>
                        
                    </div>
                </div>
                
                <div class="row">
                    <input type="submit" value="Add">
                    <a href= "<%= request.getContextPath()%>/ClassList"> <input type="button" value="Back to list"></a>
                </div>              
            </form>                
       </div>
    </body>
</html>
