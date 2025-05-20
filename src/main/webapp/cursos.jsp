<%@ page import="java.util.List" %>
<%@ page import="Modelo.Clase" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mis Cursos - Sistema Escolar</title>
    <link rel="stylesheet" href="CSS/Principal.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css">
</head>
<body>
<div class="contenedor-principal">
    <header class="cabecera">
        <div class="logo">
            <h1><i class="fas fa-chalkboard-teacher"></i> Panel del Maestro</h1>
        </div>
        <nav class="navegacion">
            <ul>
                <li><a href="/principal.html" class="activo"><i class="fas fa-book"></i> Mis Cursos</a></li>
                <li><a href="#"><i class="fas fa-users"></i> Mis Alumnos</a></li>
                <li><a href="#"><i class="fas fa-calendar-check"></i> Asistencias</a></li>
                <li><a href="#"><i class="fas fa-cog"></i> Configuración</a></li>
            </ul>
        </nav>
    </header>

    <main class="contenido">
        <section class="bienvenida-maestro">
            <h2>Bienvenido, <span class="nombre-maestro">Juan Pérez</span></h2>
            <p>Gestiona tus cursos y materiales educativos.</p>
            <button id="btn-nuevo-curso" class="btn-primario">
                <i class="fas fa-plus"></i> Agregar Nuevo Curso
            </button>
        </section>

        <section class="mis-cursos">
            <h2><i class="fas fa-book-open"></i> Mis Cursos Registrados</h2>

            <div class="lista-cursos">
                <%
                    List<Curso> cursos = (List<Curso>) request.getAttribute("cursos");
                    if (cursos != null && !cursos.isEmpty()) {
                        for (Curso curso : cursos) {
                %>
                    <div class="curso">
                        <div class="curso-info">
                            <h3><%= curso.getNombre() %></h3>
                            <p><strong>Código:</strong> <%= curso.getCodigo() %></p>
                            <p><strong>Alumnos inscritos:</strong> <%= curso.getCantidadAlumnos() %></p>
                            <p><strong>Horario:</strong> <%= curso.getHorario() %></p>
                        </div>
                        <div class="curso-acciones">
                            <form action="EditarCurso.jsp" method="post">
                                <input type="hidden" name="id" value="<%= curso.getId() %>">
                                <button class="btn-editar"><i class="fas fa-edit"></i> Editar</button>
                            </form>
                            <form action="EliminarCurso.jsp" method="post" onsubmit="return confirm('¿Deseas eliminar este curso?');">
                                <input type="hidden" name="id" value="<%= curso.getId() %>">
                                <button class="btn-eliminar"><i class="fas fa-trash"></i> Eliminar</button>
                            </form>
                        </div>
                    </div>
                <%
                        }
                    } else {
                %>
                    <p>No hay cursos registrados.</p>
                <%
                    }
                %>
            </div>
        </section>
    </main>

    <footer class="pie-pagina">
        <p>Sistema de Gestión Escolar &copy; 2025</p>
    </footer>
</div>
</body>
</html>
