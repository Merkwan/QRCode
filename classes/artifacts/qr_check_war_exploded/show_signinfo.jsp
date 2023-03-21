<%--
  Created by IntelliJ IDEA.
  User: 66
  Date: 2020/5/13
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>签到信息展示</title>
    <script type="text/javascript" src="js/plugins/jquery/jquery-1.7.2.js"></script>
    <link rel="stylesheet" type="text/css" href="css/table.css"/>
</head>
<body>
<div class="pages">
    <table>
        <tr>
            <th>签到日期</th>
            <th>签到时间</th>
            <th>学号</th>
            <th>姓名</th>
            <th>签到情况</th>
        </tr>
        <c:forEach items="${requestScope.page.items}" var="item">
            <tr>
                <td>${item.qdate}</td>
                <td>${item.qtime}</td>
                <td>${item.sno}</td>
                <td>${item.sname}</td>
                <td>${requestScope.page.result}</td>
            </tr>
        </c:forEach>
    </table>
    <%@include file="/page_nav.jsp"%>
    <a href="http://www.txjava.cn:80/qr_check/teacher_main.jsp">返回主界面</a>
    <a href="http://www.txjava.cn:80/qr_check/showsignedservlet?action=deleteAll&result=${sessionScope.state}">清除所有记录</a>
</div>
</body>
</html>
