<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="en_US" scope="session" /><!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teniski klub</title>

 <link href="<%= request.getContextPath() %>/css/bootstrap.css" rel='stylesheet' type='text/css'/>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
<script src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/responsiveslides.min.js"></script>
</head>
<body>
<div class="banner_three">
				 	<div class="banner-text">
				 	<a href="/TeniskiKlubWeb/igrac/igracHome.jsp">Pocetna</a>
				 	
<form action="/TeniskiKlubWeb/PregledRasporedaServlet" method="get">
	<input type="text" name="datumOd">
	<input type="text" name="datumDo">
	<input type="submit" class="btn btn-warning" value="Prikazi"> 
</form>


	<c:if test="${!empty sparinzi}">

<table border="1">
	<tr><th>Igrac 1</th><th>Igrac 2</th><th>Datum</th><th>Vreme</th><th>Teren</th></tr>
	<c:forEach var="sparing" items="${sparinzi}">
		<tr><td>${sparing.igrac1.ime}&nbsp${sparing.igrac1.prezime }</td><td>${sparing.igrac2.ime}&nbsp${sparing.igrac2.prezime }</td><td>${sparing.termin.datum}</td>
		<td>${sparing.termin.vreme}</td><td>${sparing.termin.teren}</td></tr>
	</c:forEach>
	</table>
	</c:if>
<br>
<br>


<c:if test="${!empty treninzi }">
<table border="1">
	<tr><th>Igrac</th><th>Trener</th><th>Datum</th><th>Vreme</th><th>Teren</th></tr>
	<c:forEach var="trening" items="${treninzi}">
		<tr><td>${trening.igrac.ime}&nbsp${trening.igrac.prezime }</td><td>${trening.trener.ime}&nbsp${trening.trener.prezime }</td><td>${trening.termin.datum}</td>
		<td>${trening.termin.vreme}</td><td>${trening.termin.teren}</td></tr>
	</c:forEach>
	</table>
	</c:if>
</div></div>
</body>
</html>