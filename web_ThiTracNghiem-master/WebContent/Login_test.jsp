<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <title>Đăng Nhập</title>
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">
  <link href="assets1/vendor/nucleo/css/nucleo.css" rel="stylesheet">
  <link href="assets1/vendor/@fortawesome/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link type="text/css" href="assets1/css/argon.css?v=1.0.0" rel="stylesheet">
 
</head>

<body background="assets1/css/111.png" style="background-size:cover">
    <div class="header py-5 py-lg-5">
      <div class="container">
        <div class="header-body text-center mb-7">
          <div class="row justify-content-center">
            <div class="col-lg-5 col-md-6">
              <h1 class="text-white">Welcome to my test exam website !</h1>
              <p class="text-lead text-white">Trang thi trắc nghiệm dành cho sinh viên đại học</p>
            </div>
          </div>
        </div>
    </div>
    
    </div>
    <div class="container mt--7 pb-4">
      <div class="row justify-content-center" style="background:co#F7F7F7">
        <div class="col-lg-6 col-md-6">
          <div class="card bg-secondary shadow border-0">   
            <div class="card-body px-lg-3 py-lg-3">
              <div class="text-center text-muted mb-4">
                <small>Đăng nhập bằng tài khoản cá nhân</small>
              </div>
              <form role="form" method="post" action="login">
                <div class="form-group mb-3">
                  <div class="input-group input-group-alternative">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-email-83"></i></span>
                    </div>
                    <input class="form-control" placeholder="Tên Đăng Nhập" name="inputUserName" type="text">
                  </div>
                </div>
                <div class="form-group">
                  <div class="input-group input-group-alternative">
                    <div class="input-group-prepend">
                      <span class="input-group-text"><i class="ni ni-lock-circle-open"></i></span>
                    </div>
                    <input class="form-control" placeholder="Mật Khẩu" name="inputPassword" type="password">
                  </div>
                </div>
                <div class="text-center">
                  <button class="btn btn-primary btn-round">Đăng nhập</button>
				  </div>
              </form>
            </div>
          </div>
         
          </div>
        </div>
      </div>
    </div>
  </div>
  <script src="assets1/vendor/jquery/dist/jquery.min.js"></script>
  <script src="assets1/vendor/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
  <script src="assets1/js/argon.js?v=1.0.0"></script>
  <script>
	</script>
</body>

</html>