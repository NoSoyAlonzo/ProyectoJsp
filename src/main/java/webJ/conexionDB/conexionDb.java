package webJ.conexionDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexionDb {
    private static Connection connection = null;

    // Constructor privado para evitar instanciación
    private conexionDb() {}

    public static Connection getConnection() {
        if (connection == null) {
            try {
                // Cargar el driver JDBC
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establecer la conexión
                connection = DriverManager.getConnection(
                        configuracionSql.getUrl(),
                        configuracionSql.getUser(),
                        configuracionSql.getPassword()
                );
                System.out.println("Conexión establecida correctamente");
            } catch (ClassNotFoundException e) {
                System.err.println("Error al cargar el driver JDBC: " + e.getMessage());
            } catch (SQLException e) {
                System.err.println("Error al conectar a la base de datos: " + e.getMessage());
            }
        }
        return connection;
    }

    public static void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexión cerrada correctamente");
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}