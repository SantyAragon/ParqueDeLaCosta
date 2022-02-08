<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<html lang="en">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>
</head>
<body>
	<header>
		<jsp:include page="partials/nav.jsp"></jsp:include>
	</header>
	<!-- - -->
	<section>
		<div class="container"></div>
	</section>
	<c:if test="${user.isAdmin()}">

	</c:if>
	<div class="container">
		<h1>
			Este es el itinerario del usuario:
			<c:out value="${user.nombre}"></c:out>
		</h1>
					
	</div>



	<h1>Estas son las atracciones y promociones que adquiriste</h1>



	<p>


		<c:if test="${flash != null}">
			<div class="alert alert-danger">
				<p>
					<c:out value="${flash}" />
					<c:if test="${errors != null}">
						<ul>
							<c:forEach items="${errors}" var="entry">
								<li><c:out value="${entry.getValue()}"></c:out></li>
							</c:forEach>
						</ul>
					</c:if>
				</p>
			</div>
		</c:if>
	<table class="table table-stripped table-hover">
		<thead>
			<tr>
				<th>Atraccion</th>
				<th>Costo</th>
				<th>Duracion</th>
				<th>Cupo</th>
			</tr>
		</thead>
		<tbody>
			<!-- 					Hallar por el id del itinerario -->
			<c:forEach items="${compradas}" var="comprada">
				<tr>




					<td><strong><c:out value="${comprada.nombre}"></c:out></strong>
						<p>
							<c:out value="${comprada.getDescripcion()}"></c:out>
						</p></td>


					<%-- 							<td><c:out value="${oferta.costo}"></c:out></td> --%>

					<td><fmt:formatNumber type="number" maxFractionDigits="3"
							value="${comprada.costo}" /></td>
					<td><c:out value="${comprada.tiempo}"></c:out></td>
					<td><c:out value="${comprada.cupo}"></c:out></td>


				</tr>
			</c:forEach>
		</tbody>


	</table>




	<!-- jQuery library -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

	<!-- Popper JS -->
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>

	<!-- Latest compiled JavaScript -->
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>