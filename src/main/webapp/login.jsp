<!doctype html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<jsp:include page="partials/head.jsp"></jsp:include>

</head>
<body>
	<!-- - -->
	<section class="login">
		<div class="alerts">
			<c:if test="${flash != null}">
				<div class="alert alert-danger">
					<p>
						<c:out value="${flash}" />
					</p>
				</div>
			</c:if>
		</div>
		<form class="form_login" action="login" method="post">
			<div id="login-box" class="col-12 col-lg-5 ms-auto">
				<div class="p-5 bg-light rounded text-center">

					<span class="text-muted">Bienvenido</span>
					<h3 class="fw-bold mb-5">Ingrese para realizar su compra</h3>
					<div class="item">
						<label for="username" class="fa fa-user-circle" aria-hidden="true"></label>
						<input class="form-control mb-2" type="text" placeholder="Usuario"
							name="username">
					</div>
					<div class="item">
						<label for="password" class="fa fa-key" aria-hidden="true"></label>
						<input class="form-control mb-2" type="password"
							placeholder="Password" name="password">
					</div>

					<button action="index.jsp" type="submit"
						class="button btn btn-primary py-0 w-100 mb-4">Ingresar</button>

					<a class="link-secondary d-inline-block mb-4" href="#"> <small>Olvido
							su contraseña?</small>
					</a>

				</div>
			</div>
		</form>
	</section>

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
