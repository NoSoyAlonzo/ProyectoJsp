// Archivo: com.mycompany.proyectov2.dao.ClaseDAO.java
package com.mycompany.proyectov2.dao;

import com.mycompany.proyectov2.model.Alumno;
import com.mycompany.proyectov2.model.Asistencia;
import com.mycompany.proyectov2.model.AsistenciaId;
import com.mycompany.proyectov2.model.Clase;
import jakarta.persistence.*;
import java.util.Date;

import java.util.List;

public class ClaseDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("escuela");

    public List<Clase> obtenerClasesPorMaestro(int idMaestro) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT c FROM Clase c WHERE c.maestro.id = :id", Clase.class)
                     .setParameter("id", idMaestro)
                     .getResultList();
        } finally {
            em.close();
        }
    }
    
    public void eliminarClasePorId(int idClase) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Clase clase = em.find(Clase.class, idClase);
            if (clase != null) {
                em.remove(clase);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }
    
    public void insertarClase(Clase clase) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(clase);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public void actualizarClase(int idClase, String nuevoNombre) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            Clase clase = em.find(Clase.class, idClase);
            if (clase != null) {
                clase.setNombre(nuevoNombre);
            }
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    public Clase obtenerClasePorId(Integer idClase) {
        EntityManager em = emf.createEntityManager();
        return em.find(Clase.class, idClase);
    }

    public List<Alumno> obtenerAlumnosConAsistenciasPorClase(Integer idClase) {
        EntityManager em = emf.createEntityManager();
        return em.createQuery(
            "SELECT DISTINCT a FROM Alumno a LEFT JOIN FETCH a.asistencias asis " +
            "WHERE a.clase.id = :idClase", Alumno.class)
            .setParameter("idClase", idClase)
            .getResultList();
    }
    
    public void agregarAsistenciasPorFecha(int idClase, Date fecha) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();

            List<Alumno> alumnos = em.createQuery(
                "SELECT DISTINCT a FROM Alumno a WHERE a.clase.id = :idClase", Alumno.class)
                .setParameter("idClase", idClase)
                .getResultList();

            for (Alumno alumno : alumnos) {
                Asistencia asistencia = new Asistencia();
                asistencia.setAlumno(alumno);
                asistencia.setPresente(false);
                asistencia.setId(new AsistenciaId(alumno.getId(), fecha));
                em.persist(asistencia);
            }

            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    
    
}
