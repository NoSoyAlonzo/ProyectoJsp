package webJ;
import webJ.conexionDB.conexionDb;

import java.sql.Connection;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Connection conex= conexionDb.getConnection();
        try{

            System.out.println("Conexion a la base de datos exitosa");
        }catch(Exception e){
            System.err.println("Eroror durante las operaciones "+e.getMessage());
        } finally {
            conexionDb.closeConnection();
        }
    }
}