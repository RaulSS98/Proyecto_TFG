package com.example.proyecto_tfg.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "contrasena",length = 255)
    private String contrasena;
    @Basic
    @Column(name = "correo",  length = 255)
    private String correo;
    @Basic
    @Column(name = "habilitado")
    private Boolean habilitado;
    @Basic
    @Column(name = "nombre",  length = 255)
    private String nombre;
    @Basic
    @Column(name = "tipo_usuario", length = 255)
    private String tipoUsuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContraseña() {
        return contrasena;
    }

    public void setContraseña(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Boolean getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(Boolean habilitado) {
        this.habilitado = habilitado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String tipoUsuario) {
        this.tipoUsuario = tipoUsuario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuarios = (Usuario) o;
        return id == usuarios.id && Objects.equals(contrasena, usuarios.contrasena) && Objects.equals(correo, usuarios.correo) && Objects.equals(habilitado, usuarios.habilitado) && Objects.equals(nombre, usuarios.nombre) && Objects.equals(tipoUsuario, usuarios.tipoUsuario);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, contrasena, correo, habilitado, nombre, tipoUsuario);
    }
}
