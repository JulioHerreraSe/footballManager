<jsp:include page="/WEB-INF/paginas/comunes/imports.jsp"></jsp:include>
<title>Editar Jugador</title>
<%@ page import="edu.ucam.pojos.Jugador" %>
<%@ taglib uri="mistags" prefix="tag"%>
<% Jugador jugador = (Jugador)request.getServletContext().getAttribute("jugador");%>
</head>
	<body>
		<jsp:include page="/WEB-INF/paginas/comunes/cabecera.jsp"></jsp:include>
			<%-- Altura de la pagina--%>
			<div class="vh-100 d-flex justify-content-center pt-5 ">
			  <div class="container mb-5">
			  <%-- cetrar el contenido--%>
			    <div class="row d-flex justify-content-center ">
			    <%-- ancho del contenido--%>
			      <div class="col-12 col-md-8 col-lg-6 ">
			      <%-- borde del contenido--%>
			        <div class="border border-3 border-primary"></div>
			        <%-- sombra y estilo de la caja--%>
			        <div class="card bg-white shadow-lg ">
			          <div class="card-body p-5 ">
			            <form class="mb-3 mt-md-4" action="${pageContext.request.contextPath}/Control?ID_ACCION=UPDATEJUGADOR&idJugador=<%=jugador.getId() %>" method="post">
			              <h2 class="fw-bold text-uppercase mb-4">Editar Jugador</h2>
			              <div class="form-group mb-4">
			                <label for="nombre" class="form-label ">Nombre</label>
			                <input type="text" class="form-control" id="nombre" name="nombre" value="<%=jugador.getNombre() %>" required>
			              </div>
			              <div class="form-group mb-4">
			                <label for="apellido" class="form-label ">Apellido</label>
			                <input type="text" class="form-control" id="apellido" name="apellido" value="<%=jugador.getApellido() %>">
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
			              <div class="form-group mb-4">
			                <label for="dorsal" class="form-label ">Dorsal</label>
			                <input type="number" class="form-control" id="dorsal" name="dorsal" min="1" pattern="^[0-9]+" max="99" value="<%=jugador.getDorsal() %>"required>
			              </div>
			              <div class="form-group mb-4">
			                <label for="idClub">Club</label>
							<select class="form-select" name="idClub" aria-label="Club">
								<tag:selectClub/>
							</select>
			              </div>
			              <div class="d-grid ">
			                <button class="btn btn-primary" type="submit">Actualizar</button>
			              </div>
			            </form>
			          </div>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>
		<jsp:include page="/WEB-INF/paginas/comunes/piedepagina.jsp"></jsp:include>
	</body>
</html>