<%--
  Created by IntelliJ IDEA.
  Author: 王会
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新数据库</title>
    <style>
        body{
            background: url("${pageContext.request.contextPath}/img/admin-login-bg.jpg");
            background-attachment: fixed;
            background-repeat: no-repeat;
            background-size: 100% 100%;

        }
        /*#border{
            margin: auto;
            width: auto;
            padding: 13px;
            border-color: rgba(240,255,255,0.5);
            border-style: solid;
            height: auto;
            position: absolute;
            left: 420px;
            right:350px
        }
*/

    </style>
</head>
<body style="margin: 20px auto;width: 800px;">
    <div id="border" align="center">
    <h2>更新数据库</h2>
    <form action="/UpdateProductServlet" method="post">
       <input name="id" value="${product.id}" hidden ><br>
        学号：<input name="id" value="${product.id}" disabled ><br>
        姓名：<input name="name" value="${product.name}" disabled><br>
        语文：<input name="chinese" value="${product.chinese}" ><br>
        数学：<input name="math" value="${product.math}" ><br>
        英语：<input name="english" value="${product.english}" ><br>
        班级：<input name="classes" value="${product.classes}" disabled><br>
        <input type="submit" value="提交">
    </form>
    </div>
</body>
</html>
