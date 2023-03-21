<%--
  Created by IntelliJ IDEA.
  User: 66
  Date: 2020/5/11
  Time: 20:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>扫码签到界面</title>
    <link rel="stylesheet" type="text/css" href="css/sacnqr.css"/>
</head>
<body>
<div class="outcontent">
    <h1>请用微信扫描二维码登录签到</h1>
    <div id="weixin"></div>
    <%@include file="isqr_success.jsp"%><br/>
    <a href="http://www.txjava.cn:80/qr_check/teacher_main.jsp">返回主界面</a>
</div>
<script type="text/javascript" src="js/plugins/jquery/jquery.min.js"></script>
<%--<script type="text/javascript" src="JS/plugins/jquery/jquery-1.7.2.js"></script>--%>
<script type="text/javascript" src="js/plugins/sui/sui.min.js"></script>
<script type="text/javascript" src="js/plugins/jquery-placeholder/jquery.placeholder.min.js"></script>

<script src="js/wxlogin.js"></script>
<script>
    window.onload=function (){
        // 生成微信二维码，工具类，不是我提供，从腾讯下载的
        // 127.0.0.1/loginServlet
        var obj = new WxLogin({
            id:"weixin",
            appid:"wx7287a60bb700fd21",
            scope:"snsapi_login",
            redirect_uri:"http://www.txjava.cn/qr_check/scan_qrservlet"
        });
    }
</script>
</body>
</html>
