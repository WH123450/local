<%@ page import="com.dao.ProductDao" %><%--
  Created by IntelliJ IDEA.
  Author: 王会
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加数据</title>
    <style>
        body{
        background: url("${pageContext.request.contextPath}/img/admin-login-bg.jpg");
        background-attachment: fixed;
        background-repeat: no-repeat;
        background-size: 100% 100%;
        }
        body{
            text-align: center;
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
        }*/

    </style>
</head>
<body style="margin: 20px auto;width: 800px">
    <h2 align="center">学生成绩的添加</h2>
   <div id="border">
    <form action="/AddProductServlet" method="post" >
        学号：<input name="id"><br>
        姓名：<input name="name"><br>
        语文：<input name="chinese"><br>
        数学：<input name="math"><br>
        英语：<input name="english"><br>
        班级：<input name="classes"><br>

        <input type="submit" value="添加" >

    </form>
   </div>
</body>
</html>
