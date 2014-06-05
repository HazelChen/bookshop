<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>My Coupons-Book House</title>
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
		<div class="row">
			<div class="col-xs-6">
				<h3>My Equal Coupons</h3>
				<table class="table">
					<thead>
						<tr>
							<th width="50%">ID</th>
							<th width="50%">Equal Value</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="equalCoupons" status="st">
							<tr>
								<td width="50%"><s:property value="id" /></td>
								<td width="50%"><s:property value="standard.equalValue" />元</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
			
			<div class="col-xs-6">
				<h3>My Discount Coupons</h3>
				<table class="table">
					<thead>
						<tr>
							<th width="50%">ID</th>
							<th width="50%">Discount Value</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="discountCoupons" status="st">
							<tr>
								<td width="50%"><s:property value="id" /></td>
								<td width="50%"><s:property value="standard.discount" /></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>