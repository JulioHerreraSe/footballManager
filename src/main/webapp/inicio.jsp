<jsp:include page="WEB-INF/paginas/comunes/imports.jsp"></jsp:include>
<title>Inicio</title>
</head>
<body>
	<jsp:include page="WEB-INF/paginas/comunes/cabecera.jsp"></jsp:include>
	<div class="container my-5">
  	<h2>Noticias y actualizaciones</h2>
  	<div class="row">
	    <div class="col-md-6">
	  	    <div class="card mb-4">
	    	    <img class="card-img-top" src="https://via.placeholder.com/500x300" alt="Noticia 1">
	  		      <div class="card-body">
	   		       <h5 class="card-title">Título de la noticia 1</h5>
	    	      <p class="card-text">Breve descripción de la noticia 1.</p>
	     	     <a href="#" class="btn btn-primary">Leer más</a>
	     	   </div>
	     	 </div>
    	 </div>
	   	 <div class="col-md-6">
	    	  <div class="card mb-4">
	       	 <img class="card-img-top" src="https://via.placeholder.com/500x300" alt="Noticia 2">
	       	 <div class="card-body">
	        	  <h5 class="card-title">Título de la noticia 2</h5>
	         	 <p class="card-text">Breve descripción de la noticia 2.</p>
	          	<a href="#" class="btn btn-primary">Leer más</a>
	        	</div>
	      	</div>
	    </div>
	  </div>
	</div>
	<jsp:include page="WEB-INF/paginas/comunes/piedepagina.jsp"></jsp:include>
</body>
</html>