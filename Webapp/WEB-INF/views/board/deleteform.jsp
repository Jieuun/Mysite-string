<%@ page contentType="text/html;charset=UTF-8" %>
<!doctype html>
<html>
<head>
<title>mysite</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8">
<link href="/Mysite-spring/assets/css/guestbook.css" rel="stylesheet" type="text/css">
</head>
<body>
	<div id="container">
		<div id="header">
			<jsp:include page = "/WEB-INF/views/include/header.jsp" flush="false"/>
		</div>
		<div id="content">
			<div id="guestbook" class="delete-form">
				<form method="post" action="/Mysite-spring/board/delete">
					<input type="hidden" name="no" value="${no}">
					<input type="hidden" name="member_no" value="${authMember.no }">
					<label>정말로 삭제하시겠습니까? </label>
					<input type="submit" value="확인">
				</form>
				<a href="/Mysite-spring/board/index">게시물 리스트</a>
			</div>
		</div>
		<div id="navigation">
			<jsp:include page = "/WEB-INF/views/include/navigation.jsp" flush = "false"/>
		</div>
		<div id="footer">
			<jsp:include page = "/WEB-INF/views/include/footer.jsp" flush = "false"/>
		</div>
	</div>
</body>
</html>