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
	<h4>게시글 목록</h4><br>
	<table border="1">
		<thead>
			<tr>
			<th>게시글번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>내용</th>
			<th>작성일자</th>
			<th>조회수</th>
			<th>첨부파일</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${notice }" var="n">
			<tr>
			<td>${n.notice_id }</td>
			<td>${n.notice_writer }</td>
			<td>${n.notice_title }</td>
			<td>${n.notice_subject }</td>
			<td>${n.notice_date }</td>
			<td>${n.notice_hit }</td>
			<td>${n.notice_attech }</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	
	<a href="noticeForm.do">글 등록하기</a>
</body>
</html>