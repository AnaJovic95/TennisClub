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

	<jsp:useBean id="sviIgraciBean" class="beans.GetSviIgraciBean"
		scope="page"></jsp:useBean>
	<form action="/TeniskiKlubWeb/IzmeniIgracaServlet" method="get">
		<select name="igrac">
			<c:forEach var="igr" items="${sviIgraciBean.sviIgraci}">
				<option value="${igr.idIgrac}">${igr.ime}&nbsp${igr.prezime}</option>
			</c:forEach>
		</select> 
<input type="submit" class="btn btn-success" value="Izmeni">
	</form>
	
	<c:if test="${!empty igracZaIzmenu }">
		<form action="/TeniskiKlubWeb/IzmeniIgracaServlet" method="post">
			<table>
			<tr><td>Id:</td><td><input type="hidden" name="idIgraca" value="${igracZaIzmenu.idIgrac }"></td></tr>
			<tr><td>Ime:</td><td><input type="text" name="ime" value="${igracZaIzmenu.ime }"></td></tr>
			<tr><td>Prezime:</td><td><input type="text" name="prezime" value="${igracZaIzmenu.prezime }"></td></tr>
			<tr><td>Datum rođenja (yyyy/MM/dd):</td><td><input type="text" name="datumRodjenja" value="${igracZaIzmenu.datumRodjenja }"></td></tr>
			<tr><td>Pol:</td><td><input type="text" name="pol" value="${igracZaIzmenu.pol }"></td></tr>
			<tr><td>Adresa:</td><td><input type="text" name="adresa" value="${igracZaIzmenu.adresa }"></td></tr>
			
			<tr><td>Lekarski pregled traje do:</td><td>${lekarski.datumDoKadaVazi }</td><td>Obavljen novi lekarski pregled:</td><td><input type="checkbox" name="uradjenMedicinskiPregled"> </td></tr>
			
			
			<tr><td>Poslednja clanarina uplacena:</td><td>${clanarina.datumUplate }</td><td>Uplacena clanarina:</td><td><input type="checkbox" name="uplacenaClanarina"> </td></tr>
			
			
			<tr><td></td><td><input type="submit"  class="btn btn-success" value="Izmeni"></td></tr>
		</table>
	</c:if>
	${porukaIzmena}
</div></div>
</body>
</html>