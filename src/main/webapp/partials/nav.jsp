<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar container-l ">
	<div class="navbar_elements">
		<img src="img\logo_inicio_azul.png">
	</div>
	<div class="navbar_centro">
		<div>
			<a class="link_navbar" href="index.do">Inicio</a>
		</div>
		<div class="dropdown-container">
			<span>Atracciones</span>
			<ul>
				<li><a class="link_navbar" href="extremo.jsp">Paseo Extremo</a></li>
				<li><a class="link_navbar" href="familiar.jsp">Paseo
						Familiar</a></li>
				<li><a class="link_navbar" href="plano.jsp">Paseo Plano</a></li>
				<li><a class="link_navbar" href="oscuro.jsp">Paseo Oscuro</a></li>

			</ul>
		</div>
		<div class="dropdown-container">
			<span>Promociones</span>
			<ul>
				<li><a class="link_navbar" href="packextremo.jsp">Packs
						Extremos</a></li>
				<li><a class="link_navbar" href="packfamiliar.jsp">Packs
						Familiares</a></li>
				<li><a class="link_navbar" href="packplano.jsp">Packs
						Planos</a></li>
				<li><a class="link_navbar" href="packoscuro.jsp">Packs
						Oscuros</a></li>

			</ul>
		</div>
		<div class="dropdown-container">

			<span><c:out value="${user.nombre}"></c:out></span>
			<ul>
				<li><a class="link_navbar" href="listBuy.do?id=${user.tipo}">Comprar</a></li>
				<li><a class="link_navbar"
					href="itinerario.do?id=${user.idUsuario}">Itinerario</a></li>
				<li><a class="link_navbar" href="perfil.jsp">Mi Perfil</a></li>
				<li><a class="link_navbar" href="logout">Salir</a></li>
			</ul>
		</div>
	</div>
	<!-- 	<div class="navbar_elements"> -->
	<!-- 		<a href="login.jsp"><button type="button" -->
	<!-- 				class="btn btn-outline-primary">LOGIN</button></a> -->
	<!-- 	</div> -->
</nav>