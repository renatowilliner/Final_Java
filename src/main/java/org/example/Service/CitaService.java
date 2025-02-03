package org.example.Service;

import java.time.LocalDate;
import java.util.List;

import org.example.Model.Cita;
import org.example.Repository.CitaDAO;


public class CitaService {

    private CitaDAO citaDAO;

  

    public List<Cita> ObtenerCitas(LocalDate fechaInicio, LocalDate fechaFin, String estado, String motivoConsulta) {
        
        if (fechaInicio != null && fechaFin != null && fechaInicio.isAfter(fechaFin)) {
            throw new IllegalArgumentException("La fecha de inicio no puede ser posterior a la fecha de fin");
        }

        if (estado != null && !estado.matches("Pendiente|Completada|Cancelada")) {
            throw new IllegalArgumentException("El estado de la cita debe ser 'Pendiente', 'Completada' o 'Cancelada'");
        }

        if (motivoConsulta != null && motivoConsulta.length() < 3) {
            throw new IllegalArgumentException("El motivo de consulta debe tener al menos 3 caracteres");
        }

        return citaDAO.ObtenerCitas(fechaInicio, fechaFin, estado, motivoConsulta);
    }
}
