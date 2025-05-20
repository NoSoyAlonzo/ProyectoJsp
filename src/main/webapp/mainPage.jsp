






 <!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard Profesor</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <div class="dashboard">
        <div class="header">
            <h1 class="welcome-message">Bienvenido, <%= profesor.getNombre() %></h1>
            <a href="logout.jsp" class="btn-logout">Cerrar Sesión</a>
        </div>

        <div class="actions">
            <a href="agregar-materia.jsp" class="btn btn-add">Agregar Nueva Materia</a>
        </div>

        <div class="materias-container">
            <% for (Materia materia : materias) { %>
                <div class="materia-card">
                    <h3 class="materia-title"><%= materia.getNombre() %></h3>
                    <p class="materia-info"><strong>Código:</strong> <%= materia.getCodigo() %></p>
                    <p class="materia-info"><strong>Horario:</strong> <%= materia.getHorario() %></p>
                    <p class="materia-info"><strong>Aula:</strong> <%= materia.getAula() %></p>

                    <div class="btn-group">
                        <a href="editar-materia.jsp?id=<%= materia.getId() %>" class="btn btn-edit">Editar</a>
                        <a href="eliminar-materia.jsp?id=<%= materia.getId() %>" class="btn btn-delete">Eliminar</a>
                    </div>
                </div>
            <% } %>
        </div>
    </div>
</body>
</html>