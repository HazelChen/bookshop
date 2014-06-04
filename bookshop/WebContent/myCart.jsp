<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My Cart</title>
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
		<div class="container">
			<div class="row">
				<div class="col-md-10">
			<h1 class="right">
				Total:
				<s:property value="totalPrice" />
			</h1>
			</div>
			<div class="col-md-2">
			<a class="btn btn-lg btn-success margin-top-20"
									href='bookInCart?bookId=<s:property value="id"/>'>Chekout</a>
			</div>
			</div>
		</div>
		<div class="container">
			<div class="row">
				<table class="table">
					<thead>
						<tr>
							<th width="20%">Book Infomation</th>
							<th width="30%"></th>
							<th width="15%">Price</th>
							<th width="15%">Count</th>
							<th width="20%">Operation</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="cartBooks" status="st">
							<tr>
								<td width="20%"><img
									src='<%=basePath%><s:property value="id"/>.jpg' height="150"
									width="150" /></td>
								<td width="30%">
									<h3>
										<s:property value="name" />
									</h3> Author:<s:property value="author" /><br /> Press:<s:property
										value="press" />
								</td>
								<td width="15%"><h4>
										<s:property value="price" />
									</h4></td>
								<td width="15%"><h4>
										<s:property value="bookInCarts[#st.index].count" />
									</h4></td>
								<td width="20%">
								<a class="btn btn-lg btn-warning"
									href='bookInCart?bookId=<s:property value="id"/>'>Delete it</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
</body>
</html>