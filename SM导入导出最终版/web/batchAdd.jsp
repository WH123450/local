<%--
  Created by IntelliJ IDEA.
  User: 会会
  Date: 2019/12/24
  Time: 15:44
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
    <title>批量添加</title>
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
<div id="uploadDlg" class="easyui-dialog" data-options="iconCls:'icon-upload',closed: true"
     style="width:300px;height:80px;padding:30px;"  >
    <form id="excel" method="post" action="/uploadFile" enctype="multipart/form-data">
        请选择文件：<input type="file" name="file" id="upExcel" style="width:240px">
        <input type="submit" value="提交" class="btn btn-primary">
        <input type="button" name="button" value="返回" class="btn btn-primary" onclick="location='http://localhost:8080/showAll.jsp'">
    </form>
</div>
</body>
</html>
