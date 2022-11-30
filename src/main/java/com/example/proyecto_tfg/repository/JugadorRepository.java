package com.example.proyecto_tfg.repository;

import com.example.proyecto_tfg.models.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface JugadorRepository extends JpaRepository<Jugador,Integer>, JpaSpecificationExecutor<Jugador> {
}
