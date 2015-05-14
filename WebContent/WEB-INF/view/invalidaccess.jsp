<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Access Error</title>
</head>
<body>
	<p>로그인을 하지 않았거나 세션이 종료되어 이 페이지를 사용할 수 없습니다. 다시 로그인한 후 접근하시기 바랍니다. </p> 
	<a href="<c:url value='/index.html'/>">log in</a>
</body>
</html>