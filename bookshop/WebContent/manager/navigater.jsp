<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
</head>
<body>
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
        	<div class="navbar-header">
				<a class="navbar-brand" class="active" href="<s:url action="setCoupons"/>">Book House</a>
        	</div>
        	<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
          			<li><a href='<s:url action="setCoupons"/>'>Set Coupons</a></li>
          			<li><a href='<s:url action="inventory"/>'>Inventory</a></li>
          			<li><a href='<s:url action="userAnalyse"/>'>User</a></li>
          			<li><a href='<s:url action="bookAnalyse"/>'>Book</a></li>
          			<li><a href='<s:url action="promotion"/>'>Promotion</a></li>
          			<li><a href='<s:url action="orderAnalyse"/>'>Order</a></li>
          		</ul>
          		<div class="navbar-form navbar-right nav navbar-nav" >
          			<s:action name="userBar" executeResult="true"></s:action>
				</div> 
        	</div>
      	</div>
    </div>
</body>
</html>