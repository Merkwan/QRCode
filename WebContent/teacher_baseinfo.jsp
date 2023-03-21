<%--
  Created by IntelliJ IDEA.
  User: 66
  Date: 2020/5/12
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>教师基本信息</title>
    <link rel="stylesheet" type="text/css" href="css/table.css"/>
    <style type="text/css">
        a{
            text-align: center;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <td>教工号：</td><td>${sessionScope.teacher.tid}</td>
        </tr>
        <tr>
            <td>姓名：</td><td>${sessionScope.teacher.tname}</td>
        </tr>
        <tr>
            <td>手机号：</td><td>${sessionScope.teacher.tphone}</td>
        </tr>
        <tr>
            <td>姓别：</td><td>${sessionScope.teacher.tsex}</td>
        </tr>
        <tr>
            <td>学院</td><td>${requestScope.classes.cdepartment}</td>
        </tr>
        <tr>
            <td>专业</td><td>${requestScope.classes.cprofession}</td>
        </tr>
        <tr>
            <td>班级号：</td><td>${requestScope.classes.cclassno}</td>
        </tr>
    </table>
<a href="./teacher_main.jsp">返回主界面</a>
</body>
</html>
