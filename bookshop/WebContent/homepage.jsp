<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Book House</title>
	<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
	<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<s:url value="/css/homepage.css" />" rel="stylesheet">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
        	<div class="navbar-header">
				<a class="navbar-brand" class="active" href="homepage.jsp">Book House</a>
        	</div>
        	<div class="navbar-collapse collapse">
          		<div class="navbar-form navbar-right nav navbar-nav" >
          			<s:action name="customerBar" executeResult="true"></s:action>
				</div> 
        	</div>
      	</div>
    </div>
    
    <div class="jumbotron">
    	<div class="container">
    		<div class="row">
    			<div class="col-md-8">
    				<img src="image/logo.png" width=250px height="250px">
    			</div>
    			<div class="col-md-4 pull-right">
    				<form class="form-signin" role="form" action="userLogin" method="post">
        				<input type="text" class="form-control input-lg margin-top" name="userID" placeholder="Your username" required autofocus>
        				<input type="password" class="form-control input-lg margin-top" name="password" placeholder="Your password" required>
        				<button class="btn btn-lg btn-primary btn-block margin-top" type="submit">Sign in for BookHouse</button>
      				</form>
      			</div>
    		</div>
    	</div>
    </div>
    
    <div class="container">
    	<footer>@2014 Book House</footer>
    </div>
</body>
</html>