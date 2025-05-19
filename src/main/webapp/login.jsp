<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><
    <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>PaginaHt</title>
        <link rel="stylesheet" type="text/css" href="estilos/baseLogin.css"/>

</head>
<body>
<header>Pagina para registro de alumnos</header>

    <header>
           <nav>
               <ul>
                   <li><a href="">Inicio</a></li>
                   <li><a href="">Acerca de</a></li>
                   <li><a href="z">Contacto</a></li>
               </ul>
           </nav>
       </header>

       <main>
           <h1>Bienvenido a mi pagina</h1>
           <p>Esta es una página para demostrar el funcionamiento de mi servidor proxy inverso con ngnix.</p>
           <div class="contenedores">
               <h2>Hero Section</h2>
               <p>Esta es una sección destacada de la página.</p>
               <div class="content">
                   <h3>Contenido Principal</h3>
                   <p>Aquí puedes agregar el contenido principal de tu página.</p>
               </div>
                <div class="proxy-info">
                   <p><strong>IP del Servidor Flask:</strong> {{ server_ip }}</p>
                   <p><strong>Hora del Servidor:</strong> {{ server_time }}</p>
               </div>

           </div>
       </main>

       <footer>
           <p>&copy; 2025 PaginaHt. Todos los derechos reservados pa mi.</p>
       </footer>
</body>
</html>