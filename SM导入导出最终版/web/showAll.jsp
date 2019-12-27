<%--
  Created by IntelliJ IDEA.
  Author: 王会
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
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
    <title>教师界面</title>
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

    </style>
    <script type="text/javascript" src="jquery-2.1.1.min.js"></script>
</head>
<body style="margin: 20px auto;width: 900px ">
<!--<form action="choose.jsp" method="post">
    请选择班级：
    <select  name="phy" size="3" multiple>
        <option aria-checked="true">计科1701</option>
        <option>计科1702</option>

    </select><br>

</form>-->

<div id="border" align="center">

    <h2 align="center">欢迎使用成绩管理系统</h2>
    <div align="center">
        <form action="/QueryProductServlet" method="post">
            <input name="keyword">
            <input type="submit" value="姓名搜索" >
        </form>
    </div>
    <div>
        <form action="/QueryIdServlet" method="post">
            <input name="id">
            <input type="submit" value="学号搜索" >
        </form>
    </div>
    <div>
        <c:choose>
            <c:when test="${empty requestScope.list}">
                <p>数据为空</p>
            </c:when>
            <c:otherwise>
                <form>
                    <table class="table table-hover">
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>语文</th>
                            <th>数学</th>
                            <th>英语</th>
                            <th>班级</th>
                            <th colspan="2">操作</th>
                        </tr>
                        <c:forEach items="${requestScope.list}" var="product">
                            <tr>
                                <td name="id">${product.id}</td>
                                <td>${product.name}</td>
                                <!-- <td><input type="text" id="chinese" name="chinese" value=${product.chinese}></td>-->
                                <td id="chinese" name="chinese">${product.chinese}</td>
                                <td id="math" name="math">${product.math}</td>
                                <td id="english" name="english">${product.english}</td>
                                <td>${product.classes}</td>
                               <!-- <td><a href="/AddProductsServlet?id=${product.id}">保存</a></td>-->
                                <!--<td><input type="submit" value="提交"></td>-->
                                <td><a href="/FindProductServlet?id=${product.id}" class="btn-primary btn-sm" role="button">修改</a></td>
                                <td><a href="/DeleteProductServlet?id=${product.id}" class="btn-primary btn-sm" role="button">删除</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </c:otherwise>
        </c:choose>

    <div style="margin-left: 100px;float:left">
        <a href="/addProduct.jsp" class="btn btn-primary" role="button">单个添加</a>
        <div style="margin-left: 100px;float:right">
            <a href="/batchAdd.jsp" class="btn btn-primary" role="button">批量添加</a>
            <div style="margin-left: 100px;float:right">
                <a href="/ExportExcelServle" class="btn btn-primary" role="button">批量导出</a>
                <div style="margin-left: 100px;float:right">
                    <a href="/ShowAllServlet" class="btn btn-primary " role="button">显示所有信息</a>
                    <div style="margin-left: 100px;float:right">
                        <a href="login.jsp" class="btn btn-primary" role="button">退出</a>
                    </div></div></div></div> </div>

    </div>
</div>
</body>
</html>
