<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
					<!-- Page Heading -->
					<h1 class="h3 mb-2 text-gray-800">${kind}</h1>


					<!-- DataTales Example -->
					<div class="card shadow mb-4">
						<div class="card-header py-3">
							<h6 class="m-0 font-weight-bold text-primary">DataTables
								Example</h6>
						</div>
						<div class="card-body">
						<form action="" class="form-inline">
						  <div class="form-group mx-sm-3 mb-2">
							<select class="custom-select mr-sm-2" name="kind" id="inlineFormCustomSelect">
								<option value="k1" ${pager.kind eq 'k1' ? 'selected' : ''}>제목</option>
								<option value="k2" ${pager.kind eq 'k2' ? 'selected' : ''}>내용</option>
								<option value="k3" ${pager.kind eq 'k3' ? 'selected' : ''}>작성자</option>
							  </select>
						    <input type="text" class="form-control" id="search" name="search" value="${pager.search}">
						  </div>
						  <button type="submit" class="btn btn-primary mb-2">검색</button>
						</form>
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="100%"
									cellspacing="0">
									<thead>
										<tr>
											<th style="width: 150px;">#</th>
											<th style="width: 200px;">작성자</th>
											<th>제목</th>
											<th style="width: 400px;">작성일</th>
											<th style="width: 100px;">조회수</th>

										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="l">
											<tr onclick="location.href='detail?boardNum=${l.boardNum}'">
												<td>${l.boardNum}</td>
												<td>${l.userName}</td>
												<td>${l.boardTitle}</td>
												<td>${l.boardDate}</td>
												<td>${l.boardHit}</td>
											</tr>
										</c:forEach>
									</tbody>
								</table>
							</div>
							<div class="form-group mb-2" style="display: flex; justify-content: center;">
								<nav aria-label="Page navigation example">
								  <ul class="pagination">
								    <li class="page-item">
								      <a class="page-link pages" href="./list?page=${pager.start-1}&kind=${pager.kind}&search=${pager.search}" aria-label="Previous">
										<span aria-hidden="true">&laquo;</span>
									  </a>
								    </li>
									<c:forEach begin="${pager.start}" end="${pager.end}" var="i">
										<li class="page-item"><a class="page-link pages" href="./list?page=${i}&kind=${pager.kind}&search=${pager.search}">${i}</a></li>
									</c:forEach>
								    <li class="page-item ${pager.endCheck ? 'disabled' : ''}">
								      <a class="page-link pages" aria-label="Next" href="./list?page=${pager.end+1}&kind=${pager.kind}&search=${pager.search}">
										  <span aria-hidden="true">&raquo;</span>
									  </a>
								    </li>
								  </ul>
								</nav>					
							</div>
							<div style="display: flex; justify-content: end;">
								<a href="add" class="btn btn-primary mb-2">글쓰기</a>
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