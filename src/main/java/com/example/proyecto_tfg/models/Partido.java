package com.example.proyecto_tfg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.sql.Date;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Partido {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_partido", nullable = false)
    private int idPartido;
    @Basic
    @Column(name = "equipo_local", nullable = true, length = 255)
    private String equipoLocal;
    @Basic
    @Column(name = "equipo_visitante", nullable = true, length = 255)
    private String equipoVisitante;
    @Basic
    @Column(name = "fecha", nullable = true)
    private Date fecha;
    @Basic
    @Column(name = "hora", nullable = true, length = 255)
    private String hora;
    @Basic
    @Column(name = "jornada", nullable = true)
    private Integer jornada;
    @Basic
    @Column(name = "resultado", nullable = true)
    private Integer resultado;
    @JsonIgnore
    @OneToMany(mappedBy = "partidoByPartidoIdPartido")
    private Collection<PartidoEquipo> partidoEquipoByIdPartido;

    public int getIdPartido() {
        return idPartido;
    }

    public void setIdPartido(int idPartido) {
        this.idPartido = idPartido;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public Integer getJornada() {
        return jornada;
    }

    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }

    public Integer getResultado() {
        return resultado;
    }

    public void setResultado(Integer resultado) {
        this.resultado = resultado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Partido partido = (Partido) o;
        return idPartido == partido.idPartido && Objects.equals(equipoLocal, partido.equipoLocal) && Objects.equals(equipoVisitante, partido.equipoVisitante) && Objects.equals(fecha, partido.fecha) && Objects.equals(hora, partido.hora) && Objects.equals(jornada, partido.jornada) && Objects.equals(resultado, partido.resultado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPartido, equipoLocal, equipoVisitante, fecha, hora, jornada, resultado);
    }

    public Collection<PartidoEquipo> getPartidoEquipoByIdPartido() {
        return partidoEquipoByIdPartido;
    }

    public void setPartidoEquipoByIdPartido(Collection<PartidoEquipo> partidoEquipoByIdPartido) {
        this.partidoEquipoByIdPartido = partidoEquipoByIdPartido;
    }
}
