<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mis Cursos - Sistema Escolar</title>
    <link rel="stylesheet" href="CSS/Principal.css">
</head>
<body>

<script>
function confirmarEliminacion(idClase) {
    if (confirm('Estas seguro de que deseas eliminar esta clase?')) {
        document.getElementById('form-eliminar-' + idClase).submit();
    }
}
</script>
    

    
<div class="contenedor-principal">
    <header class="cabecera">
        <div class="logo">
            <h1><i class="fas fa-chalkboard-teacher"></i> Panel del Maestro</h1>
        </div>
        <nav class="navegacion">
            <ul>
                <li><a href="configuracion.jsp"><i class="fas fa-cog"></i> Configuracion</a></li>
            </ul>
        </nav>
    </header>

    <main class="contenido">
        
        
        
        <!-- Esto es para que aparezca el nombre del maestro -->
        <%@ page import="com.mycompany.proyectov2.model.Maestro" %>
        <%
            Maestro maestro = (Maestro) session.getAttribute("maestroLogueado");
            if (maestro == null) {
                response.sendRedirect("login.jsp");
                return;
            }
        %>  
        <section class="bienvenida-maestro">
            <h2>Bienvenido, <span class="nombre-maestro"><%= maestro.getNombre() %></span></h2>
            <p>Gestiona tus cursos y materiales educativos.</p>
            <button id="btn-nuevo-curso" class="btn-primario">
                <i class="fas fa-plus"></i> Agregar Nuevo Curso
            </button>
        </section>
            
            
        
        <!-- Esto es para que consulte las clases y agregarle el boton de eliminar, editar y la confirmacion-->
        <%@ page import="java.util.List" %>
        <%@ page import="com.mycompany.proyectov2.model.Clase" %>
        <%
            List<Clase> clases = (List<Clase>) request.getAttribute("clases");
        %>
            
        <script>
        function confirmarEliminacion(idClase) {
            if (confirm("¿Estás seguro de que deseas eliminar esta clase?")) {
                document.getElementById("form-eliminar-" + idClase).submit();
            }
        }
        </script>

        <section class="mis-cursos">
            <h2><i class="fas fa-book-open"></i> Mis Clases Registradas</h2>

            <div class="lista-cursos">
                <% if (clases != null && !clases.isEmpty()) {
                    for (Clase clase : clases) { %>
                        <div class="curso">
                            <div class="curso-info">
                                <h3><%= clase.getNombre() %></h3>
                                <p><strong>ID: </strong> <%= clase.getId() %></p>
                            </div>
                            <div class="curso-acciones">
                                
                                <!-- NUEVO BOTÓN VER CLASE -->
                                <form action="verClase" method="get" style="display:inline;">
                                    <input type="hidden" name="idClase" value="<%= clase.getId() %>">
                                    <button type="submit" class="btn-ver">
                                        <i class="fas fa-eye"></i> Ver Clase
                                    </button>
                                </form>
                                
                                <button class="btn-editar" onclick="abrirModalEditar(<%= clase.getId() %>, '<%= clase.getNombre() %>')">
                                    <i class="fas fa-edit"></i> Editar
                                </button>
                                    
                                <form id="form-eliminar-<%= clase.getId() %>" action="eliminarClase" method="post" style="display:inline;">
                                    <input type="hidden" name="idClase" value="<%= clase.getId() %>">
                                    <button type="button" class="btn-eliminar" onclick="confirmarEliminacion(<%= clase.getId() %>)">
                                        <i class="fas fa-trash"></i> Eliminar
                                    </button>
                                </form>
                            </div>
                        </div>
                <%   }
                   } else { %>
                    <p>No tienes clases registradas.</p>
                <% } %>
            </div>
        </section>
        <!--Fin de la seccion para ver las clases, cuyas tienen el boton editar, eliminar -->


        <!-- Modal para agregar nueva clase -->
        <div id="modal-curso" class="modal">
            <div class="modal-contenido">
                <span class="cerrar-modal">&times;</span>
                <h2 id="modal-titulo">Nueva Clase</h2>
                <form id="form-curso" action="agregarClase" method="post" onsubmit="return confirm('¿Estás seguro de que deseas agregar esta clase?');">
                    <div class="form-grupo">
                        <label for="nombre-curso">Nombre de la Clase:</label>
                        <input type="text" id="nombre-curso" name="nombreClase" required>
                        <input type="hidden" name="idMaestro" value="<%= maestro.getId() %>">
                    </div>
                    <div class="form-acciones">
                        <button type="button" class="btn-secundario cerrar-modal">Cancelar</button>
                        <button type="submit" class="btn-primario">Guardar</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- Fin de Modal para agregar nueva clase -->
                    
                    
       <!-- Modal para editar clase -->
        <div id="modal-editar" class="modal">
            <div class="modal-contenido">
                <span class="cerrar-modal-editar">&times;</span>
                <h2>Editar Clase</h2>
                <form id="form-editar" action="editarClase" method="post" onsubmit="return confirm('¿Estás seguro de que deseas actualizar esta clase?');">
                    <input type="hidden" id="editar-id" name="idClase">
                    <div class="form-grupo">
                        <label for="editar-nombre">Nombre del Curso:</label>
                        <input type="text" id="editar-nombre" name="nombreClase" required>
                    </div>
                    <div class="form-acciones">
                        <button type="button" class="btn-secundario cerrar-modal-editar">Cancelar</button>
                        <button type="submit" class="btn-primario">Actualizar</button>
                    </div>
                </form>
            </div>
        </div>
        <!-- Fin de Modal para editar clase -->


    </main>
    <footer class="pie-pagina">
        <p>Sistema de Gestion de Alumnos &copy; 2025</p>
    </footer>
</div>


<!-- Esto es para que se muestre el modal agregar nueva clase-->
<script>
document.getElementById('btn-nuevo-curso').addEventListener('click', function() {
    document.getElementById('modal-curso').style.display = 'block';
});

document.querySelectorAll('.cerrar-modal').forEach(btn => {
    btn.addEventListener('click', function() {
        document.getElementById('modal-curso').style.display = 'none';
    });
});
</script>

<!-- Esto es para que se muestre el modal editar clase -->
<script>
function abrirModalEditar(id, nombre) {
    document.getElementById('editar-id').value = id;
    document.getElementById('editar-nombre').value = nombre;
    document.getElementById('modal-editar').style.display = 'block';
}

document.querySelectorAll('.cerrar-modal-editar').forEach(btn => {
    btn.addEventListener('click', function() {
        document.getElementById('modal-editar').style.display = 'none';
    });
});
</script>              
                    
</body>
</html>