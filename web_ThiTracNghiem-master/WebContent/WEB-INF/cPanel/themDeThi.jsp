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
<title>Thêm Đề Thi</title>
<meta content-width="device-width" initial-scale="1.0"
	maximum-scale="1.0" user-scalable="0" shrink-to-fit="no"
	name="viewport" />
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
					<li class="nav-item " <%if(!session.getAttribute("role").equals("qlcauhoi")){%>hidden<%}%>><a class="nav-link"
						href="redirectCauHoi"> Câu Hỏi </a></li>
					<li class="nav-item active" <%if(!session.getAttribute("role").equals("qldethi")){%>hidden<%}%>><a class="nav-link" href="redirectDeThi">
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
						<a class="btn btn-primary btn-round" href="logout">Đăng xuất</a>
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
									<h4 class="card-title col-xs-12 my-auto ml-sm-5">Thêm Đề Thi</h4>
								</div>
							</div>
							<div class="card-body">
								<form action="themDeThi">
									<div class="table-responsive">
										<div class="card-body">
											<div class="row">
												
												<div class="col-sm-2">
													<h5 class="mb-0 mt-2">Học Kỳ:</h5>
												</div>
												<div class="col-sm-1">
													<input type="text" class="form-control form-control-sm"
														name="a_hocKy" aria-describedby="helpId" class="col-sm-3"
														style="text-align: center;" placeholder="1" required>
												</div>

											</div>
											<div class="row">
												<div class="col-sm-2">
													<h5 class="mb-0 mt-2">Thời Gian Bắt Đầu:</h5>
												</div>
												<div class="col-sm-2">
													<input type="text" class="form-control form-control-sm"
														name="a_thoiGianBatDau" aria-describedby="helpId"
														class="col-sm-3" style="text-align: center;"
														placeholder="yyyy-mm-dd HH:mm:ss" required>
												</div>
												<div>Cú pháp: yyyy-mm-dd HH:mm:ss (Nhập đúng cú pháp nha)</div>
											</div>
											<div class="row">
												<div class="col-sm-2	">
													<h5 class="mb-0 mt-2">Thời Lượng:</h5>
												</div>
												<div class="col-sm-1">
													<input type="text" class="form-control form-control-sm"
														name="a_thoiLuong" aria-describedby="helpId"
														class="col-sm-3" style="text-align: center;"
														placeholder="60" required>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-2	">
													<h5 class="mb-0 mt-2">Câu Dễ:</h5>
												</div>
												<div class="col-sm-1">
													<input type="text" class="form-control form-control-sm"
														name="a_soCHDe" aria-describedby="helpId" class="col-sm-3"
														style="text-align: center;" placeholder="10" required>
												</div>
												<div class="col-sm-2	">
													<h5 class="mb-0 mt-2">Câu TB:</h5>
												</div>
												<div class="col-sm-1">
													<input type="text" class="form-control form-control-sm"
														name="a_soCHTB" aria-describedby="helpId" class="col-sm-3"
														style="text-align: center;" placeholder="10" required>
												</div>
												<div class="col-sm-2	">
													<h5 class="mb-0 mt-2">Câu Khó:</h5>
												</div>
												<div class="col-sm-1">
													<input type="text" class="form-control form-control-sm"
														name="a_soCHKho" aria-describedby="helpId"
														class="col-sm-3" style="text-align: center;"
														placeholder="10" required>
												</div>
											</div>
											<div class="row">
												<div class="col-sm-2	">
													<h5 class="mb-0 mt-2">Thang Điểm:</h5>
												</div>
												<div class="col-sm-1">
													<input type="text" class="form-control form-control-sm"
														name="a_thangDiem" aria-describedby="helpId"
														class="col-sm-3" style="text-align: center;"
														placeholder="10" required>
												</div>
												<div class="col-sm-2	">
													<h5 class="mb-0 mt-2">Kích Hoạt:</h5>
												</div>

												<div class="col-sm-1">
													<input type="text" class="form-control form-control-sm"
														name="a_isActive" aria-describedby="helpId"
														class="col-sm-3" style="text-align: center;"
														placeholder="false" required>
												</div>
											</div>
										</div>
									</div>
									<div class="row row justify-content-center">
										<div class="col-ms-4 ">
											<a href="redirectDeThi" class="btn btn-danger col-auto btn-round ">Hủy</a>
										</div>
										<div class="col-ms-4 ">
											<button class="btn btn-success col-auto btn-round ">Lưu Đề Thi</button>

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
</body>

</html>