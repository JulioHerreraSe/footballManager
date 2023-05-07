<div class="modal fade" id="ModalUser" tabindex="-1" aria-labelledby="miModal" aria-hidden="true">
	<div class="modal-dialog">
		<div class="modal-content">
			<div class="modal-header">
			<h5 class="modal-title">Agregar Usuario</h5>
				<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			</div>
			<form action="Control?ID_ACCION=ADDUSER" method="post" >
				<div class="modal-body">
					<div class="form-group">
						<label for="name">Nombre</label>
						<input type="text" class="form-control" name="name" required>
					</div>
					<div class="form-group">
						<label for="pass">Contraseña</label>
						<input type="password" class="form-control" name="pass" required>
					</div>
				</div>
				<div class="modal-footer">
					<button class="btn btn-primary" type="submit">Agregar Usuario</button>
				</div>
			</form>
		</div>
	</div>
</div>