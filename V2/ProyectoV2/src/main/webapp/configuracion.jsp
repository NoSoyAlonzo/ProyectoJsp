<%@ page import="com.mycompany.proyectov2.model.Maestro" %>
<%
    Maestro maestro = (Maestro) session.getAttribute("maestroLogueado");
    if (maestro == null) {
        response.sendRedirect("login.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Configuración de Perfil - Maestro</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="CSS/Style.css">
</head>

<body class="bg-dark">
<div class="container d-flex justify-content-center align-items-center min-vh-100">
    <div class="form-container card shadow p-4" style="max-width: 500px; width: 100%;">
        <h2 class="mb-4 text-center text-white">Editar Perfil</h2>

        <form id="formConfiguracion" action="editarMaestro" method="post">
            <div class="mb-3">
                <label for="nombre" class="form-label text-white">Nombre Completo</label>
                <input type="text" class="form-control" id="nombre" name="nombre" value="<%= maestro.getNombre() %>" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label text-white">Correo Electrónico</label>
                <input type="email" class="form-control" id="email" name="email" value="<%= maestro.getEmail() %>" required>
            </div>
            <div class="mb-3">
                <label for="contrasena" class="form-label text-white">Nueva Contraseña</label>
                <input type="password" class="form-control" id="contrasena" name="contrasena" placeholder="Deja vacío si no deseas cambiarla">
            </div>
            <div class="mb-3">
                <label for="confirmarContrasena" class="form-label text-white">Confirmar Nueva Contraseña</label>
                <input type="password" class="form-control" id="confirmarContrasena" name="confirmarContrasena" placeholder="Deja vacío si no deseas cambiarla">
            </div>

            <div class="d-grid gap-2 mt-3">
                <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                <a href="principal" class="btn btn-secondary">Regresar</a>
            </div>
        </form>

    </div>
</div>

</body>

</html>
