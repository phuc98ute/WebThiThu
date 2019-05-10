<%@page import="Objects.KetQua"%>
<%@page import="Objects.dsKetQua"%>
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
<style type="text/css">
.numberCircle {
	border-radius: 50%;
	behavior: url(PIE.htc);
	/* remove if you don't care about IE8 */
	width: 45px;
	height: 45px;
	padding: 3px;
	background: #2C72C7;
	border: 2px solid #2C72C7;
	color: #FF6600;
	text-align: center;
	font: 24px Arial, sans-serif;
}
</style>
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
				<a class="text-danger " href="logout"><span
					class="border border-danger px-3 py-2 bg-warning ">Thoát</span></a>
			</div>
		</nav>
		<div class="content mx-5">
			<div class="row mt-5">
				<div class="col-sm-8">
					<table class="table">
						<thead class=" text-primary">
							<tr>
								<th style="text-align: center;" scope="col">Đề thi</th>
								<th style="text-align: center;" scope="col">Điểm</th>
							</tr>
						</thead>
						<tbody>
							<%
								dsKetQua obj = (dsKetQua) request.getAttribute("dsKQ");
								List<KetQua> ds = (List<KetQua>) obj.getDs();
							%>

							<%
								for (int i = 0; i < ds.size(); i++) {
							%>
							<tr>
								<td style="text-align: center;"><%=ds.get(i).getMaDeThi()%></td>
								<td style="text-align: center;"><%=ds.get(i).getDiem()%></td>

								<td><a target="_blank" href="xuatPDF?maKQ=<%=ds.get(i).getMaKQ()%>&maDT=<%=ds.get(i).getMaDeThi()%>">Xuất file PDF</a></td>
							</tr>
							<%
								}
							%>

						</tbody>
					</table>
				</div>
				<div class="col-sm-4">
					<div class="card text-center">
						<img style="width: 18rem;" class="card-img-top mx-auto my-2"
							src="${pageContext.request.contextPath}/Source/hinh1.png"
							alt="Card image cap">
						<div class="card-body">
							<p class="card-text">MSSV: <%=session.getAttribute("mataikhoan") %></p>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
</body>

</html>