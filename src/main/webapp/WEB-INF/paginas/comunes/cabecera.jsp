<%@ taglib uri="mistags" prefix="tag" %>
<header class="bg-dark p-2 border-4 border-bottom border-primary">
	<div class="container">
		<div class="col-lg text-center text-white">
			<h1>Football Manager</h1>
		</div>
	</div>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark" >
	  <div class="container-fluid">
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link"  href="inicio.jsp">Inicio</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="Control?ID_ACCION=LISTARLIGAS">Ligas</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="Control?ID_ACCION=LISTARCLUBS">Clubs</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="Control?ID_ACCION=LISTARJUGADORES">Jugadores</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="Control?ID_ACCION=LISTARPARTIDOS">Partidos</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="Control?ID_ACCION=CLASIFICACIONES&idLiga=0">Clasificaciones</a>
	        </li>
	        <tag:TagCabecera/>
	      </ul>
	      <form class="d-flex" action="Control?ID_ACCION=LOGOUT" method="post">
	        <button class="btn btn-outline-primary" type="submit">Cerrar Sesion</button>
	      </form>
	    </div>
	  </div>
	</nav>
</header>

