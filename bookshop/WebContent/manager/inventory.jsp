<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Inventory Analyse-Book House</title>
<title>Set Coupons</title>
<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<s:url value="/css/default.css" />" rel="stylesheet">
<link href="<s:url value="/css/homepage.css" />" rel="stylesheet">

<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/highcharts.js" />></script>
<script src=<s:url value="/js/inventory.js" />></script>
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<h1>Inventory Analyse</h1>
		<p>The newest average inventory is <s:property value="averageInventory"/>, the count of items is <s:property value="itemCount"/>.
	</div>
	
	<div class="container">
		<div id="chart"></div>
	</div>
	
	<div class="container">
		<table class="table">
			<thead>
				<tr>
					<th>ISBN</th>
					<th>Name</th>
					<th>Price</th>
					<th>Funds Used Average</th>
					<th>Item</th>
					<th>Item Percentage</th>
					<th>Funds Used Cumulative Average</th>
					<th>Funds Used Cumulative Average Percentage</th>
					<th>Category</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="bookInventories" >
				<tr>
					<td><s:property value="isbn"/></td>
					<td><s:property value="name"/></td>
					<td><s:property value="price"/></td>
					<td><s:property value="fundsUsedAvg"/></td>
					<td><s:property value="item"/></td>
					<td><s:property value="itemPercentage"/>%</td>
					<td><s:property value="fundsUsedAvgCount"/></td>
					<td><s:property value="fundsUsedAvgCountPer"/>%</td>
					<td><s:property value="category"/></td>
				</tr>
				</s:iterator>
			</tbody>
		</table>
	</div>
	<div class="hidden" id="data">[
		<s:iterator value="bookInventories" >
			<s:property value="fundsUsedAvgCountPer"/>,
		</s:iterator>]
	</div>
</body>
</html>