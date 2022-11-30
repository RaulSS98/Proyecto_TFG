package com.example.proyecto_tfg.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "partido_equipo", schema = "public", catalog = "trabajo_tfg")
public class PartidoEquipo {
    @Id
    @Basic
    @Column(name = "partido_id_partido", nullable = false, insertable = false, updatable = false)
    private int partidoIdPartido;
    @Basic
    @Column(name = "equipo_id_equipo", nullable = false, insertable = false, updatable = false)
    private int equipoIdEquipo;
    @ManyToOne(optional = false)
    @JoinColumn(name = "partido_id_partido", nullable = false, insertable = false, updatable = false, referencedColumnName = "id_partido")
    private Partido partidoByPartidoIdPartido;
    @ManyToOne
    @JoinColumn(name = "equipo_id_equipo", referencedColumnName = "id_equipo", nullable = false)
    private Equipo equipoByEquipoIdEquipo;

    public int getPartidoIdPartido() {
        return partidoIdPartido;
    }

    public void setPartidoIdPartido(int partidoIdPartido) {
        this.partidoIdPartido = partidoIdPartido;
    }

    public int getEquipoIdEquipo() {
        return equipoIdEquipo;
    }

    public void setEquipoIdEquipo(int equipoIdEquipo) {
        this.equipoIdEquipo = equipoIdEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PartidoEquipo that = (PartidoEquipo) o;
        return partidoIdPartido == that.partidoIdPartido && equipoIdEquipo == that.equipoIdEquipo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(partidoIdPartido, equipoIdEquipo);
    }

    public Partido getPartidoByPartidoIdPartido() {
        return partidoByPartidoIdPartido;
    }

    public void setPartidoByPartidoIdPartido(Partido partidoByPartidoIdPartido) {
        this.partidoByPartidoIdPartido = partidoByPartidoIdPartido;
    }

    public Equipo getEquipoByEquipoIdEquipo() {
        return equipoByEquipoIdEquipo;
    }

    public void setEquipoByEquipoIdEquipo(Equipo equipoByEquipoIdEquipo) {
        this.equipoByEquipoIdEquipo = equipoByEquipoIdEquipo;
    }
}
