<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Set Coupons</title>
<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<s:url value="/css/default.css" />" rel="stylesheet">
<link href="<s:url value="/css/homepage.css" />" rel="stylesheet">

<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/bootstrap.min.js" />
	type="text/javascript"></script>
</head>
<body>
	<s:include value="navigater.jsp" />

	<div class="container">
		<h1>Set Coupons</h1>
		<div class="row">
			<div class="col-md-6">
				<form method="post" action="addEqualCoupons">
					<label class="margin-top">New Equal Coupns Value:</label>
					<input type="text" class="form-control" name="equalCoupons" required autofocus>
				</form>
				<p class="margin-top">
					existing values:
					<s:iterator value="equalCouponsStandards">
						<s:property value="equalValue" />、
    				</s:iterator>
				</p>
			</div>
			<div class="col-md-6">
				<form method="post" action="addDiscountCoupons">
					<label class="margin-top">New Discount Coupns Value:</label>
					<input type="text" class="form-control" name="discountCoupons" required autofocus>
				</form>
				<p class="margin-top">
					existing values:
					<s:iterator value="discountCouponsStandards">
						<s:property value="discount" />、
    				</s:iterator>
				</p>
			</div>
		</div>
	</div>
</body>
</html>