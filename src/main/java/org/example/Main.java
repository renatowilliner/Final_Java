package org.example;

import java.time.LocalDate;

import org.example.Model.Paciente;

import org.example.Repository.PacienteDAO;
import org.example.Service.PacienteService;


public class Main {

    public static void main(String[] args) {

     
        PacienteService pacienteService = new PacienteService(new PacienteDAO());

       
        try {
            Paciente nuevoPaciente = new Paciente( "Juan", "Pérez", LocalDate.of(1990, 1, 1), "0987654321", "juanPerez@gmail.com");
            pacienteService.CrearPaciente(nuevoPaciente);
            System.out.println("Paciente creado con éxito");

        } catch (IllegalArgumentException e) {
            System.out.println("Error al crear paciente: " + e.getMessage());
        }

     
        try {
            System.out.println("Listado de pacientes:");
            pacienteService.ObtenerPacientes().forEach(paciente -> {
                System.out.println(paciente.getNombre() + " " + paciente.getApellido());
            });
        } catch (Exception e) {
            System.out.println("Error al obtener pacientes: " + e.getMessage());
        }

        
        try {
            pacienteService.ActualizarPaciente(1, "Juan", "Pérez", "0987654321", "juan.nuevo@email.com");
            System.out.println("Paciente actualizado con éxito");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al actualizar paciente: " + e.getMessage());
        }

   
        try {
            pacienteService.EliminarPaciente(1);
            System.out.println("Paciente eliminado con éxito");
        } catch (IllegalArgumentException e) {
            System.out.println("Error al eliminar paciente: " + e.getMessage());
        }

        
     
}
}
