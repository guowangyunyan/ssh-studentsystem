<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<script type="text/javascript" src="js/jquery-1.7.2.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<h1>login</h1>
	
	<form:form action="login" method="post" commandName="userForm">
		<font color="red"><form:errors path="name"/></font><br>
		<spring:message code="user.name" />：<form:input path="name" id="name"/><br>
		<c:if test="${not empty name}">
			<font color="red">${name }</font>
		</c:if>
		<spring:message code="user.password" />：<form:password path="password" id="password"/><br>
		<c:if test="${not empty password}">
			<font color="red">${password }</font>
		</c:if>
		<spring:message code="user.rememberMe" />：<form:checkbox path="rememberMe"/><br>
		<input type="submit" value="login"/>
	</form:form>
	
</body>
</html>
