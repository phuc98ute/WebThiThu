<%@page import="java.util.List"%>
<%@page import="Objects.TaiKhoan"%>
<%@page import="Objects.dsTaiKhoan"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="${pageContext.request.contextPath}/assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Quản Lí Thí Sinh</title>
<link
	href="${pageContext.request.contextPath}/assets/css/material-dashboard.css?v=2.1.0" rel="stylesheet" />
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
						<form class="navbar-form" action="TimSinhVien">
							<div class="input-group no-border">
								<input type="text" name="tenSV" class="form-control"
									value="${param.tenSV}">
								<button type="submit"
									class="btn btn-primary btn-round ">
								Tìm Thí Sinh
									<div class="ripple-container"></div>
								</button>
							</div>
						</form>
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
									<h4 class="card-title col-xs-12 my-auto ml-sm-5">Danh Sách Thí Sinh</h4>
									<a class="btn btn-success col-xs-12 ml-auto mr-sm-5 btn-round"
										href="ThemSinhVien"> Thêm Thí Sinh
									</a>
								</div>
							</div>
							<div class="card-body">
								<div class="table-responsive">
									<table class="table">
										<thead class=" text-primary">
											<tr>
												<th style="text-align: center;" scope="col">Mã Thí Sinh</th>
												<th style="text-align: center;" scope="col">Tên Thí Sinh</th>
												<th style="text-align: center;" scope="col">Giới Tính</th>
												<th style="text-align: center;" scope="col">SĐT</th>
											</tr>
										</thead>
										<tbody>
											<%
												dsTaiKhoan obj = (dsTaiKhoan) request.getAttribute("dsLH");
												List<TaiKhoan> ds = (List<TaiKhoan>) obj.getDs();
											%>

											<%
												for (int i = 0; i < ds.size(); i++) {
											%>
											<tr>
												<td style="text-align: center;"><%=ds.get(i).getMaTK()%></td>
												<td style="text-align: center;"><%=ds.get(i).getTenSV()%></td>
												<td style="text-align: center;"><%=ds.get(i).getGioiTinh()%></td>
												<td style="text-align: center;"><%=ds.get(i).getSDT()%></td>
										
												<td style="text-align: center;">
                                                    <a href="redirectSuaSinhVien?maTK=<%=ds.get(i).getMaTK()%>&tenSV=<%=ds.get(i).getTenSV()%>&gioiTinh=<%=ds.get(i).getGioiTinh()%>&sdt=<%=ds.get(i).getSDT()%>" class="btn btn-info btn-round"><i class="fa fa-pencil"></i></a>
                                                    <a href="redirectXoaSinhVien?maTK=<%=ds.get(i).getMaTK()%>" class="btn btn-warning btn-round" ><i class="fa fa-trash"></i></a>
                                                    
                                                </td>
											</tr>
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