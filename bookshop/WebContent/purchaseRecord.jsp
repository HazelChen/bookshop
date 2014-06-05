<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Purchase Records-Book House</title>
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
		<h1>Purchase Records</h1>
	</div>
	
	<%
			String path = request.getContextPath();
			String basePath = request.getScheme() + "://"
					+ request.getServerName() + ":" + request.getServerPort()
					+ path + "/images/book\\";
	%>
	
	<div class="container">
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th width="20%">Book</th>
						<th width="30%"></th>
						<th width="10%">Unit Price</th>
						<th width="10%">Count</th>
						<th width="15%">Total Price</th>
						<th width="15%">State</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="orders" id="order">
					<tr>
						<td colspan="6">
							<span class="label label-info"><s:property value="#order.confirmDate"/></span>
							ID:<s:property value="#order.id"/>
						</td>
					</tr>
					<s:iterator value="buyBooks" status="st" id="buybooks">
					<tr>
						<td width="20%"><img src='<%=basePath%><s:property value="#buybooks.book.id"/>.jpg' height="150" width="150" /></td>
						<td width="30%">
							<h3>
								<s:property value="#buybooks.book.name" />
							</h3>
							Author:<s:property value="#buybooks.book.author" />
							<br /> 
							Press:<s:property value="#buybooks.book.press" />
						</td>
						<td width="10%"><s:property value="#buybooks.singlePrice" /></td>
						<td width="10%"><s:property value="#buybooks.count" /></td>
						<s:if test="%{#st.index==0}">
							<td width="15%" rowspan='<s:property value="buybooks.size()" />'>
								<h3><s:property value="#order.price" /></h3>
							</td>
							<td width="15%" rowspan='<s:property value="buybooks.size()" />'>
								<h3><s:property value="#order.state.state" /></h3>
							</td>
						</s:if>
					</tr>
					</s:iterator>
					</s:iterator>
				</tbody>
			</table>
			</div>
		</div>
</body>
</html>