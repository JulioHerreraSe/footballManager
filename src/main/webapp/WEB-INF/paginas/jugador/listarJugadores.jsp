<%@ taglib uri="mistags" prefix="tag"%>
<section style="min-height: 395px">
	<div class="col-11 mt-3 ms-auto">
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#ModalJugador">Agregar Jugador</button>
	</div>
	<div class="container">
		<div class="row justify-content-start">
			<div class="col-12">
				<h3 class="text-center mt-5">Listado de jugadores</h3>
				<div class="table-responsive">
					<table id="tabla" class="table table-bordered" style="width:100%">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Apellido</th>
								<th>Posicion</th>
								<th>Dorsal</th>
								<th>Equipo</th>
								<th class="text-center">Editar</th>
								<th class="text-center">Borrar</th>
							</tr>
						</thead>
						<tbody><tag:listarJugador/></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>
<tag:TotastJugador/>