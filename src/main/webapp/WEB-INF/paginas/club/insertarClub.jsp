<%@ taglib uri="mistags" prefix="tag"%>
<div class="modal fade" id="ModalClub" tabindex="-1" aria-labelledby="miModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h5 class="modal-title">Agregar Club</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<form action="Control?ID_ACCION=ADDCLUB" method="post" >
				<div class="modal-body">
					<div class="form-group">
						<label for="nombre">Nombre</label>
						<input type="text" class="form-control" name="nombre" required>
					</div>
					<div class="form-group">
						<label for="idLiga">Liga</label>
						<select class="form-select" name="idLiga" aria-label="Liga">
							<tag:selectLiga/>
						</select>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="submit">Agregar Club</button>
				</div>
			</form>
		</div>
	</div>
</div>