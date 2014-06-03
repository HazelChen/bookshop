<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Set Coupons</title>
</head>
<body>
	<s:form theme="simple" role="form" method="post" action="addEqualCouponStandard" >
       <s:textfield name="equalCoupons" cssClass="textfield_input" placeholder="Please Input A New Equal Coupons Value"/>
    </s:form>
    
    <p>existing values:
    <s:iterator value="equalCouponsStandards">
    	<s:property value="equalValue"/>、
    </s:iterator>
    </p>
    
	<s:form theme="simple" role="form" method="post" action="addDiscountCouponStandard" >
       <s:textfield name="discountCoupons" cssClass="textfield_input" placeholder="Please Input A New Discount Coupons Value"/>
    </s:form>
    
    <p>existing values:
    <s:iterator value="discountCouponsStandards">
    	<s:property value="discountValue"/>、
    </s:iterator>
    </p>

</body>
</html>