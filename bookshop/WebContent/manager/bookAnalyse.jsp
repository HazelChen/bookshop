<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Book Analyse-Book House</title>
<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<s:url value="/css/default.css" />" rel="stylesheet">

<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/highcharts.js" />></script>
<script src=<s:url value="/js/exporting.js" />></script>
<script src=<s:url value="/js/highcharts-3d.js" />></script>
<script src=<s:url value="/js/bookAnalyse.js" />></script>
<script src=<s:url value="/js/book3D.js" />></script>
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<div class="row">
			<div class="col-xs-6">
				<h1>Book Analyse</h1>
				<p>The right chart is about the sales of each category. While from the chart bottom, you can see the relation about price, collections and sales. 
			</div>
			<div class="col-xs-6">
				<div id="category"></div>
			</div>
		</div>
		<div class="row">
			<div id="container"></div>
		</div>
	</div>
	
	<div id="categorya">
		[<s:iterator value="category" status="st">{
			y:<s:property value="count" />,
			color: colors[<s:property value="#st.index" />],
			drilldown: {
				name: '<s:property value="category" />',
				categories:[
				<s:iterator value="responseBook[#st.index]">
				'<s:property value="name"/>',
				</s:iterator>
				],
				data:[
				<s:iterator value="responseBook[#st.index]">
				<s:property value="sales"/>,
				</s:iterator>
				],
				color: colors[<s:property value="#st.index" />]}
		},</s:iterator>
		]
	</div>
</body>
</html>