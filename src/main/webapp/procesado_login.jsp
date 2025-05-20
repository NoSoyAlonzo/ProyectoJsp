<%@ page import="modelo.Maestro, dao.MaestroDAO" %>
<%@ page import="java.sql.*" %>
<%
    String email = request.getParameter("usuario");
    String clave = request.getParameter("clave");

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Escuela", "root", "Alonso181437");

        MaestroDAO dao = new MaestroDAO(conn);
        Maestro maestro = dao.autenticar(email, clave);

        if (maestro != null) {
            session.setAttribute("maestro", maestro);
            response.sendRedirect("principal.jsp");
        } else {
            request.setAttribute("error", "Credenciales incorrectas");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

        conn.close();
    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("error", "Error en el servidor");
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
%>
