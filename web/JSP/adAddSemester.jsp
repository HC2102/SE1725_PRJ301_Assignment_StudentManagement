<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Semester</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="<%= request.getContextPath()%>/css/CourseStyle_1.css">
    </head>
    <body>
        <h2>Add New Semester...</h2>
        <div class="container">
            <div class="imgdiv">
                <img src="<%= request.getContextPath()%>/image/class.png" alt="">
            </div>
            <form action="<%= request.getContextPath()%>/addSemester" method="post">
                <div class="row">
                    <div class="col-25">
                        <label for="text">New Semester ID:</label>
                    </div>
                    <div class="col-75">
                        <input type="text" name="sID" id="text" placeholder="Semester ID" required>
                    </div>
                </div>            
                <div class="row">
                    <div class="col-25">
                        <label for="text">Time start</label>
                    </div>
                    <div class="col-75">
                        <input type="date" name="sStart" id="text" placeholder="Time start" required>
                    </div>
                </div>
                <div class="row">
                    <div class="col-25">
                        <label for="text">Time end:</label>
                    </div>
                    <div class="col-75">
                        <input type="date" name="sEnd" id="text" placeholder="Time end" required>
                    </div>
                </div>
                <div class="row">
                    <input type="submit" value="Add">
                    <a href= "<%= request.getContextPath()%>/adSemesterList"> <input type="button" value="Back to list"></a>
                </div>              
            </form>                
        </div>
    </body>
</html>