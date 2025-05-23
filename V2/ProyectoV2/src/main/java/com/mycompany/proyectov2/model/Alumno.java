/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectov2.model;

import jakarta.persistence.*;
import java.util.List;

/**
 *
 * @author crazy
 */

@Entity
public class Alumno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String nombre;
    
    @ManyToOne
    @JoinColumn
    private Clase clase;
    
    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL)
    private List<Asistencia> asistencias;

    public Clase getClase() {
        return clase;
    }

    public void setClase(Clase clase) {
        this.clase = clase;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }
 
    public Alumno() {
    }

    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Alumno(String nombre) {
        this.nombre = nombre;
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

}
