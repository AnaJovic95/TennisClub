<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<div class="banner_two">
				 	<div class="banner-text">
						<a href="/TeniskiKlubWeb/admin/dodajIgraca.jsp">Dodaj igraca</a>
<br>
<a href="/TeniskiKlubWeb/admin/dodajTrenera.jsp">Dodaj trenera</a>
<br>
<a href="/TeniskiKlubWeb/admin/izbrisiIgraca.jsp">Izbrisi igraca</a>
<br>
<a href="/TeniskiKlubWeb/admin/izbrisiTrenera.jsp">Izbrisi trenera</a>
<br>
<a href="/TeniskiKlubWeb/admin/izmeniIgraca.jsp">Izmeni igraca</a>
<br>
<a href="/TeniskiKlubWeb/admin/izvestaji.jsp">Izvestaji</a>
					</div>
				 </div>

</body>
</html>