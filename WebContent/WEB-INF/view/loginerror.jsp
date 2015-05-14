<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Login Error</title>
</head>
<body>
	<p>${username} ID가 없거나 패스워드가 틀렸습니다. 다시 입력하시기 바랍니다.</p> 
	<a href="<c:url value='/index.html'/>">log in</a>
</body>
</html>