package com.example.proyecto_tfg.repository;

import com.example.proyecto_tfg.models.Partido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PartidoRepository extends JpaRepository<Partido,Integer>, JpaSpecificationExecutor<Partido> {
}
