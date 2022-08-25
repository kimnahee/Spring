<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach items="${notices }" var="n">
	<!-- 넘어오는 column 명을 그대로 써줌(DB에서는 column명이 대문자라서) 
		 => List Map으로 받아왔기 때문에(vo로 받지않고)-->
		${n.NOTICE_ID } : ${n.NOTICE_WRITER } : ${n.NOTICE_TITLE }<br>
	</c:forEach>
</body>
</html>