<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<%String path = request.getContextPath();
		String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/images/user/";
		%>
		
		<a href="#" class="btn btn-primary">
			<img src="<%=basePath %><s:property value="user.username" />.jpg" />
			<span><s:property value="user.username" /></span>
		</a>
		
		<a href='<s:url action="customerLogout"/>' class="btn btn-primary">注销</a>
</body>
</html>