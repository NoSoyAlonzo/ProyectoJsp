package com.mycompany.proyectov2.model;

import jakarta.persistence.*;

@Entity
public class Asistencia {

    @EmbeddedId
    private AsistenciaId id;

    @ManyToOne
    @MapsId("alumnoId")
    @JoinColumn(name = "alumno_id")
    private Alumno alumno;

    private boolean presente;

    public Asistencia() {
    }

    public Asistencia(AsistenciaId id, Alumno alumno, boolean presente) {
        this.id = id;
        this.alumno = alumno;
        this.presente = presente;
    }

    public Asistencia(Alumno alumno, boolean presente) {
        this.alumno = alumno;
        this.presente = presente;
    }

    public AsistenciaId getId() {
        return id;
    }

    public void setId(AsistenciaId id) {
        this.id = id;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public boolean isPresente() {
        return presente;
    }

    public void setPresente(boolean presente) {
        this.presente = presente;
    }
}
