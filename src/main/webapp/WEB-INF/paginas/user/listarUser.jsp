<%@ taglib uri="mistags" prefix="tag"%>
<section style="min-height: 395px">
	<div class="col-lg-11 mt-3 ms-4 ms-sm-auto">
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#ModalUser">Agregar Usuario</button>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h3 class="text-center mt-5">Listado de usuarios</h3>
					<div class="table-responsive">
						<table id="tabla" class="table table-bordered" style="width:100%">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Contraseña</th>
								<th>Editar</th>
								<th>Borrar</th>
							</tr>
						</thead>
						<tbody>
							<tag:listarUser/>
						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>
<tag:ToastUser/>