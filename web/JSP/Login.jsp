<%-- 
    Document   : Login
    Created on : Mar 1, 2023, 10:41:13 PM
    Author     : HE170417
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Đăng nhập vào website</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link href="..\css\login.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <div class="login-form">
            <form action="" method="post">
                <h1>STUDENT MANAGEMENT LOGIN</h1>
                <div class="input-box">
                    <i></i>
                    <input
                        type="text"
                        placeholder="Enter username"
                        name="user"
                        required
                        />
                </div>
                <div class="input-box">
                    <i></i>
                    <input
                        type="password"
                        placeholder="Enter password"
                        name="pass"
                        required
                        />
                </div>
                <div class="btn-box">
                    <select name="choice">
                        <option value="Choice" hidden>WHO ARE YOU ?</option>
                        <option value="student">STUDENT</option>
                        <option value="teacher">TEACHER</option>
                        <option value="manager">ADMIN</option>
                    </select>
                    <input type="submit" value="LOGIN" />
                </div>
            </form>
        </div>
    </body>
</html>
