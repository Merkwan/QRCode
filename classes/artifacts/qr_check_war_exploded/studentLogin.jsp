<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="include.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<title>实践课程考勤系统学生PC端</title>
</head>
<body>
<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<!-- Brand and toggle get grouped for better mobile display -->
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				    </button>
					<a class="navbar-brand" href="#">HHU</a>
				</div>

			
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

					<ul class="nav navbar-nav navbar-right">
						<li>
							<a href="index.jsp"> <span class="glyphicon glyphicon-user"> </span> 工作人员登陆</a>
						</li>
						<li>
							<a href="#"> <span class="glyphicon glyphicon-user"> </span> 帮助</a>
						</li>

					</ul>
				</div>
			
			</div>
		
</nav>


<div class="container">
<div class="jumbotron_test jumbotron " style="margin-top: 50px;" >

				<h1>实践课程考勤系统</h1>
				<p>艰苦朴素 实事求是 严格要求 勇于探索</p>

			</div>
</div>

		
<div class="container">
	<form action="http://www.txjava.cn:80/qr_check/StudentLoginServlet" method="post">
			<table class="table">
				<tr>
					<td style="vertical-align: middle;">手机号码:</td>
					<td>
						<input type="text" class="form-control" name="sphone" id="" value="" />
					</td>
				</tr>
		
				<tr>
					<td style="vertical-align: middle;">登陆密码:</td>
					<td>
						<input type="password"  class="form-control" name="spass" id="" value="" />
					</td>
				</tr>
				
				<tr>
					<td  align="center">
						<input type="checkbox" name="" id="" value="" />记住密码
					</td>
					<td  align="center">
					<a href="#" onclick="alert('此功能看时间而定')"> 忘记密码？</a>
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="button" name="" id="" onclick="window.location.href='studentAdd.jsp'" class="btn btn-success btn-block" value="注册" />
					
					</td>
					<td align="center">
						<input type="submit" name="" id="" class="btn btn-danger btn-block" value="登录" />
					</td>
				</tr>
			</table>
	</form>
</div>
<footer>
	<div>
		<div class="container">
			<h4>河海大学 江宁校区</h4>
			<p>Designed and built by <a href="http://www.hhu.edu.cn/" target="_blank">@HHU</a></p>
		</div>
	</div>
</footer>
<script type="text/javascript">
	
var msg='<%=request.getAttribute("msg")%>'; 
if(msg!='null'){//如果有消息
	alert(msg);
}  
</script> 
</body>
</html>