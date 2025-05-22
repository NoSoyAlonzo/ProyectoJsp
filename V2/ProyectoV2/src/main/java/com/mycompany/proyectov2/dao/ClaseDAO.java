// Archivo: com.mycompany.proyectov2.dao.ClaseDAO.java
package com.mycompany.proyectov2.dao;

import com.mycompany.proyectov2.model.Clase;
import jakarta.persistence.*;

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


    
    
    
    
}
