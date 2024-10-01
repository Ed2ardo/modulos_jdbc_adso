package com.mycompany.parking;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class ClienteDAO {

    public void insertarCliente(Cliente cliente) {
        Connection connection = DatabaseConnection.getConnection();
        String sql = "INSERT INTO clientes (nombre, email, telefono) VALUES (?, ?, ?)";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getEmail());
            statement.setString(3, cliente.getTelefono());

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Cliente insertado exitosamente");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
     // Método para consultar un cliente por ID
    public Cliente obtenerClientePorId(int id) {
        Connection connection = DatabaseConnection.getConnection();
        Cliente cliente = null;

        String query = "SELECT * FROM clientes WHERE id = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                cliente = new Cliente(
                    resultSet.getInt("id"),
                    resultSet.getString("nombre"),
                    resultSet.getString("email"),
                    resultSet.getString("telefono")
                );
                System.out.println("Cliente encontrado: " + cliente.getNombre());
            } else {
                System.out.println("Cliente no encontrado.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return cliente;
    }
    
    public void actualizarClientePorId(int id, String nuevoNombre, String nuevoEmail, String nuevoTelefono) {
    String sql = "UPDATE clientes SET nombre = ?, email = ?, telefono = ? WHERE id = ?";
    
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        
        statement.setString(1, nuevoNombre);
        statement.setString(2, nuevoEmail);
        statement.setString(3, nuevoTelefono);
        statement.setInt(4, id);
        
        int filasActualizadas = statement.executeUpdate();
        if (filasActualizadas > 0) {
            System.out.println("Cliente con ID " + id + " actualizado exitosamente");
        } else {
            System.out.println("No se encontró un cliente con ID " + id);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


    public void eliminarClientePorId(int id) {
    String sql = "DELETE FROM clientes WHERE id = ?";
    
    try (Connection connection = DatabaseConnection.getConnection();
         PreparedStatement statement = connection.prepareStatement(sql)) {
        
        statement.setInt(1, id);
        
        int filasEliminadas = statement.executeUpdate();
        if (filasEliminadas > 0) {
            System.out.println("Cliente con ID " + id + " eliminado exitosamente");
        } else {
            System.out.println("No se encontró un cliente con ID " + id);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}


}

