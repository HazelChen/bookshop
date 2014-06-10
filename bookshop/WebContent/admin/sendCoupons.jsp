<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
	<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<s:url value="/css/bootstrap-select.css" />" rel="stylesheet">
	<link href="<s:url value="/css/default.css" />" rel="stylesheet">
	
	<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
	<script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
	<script src=<s:url value="/js/bootstrap-select.min.js" /> type="text/javascript"></script>
	<script type="text/javascript">
        $(window).on('load', function () {

            $('.selectpicker').selectpicker();

        });
    </script>
<title>Send Coupons-Book House</title>
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<h1>Send Coupons</h1>
		
		<div class="container">
			<div class="row">
				<table class="table">
					<thead>
						<tr>
							<th width="10%">Username</th>
							<th width="20%">EqualCoupons</th>
							<th width="20%">DiscoutCoupons</th>
							<th width="50%">Send Coupons</th>
						</tr>
					</thead>
					<tbody>
						<s:iterator value="users" status="st">
							<tr>
								<td width="10%"><s:property value="username"/></td>
								<td width="20%">
									<s:iterator value="customerInfo.equalCoupons">
										<s:property value="standard.equalValue" />、
									</s:iterator>
								</td>
								<td width="20%">
									<s:iterator value="customerInfo.discountCoupons">
										<s:property value="standard.discount" />、
									</s:iterator>
								</td>
								<td width="50%">
								
									<form action='sendCoupons'>
									<input type="hidden" value='<s:property value="customerInfo.id"/>' name="customerId">
									<div class="row">
									<div class="col-xs-4">
									<select name="equalCoupons" class="selectpicker">
				    					<option>equal coupons</option>
 										<s:iterator value="equalCouponsStandards" status="status" id="inner">
    										<option>N<s:property value="id"/>-<s:property value="equalValue"/></option>
   										</s:iterator>
   									</select>
   									</div>
   									<div class="col-xs-4">
									<select name="discountCoupons" class="selectpicker">
				    					<option>discount coupons</option>
 										<s:iterator value="discountCouponsStandards" status="status" id="inner">
    										<option>N<s:property value="id"/>-<s:property value="discount"/></option>
   										</s:iterator>
  									</select>
  									</div>
  									<div class="col-xs-2 right">
   										<button class="btn btn-sm btn-success btn-block" type="submit"> Send </button>
   										</div>
  									</div>
  									</form>
  								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
			
		</div>
	</div>
</body>
</html>