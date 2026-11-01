
package com.carnecol.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL =
            "jdbc:mysql://localhost:3306/carnecol";

    private static final String USUARIO = "root";

   private static final String CONTRASENA =
        System.getenv("CARNECOL_DB_PASSWORD");

    public static Connection conectar() {

        try {
            Connection conexion = DriverManager.getConnection(
                    URL, USUARIO, CONTRASENA
            );

            System.out.println("Conexion con Carnecol exitosa.");

            return conexion;

        } catch (SQLException e) {

            System.out.println("Error al conectar: " + e.getMessage());

            return null;
        }
    }
}

