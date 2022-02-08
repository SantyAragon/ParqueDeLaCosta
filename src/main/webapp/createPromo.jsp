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
	<section>
		<main class="container">

			<c:if test="${promocion != null && !promocion.isValid()}">
				<div class="alert alert-danger">
					<p>Se encontraron errores al crear la promocion.</p>
				</div>
			</c:if>

			<form action="createPromo.do" method="post">
				<jsp:include page="/formPromo.jsp"></jsp:include>
			</form>
		</main>
	</section>
</body>
</html>