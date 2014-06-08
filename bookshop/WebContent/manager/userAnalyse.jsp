<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User Analyse-Book House</title>
<link rel="shortcut icon" href="<s:url value="/favicon.ico" />">
<link href="<s:url value="/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<s:url value="/css/default.css" />" rel="stylesheet">
<link href="<s:url value="/css/homepage.css" />" rel="stylesheet">

<script src=<s:url value="/js/jquery-2.1.0.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/bootstrap.min.js" /> type="text/javascript"></script>
<script src=<s:url value="/js/highcharts.js" />></script>
<script src=<s:url value="/js/userAnalyse.js" />></script>
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<div class="row">
			<div class="col-xs-6">
				<h1>User Analyse</h1>
				<p>Over the past three months the number of new users is 
				<s:property value="userMonthAdds[0].count" />,<s:property value="userMonthAdds[1].count" /> and 
				<s:property value="userMonthAdds[2].count" />. Accourding to the result of linear programming , in the 
				next month, the number of new user is <s:property value="newUserAddCount" />.</p>
				
			</div>
			<div class="col-xs-6">
				<div id="userAdd"></div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-4">
				<div id="userAddress"></div>
			</div>
			<div class="col-xs-4">
				<div id="userAge"></div>
			</div>
			<div class="col-xs-4">
				<div id="userGender"></div>
			</div>
		</div>
	</div>
	
	<div class="hide" id="userAddData">
		[<s:property value="userMonthAdds[0].count" />,
		<s:property value="userMonthAdds[1].count" />, 
		<s:property value="userMonthAdds[2].count" />]
	</div>
	
	<div class="hide" id="userAddressCategory">
		[<s:iterator value="userAddresses">
			'<s:property value="address"/>',
		</s:iterator>]
	</div>
	
	<div class="hide" id="userAddressData">
		[<s:iterator value="userAddresses">
			<s:property value="count"/>,
		</s:iterator>]
	</div>
	
	<div class="hide" id="userAgeData">
	 [<s:iterator value="userAges">
	 ['<s:property value="ageRange"/>', <s:property value="percentage"/>],
	 </s:iterator>]
	</div>
	
	<div class="hide" id="userGenderData">
		[<s:property value="userGenders[0].count"/>,<s:property value="userGenders[1].count"/>]
	</div>
</body>
</html>