package webJ.DAO;
import webJ.Modelo.Clase;

import java.sql.*;
import java.util.*;

public class ClaseDAO {
    private Connection conn;

    public ClaseDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Clase> obtenerClasesPorMaestro(int maestroId) {
        List<Clase> clases = new ArrayList<>();
        String sql = "SELECT * FROM Clase WHERE maestro_id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, maestroId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Clase clase = new Clase();
                clase.setId(rs.getInt("id"));
                clase.setNombre(rs.getString("nombre"));
                clase.setMaestroId(rs.getInt("maestro_id"));
                clases.add(clase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clases;
    }

    public void agregarClase(Clase clase) {
        String sql = "INSERT INTO Clase (nombre, maestro_id) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, clase.getNombre());
            stmt.setInt(2, clase.getMaestroId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarClase(int id) {
        String sql = "DELETE FROM Clase WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void actualizarClase(Clase clase) {
        String sql = "UPDATE Clase SET nombre = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, clase.getNombre());
            stmt.setInt(2, clase.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
