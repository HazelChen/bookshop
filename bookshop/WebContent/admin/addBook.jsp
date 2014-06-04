<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Add Book</title>

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
</head>
<body>
	<s:include value="navigater.jsp" />
	
	<div class="container">
		<h1>Add Books</h1>
		<form method="post" action="addBook">
			<div class="row">
				<div class="col-md-6">
					<label class="margin-top">Name:</label>
					<input type="text" class="form-control" name="name" required autofocus>
					<label class="margin-top">ISBN:</label>
        			<input type="text" class="form-control" name="ISBN" required>
        			<label class="margin-top">Author:</label>
        			<input type="text" class="form-control" name="author" required>
					<label class="margin-top">Press:</label>
        			<input type="text" class="form-control" name="press" required>
					<label class="margin-top">Publish Date:</label>
					<input type="text" class="form-control" name="publishDate" required onfocus="HS_setDate(this)">
					<label class="margin-top">Price:</label>
					<input type="text" class="form-control" name="price" required>
				</div>
				
				<div class="col-md-6">
					<label class="margin-top">Category:</label>
					<br />
					<select name="category" class="selectpicker bla bli">
 						<s:iterator value="categories" status="status" id="inner">
    					<option><s:property value="category"/></option>
   						</s:iterator>
  					</select>
					<br />
					
					<label class="margin-top">Count:</label>
        			<input type="text" class="form-control" name="count" required>
        			
					<label class="margin-top">Description:</label>
					<textarea class="form-control" rows="11" cols="30" name="description" id="paragraph"></textarea>
					
					<div class="margin-top right col-md-6">
        				<button class="btn btn-lg btn-success btn-block" type="submit">Add a book</button>
        			</div>
				</div>
			</div>
		</form>
	</div>
</body>
</html>