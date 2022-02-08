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
		<div class="container d-flex flex-column">
			<div class="d-flex align-items-center">
				<div class="cards">
					<img class="card-img-top" src="img/vuelta_al_mundo.jpg" alt="100px">
					<div class="card-body">
						<h4 class="card-title">Vuelta al Mundo</h4>
						<p class="card-text">Altura minima requerida 0,70 m Entre
							0,70 m y 1,30 m deberan subir con un adulto responsable directo</p>
						<a href="https://youtu.be/hr1Ud3_eK6I"
							class="btn btn-primary btn-atracciones">Ver</a>
					</div>
				</div>
				<div class="cards">
					<img class="card-img-top" src="img/monza_karting.jpg" alt="100px">
					<div class="card-body">
						<h4 class="card-title">Monza Karting</h4>
						<p class="card-text">Altura minima requerida 1,60 M
							Atraccion no disponible con pista mojada</p>
						<a href="https://youtu.be/rLUT2ivwEsQ"
							class="btn btn-primary btn-atracciones">Ver</a>
					</div>
				</div>
			</div>
			<div class="d-flex align-items-center">
				<div class="cards">
					<img class="card-img-top" src="img/orcas_voladoras.jpg" alt="100px">
					<div class="card-body">
						<h4 class="card-title">Orcas Voladoras</h4>
						<p class="card-text">Altura minima requerida 1,00M No apto
							para menores de 4 años</p>
						<a href="#!" class="btn btn-primary btn-atracciones">Ver</a>
					</div>
				</div>
				<div class="cards">
					<img class="card-img-top" src="img/samba.jpg" alt="100px">
					<div class="card-body">
						<h4 class="card-title">Samba</h4>
						<p class="card-text">Altura minima requerida 1,30 M No apto
							para menores de 12 años.</p>
						<a href="https://youtu.be/cF77UItDdNc"
							class="btn btn-primary btn-atracciones">Ver</a>
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