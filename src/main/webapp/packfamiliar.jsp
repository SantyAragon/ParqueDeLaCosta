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

		<div class="container">
			<div>
				<h1>Packs Familiares</h1>
			</div>
			<div id="accordion" style="padding: 30px 5px;">
				<div class="card">
					<div class="card-header" id="headingOne">
						<h5 class="mb-0">
							<button class="btn btn-link text-uppercase"
								data-toggle="collapse" data-target="#collapseOne"
								aria-expanded="true" aria-controls="collapseOne">Pack
								Familiar 1</button>
						</h5>
					</div>

					<div id="collapseOne" class="collapse justify-content-around"
						aria-labelledby="headingOne" data-parent="#accordion">
						<br>
						<p class="card-text text-center">En el Pack Familiar 1
							disponés de las tres atracciones más populares para toda la
							familia. Monza Karting, Samba y Orcas voladoras a tan solo $600.</p>
						<div class="contenedor-prom">
							<div class="card prom-card">
								<img class="prom-card-img" src="img/monza_karting.jpg"
									alt="50px">
								<h4 class="card-title text-center">
									<a href="https://youtu.be/rLUT2ivwEsQ"
										class="text-decoration-none">Monza Karting</a>
								</h4>
								<p class="card-text text-center">Altura minima requerida
									1,60 Mts. Atraccion no disponible con pista mojada</p>

							</div>
							<div class="card prom-card">
								<img class="prom-card-img" src="img/orcas_voladoras.jpg"
									alt="50px">
								<h4 class="card-title text-center">
									<a href="" class="text-decoration-none">Orcas Voladoras</a>
								</h4>
								<p class="card-text text-center">Altura minima requerida
									1,00Mts. No apto para menores de 4 años</p>

							</div>
							<div class="card prom-card">
								<img class="prom-card-img" src="img/samba.jpg" alt="50px">
								<h4 class="card-title text-center">
									<a href="https://youtu.be/cF77UItDdNc"
										class="text-decoration-none">Samba</a>
								</h4>
								<p class="card-text text-center">Altura minima requerida
									1,30Mts. No apto para menores de 12 años.</p>

							</div>
							
						</div>
						<a href="#" class="btn btn-primary btn-promociones ">Comprar
							promoción</a>
					</div>

				</div>
				<br>
				<div class="card">
					<div class="card-header" id="headingTwo">
						<h2 class="mb-0">
							<button class="btn btn-link collapsed text-uppercase"
								data-toggle="collapse" data-target="#collapseTwo"
								aria-expanded="false" aria-controls="collapseTwo">Pack
								Familiar 2</button>
						</h2>
					</div>
					<div id="collapseTwo" class="collapse" aria-labelledby="headingTwo"
						data-parent="#accordion">
						<br>
						<p class="card-text text-center">Con el Pack Familiar 2 te
							llevás Samba y La vuelta al Mundo con un 25% de descuento.</p>
						<div class="contenedor-prom">
							<div class="card prom-card">
								<img class="prom-card-img" src="img/vuelta_al_mundo.jpg"
									alt="50px">
								<h4 class="card-title text-center">
									<a href="https://youtu.be/hr1Ud3_eK6I"
										class="text-decoration-none">Vuelta al Mundo</a>
								</h4>
								<p class="card-text text-center">Altura mínima requerida
									0,70Mts. Los menores deberan subir con un adulto.</p>

							</div>
							<div class="card prom-card">
								<img class="prom-card-img" src="img/samba.jpg" alt="50px">
								<h4 class="card-title text-center">
									<a href="https://youtu.be/cF77UItDdNc"
										class="text-decoration-none">Samba</a>
								</h4>
								<p class="card-text text-center">Altura minima requerida
									1,30Mts. No apto para menores de 12 años.</p>

							</div>
						</div>
						<a href="#" class="btn btn-primary btn-promociones ">Comprar
							promoción</a>
					</div>
				</div>

			</div>

		</div>
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