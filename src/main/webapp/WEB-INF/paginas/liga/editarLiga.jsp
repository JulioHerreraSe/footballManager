<jsp:include page="/WEB-INF/paginas/comunes/imports.jsp"></jsp:include>
<title>Editar Liga</title>
<%@ page import="edu.ucam.pojos.Liga" %>
<%@ taglib uri="mistags" prefix="tag"%>
<%--Recojemos el club del cotexto--%>
<% Liga liga = (Liga)request.getServletContext().getAttribute("liga");%>
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
			            <form class="mb-3 mt-md-4" action="${pageContext.request.contextPath}/Control?ID_ACCION=UPDATELIGA&idLiga=<%=liga.getId() %>" method="post">
			              <h2 class="fw-bold text-uppercase mb-4">Editar Liga</h2>
			              <div class="form-group mb-4">
			                <label for="nombre" class="form-label ">Nombre</label>
			                <input type="text" class="form-control" id="nombre" name="nombre" value="<%=liga.getNombre() %>" required>
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