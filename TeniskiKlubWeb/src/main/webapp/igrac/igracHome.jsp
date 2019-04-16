<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<br>
<div class="banner_two">
				 	<div class="banner-text">
<a href="/TeniskiKlubWeb/igrac/zakaziTrening.jsp">Zakazi trening</a>
<br>
<a href="/TeniskiKlubWeb/igrac/zakaziSparing.jsp">Zakazi sparing</a>
<br>
<a href="/TeniskiKlubWeb/igrac/pregledRasporeda.jsp">Pregled rasporeda</a>
<br>
<a href="/TeniskiKlubWeb/igrac/prijavaZaTurnir.jsp">Prijava turnira</a>
<br>
<a href="/TeniskiKlubWeb/igrac/promenaLozinke.jsp">Izmena lozinke</a>
<br>
</div></div>
</body>
</html>