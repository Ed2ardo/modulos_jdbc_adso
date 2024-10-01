package com.mycompany.parking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    // Cambia los valores según tu configuración
    private static final String URL = "jdbc:mysql://localhost:3306/parqueadero";
    private static final String USER = "root";  // Usuario de la base de datos
    private static final String PASSWORD = "";  // Contraseña de la base de datos

    public static Connection getConnection() {
        Connection connection = null;
        try {
            // Cargar el controlador de MySQL manualmente
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a la base de datos exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el controlador JDBC de MySQL.");
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}

