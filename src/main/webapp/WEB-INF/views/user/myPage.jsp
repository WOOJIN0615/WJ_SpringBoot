<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
					<div class="page-content">
						<!-- Page title -->
						<div class="page-title">
						  <div class="row justify-content-between align-items-center">
							<div class="col-md-6 d-flex align-items-center justify-content-between justify-content-md-start mb-3 mb-md-0">
							  <!-- Page title + Go Back button -->
							  <div class="d-inline-block">
								<h5 class="h4 d-inline-block font-weight-400 mb-0 text-blue">My profile</h5>
							  </div><hr>
							  <!-- Additional info -->
							</div>
							<div class="col-md-6 d-flex align-items-center justify-content-between justify-content-md-end">
								<div class="actions actions-dark d-inline-block">
								</div>
							</div>
						</div>
						</div>
						<div class="row">
						  <div class="col-lg-4">
							  <!-- Profile stats -->
							  <sec:authentication property="principal" var="user"/>
							<div class="card card-fluid">
							  <div class="card-header">
								<div class="row align-items-center">
								  <div class="col-auto">
									<!-- Avatar -->
									<a href="#" class="avatar rounded-circle">
										<img class="img-profile rounded-circle"
										src="/files/user/${user.fileName}" style="width: 50px; height: 50px;">
									</a>
								  </div>
								  <div class="col ml-md-n2">
									<a href="#!" class="d-block h6 mb-0">${user.name}</a>
									<small class="d-block text-muted">Laravel Developer</small>
								  </div>
								  <div class="col-auto">
									<a type="button" href="/user/update" class="btn btn-xs btn-primary btn-icon rounded-pill">
									  <span class="btn-inner--icon"><i class="far fa-edit"></i></span>
									  <span class="btn-inner--text">Edit</span>
									</a>
								  </div>
								</div>
							  </div>
							  <div class="card-body">
								<div class="row">
								  <div class="col-4 text-center">
									<span class="h5 mb-0">86</span>
									<span class="d-block text-sm">Images</span>
								  </div>
								  <div class="col-4 text-center">
									<span class="h5 mb-0">8</span>
									<span class="d-block text-sm">Products</span>
								  </div>
								  <div class="col-4 text-center">
									<span class="h5 mb-0">1578</span>
									<span class="d-block text-sm">Followers</span>
								  </div>
								</div>
							  </div>
							  <div class="card-footer">
								<div class="row align-items-center">
								  <div class="col-6">
									<button type="button" class="btn btn-sm px-0 font-weight-bold btn-link text-primary btn-icon">
									  Message
									</button>
								  </div>
								  <div class="col-6 text-right">
									<button type="button" class="btn btn-xs btn-secondary rounded-pill">Follow</button>
								  </div>
								</div>
							  </div>
							</div>
						  </div>
						  <div class="col-lg-4">
							<!-- Profile contacts -->
							<div class="card card-fluid">
							  <div class="card-body">
								<div class="row align-items-center">
									<div class="col">
									  <h6 class="text-sm mb-0">
										<i class="fab fa-linkedin mr-2"></i>userID
									  </h6>
									</div>
									<div class="col-auto">
									  <span class="text-sm">
									  	<sec:authentication property="name"/>
									  </span>
									</div>
								  </div>
								  <hr class="my-3">
								<div class="row align-items-center">
								  <div class="col">
									<h6 class="text-sm mb-0">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-envelope" viewBox="0 0 16 16">
											<path d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1zm13 2.383-4.708 2.825L15 11.105zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741M1 11.105l4.708-2.897L1 5.383z"/>
										  </svg> Email
									</h6>
								  </div>

								  <div class="col-auto">
									<span class="text-sm">
										${user.email}
									</span>
								  </div>
								</div>
								<hr class="my-3">
								<div class="row align-items-center">
								  <div class="col">
									<h6 class="text-sm mb-0">
									  <i class="fab fa-whatsapp mr-2"></i>Phone
									</h6>
								  </div>
								  <div class="col-auto">
									<span class="text-sm">${user.phone}</span>
								  </div>
								</div>
								<hr class="my-3">
								<div class="row align-items-center">
								  <div class="col">
									<h6 class="text-sm mb-0">
										<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cake2" viewBox="0 0 16 16">
											<path d="m3.494.013-.595.79A.747.747 0 0 0 3 1.814v2.683q-.224.051-.432.107c-.702.187-1.305.418-1.745.696C.408 5.56 0 5.954 0 6.5v7c0 .546.408.94.823 1.201.44.278 1.043.51 1.745.696C3.978 15.773 5.898 16 8 16s4.022-.227 5.432-.603c.701-.187 1.305-.418 1.745-.696.415-.261.823-.655.823-1.201v-7c0-.546-.408-.94-.823-1.201-.44-.278-1.043-.51-1.745-.696A12 12 0 0 0 13 4.496v-2.69a.747.747 0 0 0 .092-1.004l-.598-.79-.595.792A.747.747 0 0 0 12 1.813V4.3a22 22 0 0 0-2-.23V1.806a.747.747 0 0 0 .092-1.004l-.598-.79-.595.792A.747.747 0 0 0 9 1.813v2.204a29 29 0 0 0-2 0V1.806A.747.747 0 0 0 7.092.802l-.598-.79-.595.792A.747.747 0 0 0 6 1.813V4.07c-.71.05-1.383.129-2 .23V1.806A.747.747 0 0 0 4.092.802zm-.668 5.556L3 5.524v.967q.468.111 1 .201V5.315a21 21 0 0 1 2-.242v1.855q.488.036 1 .054V5.018a28 28 0 0 1 2 0v1.964q.512-.018 1-.054V5.073c.72.054 1.393.137 2 .242v1.377q.532-.09 1-.201v-.967l.175.045c.655.175 1.15.374 1.469.575.344.217.356.35.356.356s-.012.139-.356.356c-.319.2-.814.4-1.47.575C11.87 7.78 10.041 8 8 8c-2.04 0-3.87-.221-5.174-.569-.656-.175-1.151-.374-1.47-.575C1.012 6.639 1 6.506 1 6.5s.012-.139.356-.356c.319-.2.814-.4 1.47-.575M15 7.806v1.027l-.68.907a.94.94 0 0 1-1.17.276 1.94 1.94 0 0 0-2.236.363l-.348.348a1 1 0 0 1-1.307.092l-.06-.044a2 2 0 0 0-2.399 0l-.06.044a1 1 0 0 1-1.306-.092l-.35-.35a1.935 1.935 0 0 0-2.233-.362.935.935 0 0 1-1.168-.277L1 8.82V7.806c.42.232.956.428 1.568.591C3.978 8.773 5.898 9 8 9s4.022-.227 5.432-.603c.612-.163 1.149-.36 1.568-.591m0 2.679V13.5c0 .006-.012.139-.356.355-.319.202-.814.401-1.47.576C11.87 14.78 10.041 15 8 15c-2.04 0-3.87-.221-5.174-.569-.656-.175-1.151-.374-1.47-.575-.344-.217-.356-.35-.356-.356v-3.02a1.935 1.935 0 0 0 2.298.43.935.935 0 0 1 1.08.175l.348.349a2 2 0 0 0 2.615.185l.059-.044a1 1 0 0 1 1.2 0l.06.044a2 2 0 0 0 2.613-.185l.348-.348a.94.94 0 0 1 1.082-.175c.781.39 1.718.208 2.297-.426"/>
										  </svg> Birth
									</h6>
								  </div>
								  <div class="col-auto">
									<span class="text-sm">${user.birth}</span>
								  </div>
								</div>
							  </div>
							</div>
						  </div>
						  <div class="col-lg-4">
							<!-- Profile performance -->
							<div class="card card-fluid">
							  <div class="card-body">
								<div class="row align-items-center">
								  <div class="col">
									<h6 class="text-sm mb-0">Performance</h6>
									<span class="text-nowrap h6 text-muted text-sm">65%</span>
									<span class="badge badge-xs badge-soft-warning ml-2"><i class="far fa-arrow-down"></i> 13%</span>
								  </div>
								  <div class="col-4">
									<div style="max-width: 100px; position: relative;">
									  <div class="spark-chart" data-toggle="spark-chart" data-type="line" data-height="30" data-color="warning" data-dataset="[47, 94, 24, 18, 26, 65, 31, 47, 10, 44, 45]" style="min-height: 30px;"><div id="apexcharts116nbnak" class="apexcharts-canvas apexcharts116nbnak light" style="width: 79px; height: 30px;"><svg id="SvgjsSvg1176" width="79" height="30" xmlns="http://www.w3.org/2000/svg" version="1.1" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:svgjs="http://svgjs.com/svgjs" class="apexcharts-svg" xmlns:data="ApexChartsNS" transform="translate(0, 0)" style="background: transparent;"><g id="SvgjsG1178" class="apexcharts-inner apexcharts-graphical" transform="translate(0, 0)"><defs id="SvgjsDefs1177"><clipPath id="gridRectMask116nbnak"><rect id="SvgjsRect1183" width="81" height="32" x="-1" y="-1" rx="0" ry="0" fill="#ffffff" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0"></rect></clipPath><clipPath id="gridRectMarkerMask116nbnak"><rect id="SvgjsRect1184" width="119" height="70" x="-20" y="-20" rx="0" ry="0" fill="#ffffff" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0"></rect></clipPath></defs><line id="SvgjsLine1182" x1="0" y1="0" x2="0" y2="30" stroke="#b6b6b6" stroke-dasharray="3" class="apexcharts-xcrosshairs" x="0" y="0" width="1" height="30" fill="#b1b9c4" filter="none" fill-opacity="0.9" stroke-width="1"></line><g id="SvgjsG1191" class="apexcharts-xaxis" transform="translate(0, 0)"><g id="SvgjsG1192" class="apexcharts-xaxis-texts-g" transform="translate(0, 1.875)"></g></g><g id="SvgjsG1195" class="apexcharts-grid"><line id="SvgjsLine1197" x1="0" y1="30" x2="79" y2="30" stroke="transparent" stroke-dasharray="0"></line><line id="SvgjsLine1196" x1="0" y1="1" x2="0" y2="30" stroke="transparent" stroke-dasharray="0"></line></g><g id="SvgjsG1186" class="apexcharts-line-series apexcharts-plot-series"><g id="SvgjsG1187" class="apexcharts-series seriesx1" data:longestSeries="true" rel="1" data:realIndex="0"><path id="apexcharts-line-0" d="M 0 15.9C 2.7649999999999997 15.9 5.135 1.8000000000000007 7.8999999999999995 1.8000000000000007C 10.665 1.8000000000000007 13.035 22.8 15.799999999999999 22.8C 18.564999999999998 22.8 20.935 24.6 23.7 24.6C 26.465 24.6 28.834999999999997 22.2 31.599999999999998 22.2C 34.364999999999995 22.2 36.735 10.5 39.5 10.5C 42.265 10.5 44.635 20.700000000000003 47.4 20.700000000000003C 50.165 20.700000000000003 52.535 15.9 55.3 15.9C 58.065 15.9 60.434999999999995 27 63.199999999999996 27C 65.96499999999999 27 68.335 16.8 71.1 16.8C 73.865 16.8 76.235 16.5 79 16.5" fill="none" fill-opacity="1" stroke="rgba(255,171,0,0.85)" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-line" index="0" clip-path="url(#gridRectMask116nbnak)" pathTo="M 0 15.9C 2.7649999999999997 15.9 5.135 1.8000000000000007 7.8999999999999995 1.8000000000000007C 10.665 1.8000000000000007 13.035 22.8 15.799999999999999 22.8C 18.564999999999998 22.8 20.935 24.6 23.7 24.6C 26.465 24.6 28.834999999999997 22.2 31.599999999999998 22.2C 34.364999999999995 22.2 36.735 10.5 39.5 10.5C 42.265 10.5 44.635 20.700000000000003 47.4 20.700000000000003C 50.165 20.700000000000003 52.535 15.9 55.3 15.9C 58.065 15.9 60.434999999999995 27 63.199999999999996 27C 65.96499999999999 27 68.335 16.8 71.1 16.8C 73.865 16.8 76.235 16.5 79 16.5" pathFrom="M -1 30L -1 30L 7.8999999999999995 30L 15.799999999999999 30L 23.7 30L 31.599999999999998 30L 39.5 30L 47.4 30L 55.3 30L 63.199999999999996 30L 71.1 30L 79 30"></path><g id="SvgjsG1188" class="apexcharts-series-markers-wrap"><g class="apexcharts-series-markers"><circle id="SvgjsCircle1203" r="0" cx="0" cy="0" class="apexcharts-marker w10aplabl no-pointer-events" stroke="#ffffff" fill="#ffab00" fill-opacity="1" stroke-width="2" stroke-opacity="0.9" default-marker-size="0"></circle></g></g><g id="SvgjsG1189" class="apexcharts-datalabels"></g></g></g><line id="SvgjsLine1198" x1="0" y1="0" x2="79" y2="0" stroke="#b6b6b6" stroke-dasharray="0" stroke-width="1" class="apexcharts-ycrosshairs"></line><line id="SvgjsLine1199" x1="0" y1="0" x2="79" y2="0" stroke-dasharray="0" stroke-width="0" class="apexcharts-ycrosshairs-hidden"></line><g id="SvgjsG1200" class="apexcharts-yaxis-annotations"></g><g id="SvgjsG1201" class="apexcharts-xaxis-annotations"></g><g id="SvgjsG1202" class="apexcharts-point-annotations"></g></g><rect id="SvgjsRect1181" width="0" height="0" x="0" y="0" rx="0" ry="0" fill="#fefefe" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0"></rect><g id="SvgjsG1193" class="apexcharts-yaxis" rel="0" transform="translate(-21, 0)"><g id="SvgjsG1194" class="apexcharts-yaxis-texts-g"></g></g></svg><div class="apexcharts-legend"></div><div class="apexcharts-tooltip light"><div class="apexcharts-tooltip-series-group"><span class="apexcharts-tooltip-marker" style="background-color: rgb(255, 171, 0);"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-label"></span><span class="apexcharts-tooltip-text-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div></div></div></div>
									<div class="resize-triggers"><div class="expand-trigger"><div style="width: 80px; height: 31px;"></div></div><div class="contract-trigger"></div></div></div>
								  </div>
								</div>
								<hr class="my-3">
								<div class="row align-items-center">
								  <div class="col">
									<h6 class="text-sm mb-0">Sales</h6>
									<span class="text-nowrap h6 text-muted text-sm">$3.068,90</span>
									<span class="badge badge-xs badge-soft-success ml-2"><i class="far fa-arrow-up"></i> 25%</span>
								  </div>
								  <div class="col-4">
									<div style="max-width: 100px; position: relative;">
									  <div class="spark-chart" data-toggle="spark-chart" data-type="line" data-height="30" data-color="success" data-dataset="[47, 94, 24, 18, 26, 65, 31, 47, 10, 44, 45]" style="min-height: 30px;"><div id="apexcharts1oxv5cbn" class="apexcharts-canvas apexcharts1oxv5cbn light" style="width: 79px; height: 30px;"><svg id="SvgjsSvg1207" width="79" height="30" xmlns="http://www.w3.org/2000/svg" version="1.1" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:svgjs="http://svgjs.com/svgjs" class="apexcharts-svg" xmlns:data="ApexChartsNS" transform="translate(0, 0)" style="background: transparent;"><g id="SvgjsG1209" class="apexcharts-inner apexcharts-graphical" transform="translate(0, 0)"><defs id="SvgjsDefs1208"><clipPath id="gridRectMask1oxv5cbn"><rect id="SvgjsRect1214" width="81" height="32" x="-1" y="-1" rx="0" ry="0" fill="#ffffff" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0"></rect></clipPath><clipPath id="gridRectMarkerMask1oxv5cbn"><rect id="SvgjsRect1215" width="119" height="70" x="-20" y="-20" rx="0" ry="0" fill="#ffffff" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0"></rect></clipPath></defs><line id="SvgjsLine1213" x1="0" y1="0" x2="0" y2="30" stroke="#b6b6b6" stroke-dasharray="3" class="apexcharts-xcrosshairs" x="0" y="0" width="1" height="30" fill="#b1b9c4" filter="none" fill-opacity="0.9" stroke-width="1"></line><g id="SvgjsG1222" class="apexcharts-xaxis" transform="translate(0, 0)"><g id="SvgjsG1223" class="apexcharts-xaxis-texts-g" transform="translate(0, 1.875)"></g></g><g id="SvgjsG1226" class="apexcharts-grid"><line id="SvgjsLine1228" x1="0" y1="30" x2="79" y2="30" stroke="transparent" stroke-dasharray="0"></line><line id="SvgjsLine1227" x1="0" y1="1" x2="0" y2="30" stroke="transparent" stroke-dasharray="0"></line></g><g id="SvgjsG1217" class="apexcharts-line-series apexcharts-plot-series"><g id="SvgjsG1218" class="apexcharts-series seriesx1" data:longestSeries="true" rel="1" data:realIndex="0"><path id="apexcharts-line-0" d="M 0 15.9C 2.7649999999999997 15.9 5.135 1.8000000000000007 7.8999999999999995 1.8000000000000007C 10.665 1.8000000000000007 13.035 22.8 15.799999999999999 22.8C 18.564999999999998 22.8 20.935 24.6 23.7 24.6C 26.465 24.6 28.834999999999997 22.2 31.599999999999998 22.2C 34.364999999999995 22.2 36.735 10.5 39.5 10.5C 42.265 10.5 44.635 20.700000000000003 47.4 20.700000000000003C 50.165 20.700000000000003 52.535 15.9 55.3 15.9C 58.065 15.9 60.434999999999995 27 63.199999999999996 27C 65.96499999999999 27 68.335 16.8 71.1 16.8C 73.865 16.8 76.235 16.5 79 16.5" fill="none" fill-opacity="1" stroke="rgba(54,179,126,0.85)" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-line" index="0" clip-path="url(#gridRectMask1oxv5cbn)" pathTo="M 0 15.9C 2.7649999999999997 15.9 5.135 1.8000000000000007 7.8999999999999995 1.8000000000000007C 10.665 1.8000000000000007 13.035 22.8 15.799999999999999 22.8C 18.564999999999998 22.8 20.935 24.6 23.7 24.6C 26.465 24.6 28.834999999999997 22.2 31.599999999999998 22.2C 34.364999999999995 22.2 36.735 10.5 39.5 10.5C 42.265 10.5 44.635 20.700000000000003 47.4 20.700000000000003C 50.165 20.700000000000003 52.535 15.9 55.3 15.9C 58.065 15.9 60.434999999999995 27 63.199999999999996 27C 65.96499999999999 27 68.335 16.8 71.1 16.8C 73.865 16.8 76.235 16.5 79 16.5" pathFrom="M -1 30L -1 30L 7.8999999999999995 30L 15.799999999999999 30L 23.7 30L 31.599999999999998 30L 39.5 30L 47.4 30L 55.3 30L 63.199999999999996 30L 71.1 30L 79 30"></path><g id="SvgjsG1219" class="apexcharts-series-markers-wrap"><g class="apexcharts-series-markers"><circle id="SvgjsCircle1234" r="0" cx="0" cy="0" class="apexcharts-marker wiis5iv7z no-pointer-events" stroke="#ffffff" fill="#36b37e" fill-opacity="1" stroke-width="2" stroke-opacity="0.9" default-marker-size="0"></circle></g></g><g id="SvgjsG1220" class="apexcharts-datalabels"></g></g></g><line id="SvgjsLine1229" x1="0" y1="0" x2="79" y2="0" stroke="#b6b6b6" stroke-dasharray="0" stroke-width="1" class="apexcharts-ycrosshairs"></line><line id="SvgjsLine1230" x1="0" y1="0" x2="79" y2="0" stroke-dasharray="0" stroke-width="0" class="apexcharts-ycrosshairs-hidden"></line><g id="SvgjsG1231" class="apexcharts-yaxis-annotations"></g><g id="SvgjsG1232" class="apexcharts-xaxis-annotations"></g><g id="SvgjsG1233" class="apexcharts-point-annotations"></g></g><rect id="SvgjsRect1212" width="0" height="0" x="0" y="0" rx="0" ry="0" fill="#fefefe" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0"></rect><g id="SvgjsG1224" class="apexcharts-yaxis" rel="0" transform="translate(-21, 0)"><g id="SvgjsG1225" class="apexcharts-yaxis-texts-g"></g></g></svg><div class="apexcharts-legend"></div><div class="apexcharts-tooltip light"><div class="apexcharts-tooltip-series-group"><span class="apexcharts-tooltip-marker" style="background-color: rgb(54, 179, 126);"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-label"></span><span class="apexcharts-tooltip-text-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div></div></div></div>
									<div class="resize-triggers"><div class="expand-trigger"><div style="width: 80px; height: 31px;"></div></div><div class="contract-trigger"></div></div></div>
								  </div>
								</div>
								<hr class="my-3">
								<div class="row align-items-center">
								  <div class="col">
									<h6 class="text-sm mb-0">Followers</h6>
									<span class="text-nowrap h6 text-muted text-sm">80</span>
									<span class="badge badge-xs badge-soft-info ml-2"><i class="far fa-arrow-up"></i> 17%</span>
								  </div>
								  <div class="col-4">
									<div style="max-width: 100px; position: relative;">
									  <div class="spark-chart" data-toggle="spark-chart" data-type="bar" data-height="30" data-color="primary" data-dataset="[47, 94, 24, 18, 26, 65, 31, 47, 10, 44, 45]" style="min-height: 30px;"><div id="apexchartsc3scdsxm" class="apexcharts-canvas apexchartsc3scdsxm light" style="width: 79px; height: 30px;"><svg id="SvgjsSvg1237" width="79" height="30" xmlns="http://www.w3.org/2000/svg" version="1.1" xmlns:xlink="http://www.w3.org/1999/xlink" xmlns:svgjs="http://svgjs.com/svgjs" class="apexcharts-svg" xmlns:data="ApexChartsNS" transform="translate(0, 0)" style="background: transparent;"><g id="SvgjsG1239" class="apexcharts-inner apexcharts-graphical" transform="translate(0, 0)"><defs id="SvgjsDefs1238"><linearGradient id="SvgjsLinearGradient1241" x1="0" y1="0" x2="0" y2="1"><stop id="SvgjsStop1242" stop-opacity="0.4" stop-color="rgba(216,227,240,0.4)" offset="0"></stop><stop id="SvgjsStop1243" stop-opacity="0.5" stop-color="rgba(190,209,230,0.5)" offset="1"></stop><stop id="SvgjsStop1244" stop-opacity="0.5" stop-color="rgba(190,209,230,0.5)" offset="1"></stop></linearGradient><clipPath id="gridRectMaskc3scdsxm"><rect id="SvgjsRect1246" width="81" height="32" x="-1" y="-1" rx="0" ry="0" fill="#ffffff" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0"></rect></clipPath><clipPath id="gridRectMarkerMaskc3scdsxm"><rect id="SvgjsRect1247" width="119" height="70" x="-20" y="-20" rx="0" ry="0" fill="#ffffff" opacity="1" stroke-width="0" stroke="none" stroke-dasharray="0"></rect></clipPath></defs><rect id="SvgjsRect1245" width="5.53" height="30" x="0" y="0" rx="0" ry="0" fill="url(#SvgjsLinearGradient1241)" opacity="1" stroke-width="0" stroke-dasharray="3" class="apexcharts-xcrosshairs" y2="30" filter="none" fill-opacity="0.9"></rect><g id="SvgjsG1263" class="apexcharts-xaxis" transform="translate(0, 0)"><g id="SvgjsG1264" class="apexcharts-xaxis-texts-g" transform="translate(0, -4)"></g></g><g id="SvgjsG1267" class="apexcharts-grid"><line id="SvgjsLine1269" x1="0" y1="30" x2="79" y2="30" stroke="transparent" stroke-dasharray="0"></line><line id="SvgjsLine1268" x1="0" y1="1" x2="0" y2="30" stroke="transparent" stroke-dasharray="0"></line></g><g id="SvgjsG1249" class="apexcharts-bar-series apexcharts-plot-series"><g id="SvgjsG1250" class="apexcharts-series seriesx1" rel="1" data:realIndex="0"><path id="apexcharts-bar-area-0" d="M -2.765 30L -2.765 15.9L 0.7650000000000001 15.9L 0.7650000000000001 30L -3.765 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M -2.765 30L -2.765 15.9L 0.7650000000000001 15.9L 0.7650000000000001 30L -3.765 30" pathFrom="M -2.765 30L -2.765 30L 0.7650000000000001 30L 0.7650000000000001 30L -3.765 30" cy="15.9" cx="-0.23499999999999988" j="0" val="47" barHeight="14.1" barWidth="5.53"></path><path id="apexcharts-bar-area-0" d="M 5.135 30L 5.135 1.8000000000000007L 8.665 1.8000000000000007L 8.665 30L 4.135 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M 5.135 30L 5.135 1.8000000000000007L 8.665 1.8000000000000007L 8.665 30L 4.135 30" pathFrom="M 5.135 30L 5.135 30L 8.665 30L 8.665 30L 4.135 30" cy="1.8000000000000007" cx="7.664999999999999" j="1" val="94" barHeight="28.2" barWidth="5.53"></path><path id="apexcharts-bar-area-0" d="M 13.034999999999998 30L 13.034999999999998 22.8L 16.564999999999998 22.8L 16.564999999999998 30L 12.034999999999998 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M 13.034999999999998 30L 13.034999999999998 22.8L 16.564999999999998 22.8L 16.564999999999998 30L 12.034999999999998 30" pathFrom="M 13.034999999999998 30L 13.034999999999998 30L 16.564999999999998 30L 16.564999999999998 30L 12.034999999999998 30" cy="22.8" cx="15.564999999999998" j="2" val="24" barHeight="7.199999999999999" barWidth="5.53"></path><path id="apexcharts-bar-area-0" d="M 20.935 30L 20.935 24.6L 24.465 24.6L 24.465 30L 19.935 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M 20.935 30L 20.935 24.6L 24.465 24.6L 24.465 30L 19.935 30" pathFrom="M 20.935 30L 20.935 30L 24.465 30L 24.465 30L 19.935 30" cy="24.6" cx="23.465" j="3" val="18" barHeight="5.3999999999999995" barWidth="5.53"></path><path id="apexcharts-bar-area-0" d="M 28.834999999999997 30L 28.834999999999997 22.2L 32.364999999999995 22.2L 32.364999999999995 30L 27.834999999999997 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M 28.834999999999997 30L 28.834999999999997 22.2L 32.364999999999995 22.2L 32.364999999999995 30L 27.834999999999997 30" pathFrom="M 28.834999999999997 30L 28.834999999999997 30L 32.364999999999995 30L 32.364999999999995 30L 27.834999999999997 30" cy="22.2" cx="31.364999999999995" j="4" val="26" barHeight="7.8" barWidth="5.53"></path><path id="apexcharts-bar-area-0" d="M 36.735 30L 36.735 10.5L 40.265 10.5L 40.265 30L 35.735 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M 36.735 30L 36.735 10.5L 40.265 10.5L 40.265 30L 35.735 30" pathFrom="M 36.735 30L 36.735 30L 40.265 30L 40.265 30L 35.735 30" cy="10.5" cx="39.265" j="5" val="65" barHeight="19.5" barWidth="5.53"></path><path id="apexcharts-bar-area-0" d="M 44.635 30L 44.635 20.700000000000003L 48.165 20.700000000000003L 48.165 30L 43.635 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M 44.635 30L 44.635 20.700000000000003L 48.165 20.700000000000003L 48.165 30L 43.635 30" pathFrom="M 44.635 30L 44.635 30L 48.165 30L 48.165 30L 43.635 30" cy="20.700000000000003" cx="47.165" j="6" val="31" barHeight="9.299999999999999" barWidth="5.53"></path><path id="apexcharts-bar-area-0" d="M 52.535 30L 52.535 15.9L 56.065 15.9L 56.065 30L 51.535 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M 52.535 30L 52.535 15.9L 56.065 15.9L 56.065 30L 51.535 30" pathFrom="M 52.535 30L 52.535 30L 56.065 30L 56.065 30L 51.535 30" cy="15.9" cx="55.065" j="7" val="47" barHeight="14.1" barWidth="5.53"></path><path id="apexcharts-bar-area-0" d="M 60.434999999999995 30L 60.434999999999995 27L 63.96499999999999 27L 63.96499999999999 30L 59.434999999999995 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M 60.434999999999995 30L 60.434999999999995 27L 63.96499999999999 27L 63.96499999999999 30L 59.434999999999995 30" pathFrom="M 60.434999999999995 30L 60.434999999999995 30L 63.96499999999999 30L 63.96499999999999 30L 59.434999999999995 30" cy="27" cx="62.96499999999999" j="8" val="10" barHeight="3" barWidth="5.53"></path><path id="apexcharts-bar-area-0" d="M 68.335 30L 68.335 16.8L 71.865 16.8L 71.865 30L 67.335 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M 68.335 30L 68.335 16.8L 71.865 16.8L 71.865 30L 67.335 30" pathFrom="M 68.335 30L 68.335 30L 71.865 30L 71.865 30L 67.335 30" cy="16.8" cx="70.865" j="9" val="44" barHeight="13.2" barWidth="5.53"></path><path id="apexcharts-bar-area-0" d="M 76.235 30L 76.235 16.5L 79.765 16.5L 79.765 30L 75.235 30" fill="rgba(110,0,255,0.85)" fill-opacity="1" stroke="#6e00ff" stroke-opacity="1" stroke-linecap="butt" stroke-width="2" stroke-dasharray="0" class="apexcharts-bar-area" index="0" clip-path="url(#gridRectMaskc3scdsxm)" pathTo="M 76.235 30L 76.235 16.5L 79.765 16.5L 79.765 30L 75.235 30" pathFrom="M 76.235 30L 76.235 30L 79.765 30L 79.765 30L 75.235 30" cy="16.5" cx="78.765" j="10" val="45" barHeight="13.5" barWidth="5.53"></path><g id="SvgjsG1251" class="apexcharts-datalabels"></g></g></g><line id="SvgjsLine1270" x1="0" y1="0" x2="79" y2="0" stroke="#b6b6b6" stroke-dasharray="0" stroke-width="1" class="apexcharts-ycrosshairs"></line><line id="SvgjsLine1271" x1="0" y1="0" x2="79" y2="0" stroke-dasharray="0" stroke-width="0" class="apexcharts-ycrosshairs-hidden"></line><g id="SvgjsG1272" class="apexcharts-yaxis-annotations"></g><g id="SvgjsG1273" class="apexcharts-xaxis-annotations"></g><g id="SvgjsG1274" class="apexcharts-point-annotations"></g></g><g id="SvgjsG1265" class="apexcharts-yaxis" rel="0" transform="translate(-21, 0)"><g id="SvgjsG1266" class="apexcharts-yaxis-texts-g"></g></g></svg><div class="apexcharts-legend"></div><div class="apexcharts-tooltip light"><div class="apexcharts-tooltip-series-group"><span class="apexcharts-tooltip-marker" style="background-color: rgb(110, 0, 255);"></span><div class="apexcharts-tooltip-text" style="font-family: Helvetica, Arial, sans-serif; font-size: 12px;"><div class="apexcharts-tooltip-y-group"><span class="apexcharts-tooltip-text-label"></span><span class="apexcharts-tooltip-text-value"></span></div><div class="apexcharts-tooltip-z-group"><span class="apexcharts-tooltip-text-z-label"></span><span class="apexcharts-tooltip-text-z-value"></span></div></div></div></div></div></div>
									<div class="resize-triggers"><div class="expand-trigger"><div style="width: 80px; height: 31px;"></div></div><div class="contract-trigger"></div></div></div>
								  </div>
								</div>
							  </div>
							</div>
						  </div>
						</div>
						<div class="row">
						  <div class="col-xl-8 col-md-6">
							<div class="card card-fluid">
							  <div class="card-header border-0">
								<h6 class="mb-0">내가 쓴 글</h6>
							  </div>
							  <div class="table-responsive">
								<table class="table align-items-center">
								  <thead>
									<tr>
									  <th scope="col" class="sort" data-sort="name">Project</th>
									  <th scope="col" class="sort" data-sort="budget">Tasks</th>
									  <th scope="col" class="sort" data-sort="status">Status</th>
									  <th scope="col" class="sort" data-sort="completion">Completion</th>
									</tr>
								  </thead>
								  <tbody class="list">
									<tr>
									  <th scope="row">
										<div class="media align-items-center">
										  <div>
											<img alt="Image placeholder" src="../../assets/img/theme/light/brand-avatar-1.png" class="avatar  rounded-circle avatar-sm">
										  </div>
										  <div class="media-body ml-4">
											<a href="overview.html" class="name mb-0 h6 text-sm">Purpose Website UI</a>
										  </div>
										</div>
									  </th>
									  <td class="budget">
										1
									  </td>
									  <td>
										<span class="badge badge-dot mr-4">
										  <i class="bg-warning"></i>
										  <span class="status">pending</span>
										</span>
									  </td>
									  <td>
										<div class="d-flex align-items-center">
										  <span class="completion mr-2">60%</span>
										  <div>
											<div class="progress" style="width: 100px;">
											  <div class="progress-bar bg-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div>
											</div>
										  </div>
										</div>
									  </td>
									</tr>
									<tr>
									  <th scope="row">
										<div class="media align-items-center">
										  <div>
											<img alt="Image placeholder" src="../../assets/img/theme/light/brand-avatar-2.png" class="avatar  rounded-circle avatar-sm">
										  </div>
										  <div class="media-body ml-4">
											<a href="overview.html" class="name mb-0 h6 text-sm">Website Redesign</a>
										  </div>
										</div>
									  </th>
									  <td class="budget">
										2
									  </td>
									  <td>
										<span class="badge badge-dot mr-4">
										  <i class="bg-success"></i>
										  <span class="status">completed</span>
										</span>
									  </td>
									  <td>
										<div class="d-flex align-items-center">
										  <span class="completion mr-2">100%</span>
										  <div>
											<div class="progress" style="width: 100px;">
											  <div class="progress-bar bg-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"></div>
											</div>
										  </div>
										</div>
									  </td>
									</tr>
									<tr>
									  <th scope="row">
										<div class="media align-items-center">
										  <div>
											<img alt="Image placeholder" src="../../assets/img/theme/light/brand-avatar-3.png" class="avatar  rounded-circle avatar-sm">
										  </div>
										  <div class="media-body ml-4">
											<a href="overview.html" class="name mb-0 h6 text-sm">Webpixels Website</a>
										  </div>
										</div>
									  </th>
									  <td class="budget">
										3
									  </td>
									  <td>
										<span class="badge badge-dot mr-4">
										  <i class="bg-danger"></i>
										  <span class="status">delayed</span>
										</span>
									  </td>
									  <td>
										<div class="d-flex align-items-center">
										  <span class="completion mr-2">72%</span>
										  <div>
											<div class="progress" style="width: 100px;">
											  <div class="progress-bar bg-danger" role="progressbar" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100" style="width: 72%;"></div>
											</div>
										  </div>
										</div>
									  </td>
									</tr>
									<tr>
									  <th scope="row">
										<div class="media align-items-center">
										  <div>
											<img alt="Image placeholder" src="../../assets/img/theme/light/brand-avatar-4.png" class="avatar  rounded-circle avatar-sm">
										  </div>
										  <div class="media-body ml-4">
											<a href="overview.html" class="name mb-0 h6 text-sm">Purpose Application UI</a>
										  </div>
										</div>
									  </th>
									  <td class="budget">
										4
									  </td>
									  <td>
										<span class="badge badge-dot mr-4">
										  <i class="bg-info"></i>
										  <span class="status">on schedule</span>
										</span>
									  </td>
									  <td>
										<div class="d-flex align-items-center">
										  <span class="completion mr-2">90%</span>
										  <div>
											<div class="progress" style="width: 100px;">
											  <div class="progress-bar bg-info" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;"></div>
											</div>
										  </div>
										</div>
									  </td>
									</tr>
								  </tbody>
								</table>
							  </div>
							</div>
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