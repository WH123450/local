<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>
<html >
    <head>
        <meta charset="UTF-8" />
        <title>登录界面</title>
        <style type="text/css">
            input{
                height: 30px;
                font-size: 20px;
            }
            li{
                display: inline-block;
            }
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
        <script language="JavaScript" type="text/javascript">
            function exit() {
                window.navigator("/exit.jsp");
            }
        </script>

    </head>
    <body>
    <div align="center">
        <form  action="/LoginServlet" method="post" >
            <h3 align="center">用户登录</h3>
            用户名：<input  type="text"  name="username" /><br><br>
            密&nbsp &nbsp码：<input  type="password" name="userpassword"/><br><br>
            身&nbsp &nbsp份：<input type="radio" name="id" value="student"checked>学生
                 <input type="radio" name="id" value="teacher">教师<br>
            <input type="submit" name="button" value="登录" >
            <input type="button" name="button" value="退出" onclick="location='http://localhost:8080/exit.jsp'">


        </form>


    </div>
    </body>
    <html>