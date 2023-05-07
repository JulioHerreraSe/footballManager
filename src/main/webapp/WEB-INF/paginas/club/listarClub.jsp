<%@ taglib uri="mistags" prefix="tag"%>
<section style="min-height: 395px">
	<div class="col-lg-11 mt-3 ms-4 ms-sm-auto">
		<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#ModalClub">Agregar Club</button>
	</div>
	<div class="container">
		<div class="row justify-content-start">
			<div class="col-12 col-lg-9">
				<h3 class="text-center mt-5">Listado de clubs</h3>
				<div class="table-responsive">
					<table id="tabla" class="table table-bordered" style="width:100%">
						<thead>
							<tr>
								<th>Nombre</th>
								<th>Liga</th>
								<th>Jugadores</th>
								<th>Editar</th>
								<th>Borrar</th>
							</tr>
						</thead>
						<tbody><tag:listarClub/></tbody>
					</table>
				</div>
			</div>
			<div class="col-lg-3 col-12 p-5">
				<h3 class="pb-3">Añadir jugador</h3>
				<form action="Control?ID_ACCION=ADDJUGADORCLUB" method="post">
					<h4>Club</h4>
					<select class="form-select" name="idClub" aria-label="Club">
						<option value="0">Seleccionar Club</option>
						<tag:selectClub/>
					</select>
					<h4>Jugador</h4>
					<select class="form-select" name="idJugador" aria-label="Jugador">
						<option value="0">Seleccionar Jugador</option>
						<tag:selectJugador/>
					</select>
					<button class="btn btn-primary mt-3" type="submit">Añadir</button>
				</form>
			</div>
		</div>
	</div>
</section>
<tag:TotastClub/>