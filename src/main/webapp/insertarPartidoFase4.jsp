<%@ taglib uri="mistags" prefix="tag"%>
<jsp:include page="WEB-INF/paginas/comunes/imports.jsp"></jsp:include>
<title>Insertar Partido</title>
</head>
<body>
	<jsp:include page="WEB-INF/paginas/comunes/cabecera.jsp"></jsp:include>
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
			          <form class="mb-3 mt-md-4" action="${pageContext.request.contextPath}/Control?ID_ACCION=ADDPARTIDO" method="post">
			            <tag:TagFormPartidoFase4/>
			            <div class="d-grid ">
			                <button class="btn btn-primary" type="submit">Añadir partido</button>
			              </div>
			            </form>
			          </div>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>
	<jsp:include page="WEB-INF/paginas/comunes/piedepagina.jsp"></jsp:include>
</body>
</html>
