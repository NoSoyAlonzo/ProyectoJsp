package com.mycompany.proyectov2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Maestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;
    private String email;
    private String contrasena;
    
    @OneToMany(mappedBy = "maestro", cascade = CascadeType.ALL)
    private List<Clase> clases;

    public Maestro() {
    }

    public Maestro(int id, String nombre, String email, String contrasena, List<Clase> clases) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.clases = clases;
    }

    public Maestro(String nombre, String email, String contrasena, List<Clase> clases) {
        this.nombre = nombre;
        this.email = email;
        this.contrasena = contrasena;
        this.clases = clases;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public List<Clase> getClases() {
        return clases;
    }

    public void setClases(List<Clase> clases) {
        this.clases = clases;
    }
}
