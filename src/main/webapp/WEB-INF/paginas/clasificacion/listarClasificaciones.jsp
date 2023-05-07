<%@ taglib uri="mistags" prefix="tag"%>
<section style="min-height: 395px">
<div class=" col-2 mt-3 mx-auto">
	<h4 class="text-center">Seleccionar liga</h4>
	<form action="Control?ID_ACCION=CLASIFICACIONES" method="post">
		<select class="form-select" name="idLiga" aria-label="Liga" onchange="this.form.submit()">
			<tag:selectLiga/>
		</select>
	</form>
</div>
	<div class="container">
		<div class="row justify-content-start">
			<div class="col-12">
				<h3 class="text-center mt-5">Clasificación</h3>
				<div class="table-responsive">
					<table id="tabla" class="table table-striped table-bordered text-center" style="width:100%">
						<thead>
							<tr>
								<th>Posición</th>
								<th>Nombre</th>
								<th>Puntos</th>
								<th>Partidos ganados</th>
								<th>Partidos empatados</th>
								<th>Partidos perdidos</th>
								<th>Goles a favor</th>
								<th>Goles en contra</th>
							</tr>
						</thead>
						<tbody><tag:TagClasificaciones/></tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</section>
<tag:TotastClub/>