<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="modal-body">
	<div class="mb-3">
		<label for="name" class="col-form-label">Nombre:</label> <input
			type="text" class="form-control" id="name" name="name" required
			value="${attraction.nombre}">
	</div>
	<div class="mb-3">
		<label for="cost"
			class='col-form-label ${attraction.errors.get("costo") != null ? "is-invalid" : "" }'>Costo:</label>
		<input class="form-control" type="number" id="cost" name="cost"
			required value="${attraction.costo}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("costo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="duration"
			class='col-form-label ${attraction.errors.get("duracion") != null ? "is-invalid" : "" }'>Duracion:</label>
		<input step="0.01" class="form-control" type="number" id="duration"
			name="duration" required value="${attraction.tiempo}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("duracion")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="capacity"
			class='col-form-label ${attraction.errors.get("cupo") != null ? "is-invalid" : "" }'>Cupo:</label>
		<input class="form-control" type="number" id="capacity"
			name="capacity" required value="${attraction.cupo}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("cupo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="tipo"
			class='col-form-label ${attraction.errors.get("tipo") != null ? "is-invalid" : "" }'>Tipo:</label>
		<input class="form-control" type="number" id="tipo" name="tipo"
			required value="${attraction.getTipoAtraccion()}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("tipo")}'></c:out>
		</div>
	</div>
	<div class="mb-3">
		<label for="descripcion"
			class='col-form-label ${attraction.errors.get("descripcion") != null ? "is-invalid" : "" }'>Descripcion:</label>
		<input class="form-control" type="text" id="descripcion" name="descripcion"
			required value="${attraction.descripcion}"></input>
		<div class="invalid-feedback">
			<c:out value='${attraction.errors.get("descripcion")}'></c:out>
		</div>
	</div>


</div>
<div>
	<button type="submit" class="btn btn-primary">Guardar</button>
	<a onclick="window.history.back();" class="btn btn-secondary"
		role="button">Cancelar</a>
</div>