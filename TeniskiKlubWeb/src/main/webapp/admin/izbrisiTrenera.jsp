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

 <link href="<%= request.getContextPath() %>/css/bootstrap.css" rel='stylesheet' type='text/css'/>
<link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css" type="text/css">
<script src="<%= request.getContextPath() %>/js/jquery.min.js"></script>
<script src="<%= request.getContextPath() %>/js/responsiveslides.min.js"></script>
<title>Teniski klub</title>
</head>
<body>
<div class="banner_two">
				 	<div class="banner-text">
<a href="/TeniskiKlubWeb/admin/adminHome.jsp">Pocetna</a>

	<jsp:useBean id="sviTreneriBean" class="beans.GetSviTreneriBean"
		scope="page"></jsp:useBean>
	<form action="/TeniskiKlubWeb/IzbrisiTreneraServlet" method="post">
		<select name="trener">
			<c:forEach var="tren" items="${sviTreneriBean.sviTreneri}">
				<option value="${tren.idTrener}">${tren.ime}&nbsp${tren.prezime}</option>
			</c:forEach>
		</select> <input type="submit"  class="btn btn-danger" value="Obrisi">

	</form>
</div></div>
</body>
</html>