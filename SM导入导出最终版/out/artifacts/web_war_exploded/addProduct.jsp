<%@ page import="com.dao.ProductDao" %><%--
  Created by IntelliJ IDEA.
  Author: 王会
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
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
        <div style="margin-left: 350px;float: left">
        <input type="submit" value="添加" class="btn btn-primary">
        <div style="margin-left: 20px;float: right">
        <input type="button" name="button" value="返回" class="btn btn-primary" onclick="location='http://localhost:8080/showAll.jsp'">
    </form>
   </div></div>
</body>
</html>
