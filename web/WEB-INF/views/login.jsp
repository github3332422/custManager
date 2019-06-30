<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
<head>
<title>登录页面</title>
<link href="http://cdn.static.runoob.com/libs/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        function check() {
            var usercode = $("#usercode").val();
            var password = $("#password").val();
            if(usercode == null || usercode == ""){
                alert("用户名不能为空");
                $("#usercode").focus();
                return false;
            }
            if(password == null || password == ""){
                alert("密码不能为空");
                $("#password").focus();
                return false;
            }
            return true;
        }
    </script>
</head>
	<form id="form1" class="well" style="width: 30em; margin: auto; margin-top: 150px;"
		  method="post" action="/login.action" onsubmit="return check()">
		<h3>用户登录
			<font color="red">
				<%-- 提示信息--%>
				<span id="message">${msg}</span>
			</font>
		</h3>
		<div class=" input-group input-group-md">
				  <span class="input-group-addon" id="sizing-addon1"><i
						  class="glyphicon glyphicon-user" ></i></span>
			<input id="usercode" type="text" class="form-control" name="usercode"/>

		</div>
		<br />
		<div class="input-group input-group-md">
				  <span class="input-group-addon" id="sizing-addon1"><i
						  class="glyphicon glyphicon-lock"></i></span>
			<input type="password" id="password" class="form-control" name="password"/>
		</div>
		<br/>
		<button type="submit" id="bn" class="btn btn-success btn-block">登录</button>
		<a class="btn btn-sm btn-white btn-block" style="text-align: right;" th:href="@{register}" href="register.html"><h6>还没有账户？前往注册</h6></a>
	</form>
</body>
</html>
