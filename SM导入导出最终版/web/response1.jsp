<%--
  Created by IntelliJ IDEA.
  User: 会会
  Date: 2019/12/25
  Time: 12:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>查询失败</title>
    <style>
        body{
            background: url("${pageContext.request.contextPath}/img/admin-login-bg.jpg");
            background-attachment: fixed;
            background-repeat: no-repeat;
            background-size: 100% 100%;

        }
    </style>
</head>
<body style="margin: 20px auto;width: 800px">
<h2 style="color: red">用户名不存在请重新输入</h2>
<li><a href="squery.jsp">返回</a></li>
</body>
</html>
