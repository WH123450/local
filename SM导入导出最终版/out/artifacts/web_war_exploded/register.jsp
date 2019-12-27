<%--
  Created by IntelliJ IDEA.
  User: 会会
  Date: 2019/12/24
  Time: 14:53
  To change this template use File | Settings | File Templates.
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
    <title>注册界面</title>
    <style type="text/css">
        input {
            height: 30px;
            font-size: 20px;
        }

        li {
            display: inline-block;
        }

        body {
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
<body>
<div  style="margin: 200px 0 0 540px">
    <form  action="/RegisterServlet" method="post" >
        <h1 style="margin-left: 90px">用户注册</h1>
        用户名：<input  type="text"  name="username" /><br><br>
        密&nbsp&nbsp &nbsp码：<input  type="password" name="userpassword"/><br>
        身&nbsp &nbsp份：<input type="radio" name="id" value="student"checked>学生
        <input type="radio" name="id" value="teacher">教师<br><br>
<div style="margin-left: 40px;float:left" >
        <input type="submit" name="button" value="提交" class="btn btn-primary" >
    <div style="margin-left: 30px;float:right">
        <input type="reset" name="button" value="重置" class="btn btn-primary" >
        <div style="margin-left: 30px;float:right">
        <input type="button" name="button" value="返回" class="btn btn-primary"  onclick="location='http://localhost:8080/login.jsp'">

    </form>

</div>
</div>
</div>
</div>
</body>
</html>
