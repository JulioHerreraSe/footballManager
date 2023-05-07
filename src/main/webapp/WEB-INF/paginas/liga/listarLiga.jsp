<%@ taglib uri="mistags" prefix="tag"%>
<section style="min-height: 395px">
<div class="col-11 mt-3 ms-auto">
	<button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#ModalLiga">Agregar liga</button>
</div>
	<div class="container">
		<div class="row">
			<div class="col-lg-12">
				<h3 class="text-center mt-5">Listado de ligas</h3>
					<div class="table-responsive">
						<table id="tabla" class="table table-bordered" style="width:100%">
							<thead>
								<tr>
									<th>Nombre</th>
									<th>Clubs</th>
									<th>Editar</th>
									<th>Borrar</th>
								</tr>
							</thead>
							<tbody>
								<tag:listarLiga/>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
</section>
<tag:ToastLiga/>