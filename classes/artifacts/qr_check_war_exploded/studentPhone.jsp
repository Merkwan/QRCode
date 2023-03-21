<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%@ page import="com.hhuQd.service.StudentService"%>
<%@ page import="com.hhuQd.dao.StudentDao"%>
<%@ page import="com.hhuQd.entity.Student"%>
<%@ include file="include.jsp" %>  
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge,chrome=1">
<title>二维码签到系统学生PC端</title>
</head>
<body>
		<%
			//通过 cookies 判断是否已登陆
			//从 StudentLoginServlet 拿到 cookies
			Cookie cc[]= request.getCookies();//获取客户端本地的cookie数据

			boolean flag=false;//表示没有登录
			String sphone="";//学生电话号码
			String sno="";//学生在数据库的编号
			String sname = " ";
			for(Cookie c:cc){
				if(c.getName().equals("islogin")){
					if(c.getValue().equals("true")){
						flag=true;
					}
				}
				
				if(c.getName().equals("sphone")){
					sphone=c.getValue();
				}
				
				if(c.getName().equals("sno")){
					sno=c.getValue();
				}

				if(c.getName().equals("sname")){
					sname = c.getValue();
				}
			}
			
		 %>

<nav class="navbar navbar-default navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
				        <span class="sr-only">Toggle navigation</span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				        <span class="icon-bar"></span>
				    </button>
					<a class="navbar-brand" href="#">HHU</a>
				</div>

				<!-- Collect the nav links, forms, and other content for toggling -->
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

					<ul class="nav navbar-nav navbar-right">
						<%
							if(flag==true){
						%>
						
							<li>
								<a href="#"> <span class="glyphicon glyphicon-user"> </span> 欢迎 <%= sname %> 同学</a>
							</li>
							<li>
								<a href="${CTX_PATH}/studentLogin.jsp"><span class="glyphicon glyphicon-log-out"> </span> 安全退出</a>
							</li>
						<%		
							}else{

						%>

							<li>
								<a href="studentLogin.jsp"> <span class="glyphicon glyphicon-user"> </span> 登陆</a>
							</li>
						<%	
							}
						 %>

					 

					</ul>
			</div>	
		</div>
</nav>
		


<div class="jumbotron_test jumbotron " style="margin-top: 50px;">
	<div class="container">
		<h3 id="serverMsg"></h3>   
		<h1>实践课程考勤系统</h1>
		
						<%
							if(flag==true){
						%>
						
							 	<p >欢迎 <%=sno%></p>
						<%		
							}else{
							
						%>
						
							<p >艰苦朴素 实事求是 严格要求 勇于探索</p>
						
						<%} %>
<%--		<div align="right">--%>
<%--			<span class="badge">0</span>--%>
<%--		</div>--%>
	</div>

</div>

<div id="btnDiv"> 
	<div class="container divcss5 ">
<%--		<input type="button" id="btn1" class="btn btn-block btn-lg btn-danger" value="签到" />--%>
		<input type="button" class="btn btn-block btn-primary btn-lg" id="btn2" value="申请请假" />
		<input type="button" class="btn btn-block btn-default btn-lg" id="btn6" value="查看请假状态" />
		<input type="button" class="btn btn-block btn-success btn-lg" id="btn3" value="查看签到信息" />
		<input type="button" class="btn btn-block btn-info btn-lg " id="btn5" value="健康申报" onclick="alert('此功能看时间而定')">
		<input type="button" class="btn btn-block btn-warning btn-lg" id="btn4" value="修改信息" />

	</div>
</div>

<div id="div_qd" style="display: none;">
			
			<div class="container">
				<h3 id="tihsiMsg"></h3>
				<div align="center">
					
					<img id="stateImg" class="img-responsive" src="" />
				</div>
				<br />

				<%--    空		返回主菜单  		   --%>

				<input type="button" name="" class="btn btn-danger btn-block" id="" value="返回主菜单" onclick="showHomePage('div_qd')" />
				
				<div style="margin-top: 55px;"></div>
				
			</div>
			
</div>

<div id="div_sqqj" style="display: none;">
			<table class="table table-striped">
				<tr>
					<td>请假时间</td>
				</tr>
				<tr>
					<td><input type="text" id="sqqj_day" class="form-control" value="2020-05-20" /></td>
				</tr>

				
				<tr>  
					<td>选择老师</td>
				</tr>  
				<tr>
					<td>
						<select   class="form-control"   id="teacherData">
							<option value="-1">请选择</option>
						</select>
					</td>

				</tr>
				
				
				<tr>
					<td>备注 </td>
				</tr>

				<tr>
					<td>
						<textarea name="3" rows="3"  id="sqqj_bz" cols="" class="form-control"></textarea>
					</td>
				</tr>

				<tr>
					<td>

					<%--	确认申请			btnaaa		--%>

						<input type="button" class="btn btn-danger btn-block" name="" id="btnaaa" onclick="sendQJMessage()" value="确认申请" />
					</td>
				</tr>
				<tr>
					<td>

						<%--	返回菜单			btnaaa		--%>

						<input type="button" class="btn btn-success btn-block" name="" id="btnaaa" onclick="showHomePage('div_sqqj')" value="返回主菜单" />
					</td>
				</tr>


			</table>
