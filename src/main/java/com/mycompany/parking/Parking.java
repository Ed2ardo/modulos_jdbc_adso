/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.parking;

/**
 *
 * @author Equipo
 */


public class Parking {

    public static void main(String[] args) {
    // Probar la conexión a la base de datos
    DatabaseConnection.getConnection();
    
    // Crear un nuevo cliente
        Cliente cliente = new Cliente(0, "Year Jliaba", "Seb.bsgz@correo.com", "159875632");

        // Insertar el cliente en la base de datos
        ClienteDAO clienteDAO = new ClienteDAO();
        clienteDAO.insertarCliente(cliente);
        
         // Consultar cliente por ID (asume que el ID es 1)
        Cliente clienteConsultado = clienteDAO.obtenerClientePorId(1);

        // Si el cliente fue encontrado, mostrar sus detalles
        if (clienteConsultado != null) {
            System.out.println("Datos del cliente consultado:");
            System.out.println("ID: " + clienteConsultado.getId());
            System.out.println("Nombre: " + clienteConsultado.getNombre());
            System.out.println("Email: " + clienteConsultado.getEmail());
            System.out.println("Teléfono: " + clienteConsultado.getTelefono());
        }
              // Actualizar cliente por ID
        int idActualizar = 1;  // Aquí indicas el ID que deseas actualizar
        clienteDAO.actualizarClientePorId(idActualizar, "Marganira Actualizado", "email.update@juana.com", "965874123");

        // Eliminar cliente por ID
        int idEliminar = 4;  // Aquí indicas el ID que deseas eliminar
        clienteDAO.eliminarClientePorId(idEliminar);
    }
}
