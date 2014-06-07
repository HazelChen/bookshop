<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Change Order State-Book House</title>
<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
	<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<s:url value="/css/bootstrap-select.css" />" rel="stylesheet">
	<link href="<s:url value="/css/default.css" />" rel="stylesheet">
	
	<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
	<script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
	<script src=<s:url value="/js/bootstrap-select.min.js" /> type="text/javascript"></script>
	<script type="text/javascript">
	$('#affix').affix({
	    offset: {
	      top: 100
	    , bottom: function () {
	        return (this.bottom = $('.bs-footer').outerHeight(true))
	      }
	    }
	  })
    </script>
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<div id="affix" data-spy="affix" data-offset-top="200">
			<div class="col-xs-3">
				<ul class="nav nav-tabs nav-stacked affix" data-spy="affix">
					<li><a href="#one">Orders Comfired</a></li>
					<li><a href="#two">Orders Distributed</a></li>
					<li><a href="#three">Orders Sended</a></li>
				</ul>
			</div>
			<div class="col-xs-9">
			<h3 id="one">Orders Comfirded</h3>
			<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th width="30%">Book Name</th>
						<th width="20%">ISBN</th>
						<th width="20%">Address</th>
						<th width="15%">Price</th>
						<th width="15%">State</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="confirmedOrder" id="order">
					<tr>
						<td colspan="6" bgcolor="#e2e2e2">
							<div class="bold">
								<s:date format="yyyy-MM-dd" name="#order.confirmDate"/>
									ID:<s:property value="#order.id"/>
							</div>
						</td>
					</tr>
					<s:iterator value="buyBooks" status="st" id="buybooks">
					<tr>
						<td width="30%"><s:property value="#buybooks.book.name" /></td>
						<td width="20%"><s:property value="#buybooks.book.ISBN" /></td>
						<s:if test="%{#st.index==0}">
						<td width="20%"><s:property value="#order.customerInfo.address" /></td>
						<td width="15%" rowspan='<s:property value="buybooks.size()" />'>
							<s:property value="#order.price" />
						</td>
						<td width="15%" rowspan='<s:property value="buybooks.size()" />'>
							<a class="btn btn-lg btn-warning" href='setStateToDistribute?orderId=<s:property value="#order.id"/>'>Distribute</a>
						</td>
						</s:if>
					</tr>
					</s:iterator>
					</s:iterator>
				</tbody>
			</table>
			</div>
			<h3 id="two">Orders Distributed</h3>
			<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th width="30%">Book Name</th>
						<th width="20%">ISBN</th>
						<th width="20%">Address</th>
						<th width="15%">Price</th>
						<th width="15%">State</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="distributedOrder" id="order">
					<tr>
						<td colspan="6" bgcolor="#e2e2e2">
							<div class="bold">
								<s:date format="yyyy-MM-dd" name="#order.confirmDate"/>
									ID:<s:property value="#order.id"/>
							</div>
						</td>
					</tr>
					<s:iterator value="buyBooks" status="st" id="buybooks">
					<tr>
						<td width="30%"><s:property value="#buybooks.book.name" /></td>
						<td width="20%"><s:property value="#buybooks.book.ISBN" /></td>
						<s:if test="%{#st.index==0}">
						<td width="20%"><s:property value="#order.customerInfo.address" /></td>
						<td width="15%" rowspan='<s:property value="buybooks.size()" />'>
							<s:property value="#order.price" />
						</td>
						<td width="15%" rowspan='<s:property value="buybooks.size()" />'>
							<a class="btn btn-lg btn-success" href='setStateToSend?orderId=<s:property value="#order.id"/>'>Send</a>
						</td>
						</s:if>
					</tr>
					</s:iterator>
					</s:iterator>
				</tbody>
			</table>
			</div>
			<h3 id="three">Orders Sended</h3>
			<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th width="30%">Book Name</th>
						<th width="20%">ISBN</th>
						<th width="20%">Address</th>
						<th width="15%">Price</th>
						<th width="15%">State</th>
					</tr>
				</thead>
				<tbody>
					<s:iterator value="sendedOrder" id="order">
					<tr>
						<td colspan="6" bgcolor="#e2e2e2">
							<div class="bold">
								<s:date format="yyyy-MM-dd" name="#order.confirmDate"/>
									ID:<s:property value="#order.id"/>
							</div>
						</td>
					</tr>
					<s:iterator value="buyBooks" status="st" id="buybooks">
					<tr>
						<td width="30%"><s:property value="#buybooks.book.name" /></td>
						<td width="20%"><s:property value="#buybooks.book.ISBN" /></td>
						<s:if test="%{#st.index==0}">
						<td width="20%"><s:property value="#order.customerInfo.address" /></td>
						<td width="15%" rowspan='<s:property value="buybooks.size()" />'>
							<s:property value="#order.price" />
						</td>
						<td width="15%" rowspan='<s:property value="buybooks.size()" />'>Sended</td>
						</s:if>
					</tr>
					</s:iterator>
					</s:iterator>
				</tbody>
			</table>
			</div>
		</div>
	</div>
</body>
</html>