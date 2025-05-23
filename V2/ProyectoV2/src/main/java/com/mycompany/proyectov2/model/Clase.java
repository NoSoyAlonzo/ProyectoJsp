package com.mycompany.proyectov2.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Clase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "maestro_id")
    private Maestro maestro;

    @OneToMany(mappedBy = "clase", cascade = CascadeType.ALL)
    private List<Alumno> alumnos;

    public Clase() {
    }

    public Clase(int id, String nombre, Maestro maestro, List<Alumno> alumnos) {
        this.id = id;
        this.nombre = nombre;
        this.maestro = maestro;
        this.alumnos = alumnos;
    }

    public Clase(String nombre, Maestro maestro, List<Alumno> alumnos) {
        this.nombre = nombre;
        this.maestro = maestro;
        this.alumnos = alumnos;
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

    public Maestro getMaestro() {
        return maestro;
    }

    public void setMaestro(Maestro maestro) {
        this.maestro = maestro;
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(List<Alumno> alumnos) {
        this.alumnos = alumnos;
    }
}

