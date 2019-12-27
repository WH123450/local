<%--
  Created by IntelliJ IDEA.
  Author: 王会
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
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
    <script type="text/javascript" src="jquery-2.1.1.min.js"></script>
</head>
<body style="margin: 20px auto;width: 900px ">

<div id="border" align="center">
    <h2 align="center">欢迎使用成绩管理系统</h2>
    <div align="center">
        <form action="/QueryProductServlet" method="post">
            <input name="keyword">
            <input type="submit" value="搜索">
        </form>
        <!--
        <form action="/QueryProductServlet" method="post">
            <input name="keyword">
            <input type="submit" value="请输入要录入的班级">
        </form>
        -->
    </div>
    <div>
        <c:choose>
            <c:when test="${empty requestScope.list}">
                <p>数据为空</p>
            </c:when>
            <c:otherwise>
                <form action="/AddProductsServlet">
                    <table border="1" cellpadding="5" cellspacing="0" align="center">
                        <tr>
                            <th>学号</th>
                            <th>姓名</th>
                            <th>语文</th>
                            <th>数学</th>
                            <th>英语</th>
                            <th>班级</th>
                            <th colspan="3">操作</th>
                        </tr>
                        <c:forEach items="${requestScope.list}" var="product">
                            <tr>
                                <td name="id">${product.id}</td>
                                <td>${product.name}</td>
                                <!-- <td><input type="text" id="chinese" name="chinese" value=${product.chinese}></td>-->
                                <td contenteditable="true" id="chinese" name="chinese">${product.chinese}</td>
                                <td contenteditable="true" id="math" name="math">${product.math}</td>
                                <td contenteditable="true" id="english" name="english">${product.english}</td>
                                <td>${product.classes}</td>
                                <td><a href="/AddProductsServlet?id=${product.id}">保存</a></td>
                                <!--<td><input type="submit" value="提交"></td>-->
                                <td><a href="/FindProductServlet?id=${product.id}">修改</a></td>
                                <td><a href="/DeleteProductServlet?id=${product.id}">删除</a></td>
                            </tr>
                        </c:forEach>
                    </table>
                </form>
            </c:otherwise>
        </c:choose>

    </div>
    <!-- <div>
        <form action="${pageContext.request.contextPath}/AddProductsServlet" method="post">
            <input type="submit" value="提交">
        </form>
    </div>-->
    <div align="center">
        <ul>
            <li><a href="/addProduct.jsp">单个添加</a></li>
            <li><a href="/ShowAllServlet">显示所有信息</a></li>
            <li><a href="login.jsp">退出</a></li>
        </ul>
    </div>
    <div id="uploadDlg" class="easyui-dialog" data-options="iconCls:'icon-upload',closed: true"
         style="width:300px;height:180px;padding:30px;">
        <form id="excel" method="post" action="/uploadFile" enctype="multipart/form-data">
            请选择文件：<input type="file" name="file" id="upExcel" style="width:240px">
            <input type="submit" value="提交">
        </form>
    </div>
</div>
</body>
</html>
