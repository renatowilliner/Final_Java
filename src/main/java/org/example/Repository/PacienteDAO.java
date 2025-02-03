package org.example.Repository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.time.LocalDate;

import org.example.connections.HibernateUtil;
import org.example.Model.Cita;
import org.example.Model.Paciente;
import org.hibernate.Session;




public class PacienteDAO {
    public void CrearPaciente(Paciente paciente) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.save(paciente);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Paciente> ObtenerPacientes() {
        try (Session session = HibernateUtil.getSession()) {
            CriteriaBuilder builder =  session.getCriteriaBuilder();
            CriteriaQuery<Paciente> criteria = builder.createQuery(Paciente.class);
            Root<Paciente> root = criteria.from(Paciente.class);
            criteria.select(root);
            return session.createQuery(criteria).getResultList();
        }
    }

    public void ActualizarPaciente(Integer idPaciente, String nombre, String apellido, String telefono, String email) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Paciente paciente = session.get(Paciente.class, idPaciente);
            if (paciente != null) {
                paciente.setNombre(nombre);
                paciente.setApellido(apellido);
                paciente.setTelefono(telefono);
                paciente.setEmail(email);
                session.update(paciente);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void EliminarPaciente(Integer idPaciente) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Paciente paciente = session.get(Paciente.class, idPaciente);
            if (paciente != null) {
                session.delete(paciente);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}