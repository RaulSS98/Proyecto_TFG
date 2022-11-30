package com.example.proyecto_tfg.models;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

@Entity
public class Jugador {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_jugador", nullable = false)
    private int idJugador;
    @Basic
    @Column(name = "altura", nullable = false)
    private Integer altura;
    @Basic
    @Column(name = "dorsal", nullable = false)
    private Integer dorsal;
    @Basic
    @Column(name = "fecha_nac", nullable = false)
    private Date fechaNac;
    @Basic
    @Column(name = "imagen", nullable = false, length = 255)
    private String imagen;
    @Basic
    @Column(name = "nacionalidad", nullable = false, length = 255)
    private String nacionalidad;
    @Basic
    @Column(name = "nombre", nullable = false, length = 255)
    private String nombre;
    @Basic
    @Column(name = "peso", nullable = false)
    private Integer peso;
    @Basic
    @Column(name = "id_equipo", nullable = true)
    private Integer idEquipo;
    @ManyToOne
    @JoinColumn(name = "id_equipo", insertable = false, updatable = false, referencedColumnName = "id_equipo")
    private Equipo equipoByIdEquipo;

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public Integer getAltura() {
        return altura;
    }

    public void setAltura(Integer altura) {
        this.altura = altura;
    }

    public Integer getDorsal() {
        return dorsal;
    }

    public void setDorsal(Integer dorsal) {
        this.dorsal = dorsal;
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPeso() {
        return peso;
    }

    public void setPeso(Integer peso) {
        this.peso = peso;
    }

    public Integer getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Integer idEquipo) {
        this.idEquipo = idEquipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Jugador jugador = (Jugador) o;
        return idJugador == jugador.idJugador && Objects.equals(altura, jugador.altura) && Objects.equals(dorsal, jugador.dorsal) && Objects.equals(fechaNac, jugador.fechaNac) && Objects.equals(imagen, jugador.imagen) && Objects.equals(nacionalidad, jugador.nacionalidad) && Objects.equals(nombre, jugador.nombre) && Objects.equals(peso, jugador.peso) && Objects.equals(idEquipo, jugador.idEquipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idJugador, altura, dorsal, fechaNac, imagen, nacionalidad, nombre, peso, idEquipo);
    }

    public Equipo getEquipoByIdEquipo() {
        return equipoByIdEquipo;
    }

    public void setEquipoByIdEquipo(Equipo equipoByIdEquipo) {
        this.equipoByIdEquipo = equipoByIdEquipo;
    }
}
