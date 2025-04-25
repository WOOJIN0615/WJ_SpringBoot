<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
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
				<div class="container-fluid" style="display: flex; justify-content: center;">
					<!-- contents -->
					<div class="col-lg-6">
						<div class="p-5">
							<div class="text-center">
								<h1 class="h4 text-gray-900 mb-4">Welcome Back!</h1>
								<h3><spring:message code="${code}"></spring:message>${param.message}</h3>
							</div>
							<form action="" method="post" class="user">
							<input type="hidden" value="${_csrf.token}" name="${_csrf_parameterName}"/>
								<div class="form-group">
									<input type="text" class="form-control form-control-user"
										id="exampleInputEmail" aria-describedby="emailHelp"
										placeholder="ID를 입력하세요." name="username">
								</div>
								<div class="form-group">
									<input type="password" class="form-control form-control-user"
										id="exampleInputPassword" placeholder="Password" name="password">
								</div>
								<div class="form-group">
									<div class="custom-control custom-checkbox small">
										<input type="checkbox" name="remember-me" class="custom-control-input" id="customCheck">
										<label class="custom-control-label" for="customCheck">remember me</label>
									</div>
								</div>
								<button type="submit" class="btn btn-primary btn-user btn-block">
									로그인
								</button>
								<hr>
								<a href="/oauth2/authorization/kakao" class="btn btn-warning btn-user btn-block">
									<i class="fab fa-google fa-fw"></i> 카카오 로그인
								</a>
								<a href="index.html" class="btn btn-facebook btn-user btn-block">
									<i class="fab fa-facebook-f fa-fw"></i> 페이스북 로그인
								</a>
							</form>
							<hr>
							<div class="text-center">
								<a class="small" href="forgot-password.html">비밀번호 찾기</a>
							</div>
							<div class="text-center">
								<a class="small" href="/user/join">회원가입</a>
							</div>
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