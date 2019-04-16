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
<jsp:useBean id="sviIgraciBean" class="beans.GetSviIgraciBean"
		scope="page">
</jsp:useBean>		
	
<div class="banner_two">
				 	<div class="banner-text">

				 	<a href="/TeniskiKlubWeb/igrac/igracHome.jsp">Pocetna</a>

<form action="/TeniskiKlubWeb/ZakaziSparingServlet" method="post">
		
		<table>
		<tr><td><select name="protivnik">
			<c:forEach var="igr" items="${sviIgraciBean.sviIgraci}">
				<option value="${igr.idIgrac}">${igr.ime}&nbsp${igr.prezime}</option>
			</c:forEach>
		</select> 
		</select> </td></tr>
			<tr><td>Datum:</td><td><input type="text" name="datum"></td></tr>
						<tr><td>Teren:</td><td><input type="text" name="teren"></td></tr>
						<tr><td>Trajanje:</td><td><input type="text" name="trajanje"></td></tr>
						<tr><td>Vreme:</td><td><input type="text" name="vreme"></td></tr>
		<tr><td><input type="submit" class="btn btn-warning" value="Sacuvaj"></td></tr>
</table>
	</form>
	
	</div></div>
</body>
</html>