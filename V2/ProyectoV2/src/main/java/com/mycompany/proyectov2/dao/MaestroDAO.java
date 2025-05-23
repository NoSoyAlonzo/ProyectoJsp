package com.mycompany.proyectov2.dao;

import com.mycompany.proyectov2.model.Maestro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class MaestroDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("escuela");

    public void guardar(Maestro maestro) {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(maestro);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }
    
    // para el login
    public Maestro buscarPorEmailYContrasena(String email, String contrasena) {
    EntityManager em = emf.createEntityManager();
    try {
        return em.createQuery("SELECT m FROM Maestro m WHERE m.email = :email AND m.contrasena = :contrasena", Maestro.class)
                .setParameter("email", email)
                .setParameter("contrasena", contrasena)
                .getResultStream()
                .findFirst()
                .orElse(null);
    } finally {
        em.close();
    }
}

    // posiblemente se use en elregistro para verificar que no exista alguien con mismo email
    public Maestro buscarPorEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.createQuery("SELECT m FROM Maestro m WHERE m.email = :email", Maestro.class)
                     .setParameter("email", email)
                     .getResultStream()
                     .findFirst()
                     .orElse(null);
        } finally {
            em.close();
        }
    }

    public void actualizarMaestro(Maestro maestro) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(maestro);
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) {
                tx.rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }
    
    
}
