/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.proyectov2.servlets;

import com.mycompany.proyectov2.dao.MaestroDAO;
import com.mycompany.proyectov2.model.Maestro;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author crazy
 */
@WebServlet("/editarMaestro")
public class EditarMaestroServlet extends HttpServlet {

    private MaestroDAO maestroDAO = new MaestroDAO();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditarMaestroServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditarMaestroServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("maestroLogueado") == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        Maestro maestro = (Maestro) session.getAttribute("maestroLogueado");

        String nombre = request.getParameter("nombre");
        String email = request.getParameter("email");
        String contrasena = request.getParameter("contrasena");
        String confirmarContrasena = request.getParameter("confirmarContrasena");

        // Validar que las contraseñas coincidan si se ingresó alguna
        if (contrasena != null && !contrasena.isEmpty()) {
            if (!contrasena.equals(confirmarContrasena)) {
                request.setAttribute("error", "Las contraseñas no coinciden.");
                request.getRequestDispatcher("configuracion.jsp").forward(request, response);
                return;
            } else {
                maestro.setContrasena(contrasena);
            }
        }

        maestro.setNombre(nombre);
        maestro.setEmail(email);

        try {
            maestroDAO.actualizarMaestro(maestro);
            // Actualizar el objeto en sesión para que tenga los nuevos datos
            session.setAttribute("maestroLogueado", maestro);

            request.setAttribute("mensaje", "Perfil actualizado correctamente.");
        } catch (Exception e) {
            request.setAttribute("error", "Error al actualizar perfil: " + e.getMessage());
        }

        request.getRequestDispatcher("configuracion.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
