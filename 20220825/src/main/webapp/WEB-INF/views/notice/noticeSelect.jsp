<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap CDN -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
</head>
<body>
<!-- model 객체에서 n으로 notice를 받아옴 -->
	<div align="center">
		<h4>상세보기</h4>
		<table border="1" class="table table-hover" style="width: 80%;">
			<tr>
				<th>글번호</th>
				<td>${n.noticeId }</td>
				<th>작성일자</th>
				<td>${n.noticeDate }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td>${n.noticeWriter }</td>
				<th>조회수</th>
				<td>${n.noticeHit }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${n.noticeTitle }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">${n.noticeSubject }</td>
			</tr>
			<tr>
				<th>첨부파일</th>
				<td colspan="3">${n.noticeAttech }</td>
			</tr>
		</table>
		<br>
		<button type="button" id="List">목록</button>
		<input type="button" value="수정">
		<input type="button" value="삭제">
	</div>
	<script>
		List.addEventListener("click", function(){
			location.href="noticeSelectList.do";
		})
	</script>
</body>
</html>