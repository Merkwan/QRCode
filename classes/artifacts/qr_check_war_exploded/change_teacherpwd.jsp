<%--
  Created by IntelliJ IDEA.
  User: 66
  Date: 2020/5/12
  Time: 20:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>密码修改</title>
    <link rel="stylesheet" type="text/css" href="css/changepwd.css"/>
</head>
<body>
<div>
<form action="http://www.txjava.cn:80/qr_check/teacherinfoservlet?action=changepwd" method="post">
    <table>
        <tr>
            <td>请输入旧密码：</td>
            <td><input type="password" name="oldpwd" class="input"/></td>
        </tr>
        <tr>
            <td>请输入新密码：</td>
            <td><input type="password" name="newpwd" class="input"/></td>
        </tr>
        <tr>
            <td>请确认新密码：</td>
            <td><input type="password" name="conewpwd" class="input"/></td>
        </tr>
    </table>
    <input type="submit" value="修改" id="button"/>
</form>
<%@include file="changepwd_succ.jsp"%>
</div>
</body>
</html>
