<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="en_US" scope="session" />
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
<a href="/TeniskiKlubWeb/admin/adminHome.jsp">Pocetna</a>

			<form action="/TeniskiKlubWeb/DodajTreneraServlet" method="post">
<table>
			<tr><td>Ime:</td><td><input type="text" name="ime"></td></tr>
			<tr><td>Prezime:</td><td><input type="text" name="prezime"></td></tr>
						<tr><td>Adresa:</td><td><input type="text" name="adresa"></td></tr>
			
			<tr><td>Datum rodjenja (yyyy/MM/dd):</td><td><input type="text" name="datumRodjenja"></td></tr>

				<tr><td>Licenca</td><td><input type="text" name="licenca"></td></tr>
				 <tr><td><input type="submit" class="btn btn-info" value="Snimi"></td></tr>
		</table>
		${poruka}
		</div>
	</div>
	</form>
</body>
</html>