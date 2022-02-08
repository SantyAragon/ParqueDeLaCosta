<!doctype html>
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
			<div class="container">
				<div>
					<h1>Packs Extremos</h1>
				</div>
				<div id="accordion" style="padding: 30px 5px;">
					<div class="card">
						<div class="card-header" id="headingOne">
							<h5 class="mb-0">
								<button class="btn btn-link text-uppercase"
									data-toggle="collapse" data-target="#collapseOne"
									aria-expanded="true" aria-controls="collapseOne">Pack
									Extremo 1</button>
							</h5>
						</div>

						<div id="collapseOne" class="collapse justify-content-around"
							aria-labelledby="headingOne" data-parent="#accordion">
							<br>
							<p class="card-text text-center">En el Pack Extremo 1 está diseñado para poner a prueba tu resistencia a la adrenalina. 
							Comprando acceso a El desafío y Bommerang, tendrás acceso al torbellino completamente gratis.</p>
							<div class="contenedor-prom">
								<div class="card prom-card">
									<img class="prom-card-img" src="img/torbellino.jpg" alt="50px">
									<h4 class="card-title text-center">
										<a href="https://youtu.be/RGpQQOcGWqM"
											class="text-decoration-none">Boomerang</a>
									</h4>
									<p class="card-text text-center">Altura mínima requerida
										1,20 Mts. Los menores de 10 años deberán subir con un adulto
										responsable directo.</p>

								</div>
								<div class="card prom-card">
									<img class="prom-card-img" src="img/desafio.jpg" alt="50px">
									<h4 class="card-title text-center">
										<a href="https://youtu.be/DrK6pBKH-D0"
											class="text-decoration-none">Torbellino</a>
									</h4>
									<p class="card-text text-center">La altura mínima requerida
										para el ingreso1,30 M. No apto para menores de 10 años.</p>

								</div>
								<div class="card prom-card">
									<img class="prom-card-img" src="img/desafio.jpg" alt="50px">
									<h4 class="card-title text-center">
										<a href="https://youtu.be/lvgBYc96wS0"
											class="text-decoration-none">El desafío</a>
									</h4>
									<p class="card-text text-center">Altura mínima requerida
										1,30 M. Menores de 10 años deberán subir con un adulto
										responsable directo.</p>

								</div>

							</div>
							<a href="#" class="btn btn-primary btn-promociones ">Comprar
								promoción</a>
						</div>

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