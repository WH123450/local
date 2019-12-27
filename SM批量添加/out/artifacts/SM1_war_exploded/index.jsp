<%--
  Created by IntelliJ IDEA.
  Author: 王会
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <style>
      body{
        background: url("${pageContext.request.contextPath}/img/admin-login-bg.jpg");
        background-attachment: fixed;
        background-repeat: no-repeat;
        background-size: 100% 100%;

      }
    </style>
  </head>
  <body>
    <%
      response.sendRedirect("login.jsp");
    %>

  </body>
</html>
