<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload File Request Page</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<script type="text/javascript">
	$(function() {
		$('#file').on('change', function() {
			var filePath = $(this).val();
			$('#filename').attr('value', filePath);
		});
	});
</script>
</head>
<body>
	<div align="right" style="padding-right: 10px;">
		<a href="<c:url value="/logout" />">Logout</a>
	</div>

	<div align="left" style="padding-right: 10px;padding-top: 10px;">
		<form method="POST" action="uploadFile" enctype="multipart/form-data">
		File to upload: <input id="file" type="file" name="file">
 
		<input id="filename" type="hidden" name="name">
 
 
		&nbsp;&nbsp; And then, click <input type="submit" value="Upload"> to upload the file!
	</form>	
	</div>
</body>
</html>