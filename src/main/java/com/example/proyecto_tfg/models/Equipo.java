package com.example.proyecto_tfg.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.mapping.List;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
public class Equipo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_equipo", nullable = false)
    private int idEquipo;
    @Basic
    @Column(name = "entrenador", nullable = true, length = 255)
    private String entrenador;
    @Basic
    @Column(name = "equipacion", nullable = true, length = 255)
    private String equipacion;
    @Column(name = "id_competicion", insertable = false, updatable = false)
    private Integer idCompeticion;
    @Basic
    @Column(name = "id_usuario_cor", nullable = true)
    private Integer idUsuarioCor;
    @Basic
    @Column(name = "imagen", nullable = true, length = 255)
    private String imagen;
    @Basic
    @Column(name = "localizacion", nullable = true, length = 255)
    private String localizacion;
    @Basic
    @Column(name = "nombre", nullable = true, length = 255)
    private String nombre;
    @Basic
    @Column(name = "lista_jugadores", nullable = true)
    private List listaJugadores;
    @ManyToOne
    @JoinColumn(name = "id_competicion", referencedColumnName = "id_competicion")
    private Competicion competicionByIdCompeticion;
    @JsonIgnore
    @OneToMany(mappedBy = "equipoByIdEquipo")
    private Collection<Jugador> jugadorByIdEquipo;
    @JsonIgnore
    @OneToMany(mappedBy = "equipoByEquipoIdEquipo")
    private Collection<PartidoEquipo> partidoEquipoByIdEquipo;

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(String entrenador) {
        this.entrenador = entrenador;
    }

    public String getEquipacion() {
        return equipacion;
    }

    public void setEquipacion(String equipacion) {
        this.equipacion = equipacion;
    }

    public Integer getIdCompeticion() {
        return idCompeticion;
    }

    public void setIdCompeticion(Integer idCompeticion) {
        this.idCompeticion = idCompeticion;
    }

    public Integer getIdUsuarioCor() {
        return idUsuarioCor;
    }

    public void setIdUsuarioCor(Integer idUsuarioCor) {
        this.idUsuarioCor = idUsuarioCor;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getLocalizacion() {
        return localizacion;
    }

    public void setLocalizacion(String localizacion) {
        this.localizacion = localizacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Object getListaJugadores() {
        return listaJugadores;
    }

    public void setListaJugadores(List listaJugadores) {
        this.listaJugadores = listaJugadores;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipo equipo = (Equipo) o;
        return idEquipo == equipo.idEquipo && Objects.equals(entrenador, equipo.entrenador) && Objects.equals(equipacion, equipo.equipacion) && Objects.equals(idCompeticion, equipo.idCompeticion) && Objects.equals(idUsuarioCor, equipo.idUsuarioCor) && Objects.equals(imagen, equipo.imagen) && Objects.equals(localizacion, equipo.localizacion) && Objects.equals(nombre, equipo.nombre) && Objects.equals(listaJugadores, equipo.listaJugadores);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEquipo, entrenador, equipacion, idCompeticion, idUsuarioCor, imagen, localizacion, nombre, listaJugadores);
    }

    public Competicion getCompeticionByIdCompeticion() {
        return competicionByIdCompeticion;
    }

    public void setCompeticionByIdCompeticion(Competicion competicionByIdCompeticion) {
        this.competicionByIdCompeticion = competicionByIdCompeticion;
    }

    public Collection<Jugador> getJugadorByIdEquipo() {
        return jugadorByIdEquipo;
    }

    public void setJugadorByIdEquipo(Collection<Jugador> jugadorByIdEquipo) {
        this.jugadorByIdEquipo = jugadorByIdEquipo;
    }

    public Collection<PartidoEquipo> getPartidoEquipoByIdEquipo() {
        return partidoEquipoByIdEquipo;
    }

    public void setPartidoEquipoByIdEquipo(Collection<PartidoEquipo> partidoEquipoByIdEquipo) {
        this.partidoEquipoByIdEquipo = partidoEquipoByIdEquipo;
    }
}
