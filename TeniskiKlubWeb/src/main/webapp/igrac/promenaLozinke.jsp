<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Teniski klub</title>

 <link href="<%= request.getContextPath() %>/css/bootstrap.css" rel='stylesheet' type='text/css'/>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
<script src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/responsiveslides.min.js"></script>
</head>
<body>
<div class="banner_two">
				 	<div class="banner-text">
				 					 	<a href="/TeniskiKlubWeb/igrac/igracHome.jsp">Pocetna</a>
				 	
				 	<form action="/TeniskiKlubWeb/IzmenaLozinkeServlet" method="get">
	<input type="password" name="staraLozinka">
	<input type="password" name="novaLozinka">
	<input type="password" name="novaLozinka2">
	<input type="submit" class="btn btn-warning" value="Promeni"> 
</form>
</div>
</div>
</body>
</html>