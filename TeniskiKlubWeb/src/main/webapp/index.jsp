<%@ page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="en_US" scope="session" /><html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Teniski klub</title>
<link href="css/bootstrap.css" rel='stylesheet' type='text/css'/>
<link rel="stylesheet" href="css/style.css" type="text/css">
<script src="js/jquery.min.js"></script>
<script src="js/responsiveslides.min.js"></script>
<script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
</head>
<body>

<div class="slider w3layouts">	  
	  <div class="callbacks_container">
	      <ul class="rslides" id="slider">
	         <li>
				 <div class="banner">
				 	<div class="banner-text">
					 	<h1>Dobro dosli</h1>
						<h2>Odaberite nacin logovanja</h2>
<a href="/TeniskiKlubWeb/admin/adminLogin.jsp">Administratorski</a>
<a href="/TeniskiKlubWeb/igrac/igracLogin.jsp">Korisnik sistema</a>
<br>
${loginFailed}
					</div>
				 </div>
	         </li>
	         <li>
				 <div class="banner_two">
				 	<div class="banner-text">
					 	<h1>Dobro dosli</h1>
						<h2>Odaberite nacin logovanja</h2>
<a href="/TeniskiKlubWeb/admin/adminLogin.jsp">Administratorski</a>
<a href="/TeniskiKlubWeb/igrac/igracLogin.jsp">Korisnik sistema</a>
<br>
${loginFailed}

					</div>
				 </div>
	         </li>
	         <li>
				 <div class="banner_three">
				 	<div class="banner-text">
					 		<h1>Dobro dosli</h1>
						<h2>Odaberite nacin logovanja</h2>
<a href="/TeniskiKlubWeb/admin/adminLogin.jsp">Administratorski</a>
<a href="/TeniskiKlubWeb/igrac/igracLogin.jsp">Korisnik sistema</a>
<br>
${loginFailed}

					</div>
				 </div>
	         </li>
	      </ul>	      
      </div>
</div>
</body>
</html>
