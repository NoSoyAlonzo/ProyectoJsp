package com.mycompany.proyectov2.model;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Embeddable
public class AsistenciaId implements Serializable {

    private int alumnoId;

    @Temporal(TemporalType.DATE)
    private Date fecha;

    public AsistenciaId(int alumnoId, Date fecha) {
        this.alumnoId = alumnoId;
        this.fecha = fecha;
    }

    public AsistenciaId() {
    }

    public AsistenciaId(Date fecha) {
        this.fecha = fecha;
    }

    public int getAlumnoId() {
        return alumnoId;
    }

    public void setAlumnoId(int alumnoId) {
        this.alumnoId = alumnoId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AsistenciaId)) return false;
        AsistenciaId that = (AsistenciaId) o;
        return alumnoId == that.alumnoId && Objects.equals(fecha, that.fecha);
    }

    @Override
    public int hashCode() {
        return Objects.hash(alumnoId, fecha);
    }
}
