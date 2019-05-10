<%@page import="Objects.CauHoi"%>
<%@page import="Objects.dsCauHoi"%>
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
<!-- <script src="main.js"></script> -->


<script type="text/javascript"
	src="${pageContext.request.contextPath}/assets/js/core/jquery.3.2.1.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"></script>

<style type="text/css">
.sidebar {
	position: sticky;
	top: 300px;
}

.thongtin {
	position: sticky;
	top: 110px;
}
</style>
</head>

<body>
	<script>
		var _hours = 0;
		var _minute = <%=session.getAttribute("thoiLuong")%>;
		var _seconds = 0;
		var html = '<div class="alert alert-success"><strong>Success!</strong> Hết thời gian</div>';
		function demNguoc() {

			if (_seconds != 0 || _hours != 0 || _minute != 0) {
				if (_seconds == 0 && _minute != 0) {
					_seconds = 59;
					_minute--;
				} else {
					_seconds--;
				}
				$("#seconds").text(_seconds);
				$("#minutes").text(_minute);
				$("#hours").text(_hours);

			} else {
				$("#nopbai").click();
				//$('#popupa').modal('show');

			}
		}
		function getFocus(id) {           
			$('html, body').animate({ scrollTop: $('#'+id+'').offset().top }, 'slow');
			}
		setInterval(demNguoc, 1000);
		window.onbeforeunload = function () {return false;}
		
	</script>
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
					<div class="card">
						<div class="card-header">
							<h3 class="text-center">Bài làm</h3>
						</div>
						<div class="card-body px-5 py-5">
							<form action="nopBai" id="myform">
								<%
								dsCauHoi obj = (dsCauHoi) request.getAttribute("dsCH");
								List<CauHoi> ds = (List<CauHoi>) obj.getDs();
								for (int i = 0; i < ds.size(); i++) {
							%>
							<div class="row">
								<h5 id="<%=i%>">
									Câu
									<%=i + 1%>:
									<%=ds.get(i).getNoiDungCauHoi()%>
								</h5>
								<label class="container"> <input type="radio" value="A"
									name="<%=i%>"> <span class="checkmark"><%=ds.get(i).isDapAn_A()%></span>
								</label> <label class="container"> <input type="radio" value="B"
									name="<%=i%>"> <span class="checkmark"><%=ds.get(i).isDapAn_B()%></span>
								</label> <label class="container"> <input type="radio" value="C"
									name="<%=i%>"> <span class="checkmark"><%=ds.get(i).isDapAn_C()%></span>
								</label> <label class="container"> <input type="radio" value="D"
									name="<%=i%>"> <span class="checkmark"><%=ds.get(i).isDapAn_D()%></span>
								</label>

							</div>
							<%
								}
							%>
							<button id="nopbai" type="submit" class="btn btn-success ">Nộp bài</button>
							</form>
						</div>
					</div>
				</div>

				<div class="col-sm-4 ">
					<div class="card text-center mb-3 thongtin">

						<div class="card-body">
							<div>
								Thời gian làm bài:
								<%=session.getAttribute("thoiLuong")%>
								phút
							</div>
							<div>
								Tổng số câu:
								<%=session.getAttribute("tongSoCau")%></div>

							<!--Model  -->
							<div class="row ml-5" style="border-radius: 20px;">
								<div
									style="color: #333; text-align: center; background-color: #ffd54f; border-radius: 20px;"
									class="float-right">
									<ul style="margin-top: 20px;">
										<li
											style="display: inline-block; font-size: 20px; list-style-type: none; padding: 1px; text-transform: uppercase;">
											<span id="hours" style="display: block; font-size: 30px;"></span>Hours
										</li>
										<li
											style="display: inline-block; font-size: 20px; list-style-type: none; padding: 1px; text-transform: uppercase;">
											<span id="minutes" style="display: block; font-size: 30px;"></span>Minutes
										</li>
										<li
											style="display: inline-block; font-size: 20px; list-style-type: none; padding: 1px; text-transform: uppercase;">
											<span id="seconds" style="display: block; font-size: 30px;"></span>Seconds
										</li>
									</ul>
								</div>
							</div>
							<!--  -->
						</div>
					</div>

					<div class="card text-center sidebar">
						<div class="card-body px-3 py-3">
							<%
								for (int i = 0; i < ds.size(); i++) {
							%>
							<%-- <a style="width: 40px;" class="btn btn-primary mx-2 my-2"
								href="#<%=i + 1%>"><%=i + 1%></a> --%>
								<button type="button" class='goto btn btn-light ' value="<%=i%>"><%=i + 1%></button>
							<%
								}
							%>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="modal fade" id="popupa" tabindex="-1" role="dialog"
		aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
		<div class="modal-dialog modal-dialog-centered" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<h5 class="modal-title" id="exampleModalCenterTitle">Thông
						báo!</h5>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body">Đã hết thời gian làm bài!</div>
				<div class="modal-footer">
					<input type="submit" form="myform" value="Nộp bài"/>
				</div>
			</div>
		</div>
	</div>

</body>
<script>
$(document).ready(function() {
	$(".goto").click(function(){
		getFocus($(this).val());
	})
});
</script>
</html>