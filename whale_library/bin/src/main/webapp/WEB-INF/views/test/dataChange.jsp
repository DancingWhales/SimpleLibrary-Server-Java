<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="test" tagdir="/WEB-INF/tags/test" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>데이터 테스트</title>
</head>
<body>

<h1>데이터 테스트</h1>
<c:choose>
	<c:when test="${ pageType eq 'INSERT'}">
		<test:insert/>
	</c:when>
	<c:when test="${ pageType eq 'UPDATE'}">
		<test:update/>
	</c:when>
	<c:when test="${ pageType eq 'DELETE'}">
		<test:delete/>
	</c:when>
	<c:otherwise>
		<test:list/>
	</c:otherwise>
</c:choose>
</body>
</html>