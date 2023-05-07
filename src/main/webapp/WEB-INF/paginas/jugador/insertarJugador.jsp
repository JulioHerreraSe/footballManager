<%@ taglib uri="mistags" prefix="tag"%>
<div class="modal fade" id="ModalJugador" tabindex="-1" aria-labelledby="miModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h5 class="modal-title">Agregar Jugador</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<form action="Control?ID_ACCION=ADDJUGADOR" method="post" >
				<div class="modal-body">
					<div class="form-group">
						<label for="nombre">Nombre</label>
						<input type="text" class="form-control" name="nombre" required>
					</div>
					<div class="form-group">
						<label for="apellido">Apellido</label>
						<input type="text" class="form-control" name="apellido">
					</div>
					<div class="form-group">
						<label for="posicion">Posicion</label>
						<select class="form-select" name="posicion" aria-label="Posicion" required>
							<option value="Portero">Portero</option>
							<option value="Defensa">Defensa</option>
							<option value="Centrocampista">Centrocampista</option>
							<option value="Delantero">Delantero</option>
						</select>
					</div>
					<div class="form-group">
						<label for="dorsal">Dorsal</label>
						<input type="number" class="form-control" name="dorsal" min="1" pattern="^[0-9]+" max="99" required>
					</div>
					<div class="form-group">
						<label for="idClub">Club</label>
						<select class="form-select" name="idClub" aria-label="Club">
							<option value="1" selected>Sin Club</option>
							<tag:selectClub/>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="submit">Agregar Jugador</button>
				</div>
			</form>
		</div>
	</div>
</div>