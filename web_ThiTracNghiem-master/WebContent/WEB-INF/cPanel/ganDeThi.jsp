<%@page import="Objects.PhongThi"%>
<%@page import="Objects.dsPhongThi"%>
<%@page import="java.util.List"%>
<%@page import="Objects.CauHoi"%>
<%@page import="Objects.dsCauHoi"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="../assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="../assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Gán Đề Thi</title>
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
					<li class="nav-item "><a class="nav-link"
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
									<h4 class="card-title col-xs-12 my-auto ml-sm-5">Gán Đề
										Thi</h4>

								</div>
							</div>
							<div class="card-body">
								<form action="ganPhongThi">
									<div class="row">
										<div class="col-sm-6">
											<div class="row">
												<h5 class="mb-0 mt-2 col-sm-4">Mã Lớp Học</h5>
												<input type="text"
													class="form-control form-control-sm col-sm-4 "
													name="a_taoDeLopHoc" aria-describedby="helpId"
													class="col-sm-3" style="text-align: center;"
													placeholder="1->4" required	>
											</div>

											<!--  -->
											<div class="row">
												<h5 class="mb-0 mt-2 col-sm-4">Mã Đề Thi</h5>
												<input type="text"
													class="form-control form-control-sm col-sm-4"
													name="a_taoDeDeThi" aria-describedby="helpId"
													class="col-sm-3" style="text-align: center;"
													placeholder="1->4" required>
											</div>

										</div>
										<div class="col-sm-6 py-4">
											<button class="btn btn-success my-auto" >Thêm</button>
										</div>
									</div>
								</form>

								<div class="table-responsive">
									<h3>Danh Sách Các Phòng Thi Có Sẵn</h3>
									<table class="table">
										<thead class=" text-primary">
											<tr>
												<th scope="col">Mã Phòng</th>
												<th scope="col">Mã Lớp Học</th>
												<th scope="col">Mã Đề Thi</th>
												
											</tr>
										</thead>
										<tbody>
											<%
												dsPhongThi obj = (dsPhongThi) request.getAttribute("dsPT");
												List<PhongThi> ds = (List<PhongThi>) obj.getDs();
											%>

											<%
												for (int i = 0; i < ds.size(); i++) {
											%>
											<tr>
												<td><%=ds.get(i).getMaPhong()%></td>
												<td><%=ds.get(i).getMaLopHoc()%></td>
												<td><%=ds.get(i).getMaDeThi()%></td>
												<td><a href="xoaPhongThi?maPT=<%=ds.get(i).getMaPhong()%>"	class="btn btn-warning"><i class="fa fa-trash"></i></a></td>	
											<%
												}
											%>

										</tbody>
									</table>
									<nav aria-label="Page navigation example">
										<ul class="pagination justify-content-center">
											<li class="page-item disabled"><a class="page-link"
												href="#" tabindex="-1">Trang Trước</a></li>
											<li class="page-item"><a class="page-link" href="#">1</a></li>
											<li class="page-item"><a class="page-link" href="#">2</a></li>
											<li class="page-item"><a class="page-link" href="#">3</a></li>
											<li class="page-item"><a class="page-link" href="#">Trang Sau</a>
											</li>
										</ul>
									</nav>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>