<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8" />
<link rel="apple-touch-icon" sizes="76x76"
	href="${pageContext.request.contextPath}/assets/img/apple-icon.png">
<link rel="icon" type="image/png" href="assets/img/favicon.png">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
<title>Giới Thiệu Trang</title>
<link
	href="${pageContext.request.contextPath}/assets/css/material-dashboard.css?v=2.1.0"
	rel="stylesheet" />
<!-- CSS Just for demo purpose, don't include it in your project -->
<link
	href="${pageContext.request.contextPath}/Source/font-awesome/css/font-awesome.min.css"
	rel="stylesheet" />

</head>


<body background="${pageContext.request.contextPath}/assets33/img/111.png" style="background-size:cover">
  <div class="wrapper">
    <div class="main-panel">
      <nav class="navbar navbar-expand-lg navbar-transparent navbar-absolute fixed-top ">
          <div class="container-fluid">
              <div class="navbar-wrapper"></div>
          <div class="collapse navbar-collapse justify-content-end">
          </div>
        </div>
      </nav>
      <!-- End Navbar -->
      <div class="content">
        <div class="container-fluid">
          <div class="row">
            <div class="col-md-4">
              <div class="card card-profile">
                <div class="card-avatar">
                    <img src="assets33/img/faces/web.jpg" />
                </div>
                <div class="card-body" >
                  <span style="text-align: center" ><h4 class="card-category text-black"><center><b>NHÓM SINH VIÊN</center></b></h4></span>
                  <span style="text-align: left" ><i><h5 class="card-title"><b><center>Võ Hồng Phúc - 16110423</center></b></h5></i></span>
                  <span style="text-align: left"><i><h5 class="card-title"><b><center>Phạm Kim Hùng - 16110346</center></b></h5></i></span>
                  <span style="text-align: left"><i><h5 class="card-title"><b><center>Lê Hoàng Hưng - 16110348</center></b></h5></i></span>
                  <span style="text-align: left"><h5 class="card-title"><i><b><center>Hồ Nguyễn Hoàng Quân - 16110329</b></i></h5></span>
                  <a class="btn btn-primary btn-round" href="redirectLogin">Đăng nhập</a>
                </div>
              </div>
            </div>
            <div class="col-md-7">
              <div class="card card-profile">
                <div class="card-avatar">
                    <img class="img" src="assets33/img/faces/marc.jpg" />
                </div>
                <div class="card-body" >
                        <span style="text-align: center" ><h4 class="card-category text-black"><b>GIỚI THIỆU</b></h4></span>
                       <span style="text-align: left" ><h4 class="card-category text-black"><b><center> Phần mền thi trắc nghiệm trực tuyến không chỉ giúp cho sinh viên đại học từ xa tự học tự nghiên cứu và trau dồi kiến thức mà còn phục vụ cho học sinh các cấp, hay sinh viên học tập trung tại các trường đại học.</center></b></h4></span>
                       <span style="text-align: left" ><h4 class="card-category text-black"><b><center> Phần mềm thi trắc nghiệm trực tuyến giúp cho công tác quản lý và tổ chức quản lý các kỳ thi thuận tiện và khách quan nhất.</center></b></h4></span>
                       <span style="text-align: left" ><h4 class="card-category text-black"><b><center> Ngoài ra phần mềm còn hỗ trợ những thông báo từ nhà trường, từ khoa, từ các giảng viên đến với sinh viên dễ dàng</center></b></h4></span>
                      </div>
              </div>
            </div>
          </div>
        </div>
      </div>
     
    </div>
  </div>
  <!--   Core JS Files   -->
  <script src="assets/js/core/jquery.min.js" type="text/javascript"></script>
  <script src="assets/js/core/popper.min.js" type="text/javascript"></script>
  <script src="assets/js/core/bootstrap-material-design.min.js" type="text/javascript"></script>
  <script src="assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
  <script src="assets/js/material-dashboard.min.js?v=2.1.0" type="text/javascript"></script>
  <script src="assets/demo/demo.js"></script>
</body>

</html>