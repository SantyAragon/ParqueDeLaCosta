<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/partials/head.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/partials/nav.jsp"></jsp:include>

	<main class="container">
		<section>
			<c:if test="${attraction != null && !attraction.isValid()}">
				<div class="alert alert-danger">
					<p>Se encontraron errores al actualizar la atracción.</p>
				</div>
			</c:if>
			
			<div class="bg-light p-4 mb-3 rounded">
			<h1>Modificar atracciones de Parque de la Costa</h1>
		</div>

			<form action="edit.do" method="post">
				<input type="hidden" name="id" value="${attraction.idAtraccion}">
				<jsp:include page="/form.jsp"></jsp:include>
			</form>
		</section>
	</main>
</body>
</html>