<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<pre style="word-wrap: break-word; white-space: pre-wrap;">
		<a id = "myTextarea"></a>
		</pre>
	</div>
	<script>
		var myData = ${json};
		var textedJson = JSON.stringify(myData, undefined, 4);
		$('#myTextarea').text(textedJson);
	</script>
</body>
</html>
