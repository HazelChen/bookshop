<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Join Book House</title>
	<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
	<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<s:url value="/css/default.css" />" rel="stylesheet">
	
	<script src='<s:url value="/js/calendar.js" />' type="text/javascript"></script>
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<h1>Join Book House</h1>
		<h4>The best website to buy books.</h4>
		<%String failMsg = (String)session.getAttribute("registerError");
		if (failMsg != null) {%>
		<span class="error"><%=failMsg%></span><%} %>
		<form method="post" action="register">
			<div class="row">
				<div class="col-md-6">
					<label class="margin-top">Username:</label>
					<input type="text" class="form-control" name="username" required autofocus>
					<label class="margin-top">Password:</label>
        			<input type="password" class="form-control" name="password" required>
        			<label class="margin-top">Confirm your password:</label>
        			<input type="password" class="form-control" name="repeatPassword" required>
				</div>
				
				<div class="col-md-6">
					<div class="row">
					<div class="col-md-6">
					<label class="margin-top">Gender:</label>
					<br />
					<label class="radio radio-inline"><input type="radio" name="sex" value="male" checked>male</label>
    				<label class="radio radio-inline"><input type="radio" name="sex" value="female">female</label>
    				</div>
					<div class="col-md-6">
					<label class="margin-top">Birthday:</label>
					<input type="text" class="form-control" name="birthday" required onfocus="HS_setDate(this)">
    				</div>
    				</div>
					<label class="margin-top">Address:</label>
					<input type="text" class="form-control" name="address" required>
					<label class="margin-top">Bank card:</label>
        			<input type="text" class="form-control" name="bankId" required>
				</div>
			</div>
			<div class="row margin-top">
				<div class="col-md-4">
        			<button class="btn btn-lg btn-success btn-block" type="submit">Create an account</button>
        		</div>
        	</div>
		</form>
	</div>
</body>
</html>