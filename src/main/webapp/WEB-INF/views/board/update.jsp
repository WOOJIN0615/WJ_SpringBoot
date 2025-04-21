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
					 <h1>${kind}</h1>
					 <form action="" method="post">
						 <div class="input-group mb-3">
							 <input type="text" class="form-control" placeholder="제목" name="boardTitle" value="${dto.boardTitle}" aria-describedby="basic-addon1">
						 </div>
						 <div class="input-group">
							 <div class="input-group-prepend">
							   <span class="input-group-text">내용</span>
							 </div>
							 <textarea name="boardContents" class="form-control" aria-label="With textarea" rows="10"></textarea>
						   </div>
						   <button type="submit" class="btn btn-primary">작성</button>
					 </form>
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