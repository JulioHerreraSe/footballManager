<%@ taglib uri="mistags" prefix="tag"%>
<section style="min-height: 395px">
	<div class="col-lg-11 mt-3 ms-4 ms-sm-auto">
		<a href="Control?ID_ACCION=INSERTARPARTIDO"><button type="button" class="btn btn-primary">Agregar Partido</button></a>
	</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h3 class="text-center mt-5">Listado de Partidos</h3>
				<div class="table-responsive">
					<table id="tabla" class="table table-bordered" style="width:100%">
						<thead>
							<tr>
								<th>Local</th>
								<th>Liga</th>
								<th>Visitante</th>
								<th>Fecha</th>
								<th>Goles Local</th>
								<th>Goles Visitante</th>
								<th>Editar</th>
								<th>Borrar</th>
							</tr>
						</thead>
						<tbody><tag:listarPartido/></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>
<tag:ToastPartido/>