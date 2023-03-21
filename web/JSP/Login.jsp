<%-- Document : Login Created on : Mar 1, 2023, 10:41:13 PM Author : HE170417
--%> <%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page errorPage="error.jsp" %>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Đăng nhập vào website</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link href="<%= request.getContextPath()%>\css\login.css" rel="stylesheet" type="text/css" />
  </head>
  <body>
    <div class="login-form">
      <form action="<%= request.getContextPath()%>\loginServlet" method="post">
        <h1>ACADEMIC PORTAL LOGIN</h1>
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
          <span style="color: red">
            <% String error = (String) request.getAttribute("error");
            if(error!=null && error.compareTo("")!=0){ out.println(error); } %>
          </span>
        </div>
        <div style="display:flex; align-items: center; justify-content: space-evenly;">
          <div class="btn-box">
            <input type="reset" value="RESET" />
          </div>
          <div class="btn-box">
            <input type="submit" value="LOGIN" />
          </div>
        </div>
      </form>
    </div>
  </body>
</html>
