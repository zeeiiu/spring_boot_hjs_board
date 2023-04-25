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
			<td>사원번호</td>
			<td>사원이름</td>
			<td>부서</td>
			<td>위치</td>		
		</tr>
		
		<c:forEach var="deptList" items="${empDeptList}">
			<c:forEach var="emp" items="${deptList.empList}">
			<tr>
				<td>${emp.empno}</td>
				<td>${emp.ename}</td>
				<td>${deptList.dname}</td>
				<td>${deptList.loc}</td>
			</tr>
			</c:forEach>
		</c:forEach>
	
	</table>
</body>
</html>