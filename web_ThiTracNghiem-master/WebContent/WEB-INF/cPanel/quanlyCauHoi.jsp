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
<title>Quản Lý Câu Hỏi</title>

<!--     Fonts and icons     -->


<!-- CSS Files -->
<link
	href="${pageContext.request.contextPath}/assets33/css/material-dashboard.css?v=2.1.0"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link
	href="${pageContext.request.contextPath}/Source/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />

</head>

<body class="">
	<div class="wrapper ">
		<div class="sidebar" data-color="purple" data-background-color="white"
			data-image="../assets33/img/sidebar-1.jpg">
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
					<li class="nav-item active"
						<%if (!session.getAttribute("role").equals("qlcauhoi")) {%> hidden
						<%}%>><a class="nav-link" href="redirectCauHoi"> Câu Hỏi
					</a></li>
					<li class="nav-item"
						<%if (!session.getAttribute("role").equals("qldethi")) {%> hidden
						<%}%>><a class="nav-link" href="redirectDeThi"> Đề Thi </a></li>

					<li class="nav-item"
						<%if (!session.getAttribute("role").equals("qlthisinh")) {%>
						hidden <%}%>><a class="nav-link hidden"
						href="redirectThiSinhLopHoc"> Thí Sinh </a></li>
					<li class="nav-item "
						<%if (!session.getAttribute("role").equals("qlthisinh")) {%>
						hidden <%}%>><a class="nav-link" href="redirectLopHoc">
							Lớp Học </a></li>
				</ul>
			</div>
		</div>
		<div class="main-panel">

			<nav
				class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
				<div class="container-fluid">
					<div class="navbar-wrapper">
						<form class="navbar-form" action="TimCauHoi">
							<div class="input-group no-border">
								<input type="text" name="noiDungCauHoi" class="form-control"
									value="${param.noiDungCauHoi}">
								<button class="btn btn-primary btn-round">Tìm Câu Hỏi
									<div class="ripple-container"></div>
								</button>
							</div>
						</form>
					</div>
					<div class="collapse navbar-collapse justify-content-end">
						<a class="btn btn-primary btn-round " href="logout">Đăng xuất</a>
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
									<h4 class="card-title col-xs-12 my-auto ml-sm-5">Danh Sách Câu Hỏi</h4>
									<a class="btn btn-success col-xs-12 ml-auto mr-sm-5 btn-round"
										href="redirectThemCauHoi"> Thêm Câu Hỏi </a>
								</div>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table">
										<thead class=" text-primary">
											<tr>
												<th style="text-align: center;" scope="col">Mã CH</th>
												<th style="text-align: center;" scope="col">Nội Dung
													Câu Hỏi</th>
												<th style="text-align: center;" scope="col">Câu Trả Lời</th>
												<th style="text-align: center;" scope="col">Đáp Án Đúng</th>
												<th style="text-align: center;" scope="col">Mức Độ</th>
											</tr>
										</thead>
										<tbody>
											<%
												dsCauHoi obj = (dsCauHoi) request.getAttribute("dsCH");
												List<CauHoi> ds = (List<CauHoi>) obj.getDs();
											%>

											<%
												for (int i = 0; i < ds.size(); i++) {
											%>
											<tr>
												<td style="text-align: center;"><%=ds.get(i).getMaCauHoi()%></td>
												<td style="text-align: center;"><%=ds.get(i).getNoiDungCauHoi()%></td>
												<td style="text-align: center;"><%=ds.get(i).isDapAn_A()%>...</td>
												<td style="text-align: center;"><%=ds.get(i).getDapAnDung()%></td>
												<td style="text-align: center;"><%=ds.get(i).getMaMucDo()%></td>
												<td style="text-align: center;"><a
													href="redirectSuaCauHoi?maCH=<%=ds.get(i).getMaCauHoi()%>&ndCH=<%=ds.get(i).getNoiDungCauHoi()%>&daA=<%=ds.get(i).isDapAn_A()%>&daB=<%=ds.get(i).isDapAn_B()%>&daC=<%=ds.get(i).isDapAn_C()%>&daD=<%=ds.get(i).isDapAn_D()%>&daDung=<%=ds.get(i).getDapAnDung()%>&mucDo=<%=ds.get(i).getMaMucDo()%>"
													class="btn btn-info btn-round"><i class="fa fa-pencil"></i></a> <a
													href="redirectXoaCauHoi?maCH=<%=ds.get(i).getMaCauHoi()%>"
													class="btn btn-warning btn-round"><i class="fa fa-trash"></i></a></td>
											</tr>
											<%
												}
											%>

										</tbody>
									</table>
									<nav aria-label="Page navigation example">
										<ul class="pagination justify-content-center">
											<%
												String soCauHoi = (String) request.getAttribute("total");
												int total = (int) Integer.parseInt(soCauHoi);
												String trang = (String) request.getAttribute("pages");
												int pages = (int) Integer.parseInt(trang);
												if (pages > 5 && pages < total/4 - 4) {
											%>

											<li class="page-item disabled"><a class="page-link"
												href="#" tabindex="-1">Trước</a></li>
											<%
												for (int i = pages - 5; i < pages + 5; i++) {
											%>
											<li class="page-item"><a class="page-link"
												href="redirectCauHoi?pages=<%=i%>"><%=i%></a></li>
											<%
												}
											%>
											<li class="page-item"><a class="page-link" href="#">Sau</a>
											</li>

											<%
												}
												if (pages <= 5&& pages>0) {
											%>

											<li class="page-item disabled"><a class="page-link"
												href="#" tabindex="-1">Trước</a></li>
											<%
												for (int i = 1; i < 11; i++) {
											%>
											<li class="page-item"><a class="page-link"
												href="redirectCauHoi?pages=<%=i%>"><%=i%></a></li>
											<%
												}
											%>
											<li class="page-item"><a class="page-link" href="#">Sau</a>
											</li>

											<%
												}
												if (pages >= (total/4 - 4)&& pages<=total/4+1) {
											%>

											<li class="page-item disabled"><a class="page-link"
												href="#" tabindex="-1">Trước</a></li>
											<%
												for (int i = total/4 - 10; i <= total/4+1; i++) {
											%>
											<li class="page-item"><a class="page-link"
												href="redirectCauHoi?pages=<%=i%>"><%=i%></a></li>
											<%
												}
											%>
											<li class="page-item"><a class="page-link" href="#">Sau</a>
											</li>

											<%
												}
											%>

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
	</footer>
 -->

</body>

</html>