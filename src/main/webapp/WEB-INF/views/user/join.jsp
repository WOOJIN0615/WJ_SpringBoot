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
				<div class="container-fluid" style="display: flex; justify-content: center;">
					<!-- contents -->
                    <div class="col-lg-7">
                        <div class="p-5">
                            <div class="text-center">
                                <h1 class="h4 text-gray-900 mb-4">회원가입</h1>
                            </div>
                            <form action="" method="post" class="user" enctype="multipart/form-data">
                                <div class="form-group">
                                    <input type="file" class="form-control-file" id="exampleFormControlFile1" name="attach">
                                </div>
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="text" class="form-control form-control-user" id="userName" name="userName" placeholder="아이디">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="text" class="form-control form-control-user" id="name" name="name" placeholder="이름">
                                    </div>
                                </div>
                                
                                <div class="form-group row">
                                    <div class="col-sm-6 mb-3 mb-sm-0">
                                        <input type="password" class="form-control form-control-user"
                                            id="password" placeholder="비밀번호" name="password">
                                    </div>
                                    <div class="col-sm-6">
                                        <input type="password" class="form-control form-control-user"
                                            id="exampleRepeatPassword" placeholder="비밀번호 재입력">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="birth"
                                        placeholder="생년월일" name="birth">
                                </div>
                                <div class="form-group">
                                    <input type="text" class="form-control form-control-user" id="phone"
                                        placeholder="휴대전화" name="phone">
                                </div>
                                <div class="form-group">
                                    <input type="email" class="form-control form-control-user" id="email"
                                        placeholder="이메일" name="email">
                                </div>
                                <button type="submit" class="btn btn-primary btn-user btn-block">
                                    회원가입
								</button>
                                <hr>
                                <a href="index.html" class="btn btn-google btn-user btn-block">
                                    <i class="fab fa-google fa-fw"></i> 구글 로그인
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
                                <a class="small" href="login.html">계정이 있으신가요?</a>
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