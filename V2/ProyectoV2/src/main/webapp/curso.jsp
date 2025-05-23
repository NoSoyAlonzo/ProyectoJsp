<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*, java.time.LocalDate" %>
<%@ page import="com.mycompany.proyectov2.model.Alumno, com.mycompany.proyectov2.model.Asistencia, com.mycompany.proyectov2.model.Clase" %>

<%
    Clase clase = (Clase) request.getAttribute("clase");
    List<Alumno> alumnos = (List<Alumno>) request.getAttribute("alumnos");

    Set<Date> fechas = new TreeSet<>();
    for (Alumno alumno : alumnos) {
        for (Asistencia asis : alumno.getAsistencias()) {
            if (asis.getAlumno().getClase().getId() == clase.getId()) {
                fechas.add(asis.getFecha());
            }
        }
    }
%>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <title>Asistencias de <%= clase.getNombre() %></title>
    <link rel="stylesheet" href="CSS/curso.css">
    <script>
        function abrirModal() {
            document.getElementById("modalAgregarAlumno").style.display = "block";
        }

        function cerrarModal() {
            document.getElementById("modalAgregarAlumno").style.display = "none";
        }
    </script>
</head>
<body>
    <h1>Asistencias - <%= clase.getNombre() %></h1>

    <button onclick="abrirModal()">Agregar Alumno</button>
    
    
    <!-- boton para abrir el modal  para agregar dia -->
    <button onclick="document.getElementById('modalAgregarDia').style.display='block'">Agregar día</button>
    <!-- Modal -->
    <div id="modalAgregarDia" style="display:none; position:fixed; top:20%; left:30%; background:#fff; padding:20px; border:1px solid #ccc;">
        <form action="agregarDia" method="post">
            <input type="hidden" name="idClase" value="<%= clase.getId() %>">
            <label for="fecha">Fecha:</label>
            <input type="date" name="fecha" required>
            <br><br>
            <button type="submit">Guardar</button>
            <button type="button" onclick="document.getElementById('modalAgregarDia').style.display='none'">Cancelar</button>
        </form>
    </div>
    <!-- Fin del modal para agregar dia-->
            
    <table border="1" cellpadding="10">
        <thead>
            <tr>
                <th>Alumno</th>
                <% for (Date fecha : fechas) { %>
                    <th><%= fecha.toString() %></th>
                <% } %>
            </tr>
        </thead>
        <tbody>
            <% for (Alumno alumno : alumnos) { %>
                <tr>
                    <td><%= alumno.getNombre() %></td>
                    <% for (Date fecha : fechas) {
                        boolean presente = false;
                        for (Asistencia asis : alumno.getAsistencias()) {
                            if (asis.getFecha().equals(fecha)) {
                                presente = asis.getPresente();
                                break;
                            }
                        }
                    %>
                    <td><%= presente ? "✔" : "✘" %></td>
                    <% } %>
                </tr>
            <% } %>
        </tbody>
    </table>

    <p><a href="principal" method="get">← Volver</a></p>

    <!-- Modal para agregar alumno -->
    <div id="modalAgregarAlumno" style="display:none; position:fixed; top:20%; left:30%; width:40%; background:#fff; padding:20px; border:1px solid #ccc; box-shadow: 0px 0px 10px rgba(0,0,0,0.5);">
        <h2>Agregar Alumno</h2>
        <form action="agregarAlumno" method="post">
            <input type="hidden" name="idClase" value="<%= clase.getId() %>"/>
            <label>Nombre del alumno:</label>
            <input type="text" name="nombreAlumno" required><br><br>
            <button type="submit">Guardar</button>
            <button type="button" onclick="cerrarModal()">Cancelar</button>
        </form>
    </div>
</body>
</html>
