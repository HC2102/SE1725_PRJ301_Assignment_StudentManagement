<%-- 
    Document   : tableGradeStudent
    Created on : Mar 2, 2023, 11:05:37 AM
    Author     : HE170417
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Đăng nhập vào website</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="<%= request.getContextPath()%>/css/table.css" rel="stylesheet" type="text/css"/>
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
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>1</td>
            <td>hieu</td>
            <td>Hieu</td>
            <td>SE</td>
            <td>111</td>
            <td>fwefwfgergehehhehgehger</td>
            <td>ffsdfsge</td>
            <td>123</td>
        </tr>
        <tr>
            <td>2</td>
            <td>ha</td>
            <td>Ha</td>
            <td>SE</td>
            <td>112</td>
            <td>cvdfv</td>
            <td>fgve4tg34</td>
            <td>123</td>
        </tr>
        <tr>
            <td>3</td>
            <td>hai</td>
            <td>Hai</td>
            <td>SE</td>
            <td>113</td>
            <td>g4egh4df</td>
            <td>verfger</td>
            <td>123</td>
        </tr>
        <tbody>
    </table>
</div>
    </body>
</html>
