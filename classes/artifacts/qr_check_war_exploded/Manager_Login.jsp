<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ include file="include.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">

    <title>管理员登陆界面</title>
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
<div class="jumbotron_manager jumbotron" style="margin-top: 50px;">

    <div class="container">
        <h1 class="animated fadeInDown ">高效办公</h1>
        <p class="animated fadeInRightBig">河海大学实践课程考勤系统 管理员登录入口</p>
    </div>
</div>

<div class="container" id="con_table">
    <div class="col-lg-4 col-sm-4 col-xs-4 col-lg-offset-4 col-sm-offset-4 col-xs-offset-4">
        <form action="servlet/ManagerLoginServlet" method="post">
            <table  id="table1" class="table table-bordered">
                <tr>
                    <td style="vertical-align: middle;"> <span class="glyphicon glyphicon-user"> </span> 手机号</td>
                    <td> <input class="form-control" type="text" name="sname" id=" " value="" /></td>
                </tr>

                <tr>
                    <td style="vertical-align: middle;"> <span class="glyphicon glyphicon-lock"> </span>  密码</td>
                    <td><input class="form-control" type="password" name="spass"/></td>
                </tr>

                <!--忘记密码功能暂时不做
                 <tr>
                    <td colspan="2" align="right">
                        <a href="javascript:void(0)" onclick="change('#table1','#table2')">忘记密码</a>
                    </td>
                </tr>
                  -->
                <tr>
                    <td colspan="2" align="center">
                        <input class="btn btn-info btn-block" type="submit" value="登录" />
                    </td>
                </tr>

            </table>
        </form>



    </div>
</div>


<footer>
    <div>
        <div class="container">
            <h4>河海大学 江宁校区</h4>
            <p>Designed and built by <a href="#" target="_blank">@HHU</a></p>
        </div>
    </div>
</footer>

<script type="text/javascript">
    $(function(){
        //时间函数
        startTime();
    })
    function change(selector1,selector2){
        $(selector1).css({
            "display":"none"
        });
        $(selector2).css({
            "display":"table"
        });
    }
    var msg='<%=request.getAttribute("msg")%>';
    if(msg!='null'){//如果有消息
        dhtmlx.message({
            text: msg,
            expire: 3000
        });
    }
</script>
</body>
</html>