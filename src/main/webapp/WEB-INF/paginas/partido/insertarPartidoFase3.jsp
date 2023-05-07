<%@ taglib uri="mistags" prefix="tag"%>
<jsp:include page="../comunes/imports.jsp"></jsp:include>
<title>Insertar Partido</title>
</head>
<body>
	<jsp:include page="../comunes/cabecera.jsp"></jsp:include>
	<div class="col-lg-11 mt-3 ms-4 ms-sm-auto">
		<a href="Control?ID_ACCION=LISTARPARTIDOS"><button type="button" class="btn btn-primary">Cerrar</button></a>
	</div>
	<div class="vh-100 d-flex justify-content-center pt-5">
			  <div class="container">
			  <%-- cetrar el contenido--%>
			    <div class="row d-flex justify-content-center">
			    <%-- ancho del contenido--%>
			      <div class="col-10 col-md-8 col-lg-6">
			      <%-- borde del contenido--%>
			        <div class="border border-3 border-primary"></div>
			        <%-- sombra y estilo de la caja--%>
			        <div class="card bg-white shadow-lg">
			          <div class="card-body p-5">
			          <form class="mb-3 mt-md-4" action="${pageContext.request.contextPath}/Control?ID_ACCION=INSERTARPARTIDOFASE4" method="post">
			            <tag:TagFormPartidoFase3/>
			            <div class="d-grid ">
			                <button class="btn btn-primary" type="submit">Siguente</button>
			              </div>
			            </form>
			          </div>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>
	<jsp:include page="../comunes/piedepagina.jsp"></jsp:include>
</body>
</html>
