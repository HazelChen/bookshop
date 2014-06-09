<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Promotion Analyse-Book House</title>
<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<s:url value="/css/default.css" />" rel="stylesheet">

<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/highcharts.js" />></script>
<script src=<s:url value="/js/exporting.js" />></script>
<script src=<s:url value="/js/promotion.js" />></script>
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<h1>Promotion Analyse</h1>
	</div>
	
	<div class="container">
		<h3>Sales Change</h3>
		<table class="table">
			<tbody>
				<tr>
					<th>Pre-sales</th>
					<td><s:property value="preSales" /></td>
				</tr>
				<tr>
					<th>Current Sales</th>
					<td><s:property value="currentSales" /></td>
				</tr>
				<tr>
					<th>Growth Rate</th>
					<td><s:property value="growthRate" />%</td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="container">
		<h3>Coupons Usage</h3>
		<div class="row">
			<div class="col-xs-6">
				<h5>Equal Coupons</h5>
				<table class="table">
					<thread>
						<tr>
							<th>Value</th>
							<th>Release Number</th>
							<th>Used Number</th>
							<th>Used Percentage</th>
						</tr>
					</thread>
					<tbody>
						<s:iterator value="equalCoupons">
						<tr>
							<td><s:property value="value" /></td>
							<td><s:property value="totalCount" /></td>
							<td><s:property value="usedCount" /></td>
							<td><s:property value="usedPercent" />%</td>
						</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
			<div class="col-xs-6">
				<h5>Discount Coupons</h5>
				<table class="table">
					<thread>
						<tr>
							<th>Value</th>
							<th>Release Number</th>
							<th>Used Number</th>
							<th>Used Percentage</th>
						</tr>
					</thread>
					<tbody>
						<s:iterator value="discountCoupons">
						<tr>
							<td><s:property value="value" /></td>
							<td><s:property value="totalCount" /></td>
							<td><s:property value="usedCount" /></td>
							<td><s:property value="usedPercent" />%</td>
						</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	
	<div class="container">
		<div class="col-xs-6">
			<div id="equal"></div>
		</div>
		<div class="col-xs-6">
			<div id="discount"></div>
		</div>
	</div>
	
	<div class="hide" id="equalData">
		[['Used', <s:property value="equalUsed" />],
		['Not Used', <s:property value="equalNotUsed" />]]
	</div>
	
	<div class="hide" id="discountData">
		[['Used', <s:property value="discountUsed" />],
		['Not Used', <s:property value="discountNotlUsed" />]]
	</div>
</body>
</html>