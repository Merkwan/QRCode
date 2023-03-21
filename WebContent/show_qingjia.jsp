<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 66
  Date: 2020/5/12
  Time: 16:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="cq" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请假信息界面</title>
    <link rel="stylesheet" type="text/css" href="css/table.css"/>
</head>
<body>
<div class="pages">
<table >
    <tr>
        <td>姓名</td>
        <td>学号</td>
        <td>日期</td>
        <td>请假原因</td>
        <td>请假结果</td>
    </tr>
    <c:forEach items="${requestScope.page.items}" var="qingjia">
        <tr>
            <td>${qingjia.sname}</td>
            <td>${qingjia.sno}</td>
            <td>${qingjia.qdate}</td>
            <td><textarea>${qingjia.qreason}</textarea></td>
            <td>
            <c:choose>
                <c:when test="${qingjia.qresult==0}">
                    <a href="http://www.txjava.cn:80/qr_check/showqingjiaservlet?action=isAgree&id=${qingjia.qid}&pageNo=${requestScope.page.pageNo}&result=1">同意</a>/
                    <a href="http://www.txjava.cn:80/qr_check/showqingjiaservlet?action=isAgree&id=${qingjia.qid}&pageNo=${requestScope.page.pageNo}&result=2">拒绝</a>
                </c:when>
                <c:when test="${qingjia.qresult==1}">已同意</c:when>
                <c:when test="${qingjia.qresult==2}">已拒绝</c:when>
            </c:choose>
            </td>
        </tr>
    </c:forEach>
</table>
<%@include file="/page_nav.jsp"%>
<a href="http://www.txjava.cn:80/qr_check/teacher_main.jsp">返回主界面</a>
<a href="http://www.txjava.cn:80/qr_check/showqingjiaservlet?action=deleteAll">清除所有记录</a>
</div>
</body>
</html>
