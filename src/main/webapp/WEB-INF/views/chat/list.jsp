<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/templates/header.jsp"></c:import>
<sec:authentication property="principal" var="user"/>
</head>
<body id="page-top">
	<div id="wrapper">
		<c:import url="/WEB-INF/views/templates/sidebar.jsp"></c:import>
	
		<div id="content-wrapper" class="d-flex flex-column">
			<div id="content">
				<c:import url="/WEB-INF/views/templates/topbar.jsp"></c:import>
				<div class="container-fluid">
					
					<h1>Chat List</h1>
							<div class="table-responsive">
								<table class="table table-bordered" id="dataTable" width="10%"
								cellspacing="0">
								<tbody>
									<c:forEach items="${list}" var="l">
										<tr>
											<td>${l.username}</td>
											<td>${l.name}</td>
											<td>	                                
												<c:if test="${not empty l.sns}">
												<img class="img-profile rounded-circle" src="${l.fileName}" style="width: 25px; height: 25px;">
												</c:if>
												<c:if test="${empty l.sns}">
													<img class="img-profile rounded-circle"
														src="/files/user/${l.fileName}"  style="width: 25px; height: 25px;">
												</c:if>
										</td>
										<td>
											<button data-receiver-name="${l.username}" style="width: 25px; height: 25px;" class="receiver-name btn ${l.status?'btn-success':'btn-danger'} btn-circle" data-toggle="modal" data-target="#chat"></button>
										</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
							</div>					
					
			
					
					
				</div>
			</div>
			<!-- End Content -->
			<c:import url="/WEB-INF/views/templates/foot.jsp"></c:import>
		</div>
		<!-- End Content-wrapper -->	
	</div>
	<!-- End wrapper -->

	
	
	<c:import url="/WEB-INF/views/templates/footer.jsp"></c:import>
	<!-- Chat Modal -->

	<div class="modal" tabindex="-1" id="chat" data-sender-name="${user.username}">
	  <div class="modal-dialog">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title">Modal title</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-body">
	        <div id="chat-body">
				
			</div>
		</div>
		<div class="modal-footer">
			<div>
			  <input type="hidden" id="receiver" value=""> <input type="text" id="message"><button id="send">Send</button>
			</div>
	        <!-- <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
	        <button type="button" class="btn btn-primary">Save changes</button> -->
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<script src="/js/chat/chat.js"></script>	
</body>
</html>