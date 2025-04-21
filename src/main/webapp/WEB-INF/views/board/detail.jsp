<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<c:import url="/WEB-INF/views/templates/header.jsp"></c:import>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/templates/sidebar.jsp"></c:import>
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
			<c:import url="/WEB-INF/views/templates/topbar.jsp"></c:import>
				<div class="container-fluid">
					<!-- contents -->
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
						  <li class="breadcrumb-item"><a href="/">메인화면</a></li>
						  <li class="breadcrumb-item"><a href="./list">목록</a></li>
						  <li class="breadcrumb-item active" aria-current="page">${dto.boardTitle}</li>
						</ol>
					  </nav>
					<div style="display: inline-block;">
						<h1 id="up" data-board-num="${dto.boardNum}">${dto.boardTitle}</h1> 
						<span hidden>${dto.boardNum}</span>
					</div>
					<div style="float: right; padding-right: 30px; padding-top: 30px;">
						<a href="update?boardNum=${dto.boardNum}" class="btn btn-primary mb-2">수정</a>
						<a href="delete?boardNum=${dto.boardNum}" class="btn btn-danger mb-2">삭제</a>
					</div>
					<div style="width: 500px;">
						<ui class="post_info">
							<li>작성자 : ${dto.userName}</li>
							<li>${dto.boardDate}</li>
							<li>조회 : ${dto.boardHit}</li>
						</ui>
					</div>
					<hr/>
					<div>
						<div style="text-align: center;">
							<h3>${dto.boardContents}</h3>
							<c:forEach items="${dto.boardFileVOs}" var="f">
								<img src="/files/${kind}/${f.fileName}">
							</c:forEach>
						</div>
					</div>
				</div>
			</div>
			<!-- End Content -->
			  
			<c:import url="/WEB-INF/views/templates/foot.jsp"></c:import>
		</div>
		<!-- End Content Wrapper -->
			<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
	</div>
	<!-- End Wrapper -->

</body>
</html>