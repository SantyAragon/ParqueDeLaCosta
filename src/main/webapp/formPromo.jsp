<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name" required
			value="${promocion.nombre}">
	</div>
	<div class="mb-3">
		<label for="tipoPromo"
			class='col-form-label ${promocion.errors.get("tipoPromo") != null ? "is-invalid" : "" }'>Tipo
			de Promoción:</label> <input class="form-control" type="number"
			id="tipoPromo" name="tipoPromo" required
			value="${promocion.getTipoPromocion()}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.errors.get("tipoPromo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="datoExtra"
			class='col-form-label ${promocion.errors.get("datoExtra") != null ? "is-invalid" : "" }'>Tipo
			de descuento:</label> <input step="0.01" class="form-control" type="number"
			id="datoExtra" name="datoExtra" required
			value="${promocion.getDatoExtra()}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.errors.get("datoExtra")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="tipoAtraccion"
			class='col-form-label ${promocion.errors.get("tipoAtraccion") != null ? "is-invalid" : "" }'>Tipo
			de Atracciones:</label> <input class="form-control" type="number"
			id="tipoAtraccion" name="tipoAtraccion" required
			value="${promocion.getTipoAtraccion()}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.errors.get("tipoAtraccion")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="atraccionesEnPromocion"
			class='col-form-label ${promocion.errors.get("atraccionesEnPromocion")}'>Atracciones
			en promoción:</label> <input class="form-control" type="text"
			id="atraccionesEnPromocion" name="atraccionesEnPromocion" required
			value="${promocion.convertirATexto()}"></input>
		<div class="invalid-feedback">
			<c:out value='${promocion.errors.get("atraccionesEnPromocion")}'></c:out>
		</div>
	</div>


</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>