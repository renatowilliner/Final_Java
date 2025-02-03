package org.example.Model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "Cita")
public class Cita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCita;

    @ManyToOne
    @JoinColumn(name = "idPaciente", nullable = false)
    private Paciente paciente;

    private LocalDateTime fechaCita;
    private String motivoConsulta;
    private String estado;

    // Getters y setters

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public LocalDateTime getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(LocalDateTime fechaCita) {
        this.fechaCita = fechaCita;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    // Constructor
    public Cita() {
    }

    public Cita(Paciente paciente, LocalDateTime fechaCita, String motivoConsulta, String estado) {
        this.paciente = paciente;
        this.fechaCita = fechaCita;
        this.motivoConsulta = motivoConsulta;
        this.estado = estado;
    }
}
