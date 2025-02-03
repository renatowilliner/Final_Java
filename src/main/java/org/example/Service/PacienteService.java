package org.example.Service;

import java.util.List;

import org.example.Model.Paciente;
import org.example.Repository.PacienteDAO;

public class PacienteService {

    private PacienteDAO pacienteDAO;

    public  PacienteService( PacienteDAO pacienteDAO)
    {
        this.pacienteDAO = pacienteDAO;
    }

    public void CrearPaciente(Paciente paciente) {
        
        if (paciente.getNombre() == null || paciente.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (paciente.getApellido() == null || paciente.getApellido().isEmpty()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
        if (paciente.getTelefono() == null || paciente.getTelefono().length() < 10) {
            throw new IllegalArgumentException("El teléfono debe tener al menos 10 dígitos");
        }
        if (paciente.getEmail() == null || !paciente.getEmail().contains("@")) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }
        
        pacienteDAO.CrearPaciente(paciente);
    }

    public List<Paciente> ObtenerPacientes() {
        return pacienteDAO.ObtenerPacientes();
    }

    public void ActualizarPaciente(Integer idPaciente, String nombre, String apellido, String telefono, String email) {
        
        if (idPaciente == null || idPaciente <= 0) {
            throw new IllegalArgumentException("ID de paciente no válido");
        }

        
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        if (apellido == null || apellido.isEmpty()) {
            throw new IllegalArgumentException("El apellido es obligatorio");
        }
        if (telefono == null || telefono.length() < 10) {
            throw new IllegalArgumentException("El teléfono debe tener al menos 10 dígitos");
        }
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }

      
        pacienteDAO.ActualizarPaciente(idPaciente, nombre, apellido, telefono, email);
    }

    public void EliminarPaciente(Integer idPaciente) {
        if (idPaciente == null || idPaciente <= 0) {
            throw new IllegalArgumentException("ID de paciente no válido");
        }

        pacienteDAO.EliminarPaciente(idPaciente);
    }
}