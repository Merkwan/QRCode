<%--
  Created by IntelliJ IDEA.
  User: 66
  Date: 2020/5/10
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="include.jsp" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">

    <title>实践课程考勤系统</title>
    <script type="text/javascript" src="js/plugins/jquery/jquery-3.5.1.js"></script>
    <link rel="stylesheet" type="text/css" href="css/teacher_main.css">
    <script type="text/javascript">
        //加载完成之后执行
        $(function () {
            //隐藏所有子标题
            $(".nav-menu").each(function () {
                $(this).children(".nav-content").hide();
            });
            //给所有主标题添加事件
            $(".nav-title").each(function () {
                $(this).click(function () {
                    var conEle=$(this).parents(".nav-menu").children(".nav-content");
                    if (conEle.css("display")!=="none"){
                        conEle.hide(300);
                    }else {
                        //当要展开子标题列表时，需要其它子标题列表关闭
                        var navele=conEle.parents(".nav-menu");
                        var menueles=navele.siblings();
                        menueles.each(function () {
                            $(this).children(".nav-content").hide(300);
                        })
                        conEle.show(300);
                    }
                });
            });
        });
    </script>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">HHU</a>
        </div>
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li>
                    <span id="time_show"></span>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class=" jumbotron_teacher jumbotron" style="margin-top: 50px;">

    <div class="container">
        <h1 class="animated fadeInDown ">追求卓越 敢为人先</h1>
        <p ><%=session.getAttribute("tname")==null? "":"欢迎 "+session.getAttribute("tname")+" 老师登录"%></p>
        <p class="animated fadeInRightBig">河海大学实践课程考勤系统 教师端登录入口</p>

    </div>
</div>
<div class="content">
    <div class="content-left">
<%--        <h3><%=session.getAttribute("tname")==null? "":"欢迎 "+session.getAttribute("tname")+" 登录"%><h3/>--%>
<%--        <div class="left-title">--%>
<%--            <a href="#">教师端后台</a>--%>
<%--        </div>--%>
        <!--分割线-->
<%--        <div class="seg"></div>--%>
        <!--            菜单栏导航-->
        <div class="nav">
            <!--                每一个菜单栏项-->
            <div class="nav-menu">
                <!--                    主标题-->
                <div class="nav-title">发布签到</div>
                <!--                    子标题-->
                <div class="nav-content">
                    <form method="post" action="http://www.txjava.cn:80/qr_check/post_signinservlet">
                        结束时间：<input type="time" name="end_time"/>
                        <input type="submit" value="发布" id="subpost"/>
                    </form>
                </div>
            </div>
            <div class="nav-menu">
                <!--                    主标题-->
                <div class="nav-title">签到信息</div>
                <!--                    子标题-->
                <div class="nav-content">
                    <a href="http://www.txjava.cn:80/qr_check/showsignedservlet?action=page&resultnum=1">已签到</a>
                    <a href="http://www.txjava.cn:80/qr_check/showsignedservlet?action=page&resultnum=0">未签到</a>
                </div>
            </div>
            <div class="nav-menu">
                <!--                    主标题-->
                <div class="nav-title">通知信息</div>
                <div class="nav-content">
                    <a href="http://www.txjava.cn:80/qr_check/showqingjiaservlet?action=page">请假信息</a>
                </div>
            </div>
            <div class="nav-menu">
                <!--                    主标题-->
                <div class="nav-title">设置</div>
                <!--                    子标题-->
                <div class="nav-content">
                    <a href="http://www.txjava.cn:80/qr_check/teacherinfoservlet?action=teacherinfo">教师信息</a>
                    <a href="change_teacherpwd.jsp">密码修改</a>>
                </div>
            </div>
        </div>
<%--        <div class="seg"></div>--%>
    </div>
</div>
<footer>
    <div>
        <div class="container">
            <h4>河海大学 江宁校区</h4>
            <p>Designed and built by <a href="http://www.hhu.edu.cn/" target="_blank">@HHU</a></p>
        </div>
    </div>
</footer>
</body>
</html>
