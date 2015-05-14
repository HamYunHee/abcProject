<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page session= "true" import ="java.util.*, com.shshop.*" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>

<html>
<head>
<meta charset="utf-8">
<title></title>
<script src="http://code.jquery.com/jquery-1.11.0.min.js"></script>
<link rel="stylesheet" href="css/command.css">

<script>
    $(document).ready(function() {
        $(".user_chang_choice").click(function() {
            $(".user_change").hide();
            $(this).next().show();
        });
        
        $(".closeBtn").click(function() {
            $(this).parent().hide();
        }); 
    });
</script>
</head>
<body>
	<div class="wrap">
		<div class="header_area">
			<!--헤더 인크루트 영역-->
		</div>

		<!---- 개인 정보 영역 ---->
		<div id="mypage_area">
			<div class="mypage_tap">
				<ul>
					<li><a href="#">판매</a></li>
					<li><a href="#">구매</a></li>
					<li><a href="#">개인정보</a></li>
				</ul>
			</div>
			<div id="user_wrap">
				<div class="user_form">
					<table>
						<tr>
							<th>이메일</th>
							<td class="user_table_line">hamclove@gmail.com</td>
							<td></td>
						</tr>
						<tr>
							<th>이름</th>
							<td class="user_table_line">함윤희</td>
							<td><a href="#" class="user_chang_choice">정보수정</a>
								<div id="name_change" class="user_change">
									<div class="closeBtn">
										<a href="#"><img src="image/login_close.png" alt="닫기"></a>
									</div>
									<span>이름 변경 : </span> <input type="text"> <input
										type="button" value="변경">
								</div></td>
						</tr>
						<tr>
							<th>Phone</th>
							<td class="user_table_line">010-22448-1207</td>
							<td><a href="#" class="user_chang_choice">정보수정</a>
								<div id="phone_change" class="user_change">
									<div class="closeBtn">
										<a href="#"><img src="image/login_close.png" alt="닫기"></a>
									</div>
									<span>phone 변경 : </span> <input type="text"> <input
										type="button" value="변경">
								</div></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td class="user_table_line">**********</td>
							<td><a href="#" class="user_chang_choice">정보수정</a>
								<div id="pass_change" class="user_change">
									<div class="closeBtn">
										<a href="#"><img src="image/login_close.png" alt="닫기"></a>
									</div>
									<div class="pass_wrap">
										<span>비밀번호 변경 : </span><input type="password"><br>
										<span>비밀번호 재확인 : </span><input type="password"><br>
									</div>
									<input type="button" value="변경">
								</div></td>
						</tr>
						<tr>
							<th>주소</th>
							<td class="user_table_line">서울 강북구</td>
							<td><a href="#" class="user_chang_choice">정보수정</a>
								<div id="add_change" class="user_change">
									<div class="closeBtn">
										<a href="#"><img src="image/login_close.png" alt="닫기"></a>
									</div>
									<span>주소 변경 : </span> <select name="city" id="">
										<option value="seoul">서울</option>
										<option value="dagu">대구</option>
									</select> <select name="gu" id="">
										<option value="">강서구</option>
										<option value="">강북구</option>
									</select> <input type="text" value="상세주소 입력"> <input
										type="button" value="변경">
								</div></td>
						</tr>
						<tr>
							<th>카톡아이디</th>
							<td class="user_table_line">hamclove</td>
							<td><a href="#" class="user_chang_choice">정보수정</a>
								<div id="ktalk_change" class="user_change">
									<div class="closeBtn">
										<a href="#"><img src="image/login_close.png" alt="닫기"></a>
									</div>
									<span>카톡아이디 변경 : </span> <input type="text"> <input
										type="button" value="변경">
								</div></td>
						</tr>
					</table>

				</div>
			</div>
		</div>

		<div class="footer_area">
			<!--푸터 인크루트 영역-->
		</div>
	</div>
</body>
</html>