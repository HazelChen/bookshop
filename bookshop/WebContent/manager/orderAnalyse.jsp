<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Order Analyse-Book House</title>
<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<s:url value="/css/default.css" />" rel="stylesheet">

<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/highcharts.js" />></script>
<script src=<s:url value="/js/exporting.js" />></script>
<script src=<s:url value="/js/sales.js" />></script>
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<h1>Order Analyse</h1>
	</div>
	
	<div class="container">
		<div id="sales"></div>
	</div>
	
	<div class="container">
		<h3>Order Shipment</h3>
		<table class="table">
			<thead>
				<tr>
					<th>OrderId</th>
					<th>Days for Distributed</th>
					<th>Days for Sended</th>
				</tr>
			</thead>
			<tbody>
				<s:iterator value="orderShipments" >
				<tr>
					<td><s:property value="orderId"/></td>
					<td><s:property value="distributeDay"/></td>
					<td><s:property value="sendDay"/></td>
				</tr>
				</s:iterator>
				<tr>
					<td>Average</td>
					<td><s:property value="distributedDayAvg"/></td>
					<td><s:property value="sendDayAvg"/></td>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="hide" id="salesData">
		[<s:iterator value="daySales" >
			<s:property value="count" />,
		</s:iterator>]
	</div>
</body>
</html>