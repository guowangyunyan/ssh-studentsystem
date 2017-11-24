<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>学生系统登录</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>

<script type="text/javascript" src="js/login.js"></script>

</head>
<body>
	<form>
		<span id="errorInfo"></span><br> 
		用户名:<input type="text" name="userName" id="userName"><br> 
		密码:<input type="password" name="userPwd" id="userPwd"><br> 
		验证码:<input type="text" name="verifyCode" id="verifyCode">&nbsp;&nbsp;&nbsp;
		<img class="verifyCodeImg" alt="" src="verifyCode" /><br> 
		<input type="checkbox" name="remember" value="1">记住密码&nbsp;&nbsp;&nbsp;
		<button type="button" onclick="login()">登录</button><br>
		<a href="modify.jsp">忘记密码</a>&nbsp;&nbsp;&nbsp; <a href="register.jsp">注册</a>
	</form>
</body>

</html>