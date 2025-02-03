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
import org.hibernate.Session;


public class CitaDAO {
    public List<Cita> ObtenerCitas(LocalDate fechaInicio, LocalDate fechaFin, String estado, String motivoConsulta) {
        try (Session session = HibernateUtil.getSession()) {
           
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<Cita> query = builder.createQuery(Cita.class);
            Root<Cita> root = query.from(Cita.class);

            List<jakarta.persistence.criteria.Predicate> predicates = new ArrayList<>();

            // Fecha criteria
            if (fechaInicio != null && fechaFin != null) {
                predicates.add(builder.between(root.get("fechaCita"), fechaInicio, fechaFin));
            } else if (fechaInicio != null) {
                predicates.add(builder.equal(root.get("fechaCita"), fechaInicio));
            }

            // Estado criteria
            if (estado != null && !estado.isEmpty()) {
                predicates.add(builder.equal(root.get("estado"), estado));
            }

            // Motivo consulta criteria
            if (motivoConsulta != null && !motivoConsulta.isEmpty()) {
                predicates.add(builder.like(root.get("motivoConsulta"), "%" + motivoConsulta + "%"));
            }

            // Add where clause only if there are predicates
            if (!predicates.isEmpty()) {
                query.where(predicates.toArray(new jakarta.persistence.criteria.Predicate[0]));
            }

            // Usar TypedQuery en lugar de Query
            return session.createQuery(query).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
