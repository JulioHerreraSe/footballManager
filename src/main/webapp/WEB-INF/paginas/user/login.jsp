<jsp:include page="/WEB-INF/paginas/comunes/imports.jsp"></jsp:include>
<title>Login</title>
</head>
	<body>
		<header class="bg-dark p-5 border-4 border-bottom border-primary">
			<div class="container">
				<div class="text-center text-white">
					<h1>Football Manager</h1>
				</div>
			</div>
		</header>
			<%-- Altura de la pagina--%>
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
			            <form class="mb-3 mt-md-4" action="${pageContext.request.contextPath}/Control?ID_ACCION=LOGIN" method="post">
			              <h2 class="fw-bold text-uppercase mb-4">Iniciar Sesion</h2>
			              <div class="form-group mb-4">
			                <label for="name" class="form-label ">Nombre de usuario</label>
			                <input type="text" class="form-control" id="name" name="nameLogin" placeholder="pedro" required>
			              </div>
			              <div class="form-group mb-4">
			                <label for="pass" class="form-label ">Contraseña</label>
			                <input type="password" class="form-control" id="pass" name="pass" placeholder="*******" required>
			              </div>
			              <div class="d-grid ">
			                <button class="btn btn-primary" type="submit">Iniciar sesión</button>
			              </div>
			            </form>
			           <div>
	                  <p class="mb-0  text-center"><%=request.getServletContext().getAttribute("MSG_ERROR") %></p>
	                </div>
			          </div>
			        </div>
			      </div>
			    </div>
			  </div>
			</div>
		<jsp:include page="/WEB-INF/paginas/comunes/piedepagina.jsp"></jsp:include>
	</body>
</html>