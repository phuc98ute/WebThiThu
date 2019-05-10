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
<title>Trang Chủ</title>
<meta content-width="device-width" initial-scale="1.0"
	maximum-scale="1.0" user-scalable="0" shrink-to-fit="no"
	name="viewport" />

<link href="${pageContext.request.contextPath}/assets/css/material-dashboard.css?v=2.1.0"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link href="${pageContext.request.contextPath}/Source/font-awesome/css/font-awesome.min.css"
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
					<li class="nav-item active "><a class="nav-link"
						href="redirectCpanel"> Trang Chủ </a></li>
					<li class="nav-item " <%if(!session.getAttribute("role").equals("qlcauhoi")){%>hidden<%}%>><a class="nav-link"
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
						<a class="btn btn-primary btn-round" href="logout">Đăng xuất</a>
					</div>
				</div>
			</nav>
			<!-- End Navbar -->
			<div class="content">
				<div class="container-fluid">
				
			<div class="col-md-10">
              <div class="card card-profile">
                <div class="card-avatar">
                    <img class="img" src="assets33/img/faces/tracnghiem.jpeg" />
                </div>
                <div class="card-body" >
                      
                      <span style="text-align: left" ><h4 class="card-category text-black"><b><center> Phần mềm thi trắc nghiệm là một phần mềm thiết thực cho việc thi và đánh giá kết quả học tập của sinh viên một cách thiết thực và khách quan nhất.</center></b></h4></span>
               </div>
               </div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>