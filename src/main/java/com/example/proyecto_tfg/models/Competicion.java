package com.example.proyecto_tfg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Competicion {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_competicion", nullable = false)
    private int idCompeticion;
    @Basic
    @Column(name = "nombre", nullable = true, length = 255)
    private String nombre;
    @JsonIgnore
    @OneToMany(mappedBy = "competicionByIdCompeticion")
    private Collection<Equipo> listaEquipos;

    public int getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(int idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competicion that = (Competicion) o;
        return idCompeticion == that.idCompeticion && Objects.equals(nombre, that.nombre) && Objects.equals(listaEquipos, that.listaEquipos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCompeticion, nombre, listaEquipos);
    }

    public Collection<Equipo> getEquipoByIdCompeticion() {
        return listaEquipos;
    }

    public void setEquipoByIdCompeticion(Collection<Equipo> equipoByIdCompeticion) {
        this.listaEquipos = equipoByIdCompeticion;
    }
}
