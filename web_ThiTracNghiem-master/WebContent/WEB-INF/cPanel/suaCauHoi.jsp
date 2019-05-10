<%@page import="java.util.List"%>
<%@page import="Objects.CauHoi"%>
<%@page import="Objects.dsCauHoi"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="../assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="../assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Sửa Thông Tin Câu Hỏi</title>

<!--     Fonts and icons     -->


<!-- CSS Files -->
<link
	href="${pageContext.request.contextPath}/assets/css/material-dashboard.css?v=2.1.0"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link
	href="${pageContext.request.contextPath}/Source/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />

</head>

<body class="">
	<div class="wrapper ">
		<div class="sidebar" data-color="purple" data-background-color="white"
			data-image="../assets/img/sidebar-1.jpg">
			<!--
        Tip 1: You can change the color of the sidebar using: data-color="purple | azure | green | orange | danger"

        Tip 2: you can also add an image using data-image tag
    -->
			<div class="logo">
				<img src ="assets33/img/ava.png" width ="150px" height="150px" style="margin-left:50px">
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<li class="nav-item  "><a class="nav-link"
						href="redirectCpanel"> Trang Chủ </a></li>
					<li class="nav-item active" <%if(!session.getAttribute("role").equals("qlcauhoi")){%>hidden<%}%>><a class="nav-link"
						href="redirectCauHoi"> Câu Hỏi </a></li>
					<li class="nav-item" <%if(!session.getAttribute("role").equals("qldethi")){%>hidden<%}%>><a class="nav-link" href="redirectDeThi">
							Đề Thi </a></li>

				<li class="nav-item" <%if(!session.getAttribute("role").equals("qlthisinh")){%>hidden<%}%>><a class="nav-link hidden" href="redirectThiSinhLopHoc">
							Thí Sinh
					</a></li>
						<li class="nav-item " <%if(!session.getAttribute("role").equals("qlthisinh")){%>hidden<%}%>><a class="nav-link" href="redirectLopHoc">
							Lớp Học
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">
			<!-- Navbar -->
			<nav
				class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
				<div class="container-fluid">
					<div class="collapse navbar-collapse justify-content-end">
						
						<a class="btn btn-primary btn-round" href="logout">Đăng Xuất</a>
					</div>
				</div>
			</nav>
			<!-- End Navbar -->
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="card ">
							<div class="card-header card-header-primary">
								<div class="row">
									<h4 class="card-title col-xs-12 my-auto ml-sm-5">Chỉnh Sửa Câu Hỏi</h4>
								</div>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<div class="card-body">
										<!--Phần body -->
										<form action="redirectLuuCauHoi">
											<h5 class="card-title mb-0">Mức Độ :</h5>
											<div class="row">
												<div class="input-group my-auto col-xs-12 col-sm-4">
													<div class="input-group-text"
														style="border: none; background: none">
														<input checked type="radio" name="radLevel" value="easy"
															class="ml-2 mr-1"
															<c:if test="${param.mucDo == '1'}">checked</c:if>
															aria-label="Radio button for following text input">
														Dễ <input type="radio" name="radLevel" value="normal" class="ml-2 mr-1"
															<c:if test="${param.mucDo == '2'}">checked</c:if>
															aria-label="Radio button for following text input">
														Trung Bình <input type="radio" value="hard" name="radLevel"
															class="ml-2 mr-1"
															<c:if test="${param.mucDo == '3'}">checked</c:if>
															aria-label="Radio button for following text input">
														Khó
													</div>
												</div>
											</div>
											<div class="">
												<!--Đề bài-->
												<div class="form-group">
													<label>Nội Dung Câu Hỏi :</label> <input type="text"
														class="form-control form-control-sm" name="e_ndCH"
														id="question" aria-describedby="helpId" class="col-sm-12"
														value="${param.ndCH}">
												</div>
											</div>
											<input-group-text> <!-- câu trả lời -->

											<div class="row mx-auto">
												<label
													class="btn btn-outline-success col-sm-12 px-auto py-auto">
													<input type="radio" name="a" id="a" autocomplete="off" value="dapAn_A"
													<c:if test="${param.daDung == 'A'}">checked</c:if>
													class="col-sm-1"> <input type="text" name="daA"
													id="a" class="col-sm-11" value="${param.daA}">
												</label>
											</div>
											<div class="row mx-auto">
												<label class="btn btn-outline-success col-sm-12"> <input
													type="radio" name="a" id="b" autocomplete="off" value="dapAn_B"
													<c:if test="${param.daDung == 'B'}">checked</c:if>
													class="col-sm-1"> <input type="text" name="b"
													id="b" value="${param.daB}" class="col-sm-11">
												</label>
											</div>
											<div class="row mx-auto">
												<label class="btn btn-outline-success col-sm-12"> <input
													type="radio" name="a" id="c" autocomplete="off" value="dapAn_C"
													<c:if test="${param.daDung == 'C'}">checked</c:if>
													class="col-sm-1"> <input type="text" name="c"
													id="c" value="${param.daC}" class="col-sm-11">
												</label>
											</div>
											<div class="row mx-auto">
												<label class="btn btn-outline-success col-sm-12"> <input
													type="radio" name="a" id="d" autocomplete="off" value="dapAn_D"
													<c:if test="${param.daDung == 'D'}">checked</c:if>
													class="col-sm-1"> <input type="text" name="d"
													id="d" value="${param.daD}" class="col-sm-11">
												</label>
											</div>
											<div class="row mx-auto" style="display:none">
												<input type="text" name="e_maCH" value="${param.maCH}"
													class="col-sm-11">
													<input type="text" name="e_daDung" value="${param.daDung}"
													class="col-sm-11">
											</div>
											</input-group-text>
											<div class="row row justify-content-center">
												<div class="col-sm-4 ">
													<button class="btn btn-success col-auto btn-round ">Lưu Thông Tin</button>
													<a href="redirectCauHoi" class="btn btn-danger col-auto btn-round">Hủy</a>
												</div>
												
											</div>
										</form>
									</div>
									
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- <footer class="footer">
		<div class="container-fluid">
			<nav class="float-left">
				<ul>
					<li></li>
					<li></li>
					<li><a href="#"> Group 1 </a></li>
					<li><a href="#"> Licenses </a></li>
					<li><a href="#"> About </a></li>
					<li><a href="#"> Contact </a></li>
				</ul>
			</nav>

		</div>
	</footer> -->


</body>

</html>