</div>

<div id="div_ckqj" style="display: none;">

	<div class="container">

		<table class="table table-striped">
			<tr id="qj_tableData">
				<td>请假日期</td>
				<td>备注</td>
				<td>请假状态</td>
			</tr>
		</table>

		<input type="button" name="" class="btn btn-danger btn-block" id="" value="返回主菜单"  onclick="showHomePage('div_ckqj')" />
		<div style="margin-top: 25px;"></div>

	</div>

</div>

<div id="div_ckkq" style="display: none;">
			
			<div class="container">
				
				<table class="table table-striped">
					<tr id="tableData">
						<td>日期</td>
						<td>签到截止时间</td>
						<td>签到时间</td>
 						<td>签到状态</td>
					</tr>
				</table>
				
				<input type="button" name="" class="btn btn-danger btn-block" id="" value="返回主菜单"  onclick="showHomePage('div_ckkq')" />
				<div style="margin-top: 25px;"></div>
				
			</div>
			
</div>

<div id="div_xgxx" style="display: none;">
	<div class="container">
		<table class="table table-bordered">
			<tr>
				<td>新登陆密码:</td>
			</tr>
			<tr>
				<td>
					<input type="password"  class="form-control" name="spass" id="spass" value="" />
				</td>
			</tr>
			<tr>
				<td>重复新密码:</td>
			</tr>
			<tr>
				<td>
					<input type="password"  class="form-control" name="srpass" id="srpass" value="" />
				</td>
			</tr>

			<tr>
				<td align="center">
					<input type="button" name="" id="btnSave"  class="btn btn-success" value="确认更改" />
				</td>
			</tr>
		</table>
	</div>


	<input type="button" name="" class="btn btn-danger btn-block" id="" value="返回主菜单"  onclick="showHomePage('div_xgxx')" />
</div>

<script type="text/javascript">


	var stuPhone='<%=sphone%>';	//登录的学生的电话号码

function showHomePage(div_id){
	$("#"+div_id).fadeOut(100,function(){
		$("#btnDiv").fadeIn(500);   
	});
	
	
}

//为按钮增加点击的事件处理

$("#btn2").click(function() {
	

	<%--var islogin='<%=val%>';--%>
	<%--	if(islogin=='null'){--%>
	<%--	alert('请先登录才可以申请请假');--%>
	<%--	return ;  --%>
	<%--}--%>
	
	$("#btnDiv").fadeOut(500, function() {
		
		
		//为老师这个 选择框 赋值 /servlet/GetClassTeacherDataServlet
			$.ajax({        
			     type : "POST", //提交方式
			     url : "${CTX_PATH}/servlet/GetClassTeacherDataServlet",//路径
			     data:{   
			     	 "sno":'<%=sno%>'   
				     },
			     dataType:"json",  
			     success : function(result) {//返回数据根据结果进行相应的处理       
 			       	//
 			      	$.each(result,function(inx,item){
 			      		 var data="<option value='"+item.tid+"'> "+item.tname+" </option>";
 			      		
 			      		 $("#teacherData").append(data);
 			      	});
 			     }
		  });      
		
		$("#div_sqqj").fadeIn(500);
	});
});

$("#btn6").click(function() {
		$("#btnDiv").fadeOut(500, function() {
			//$("#qj_tableData").cleanData();
			//访问后台获取数据
			$.ajax({
				type : "POST", //提交方式
				url : "${CTX_PATH}/servlet/GetStudentQJRecordServlet",//路径
				data:{
					"stuno":'<%=sno%>'
				},
				dataType:"json",
				success : function(result) {//返回数据根据结果进行相应的处理
					//$("#qj_tableData").next("tr").remove();
					//每次加载都要先将原来的数据清除
					$("#qj_tableData").next("tr").remove();
					$.each(result,function(index,item){
						$("#qj_tableData").next("tr").remove();
					})
					$.each(result,function(index,item){

						//将之间的数据先删除
						// 找到dom结构 删除#tableData 的后面的兄弟元素
						//$("#qj_tableData").next("tr").remove();

						var ss;
						if(item.qresult == 0){
							ss="待批阅";
						}
						else if(item.qresult==1){
							ss="同意";
						}
						else if(item.qresult==2){
							ss="不同意";
						}

						var newTime = new Date(item.qdate); //就得到普通的时间了
						var n=	newTime.getFullYear()+"-";
						var y=	newTime.getMonth()+1+"-";
						var r=	newTime.getDate();
						$("#qj_tableData").after(" <tr> <td> "+ (n+y+r) +" </td> <td> "+item.qreason+" </td> <td> "+ ss +" </td> </tr> ");

					});
				}
			});
			//并把数据进行解析


			$("#div_ckqj").fadeIn(500);
		});
	});

