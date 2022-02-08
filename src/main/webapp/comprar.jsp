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

			<div id="carouselExample" class="carousel-slide" data-ride="carousel">
				<ol class="carousel-indicators">
					<li data-target="#carouselExample" data-slide-to="0" class="active"></li>
					<li data-target="#carouselExample" data-slide-to="1"></li>
				</ol>
				<div class="carousel-inner">
					<div class="carousel-item active">
						<img src="img/boomerang.jpg" alt="..." class="d-block w-50">
					</div>
					<div class="carousel-item">
						<img src="img/vertigo_extremo.jpg" alt="..." class="d-block w-50">
					</div>
				</div>
				<a href="#carouselExample" class="carousel-control-prev"
					role="button" data-slide="prev"> <span
					class="carousel-control-prev-icon" aria-hidden="true"></span> <span
					class="visually-hidden">Anterior</span>
				</a> <a href="#carouselExample" class="carousel-control-next"
					role="button" data-slide="next"> <span
					class="carousel-control-next-icon" aria-hidden="true"> </span> <span
					class="visually-hidden">Siguiente</span></a>
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