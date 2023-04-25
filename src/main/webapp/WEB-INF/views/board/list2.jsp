<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table width="500" cellpadding="0" cellspacing="0" border="1">
		<tr>
			<td>번호</td>
			<td>이름</td>
			<td>제목</td>
			<td>날짜</td>
			<td>히트</td>
		</tr>
		<c:forEach var="board" items="${boards}">
		<tr>
			<td>${board.bid}</td>
			<td>${board.bname}</td>
			<td>
				<c:forEach begin="1" end="${board.bindent}">-</c:forEach>
				<a href="${pageContext.request.contextPath}/jboard/content_view?bid=${board.bid}">${board.btitle}</a></td>
			<td>${board.bdate}</td>
			<td>${board.bhit}</td>
		</tr>
		</c:forEach>
		<tr>
			<td colspan="5"> <a href="write_view">글작성</a> </td>
		</tr>
	</table>
		
		<c:if test="${pageMaker.prev}">
			<!-- http://localhost:8282/jboard/list2?pageNum=11&amount=10 -->
			<a href="list2${pageMaker.makeQuery(pageMaker.startPage - 1) }">«</a>
		</c:if>

		<c:forEach begin="${pageMaker.startPage }" end="${pageMaker.endPage }" var="idx">
			<c:out value="${pageMaker.cri.pageNum == idx?'':''}" />
			<a href="list2${pageMaker.makeQuery(idx)}">${idx}</a>
		</c:forEach>
		
		<c:if test="${pageMaker.next && pageMaker.endPage > 0}">
			<a href="list2${pageMaker.makeQuery(pageMaker.endPage +1) }"> » </a>
		</c:if> <br>
	
	
	
</body>
</html>