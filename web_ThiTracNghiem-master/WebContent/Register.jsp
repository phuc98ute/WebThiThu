<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>


<head>
<meta charset="UTF-8">
<title>Form Đăng Kí</title>
<link href="Source/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="Source/bootstrap.min.js"></script>
<script src="Source/jquery-3.3.1.min.js"></script>

<style>
* {
    -webkit-box-sizing: border-box;
	   -moz-box-sizing: border-box;
	        box-sizing: border-box;
	outline: none;
}

    .form-control {
	  position: relative;
	  font-size: 16px;
	  height: auto;
	  padding: 10px;
		@include box-sizing(border-box);

		&:focus {
		  z-index: 1;
		}
	}

body {
	background: url(Source/Backgroundregister.jpg) no-repeat center center fixed;
    -webkit-background-size: cover;
    
    -moz-background-size: cover;
    -o-background-size: cover;
    background-size: cover;
    
}

.login-form {
	margin-top: 30px;
}

form[role=login] {
	color: #5d5d5d;
	background: #f2f2f2 ;
	padding: 26px;
	border-radius: 10px;
	-moz-border-radius: 10px;
	-webkit-border-radius: 10px;
}
	form[role=login] img {
		display: block;
		margin: 0 auto;
		margin-bottom: 30px;
	}
	form[role=login] input,
	form[role=login] button {
		font-size: 18px;
		margin: 15px 0;
	}
	form[role=login] > div {
		text-align: center;
	}
</style>
</head>
<body>
<div class="container">
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
        <form method="post" action="#" role="login">
          <img src="Source/Imageregister.png"
           class="img-responsive" alt="" />
          <input type="text" name="tenDN" placeholder="Tên đăng nhập" required class="form-control input-lg"/>
          <input type="password" class="form-control input-lg" id="password" placeholder="Mật khẩu"  />
          <input type="password" name="Nhaplaipw" placeholder="Nhập lại mật khẩu" required class="form-control input-lg"/>
          <input type="email" name="txtEmail" placeholder="Email" required class="form-control input-lg"/>
          <select class="form-control" id="sel1">
        	<option>Học Sinh</option>
       		 <option>Admin</option>
      		</select>
          <div class="pwstrength_viewport_progress"></div>
          <button type="submit" name="go" class="btn btn-lg btn-primary btn-block">Đăng Kí</button>
      </form>
      </section>  
      </div>
      <div class="col-md-4"></div>
  </div>      
</div>
</body>
</html>