$("#btn3").click(function() {
	$("#btnDiv").fadeOut(500, function() {
		
		//访问后台获取数据
		$.ajax({        
			     type : "POST", //提交方式
			     url : "${CTX_PATH}/servlet/GetStudentQDRecordServlet",//路径
			     data:{
			     	 "stuno":'<%=sno%>'   
				     },
			     dataType:"json",  
			     success : function(result) {//返回数据根据结果进行相应的处理
					 // $("#tableData").next("tr").removeAllRanges();
					 //$("#tableData").clearAll();
					 //$("#tableData").next("tr").remove();
					 //每次加载都要先将原来的数据清除
					 $("#tableData").next("tr").remove();
					 $.each(result,function(index,item){
						 $("#tableData").next("tr").remove();
					 })
					 $.each(result,function(index,item){
 			      	
 			      		 //将之间的数据先删除
 			      		 // 找到dom结构 删除#tableData 的后面的兄弟元素
 			      		 //$("#tableData").next("tr").remove();
    		    
 			      	   	var ss;
			      		   if(item.qdstate == 0){
			      		   		ss="未签到";
			      		   }
							if(item.qdstate==1){
	 			      		  	ss="已签到";
	 			      		}
 			      		  var newTime = new Date(item.qdate); //就得到普通的时间了
	 			      		  var n=	newTime.getFullYear()+"-";
	 			      		  var y=	newTime.getMonth()+1+"-";   
	 			      		  var r=	newTime.getDate();  
						$("#tableData").after(" <tr> <td> "+ (n+y+r) +" </td> <td> "+item.linetime+" </td> <td> "+item.qtime+" </td> <td> "+ ss +" </td> </tr> ");
 			      		 
 			      	});
 			     }
		  });      
		//并把数据进行解析
	
	
		$("#div_ckkq").fadeIn(500);
	});
});

$("#btn4").click(function() {
	$("#btnDiv").fadeOut(500, function() {


		$("#div_xgxx").fadeIn(500);
	});
});
	//修改信息处理
	$("#btnSave").click(function(){
		//取值

		var spass=$("#spass").val();
		var srpass=$("#srpass").val();
		//判断

		if(spass==''){
			alert('密码为必填项');
			return ;
		}
		if(srpass==''){
			alert('重复密码为必填项');
			return ;
		}

		if(srpass!=spass){
			alert('两次密码不一致');
			return ;
		}
		else {
			//alert(stuPhone);
			//alert(spass);
			//发送ajax
			$.ajax({
				type : "POST", //提交方式
				url : "${CTX_PATH}/servlet/UpdateStudentPassWordServlet",//路径
				data:{
					"sphone":stuPhone,
					"spass":spass
				},
				success : function(result) {//返回数据根据结果进行相应的处理
					//alert('test');
					if(result== 1) {
						alert('密码修改成功！请重新登陆');
						window.location.href = 'studentLogin.jsp';
					}
					else{
						alert('密码修改失败');
					}
				}
			});

		}


	});

	//请假信息提交后台
function sendQJMessage() {


				$("#btnaaa").attr("disabled","disabled");

				//获取请假的数据 
				   
				var sqqj_day = $("#sqqj_day").val();
				/*var sqqj_sy ;//事由是一个radio
				if( $("#sqqj_sy").attr("checked")==true){
					sqqj_sy="0";
				}else{
					sqqj_sy="1";
				}*/
	 			var sqqj_ls = $("#teacherData").val();
				var sqqj_bz = $("#sqqj_bz").val();
				    
				if(sqqj_day=="" || sqqj_ls=="" || sqqj_bz==""  || sqqj_ls==-1){
					alert("填写的内容不完整,请检查后再次提交");
					return ;    
				}
				
				
				//访问后台获取数据
				$.ajax({        
					     type : "POST", //提交方式
					     url : "${CTX_PATH}/servlet/AddSQQJServlet",//路径
					     data:{
					     	 "sqqj_day":sqqj_day,        
					     	 //"sqqj_sy":sqqj_sy,
					     	 "sqqj_ls":sqqj_ls,
					     	 "sqqj_bz":sqqj_bz ,  
					     	 "stuno":'<%=sno%>',
							 "sname":'<%=sname%>'
	 				     },
					    
					     success : function(result) {//返回数据根据结果进行相应的处理    
	 		 			      	
					    	
	 		 			      	alert(result);
	 		 			      
	 							$("#div_sqqj").fadeOut(500, function() { 
									$("#btnDiv").fadeIn(500);
								});
							 			      
			 			      
			 			      
			 		     }
				 });      
	
}


var msg='<%=request.getAttribute("msg")%>'; 
if(msg!='null'){//如果有消息
	alert(msg);
}

</script>
</body>
</html>