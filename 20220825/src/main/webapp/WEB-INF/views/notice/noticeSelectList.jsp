<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
</style>
</head>
<body>
<div align="center">
	<div>
		<h4>공지사항 목록</h4>
	</div>
	<div>
		<table>
			<tr>
				<td width="70">
					<select id="key" name="key">
						<option value="1">제목</option>
						<option value="2">내용</option>
						<option value="3">작성자</option>
					</select>
				</td>
				<td width="100">
					<input type="text" id="val" name="val">
				</td>
				<td>
					<button type="button" class="btn btn-dark disabled" onclick="searchCall()">검색</button>
				</td>
			</tr>
		</table>
	</div>
	<div>
		<table border="1" id="noticeList" class="table table-hover" style="width: 80%; text-align: center;">
			<thead class="thead-dark">
				<tr>
					<th>글번호</th>
					<th>글제목</th>
					<th>글쓴이</th>
					<th>작성일자</th>
					<th>조회수</th>
				</tr>
			</thead>
			<tbody id="tbody">
				<c:forEach items="${notices }" var="n">
					<tr>
						<td>${n.NOTICE_ID }</td>
						<td class="title">${n.NOTICE_TITLE }</td>
						<td>${n.NOTICE_WRITER }</td>
						<td>${n.NOTICE_DATE }</td>
						<td>${n.NOTICE_HIT }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div>
		<form id="frm" method="post">
			<input type="hidden" id="noticeId" name="noticeId">
		</form>
	</div>
	<!-- Post 방식 : hidden 폼 추가해서 post 방식으로 전송 -->
	<!-- https://amongthestar.tistory.com/178 -->
	<!-- 넘어오는 column 명을 그대로 써줌(DB에서는 column명이 대문자라서) 
		 => List Map으로 받아왔기 때문에(vo로 받지않고)-->
</div>
</body>
<script>
	let List = document.getElementById("noticeList");
	List.addEventListener("click", function(e){
		//let title = e.target.getAttribute("class"); //td 클릭했을 때 class가 title이면 작동
		let noticeId = e.target.parentElement.firstElementChild.innerHTML;//글 작성번호
		//글 작성번호를 보내고 세부정보로 감
		/* if(title == "title"){
			console.log(noticeId);
			location.href="noticeSelect.do?id="+noticeId;
		} */
		noticeCall(noticeId);
		
	})
	
	function noticeCall(id){
		frm.noticeId.value=id;
		frm.action = "noticeSelect.do";
		frm.submit();
	}
	
	function searchCall(){
		//ajax 검색 처리
		let key = document.getElementById("key").value;
		let val = document.getElementById("val").value;
		$("#tbody").remove();
		$.ajax({
			url : "ajaxSearch.do",
			method : "post",
			data : {"key" : key, "val" : val},
		}).then(result => {
			let tbody = $("<tbody>").attr("id", "tbody");
			result.forEach(element => {
				tbody.append(htmlView(element))
				$("#noticeList").append(tbody);
			})
		})
		
		/* fetch("ajaxSearch.do", {
			method : 'post',
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded',
			},	
			body : "key="+key+"&val="+val
		}).then(response => response.json())
		  .then((data)=>console.log(data)) */;
		
		/* JSON형태로 바꿀때는 
		headers : 'application/json', body : JSON.stringify({'key' : key, 'val' : val})*/
	}
	
	function htmlView(data){
		//json => html 변환
		let tr = $("<tr>").append($("<td>").html(data.noticeId))
						  .append($("<td>").html(data.noticeTitle))
						  .append($("<td>").html(data.noticeWriter))
						  .append($("<td>").html(data.noticeDate))
						  .append($("<td>").html(data.noticeHit));
		return tr;
	}

</script>
</html>