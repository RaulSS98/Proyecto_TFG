package com.example.proyecto_tfg.repository;

import com.example.proyecto_tfg.models.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface EquipoRepository extends JpaRepository<Equipo,Integer>, JpaSpecificationExecutor<Equipo> {
}
