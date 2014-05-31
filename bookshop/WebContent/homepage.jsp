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
	<link href="<s:url value="/css/default.css" />" rel="stylesheet">
	
	<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
	<script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<div class="btn-group">
  			<button type="button" class="btn btn-primary btn-lg dropdown-toggle" data-toggle="dropdown">
    			Category<span class="caret"></span>
  			</button>
  			<ul class="dropdown-menu" role="menu">
  				<s:iterator value="categories" status="status" id="inner">
    			<li><a href="#"><s:property value="category"/></a></li>
    			</s:iterator>
  			</ul>
		</div>
	
	
		<!-- div class="dropdown">
  			<button class="btn dropdown-toggle sr-only" type="button" id="dropdownMenu1" data-toggle="dropdown">
    		Dropdown
    			<span class="caret"></span>
  			</button>
  			<ul class="dropdown-menu" role="menu" aria-labelledby="dropdownMenu1">
    			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">category</a></li>
    			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">category</a></li>
    			<li role="presentation"><a role="menuitem" tabindex="-1" href="#">category</a></li>
  			</ul>
		</div>	 -->
	</div>
</body>
</html> 