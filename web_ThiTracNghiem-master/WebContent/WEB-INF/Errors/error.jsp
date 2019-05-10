<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <title>Error Page</title>
</head>
<body>
	<h1 style="text-align:center; font-size: 175px;line-height: 0px;">	<%=response.getStatus() %></h1>
	<h1 style="text-align:center">	<%=(String) request.getAttribute("javax.servlet.error.message").toString() %></h1>
	<%
		if(response.getStatus()==404){
			%><h1 style="text-align:center">Bạn không có quyền truy cập đường dẫn này, vui lòng liên hệ admin.</h1><%
		}
		if(response.getStatus()==500){
			%><h1 style="text-align:center">Dữ liệu đầu vào sai, vui lòng nhập lại</h1><%
		}
	%>

</body>
</html>