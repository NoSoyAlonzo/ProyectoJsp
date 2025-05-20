package webJ.DAO;


import webJ.Modelo.Maestro;
import java.sql.*;

public class MaestroDAO {
    private Connection conn;

    public MaestroDAO(Connection conn) {
        this.conn = conn;
    }

    public Maestro autenticar(String email, String contrasena) throws SQLException {
        String sql = "SELECT * FROM Maestro WHERE email = ? AND contrasena = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, email);
            stmt.setString(2, contrasena);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Maestro(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("contrasena")
                );
            } else {
                return null;
            }
        }
    }
}
