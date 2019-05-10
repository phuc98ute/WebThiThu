<%@page import="Objects.DeThiTheoUser"%>
<%@page import="java.util.List"%>
<%@page import="Objects.dsDeThiTheoUser"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Trang chủ</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link
	href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"
	rel="stylesheet">
<script src="main.js"></script>

</head>

<body>


	<div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary sticky-top">
			<a class="navbar-brand" href="#">Thi trắc nghiệm online</a>
			<div class="">
				<ul class="navbar-nav">
					<li class="nav-item active"><a class="nav-link"
						href="redirectTrangThi">Trang chủ <span class="sr-only">(current)</span></a>
					</li>

					<li class="nav-item"><a class="nav-link" href="xemKetQua">Kết
							quả</a></li>
				</ul>
			</div>
			<div class="ml-auto">
				<a class="text-danger btn btn-warning" href="logout">Thoát</a>
			</div>
		</nav>
		<div class="content mx-5">
			<div class="row mt-5">
				<div class="col-sm-8">
					<%
						if (request.getAttribute("mess") != null) {
							String mess = (String) request.getAttribute("mess");
					%>
				
					<div class="alert alert-success alert-dismissible">
						<a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						<strong><%=mess%></strong>
					</div>
					<%
						}
					%>
					<ul class="list-group">
						<li class="list-group-item"><h3>Danh sách các bài thi</h3></li>
						<%
							dsDeThiTheoUser obj = (dsDeThiTheoUser) request.getAttribute("dsDeThi");
							List<DeThiTheoUser> ds = (List<DeThiTheoUser>) obj.getDs();
						%>

						<%
							for (int i = 0; i < ds.size(); i++) {
						%>
						<li class="list-group-item ">
							<div class="d-flex justify-content-between">
								<div class="d-inline">
									<h3 class="ml-4 "><%=ds.get(i).getTenLopHoc().toUpperCase()%></h3>
								</div>
								<div class="">
									<a
										href="vaoThi?maDeThi=<%=ds.get(i).getMaDeThi()%>&
						thoiLuong=<%=ds.get(i).getThoiLuong()%>&
						tongSoCau=<%=ds.get(i).getTongSoCauHoi()%>"
										class="btn btn-info">Bắt đầu</a>
								</div>
								
							</div>
							<hr>
							<div class="row">
								<div class="col-lg-4">
									Bài quiz số:
									<%=ds.get(i).getMaDeThi()%>
								</div>
								<div class="col-lg-8">
									Thời gian bắt đầu:
									<%=ds.get(i).getThoiGianBatDau()%></div>
							</div>
							<div class="row">
								<div class="col-lg-4">
									Số câu hỏi:
									<%=ds.get(i).getTongSoCauHoi()%>
								</div>
								<div class="col-lg-8">
									Thời gian làm bài:
									<%=ds.get(i).getThoiLuong()%></div>
							</div>


						</li>
						<%
							}
						%>
					</ul>
				</div>
				<div class="col-sm-4">
					<div class="card text-center">
						<img style="width: 18rem;" class="card-img-top mx-auto my-2"
							src="${pageContext.request.contextPath}/Source/hinh1.png"
							alt="Card image cap">
						<div class="card-body">
							<p class="card-text">
								MSSV:
								<%=session.getAttribute("mataikhoan")%></p>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
</body>

</html>