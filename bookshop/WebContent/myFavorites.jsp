<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Favorites</title>
<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<s:url value="/css/default.css" />" rel="stylesheet">

<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/bootstrap.min.js" />
	type="text/javascript"></script>
</head>
<body>
	<s:include value="navigater.jsp" />

	<div class="container">
		<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/images/book\\";
		%>
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th width="15%">Book Infomation</th>
						<th width="20%"></th>
						<th width="55%">Description</th>
						<th width="10%">Operation</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="bookCollected" status="st">
						<tr>
							<td width="15%"><img
								src='<%=basePath%><s:property value="id"/>.jpg' height="150"
								width="150" /></td>
							<td width="20%">
								<h3>
									<s:property value="name" />
								</h3>
								Author:<s:property value="author" /><br /> 
								Press:<s:property value="press" /><br />
								Price:<s:property value="price" /><br />
							</td>
							<td width="55%"><h4>
									<s:property value="description" />
								</h4></td>
							<td width="10%">
							<a class="btn btn-lg btn-success"
								href='bookInCart?bookId=<s:property value="id"/>'>Buy it</a><br />
							<a class="btn btn-lg btn-warning margin-top-20"
								href='bookInCart?bookId=<s:property value="id"/>'>Delete it</a>
							</td>
						</tr>
					</s:iterator>
				</tbody>
			</table>

		</div>
	</div>
</body>
</html>