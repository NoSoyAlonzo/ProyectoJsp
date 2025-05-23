<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="es">
<head>
 <meta charset="UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1.0">
 <title>Iniciar Sesion</title>

 <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.5/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-SgOJa3DmI69IUzQ2PVdRZhwQ+dy64/BUtbMJw1MZ8t5HZApcHrRKUc4W0kG879m7" crossorigin="anonymous">
 <link rel="stylesheet" href="CSS/Style.css">
</head>

<body>
    <div class="container mt-5">
    <div class="row align-items-center">

    <!-- Imagen a la izquierda -->
    <div class="col-md-6 mb-4 mb-md-0">
        <img src="Imagenes/imagen.png" alt="Imagen decorativa" class="login-image" style="width: 300px; height: auto;">
    </div>
    <!-- Hace falta poner imagen, (Algun logo para que se vea bien) -->
    <!-- Formulario a la derecha -->

    <div class="container mt-5">
    <div class="row justify-content-center">
    <div class="col-md-6">
    <div class="card shadow">
    <div class="card-body">
        <h2 class="mb-4 text-center text-white">Iniciar sesion</h2>

    <%-- Esto es lógica JSP, lo demás es puro HTML --%>

   <% if (request.getAttribute("error") != null) { %>
           <p style="color:red;"><%= request.getAttribute("error") %></p>
   <% } %>

    <form id="formlogin" action="login" method="post">
        <div class="mb-3">
            <label for="email" class="form-label">Correo electronico</label>
            <input type="email" id="email" name="email" class="form-control" placeholder="Correo electronico" required>
        </div>
        <div class="mb-3">
            <label for="password" class="form-label">Contrasena</label>
            <input type="password" id="password" name="password" class="form-control" placeholder="Contrasena" required>
        </div>
        <div class="d-grid">
            <button type="submit" class="btn btn-primary">Ingresar</button>
        </div>
    </form>
    <p class="mt-3 text-center text-white">
    No tiene cuenta? <a href="registro.html">Registrarse</a>
    </p>
    </div>
    </div>
    </div>
    </div>
    </div>

</body>
</html>