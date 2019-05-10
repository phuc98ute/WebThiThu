<%@page import="java.util.List"%>
<%@page import="Objects.TaiKhoan"%>
<%@page import="Objects.dsTaiKhoan"%>
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
<title>Sửa Thông Tin Thí Sinh</title>
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
			
			<div class="logo">
				<img src ="assets33/img/ava.png" width ="150px" height="150px" style="margin-left:50px">
			</div>
			<div class="sidebar-wrapper">
				<ul class="nav">
					<li class="nav-item  "><a class="nav-link"
						href="redirectCpanel"> Trang Chủ </a></li>
					<li class="nav-item " <%if(!session.getAttribute("role").equals("qlcauhoi")){%>hidden<%}%>><a class="nav-link"
						href="redirectCauHoi"> Câu Hỏi </a></li>
					<li class="nav-item" <%if(!session.getAttribute("role").equals("qldethi")){%>hidden<%}%>><a class="nav-link" href="redirectDeThi">
							Đề Thi </a></li>

				<li class="nav-item active" <%if(!session.getAttribute("role").equals("qlthisinh")){%>hidden<%}%>><a class="nav-link hidden" href="redirectThiSinhLopHoc">
							Thí Sinh
					</a></li>
						<li class="nav-item " <%if(!session.getAttribute("role").equals("qlthisinh")){%>hidden<%}%>><a class="nav-link" href="redirectLopHoc">
							Lớp Học
					</a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">

			<nav
				class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
				<div class="container-fluid">
					<div class="collapse navbar-collapse justify-content-end">
						<a class="btn btn-primary btn-round" href="logout">Đăng xuất</a>
					</div>
				</div>
			</nav>
			<div class="content">
				<div class="container-fluid">
					<div class="row">
						<div class="card ">
							<div class="card-header card-header-primary">
								<div class="row">
									<h4 class="card-title col-xs-12 my-auto ml-sm-5">Chỉnh Sửa Thông Tin Thí Sinh</h4>
								</div>
							</div>
							<div class="card-body">
							<form action="LuuSinhVienSua">
									<div class="row">
										<div class="col-sm-6">
											<div class="row">
												<h5 class="mb-0 mt-2 col-sm-4">Tên Thí Sinh</h5>
												<input type="text"
													class="form-control form-control-sm col-sm-4	"
													name="tenSV" aria-describedby="helpId"
													class="col-sm-3" style="text-align: center;"
													value="${param.tenSV}">
											</div>

											<!--  -->
											<div class="row">
												<h5 class="mb-0 mt-2 col-sm-4">Giới Tính</h5>
												<input type="text"
													class="form-control form-control-sm col-sm-4"
													name="gioiTinh" aria-describedby="helpId"
													class="col-sm-3" style="text-align: center;"
													value="${param.gioiTinh}">
											</div>
											<div class="row">
												<h5 class="mb-0 mt-2 col-sm-4">SĐT</h5>
												<input type="text"
													class="form-control form-control-sm col-sm-4"
													name="sdt" aria-describedby="helpId"
													class="col-sm-3" style="text-align: center;"
													value="${param.sdt}">
											</div>
											<div class="row" style="display:none">
												
												<input type="text"
													class="form-control form-control-sm col-sm-4	"
													name="maTK" aria-describedby="helpId"
													class="col-sm-3" style="text-align: center;"
													value="${param.maTK}">
											</div>
										</div>
										<div class="col-sm-6 py-4">
											<button class="btn btn-success my-auto btn-round" >Lưu Thông Tin</button>
											<a class="btn btn-warning btn-round" href="redirectThiSinhLopHoc">Hủy</a>
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