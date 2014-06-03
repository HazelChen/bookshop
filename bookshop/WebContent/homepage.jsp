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
	<link href="<s:url value="/css/homepage.css" />" rel="stylesheet">
	
	<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
	<script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<form action="search" class="form-inline" method="post">
			<div class="btn-group">
  				<button type="button" class="btn btn-info btn-lg dropdown-toggle" data-toggle="dropdown">
    				Category<span class="caret"></span>
  				</button>
  				<ul class="dropdown-menu" role="menu">
  					<s:iterator value="categories" status="status" id="inner">
    				<li><a href="#"><s:property value="category"/></a></li>
    				</s:iterator>
  				</ul>
			</div>
		
          	<div class="form-group" id="waitlist_email_group">
            	<input class="form-control input-lg waitlist-email" name="search" placeholder="Enter commodity infomation" size="60">
          	</div>
          	<div class="form-group">
            	<button class="btn btn-lg btn-primary" type="submit">GET!</button>
          	</div>
        </form>
        
        <div class="container">
        	<%String path = request.getContextPath();
			String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/images/book\\";
			%>
			<s:iterator value="books" status="st">
			<div class="row margin_top_10">
				<div class="col-md-3 margin_top_30">
					<div>
						<img src='<%=basePath %><s:property value="id"/>.jpg'/>
					</div>
				</div>
				<div class="col-md-7">
					<h3><s:property value="name"/></h3>
					<ul class="list-group">
						<li class="list-group-item">
							<span class="label label-info">Author:</span><s:property value="author"/>
						</li>
						<li class="list-group-item">
							<span class="label label-info">Press:</span><s:property value="press"/>
						</li>
						<li class="list-group-item">
							<span class="label label-info">Price:</span><s:property value="price"/>
						</li>
						<li class="list-group-item">
							<s:property value="description"/>
						</li>
					</ul>
					<div class="right">
	            		<a class="btn btn-lg btn-success" href='bookInCart?bookId=<s:property value="id"/>'>Buy it</a>
    	        		<a class="btn btn-lg btn-warning" href='collectBook?bookId=<s:property value="id"/>'>Collect it</a>
    	        	</div>
        	  	</div>
			</div>
			</s:iterator>
        </div>
	</div>
</body>
</html> 