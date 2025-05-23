package servlets; // O el paquete donde tengas tus servlets

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

// Importaciones actualizadas a jakarta.*
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import webJ.Modelo.Maestro;
import webJ.DAO.MaestroDAO;
import webJ.conexionDB.conexionDb;

@WebServlet("/RegistrarMaestroServlet")
public class RegistrarMaestroServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");

        Maestro nuevoMaestro = new Maestro();
        nuevoMaestro.setNombre(nombre);
        nuevoMaestro.setEmail(email);
        nuevoMaestro.setContrasena(contrasena);
        Connection conn = null;
        String mensaje = "";
        String redirectPage = "registro.html"; // Página por defecto a la que volver

        try {
            conn = conexionDb.getConnection();
            MaestroDAO maestroDAO = new MaestroDAO(conn);
            maestroDAO.agregarMaestro(nuevoMaestro);
            mensaje = "Maestro registrado exitosamente!";
            redirectPage = "login.jsp"; // O la página de éxito/login
        } catch (SQLException e) {
            e.printStackTrace();
            mensaje = "Error al registrar el maestro: " + e.getMessage();
        } catch (Exception e) {
            e.printStackTrace();
            mensaje = "Error inesperado: " + e.getMessage();
        } finally {
            conexionDb.closeConnection();
        }

        // 7. Enviar una respuesta al usuario (o redirigir)
        // Si no haces un sendRedirect antes, puedes mostrar un mensaje.
        response.setContentType("text/html;charset=UTF-8");
        try (java.io.PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado del Registro</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Resultado del Registro</h2>");
            out.println("<p>" + mensaje + "</p>");
            out.println("<a href='" + request.getContextPath() + "/" + (redirectPage.equals("login.jsp") ? "login.jsp" : "registro.html") + "'>" + (redirectPage.equals("login.jsp") ? "Ir al Login" : "Volver al registro") + "</a><br>");
            out.println("<a href='" + request.getContextPath() + "/mainPage.jsp'>Ir a la página principal</a>");
            out.println("</body>");
            out.println("</html>");
        }
    }
}