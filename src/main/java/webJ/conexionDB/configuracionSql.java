package webJ.conexionDB;

import java.sql.Connection;

public class configuracionSql {

    private static Connection conexion;

    private static final String URL = "jdbc:mysql://localhost:3306/Escuela";
    private static final String USER = "root";
    private static final String PASSWORD = "root";


    public static String getUrl() {
        return URL;
    }

    public static String getUser() {
        return USER;
    }

    public static String getPassword() {
        return PASSWORD;
    }

}
